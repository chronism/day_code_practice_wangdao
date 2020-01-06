package com.cskaoyan.service;

import com.cskaoyan.config.AliyunComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    AliyunComponent aliyunComponent;

    public void fileUpload(String fileName, File file) {
        aliyunComponent.fileUpload(fileName, file);

    }

    public void sendMsg(String phone, String code) {
        aliyunComponent.sendMsg(phone, code);
    }
}
