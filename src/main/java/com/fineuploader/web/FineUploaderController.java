package com.fineuploader.web;

import com.fineuploader.io.StorageService;
import com.fineuploader.model.UploadRequest;
import com.fineuploader.model.UploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ovaldez
 */
@RestController
public class FineUploaderController {

    private final StorageService storageService;

    @Autowired
    public FineUploaderController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> upload(@RequestBody UploadRequest request) {

        if (request.getUuid() == null) {
            return ResponseEntity.badRequest().body(new UploadResponse("No uuid received", false));
        }


        return null;
    }


}
