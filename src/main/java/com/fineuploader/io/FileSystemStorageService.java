package com.fineuploader.io;

import com.fineuploader.UploadServerProperties;
import com.fineuploader.model.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by ovaldez on 11/13/16.
 */
@Service
public class FileSystemStorageService implements StorageService {

    private static final Logger log = LoggerFactory.getLogger(FileSystemStorageService.class);

    private Path basePath;

    @Autowired
    public FileSystemStorageService(UploadServerProperties props) {
        this.basePath = props.getBaseDir();
    }

    @Override
    public void save(UploadRequest ur) {

        if (ur.getFile().isEmpty()) {
            throw new StorageException(String.format("File with uuid = [%s] is empty", ur.getUuid().toString()));
        }

        Path targetFile;
        if (ur.getPartIndex() > -1) {
            targetFile = basePath.resolve(ur.getUuid()).resolve(String.format("%s_%05d", ur.getUuid(), ur.getPartIndex()));
        } else {
            targetFile = basePath.resolve(ur.getUuid()).resolve(ur.getFileName());
        }
        try {
            Files.createDirectories(targetFile.getParent());
            Files.copy(ur.getFile().getInputStream(), targetFile);
        } catch (IOException e) {
            String errorMsg = String.format("Error occurred when saving file with uuid = [%s]", ur);
            log.error(errorMsg, e);
            throw new StorageException(errorMsg, e);
        }

    }

    @Override
    public void delete(String uuid) {
        File targetDir = basePath.resolve(uuid).toFile();
        FileSystemUtils.deleteRecursively(targetDir);
    }

    @Override
    public void mergeChunks(String uuid, String fileName, int totalParts, long totalFileSize) {
        File targetFile = basePath.resolve(uuid).resolve(fileName).toFile();
        try (FileChannel dest = new FileOutputStream(targetFile, true).getChannel()) {
            for (int i = 0; i < totalParts; i++) {
                File sourceFile = basePath.resolve(uuid).resolve(String.format("%s_%05d", uuid, i)).toFile();
                try (FileChannel src = new FileInputStream(sourceFile).getChannel()) {
                    dest.position(dest.size());
                    src.transferTo(0, src.size(), dest);
                }
                sourceFile.delete();
            }
        } catch (IOException e) {
            String errorMsg = String.format("Error occurred when merging chunks for uuid = [%s]", uuid);
            log.error(errorMsg, e);
            throw new StorageException(errorMsg, e);
        }

    }
}
