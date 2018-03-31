package com.wy.test.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wy.test.dao.ObjectResponse;
import com.wy.test.service.FileService;

@Controller
@RequestMapping("/file")
public class FileAction {
   
	@Resource
	private FileService fileService;
	
	@ResponseBody
	@RequestMapping("/upload.do")
	protected ObjectResponse upload(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException {
		     ObjectResponse response = new ObjectResponse();
		  /*   String path = request.getServletContext().getRealPath("/upload");*/
		     
		 /*    String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");*/
		     response.data = fileService.upLoadFile(file,request);
		     return response;
		
		
		
	}
}
