package com.springboot.upAndDown;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Download
{
	Logger logger = LoggerFactory.getLogger(Download.class);
	@RequestMapping(value = "/testDownload", method = RequestMethod.GET)
	public void testDownload(HttpServletResponse res)
	{
		String fileName = "a.png";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try
		{
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("./uploadFiles/" + fileName)));
			int i = bis.read(buff);
			while (i != -1)
			{
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e)
		{
			logger.info("IO异常："+e.getMessage());
		} finally
		{
			if (bis != null)
			{
				try
				{
					bis.close();
				} catch (IOException e)
				{
					logger.info("IO异常："+e.getMessage());
				}
			}
		}
		logger.info("success");
	}
}
