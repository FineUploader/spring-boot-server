package com.fineuploader.io;

import com.fineuploader.model.UploadRequest;

/**
 * Created by ovaldez on 11/13/16.
 */
public interface StorageService {

    void save(UploadRequest uploadRequest);

    void delete(String uuid);

}
