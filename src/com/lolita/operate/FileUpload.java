package com.lolita.operate;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.lolita.data.RandomCode;
import com.lolita.data.ResultCode;

@Service
public class FileUpload {

	// 创建实例
	RandomCode randomCode = new RandomCode();
	ResultJSON resultJSON = new ResultJSON();

	protected static Logger logger = Logger.getLogger(FileUpload.class);
	
	private static String url = "http://egaicar.com:8080/lolita/pic/";//正式
	//private static String url = "http://egaicar.com:8080/lolita_test/pic/";//测试

	@SuppressWarnings({ "rawtypes", "null" })
	public void userAvatarUpload(HttpServletRequest request, Integer user_id, Date date) {

		try {
			// 转型为MultipartHttpRequest：
			// MultipartHttpServletRequest multipartRequest =
			// (MultipartHttpServletRequest)request;
			MultipartResolver resolver = new CommonsMultipartResolver(request
					.getSession().getServletContext());
			MultipartHttpServletRequest multipartRequest = resolver
					.resolveMultipart(request);

			String filename = null;
			// 遍历所有文件域，获得上传的文件
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
				String key = (String) it.next();
				MultipartFile file = multipartRequest.getFile(key);
				// saveFile(file);
				if (file != null || !file.isEmpty()) {
					filename = "avatar_" + user_id + "_" + date.getTime()+".png";
					String localfileName = request.getSession()
							.getServletContext().getRealPath("/")
							+ "user_avatar/" + filename;
					// 写入文件
					File source = new File(localfileName.toString());
					// 判断目录是否存在，并创建
					if (!source.exists())
						source.mkdirs();
					// 保存文件
					file.transferTo(source);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "null" })
	public JSONObject topicPicUpload(HttpServletRequest request) {
		
		//构筑json
		JSONObject jo = new JSONObject();
		
		try {
			// 转型为MultipartHttpRequest：
			// MultipartHttpServletRequest multipartRequest =
			// (MultipartHttpServletRequest)request;
			MultipartResolver resolver = new CommonsMultipartResolver(request
					.getSession().getServletContext());
			MultipartHttpServletRequest multipartRequest = resolver
					.resolveMultipart(request);

			String filename = null;
			Date date = new Date();
			String num = randomCode.getNum(10);
			// 遍历所有文件域，获得上传的文件
			for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
				String key = (String) it.next();
				MultipartFile file = multipartRequest.getFile(key);
				// saveFile(file);
				if (file != null || !file.isEmpty()) {
					filename = date.getTime() + "_" + num + ".png";
					String localfileName = request.getSession()
							.getServletContext().getRealPath("/")
							+ "pic/" + filename;
					// 写入文件
					File source = new File(localfileName.toString());
					// 判断目录是否存在，并创建
					if (!source.exists())
						source.mkdirs();
					// 保存文件
					file.transferTo(source);
				}
			}
			
			jo = resultJSON.createResultJSON(ResultCode.SUCCESS);
			jo.put("url", url +filename);
			
		} catch (Exception e) {
			e.printStackTrace();
			jo = resultJSON.createResultJSON(ResultCode.UNKNOWN_ERROR);
		}
		return jo;
	}

}