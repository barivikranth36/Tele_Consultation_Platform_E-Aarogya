package com.shield.eaarogya.Service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String uploadFile(MultipartFile multipartFile);
}
