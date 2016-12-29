package com.fineuploader.io;

import com.fineuploader.UploadServerProperties;
import com.fineuploader.model.UploadRequest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * @author ovaldez
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileSystemStorageServiceTest {

    @Autowired
    private StorageService storageService;

    @Autowired
    private UploadServerProperties props;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void saveThrowExceptionWhenFileEmpty() throws Exception {
        final String uuid = UUID.randomUUID().toString();
        MockMultipartFile multipartFile =
                new MockMultipartFile("springboot.png", "springboot.png", "image/png", "".getBytes());
        UploadRequest ur = new UploadRequest(uuid, multipartFile);
        thrown.expect(StorageException.class);
        thrown.expectMessage(uuid);
        storageService.save(ur);
    }

    @Test
    public void save() throws Exception {
        final String uuid = UUID.randomUUID().toString();
        final String fileName = "test.txt";
        MockMultipartFile multipartFile =
                new MockMultipartFile(fileName, fileName, "text/plain", "Test file".getBytes());
        UploadRequest ur = new UploadRequest(uuid, multipartFile);
        ur.setFileName(fileName);
        storageService.save(ur);
        File file = new File(props.getBaseDir() + File.separator + uuid + File.separator + fileName);
        assertTrue(file.exists());
        assertTrue(file.isFile());
        file.delete();
        file.getParentFile().delete();
    }

    @Test
    public void delete() throws Exception {

    }

}