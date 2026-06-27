package com.raxxcodes.sedip.upload.controller;

import com.raxxcodes.sedip.common.response.ApiResponse;
import com.raxxcodes.sedip.upload.dto.UploadResponse;
import com.raxxcodes.sedip.upload.service.UploadService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("/api/v1/files")
public class UploadController {

    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<UploadResponse>  uploadFile(@RequestParam("file") MultipartFile file) {
        UploadResponse uploadResponse = uploadService.uploadFile(file);
        return ApiResponse.success("File Uploaded Successfully",uploadResponse);
    }
}
