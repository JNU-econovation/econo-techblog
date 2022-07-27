package com.econovation.tcono.service;

import com.econovation.tcono.domain.file.PictureRepository;
import com.econovation.tcono.web.dto.UploadFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FileService {

    private final PictureRepository fileRepository;

//    @Transactional
//    public Long save(UploadFile fileDto) {
//        return fileRepository.save(fileDto.toEntity(fileDto)).getId();
//    }

}