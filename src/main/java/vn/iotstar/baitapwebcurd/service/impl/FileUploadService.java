package vn.iotstar.baitapwebcurd.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadService {
    private static final String UPLOAD_DIR =
            System.getProperty("user.dir") + File.separator + "uploads" + File.separator;

    public String uploadMp4File(MultipartFile file) throws IOException {
        if (!file.getOriginalFilename().endsWith(".mp4")) {
            throw new IllegalArgumentException("Chỉ cho phép upload file MP4!");
        }
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String savedFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = UPLOAD_DIR + savedFileName;
        file.transferTo(new File(filePath));
        return savedFileName;
    }
}
