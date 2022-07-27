package com.econovation.tcono.web.controller;


 import com.econovation.tcono.domain.file.PictureRepository;
 import com.econovation.tcono.domain.file.Picture;
 import com.econovation.tcono.domain.post.Post;
 import com.econovation.tcono.domain.post.PostRepository;
 import com.econovation.tcono.domain.user.User;
 import com.econovation.tcono.domain.user.UserRepository;
 import com.econovation.tcono.file.FileStore;
 import com.econovation.tcono.web.dto.UploadFile;
 import com.econovation.tcono.web.dto.UploadPictureNameDto;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.core.io.UrlResource;
 import org.springframework.http.HttpHeaders;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.multipart.MultipartFile;
 import org.springframework.web.util.UriUtils;

 import javax.servlet.http.HttpServletRequest;
 import java.io.IOException;
 import java.net.MalformedURLException;
 import java.nio.charset.StandardCharsets;
 import java.util.List;
 import java.io.File;
 import java.util.Optional;

@Slf4j
@Controller
public class FileController {

    private String fileDir = "../../uploadFolder/";

    private FileStore fileStore;
    private PictureRepository pictureRepository;
    private UserRepository userRepsitory;
    private PostRepository postRepository;

//    글 불러오면 저장된 사진 여러개를 전달

    /**
     * @param form
     * @param UploadFile (
     * @return
     * @throws IOException
     */
    @GetMapping("/api/post/picture/{postId}")
    public List<ResponseEntity> getFilesByPost(@PathVariable Long postId) throws MalformedURLException {
        List<Picture> files = pictureRepository.findByPost(postId);
        List<ResponseEntity> list = null;
        if(files.isEmpty()){
            return null;
        }
        for (Picture iter : files) {
            int index = 0;
            String storeFileName = iter.getStoreFileName();
            String uploadFileName = iter.getUploadFileName();
            //파일 서버에 저장
            UrlResource resource = new UrlResource("file:" + fileStore.getFullPath(storeFileName));

            String encodedUploadFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
            String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";
            list.add(index, ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                    .body(resource));
            return list;
        }
        return list;
    }


    @PostMapping("/api/file")
    public Picture saveFile(UploadPictureNameDto form) throws IOException {
//        Picture uploadPicture = null;
//        log.info("request={}", request);
        log.info("userName={}", form.getUserId());
//        log.info("multipartFile={}", form.getImageFiles());

        //   DB가 아닌 파일 서버 폴더에 저장하기
        //            파일 1개일때
        UploadFile attachFile = fileStore.storeFile(form.getAttachFile());
        //            파일 2개 이상일 때
//        List<UploadFile> storeImageFiles = fileStore.storeFiles(form.getImageFiles());

//        //  DB에 저장하기
//        if (!form.getAttachFile().isEmpty()) {
            MultipartFile formAttachFile = form.getAttachFile();
//            List<MultipartFile> imageFiles = form.getImageFiles();
            //  파일 이름 설정
            String fullPath = fileDir + formAttachFile.getOriginalFilename();
            log.info("파일 저장 fullPath={}", fullPath);
        //  파일 저장하기
        //  formAttachFile.transferTo(new File(fullPath));
        //  한 글에 여러 사진이 있으면 1씩 이름을 추가한다.


//            for(MultipartFile multipartFile : imageFiles){
//                int index = 0;
//                String plusIndex = String.valueOf(index);
//                multipartFile.transferTo(new File(fullPath + plusIndex));
//                index += 1;
//            }
                formAttachFile.transferTo(new File(fullPath));

//            삽입 user, post 조회
            User user = userRepsitory.findById(form.getUserId()).get();
            Post post = postRepository.findById(form.getPostId()).get();

            Picture uploadPicture = Picture.builder()
                    .user(user)
                    .post(post)
                    .uploadFileName(attachFile.getUploadFileName())
                    .storeFileName(attachFile.getStoreFileName())
                    .build();
//        }
        return uploadPicture;
    }
}
