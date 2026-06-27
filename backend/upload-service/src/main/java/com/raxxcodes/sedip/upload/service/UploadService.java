package com.raxxcodes.sedip.upload.service;

import com.raxxcodes.sedip.upload.dto.UploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    UploadResponse uploadFile(MultipartFile file);
}
