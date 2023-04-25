package com.shield.eaarogya.Controller;

import com.shield.eaarogya.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileaws")
public class AwsStorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam(value = "file")MultipartFile multipartFile) {
        return storageService.uploadFile(multipartFile);
    }
}
