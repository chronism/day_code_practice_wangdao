package com.cskaoyan.component;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "file.component")
public class FileComponent {

    String filePath;

    String fileType;

    int maxSize;

    @Value("${file.path1111}")
    String fill;
}
