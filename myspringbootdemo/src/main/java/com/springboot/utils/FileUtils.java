package com.springboot.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils
{
	static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	public static void makeDir()
	{
		File file = new File("./export");
		if(!file.exists())
		{
			logger.info("开始创建文件夹");
			file.mkdirs();
			logger.info("已经创建文件夹");
		}
	}
	
	public static void write(String content,String fileName)
	{
		makeDir();
		try
		{
			logger.info("开始写文件");
			FileWriter fw=new FileWriter("./export/"+fileName,true);
			fw.write(content+"\n");
			logger.info("结束写文件");
			fw.close();
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("开始");
//		write("ssss");
//		write("ssss");
		System.out.println("结束");
	}
}
