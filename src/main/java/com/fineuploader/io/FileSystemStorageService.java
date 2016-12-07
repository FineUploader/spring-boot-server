package com.fineuploader.io;

import com.fineuploader.UploadServerProperties;
import com.fineuploader.model.UploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by ovaldez on 11/13/16.
 */
@Service
public class FileSystemStorageService implements StorageService {

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

        Path targetDir = basePath.resolve(ur.getUuid().toString());


    }

    @Override
    public void delete(UUID uuid) {

    }

    protected void store(MultipartFile file, Path path) {

    }
}
