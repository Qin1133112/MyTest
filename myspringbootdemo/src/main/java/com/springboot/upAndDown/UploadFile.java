package com.springboot.upAndDown;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadFile
{
	Logger logger = LoggerFactory.getLogger(UploadFile.class);

	@RequestMapping(value = "/testUploadFile", method = RequestMethod.POST)
	public void testUploadFile(HttpServletRequest req, MultipartHttpServletRequest multiReq)
	{
		// 获取上传文件的路径
		String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
		logger.info("uploadFlePath:" + uploadFilePath);
		// 截取上传文件的文件名
		String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') + 1,
				uploadFilePath.indexOf('.'));
		logger.info("multiReq.getFile()" + uploadFileName);
		// 截取上传文件的后缀
		String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
		logger.info("uploadFileSuffix:" + uploadFileSuffix);
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try
		{
			fis = (FileInputStream) multiReq.getFile("file1").getInputStream();
			fos = new FileOutputStream(new File(".//uploadFiles//" + uploadFileName + ".") + uploadFileSuffix);
			byte[] temp = new byte[1024];
			int i = fis.read(temp);
			while (i != -1)
			{
				fos.write(temp, 0, temp.length);
				fos.flush();
				i = fis.read(temp);
			}
		} catch (IOException e)
		{
			logger.info("IO 异常：" + e.getMessage());
		} finally
		{
			if (fis != null)
			{
				try
				{
					fis.close();
				} catch (IOException e)
				{
					logger.info("IO 异常：" + e.getMessage());
				}
			}
			if (fos != null)
			{
				try
				{
					fos.close();
				} catch (IOException e)
				{
					logger.info("IO 异常：" + e.getMessage());
				}
			}
		}
	}

	@RequestMapping(value = "testUploadFiles", method = RequestMethod.POST)
	@ResponseBody
	public void handleFileUpload(HttpServletRequest request)
	{
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i)
		{
			file = files.get(i);
			if (!file.isEmpty())
			{
				try
				{
					String uploadFilePath = file.getOriginalFilename();
					logger.info("uploadFlePath:" + uploadFilePath);
					// 截取上传文件的文件名
					String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') + 1,
							uploadFilePath.indexOf('.'));
					logger.info("multiReq.getFile()" + uploadFileName);
					// 截取上传文件的后缀
					String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.indexOf('.') + 1,
							uploadFilePath.length());
					logger.info("uploadFileSuffix:" + uploadFileSuffix);
					stream = new BufferedOutputStream(new FileOutputStream(
							new File(".//uploadFiles//" + uploadFileName + "." + uploadFileSuffix)));
					byte[] bytes = file.getBytes();
					stream.write(bytes, 0, bytes.length);
				} catch (Exception e)
				{
					logger.info("异常：" + e.getMessage());
				} finally
				{
					try
					{
						if (stream != null)
						{
							stream.close();
						}
					} catch (IOException e)
					{
						logger.info("IO 异常：" + e.getMessage());
					}
				}
			} else
			{
				logger.info("上传文件为空");
			}
		}
		logger.info("文件接受成功了");
	}
}
