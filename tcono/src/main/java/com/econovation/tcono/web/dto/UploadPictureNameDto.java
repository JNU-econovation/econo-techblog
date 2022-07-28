package com.econovation.tcono.web.dto;

import com.econovation.tcono.domain.file.Picture;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadPictureNameDto {
    private MultipartFile attachFile;
    private Long postId;
    private Long userId;
}
