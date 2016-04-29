package com.yinnut.utils;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils; 

public class ReadNginxLogFileParse {
	public static void main(String[] args) throws FileNotFoundException {
//		ClassLoader classLoader = ReadNginxLogFileParse.class.getClassLoader();
//		File file = new File(classLoader.getResource("./kafka-nginx_message.txt").getFile());
//		
//		System.out.println(file != null);

		File file = ResourceUtils.getFile("classpath:./kafka-nginx_message.txt");
		System.out.println(file.isFile());
		
		
		
	}
}
