package com.fineuploader.web;

import com.fineuploader.io.StorageException;
import com.fineuploader.io.StorageService;
import com.fineuploader.model.UploadRequest;
import com.fineuploader.model.UploadResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ovaldez
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FineUploaderControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private StorageService storageService;

    @Test
    public void upload() throws Exception {
        String fileName = "fineuploader.png";
        MockMultipartFile multipartFile =
                new MockMultipartFile("qqfile", fileName, "image/png", "Some bytes".getBytes());
        this.mvc.perform(fileUpload("/uploads").file(multipartFile)
                .param("qquuid", UUID.randomUUID().toString())
                .param("qqfilename", fileName))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"success\":true}"));
        verify(this.storageService).save(any(UploadRequest.class));
    }

    @Test
    public void handleException() throws Exception {
        FineUploaderController controller = new FineUploaderController(storageService);
        String errorMsg = "Something went wrong";
        StorageException ex = new StorageException(errorMsg);
        ResponseEntity<UploadResponse> resp = controller.handleException(ex);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resp.getStatusCode());
        assertFalse(resp.getBody().isSuccess());
        assertEquals(errorMsg, resp.getBody().getErrorMsg());
    }

}