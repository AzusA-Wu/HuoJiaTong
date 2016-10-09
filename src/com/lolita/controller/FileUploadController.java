package com.lolita.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lolita.operate.FileUpload;

@Controller
@RequestMapping("upload")
public class FileUploadController {
	
	@Inject
	FileUpload fileUpload;
	
	//上传图片(Post)
	//upload.do
	@RequestMapping(value = "upload.do", produces = "text/json;charset=UTF-8")
	public @ResponseBody String uploadPic(HttpServletRequest request){
		return fileUpload.topicPicUpload(request).toString();
	}
}