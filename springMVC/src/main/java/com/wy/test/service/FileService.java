package com.wy.test.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.wy.test.dao.FileRequest;
import com.wy.test.dao.FileResult;
import com.wy.test.mapper.FileMapper;
import com.wy.tests.util.StringUtils;
import com.wy.tests.util.SymbolConstants;

@Service
@Validated
public class FileService {
	
	@Resource
	private FileMapper fileMapper;
	
	
	public String upLoadFile(MultipartFile file,HttpServletRequest request) throws IOException{
		        String path = request.getSession().getServletContext().getRealPath("upload");  
		        String realPath = request.getContextPath()+"/upload";
		        String url;
	            byte[] buffer = file.getBytes();
				final String hash = StringUtils.streamToMD5(new ByteArrayInputStream(buffer));
				final String originalFileName = file.getOriginalFilename();
				final String suffix = originalFileName.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				
				FileResult fileResult = fileMapper.selectOneByHash(hash);
				if(fileResult == null){
					
					String fileName = hash + SymbolConstants.POINT+ suffix;
					File targetFile = new File(path, fileName); 
					 if(!targetFile.exists()){  
				            targetFile.mkdirs();  
				        }  
					 
					  try {  
				            file.transferTo(targetFile);  
				        } catch (Exception e) {  
				            e.printStackTrace();  
				        }  
					   FileRequest fileRequest = new FileRequest(originalFileName,hash,suffix);
						if(fileMapper.insert(fileRequest)>0){
							url = realPath + SymbolConstants.SPRIT + hash + SymbolConstants.POINT+ suffix;
							System.out.println(url);
							return url;
						
						}
						
				}
				  url = realPath + SymbolConstants.SPRIT + fileResult.hash + SymbolConstants.POINT+ suffix;
				  System.out.println(url);
			      return url;
		
	}
	
	
}
