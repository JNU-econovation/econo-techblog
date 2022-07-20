package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.file.File;
import lombok.Builder;
import lombok.Data;

@Data
public class UploadFile {
    private String uploadFileName;
    private String storeFileName;
    private Long userId;

    @Builder
    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }

    public File toEntity(UploadFile uploadFile){
        return File.builder()
                .storeFileName(uploadFile.storeFileName)
                .uploadFileName(uploadFile.uploadFileName)
                .userId(uploadFile.userId)
                .build();
    }
}
