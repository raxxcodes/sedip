package com.raxxcodes.sedip.upload.service.impl;

import com.raxxcodes.sedip.common.exception.InvalidFileException;
import com.raxxcodes.sedip.upload.dto.UploadResponse;
import com.raxxcodes.sedip.upload.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB

    @Override
    public UploadResponse uploadFile(MultipartFile file) {

        validateFile(file);

        String fileId = UUID.randomUUID().toString();

        return new UploadResponse(fileId, file.getOriginalFilename(), "UPLOADED");
    }

    private void validateFile(MultipartFile file) {

        if(file.isEmpty()) {
            throw new InvalidFileException("Please upload a file");
        }

        String fileName = file.getOriginalFilename();

        if(fileName == null || (!fileName.toLowerCase().endsWith(".xlsx") && !fileName.toLowerCase().endsWith("xls"))) {
            throw new InvalidFileException("Only Excel file (.xlsx or .xls) is allowed");
        }

        if(file.getSize() > MAX_FILE_SIZE) {
            throw new InvalidFileException("File is too large. Maximum allowed file size is 10 MB");
        }
    }
}
