package com.example.awstest2.controll;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.Deflater;

import javax.servlet.http.HttpServletRequest;

import com.example.awstest2.Service.FileUploadDownloadService;
import com.example.awstest2.model.FileUploadResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadDownloadService service;

    @GetMapping("/")
    public String controllerMain() {
        return "Hello~ File Upload Test.";
    }
/*
    @PostMapping("/uploadFile/cafeteria")
    public FileUploadResponse uploadFileCafeteria(@RequestParam("file") MultipartFile file){
        String fileName = service.storeFileCafeteria(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/cafeteria/")
                .path(fileName)
                .toUriString();

        return new FileUploadResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }
*/
    @PostMapping("/uploadFile/{type:.+}")
    public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String type ) {

        String fileName = service.storeFile(file,type);
        System.out.println(fileName);
        System.out.println(type);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/"+type+"/")
                .path(fileName)
                .toUriString();

        return new FileUploadResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles/{type:.+}")
    public List<FileUploadResponse> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files, @PathVariable String type){
        //일단 다중업로드는 notice밖에 없으니까
       return files.stream().map(file->uploadFile(file,type)).collect(Collectors.toList());

    }

    @GetMapping("/downloadFile/{type:.+}/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String type, @PathVariable String fileName, HttpServletRequest request){
        // Load file as Resource
        Resource resource = service.loadFileAsResource(fileName,type);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
/*
    @GetMapping("/downloadFile/cafeteria/{fileName:.+}")
    public ResponseEntity<Resource> downloadCafeteriaFile(@PathVariable String fileName, HttpServletRequest request){
        // Load file as Resource
        Resource resource = service.loadFileCafeteriaAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
*/
    @GetMapping(
            value = "/loadFile/{type:.+}/{fileName:.+}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageFile(@PathVariable String type ,@PathVariable String fileName) throws IOException{

        InputStream in = service.loadFileAsResource(fileName,type).getInputStream();

        return in.readAllBytes();

    }

/*    @GetMapping(
            value = "/loadFile/cafeteria/{fileName}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageCafeteriaFile(@PathVariable String fileName) throws IOException{

        InputStream in = service.loadFileCafeteriaAsResource(fileName).getInputStream();

        return in.readAllBytes();

    }*/

/*
    @GetMapping("/loadFiles")
    public InputStream getImageFiles()throws IOException{
        InputStream in = service.loadFileAsResource("KakaoTalk_20220620_203756388.jpg").getInputStream();
        InputStream in2= service.loadFileAsResource("KakaoTalk_20220620_203756388_01.jpg").getInputStream();

        List<byte[]> bytes= new ArrayList<byte[]>();
        bytes.add(in.readAllBytes());
        bytes.add(in2.readAllBytes());

        return in;
    }
*/



}