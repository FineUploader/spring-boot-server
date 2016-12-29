package com.fineuploader.io;

import com.fineuploader.UploadServerProperties;
import com.fineuploader.model.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ovaldez on 11/13/16.
 */
@Service
public class FileSystemStorageService implements StorageService {

    private static final Logger log = LoggerFactory.getLogger(FileSystemStorageService.class);

    private Path basePath;

    @Autowired
    public FileSystemStorageService(UploadServerProperties props) {
        this.basePath = Paths.get(props.getBaseDir());
    }

    @Override
    public void save(UploadRequest ur) {

        if (ur.getFile().isEmpty()) {
            throw new StorageException(String.format("File with uuid = [%s] is empty", ur.getUuid().toString()));
        }

        Path targetFile = basePath.resolve(ur.getUuid().toString()).resolve(ur.getFileName());
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

    }

}
