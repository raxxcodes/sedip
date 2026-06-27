package com.raxxcodes.sedip.upload.controller;

import com.raxxcodes.sedip.common.exception.ResourceNotFoundException;
import com.raxxcodes.sedip.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/v1/health")
    public ApiResponse<Map<String,String>> health() {
        Map<String,String> data = Map.of("service","upload-service",
                "status","UP");
        return ApiResponse.success("Health check successfully", data);
    }

    @GetMapping("/api/v1/test-error")
    public String testError() {
        throw new ResourceNotFoundException(
                "Test resource not found");
    }
}
