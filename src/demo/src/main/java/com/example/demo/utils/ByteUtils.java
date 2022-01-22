package com.example.demo.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

// TODO:別のアノテーションにする
@Service
public class ByteUtils {
	
	/**
	 * convert image to byte[]
	 * @param name name of image want to convert to byte[]
	 * @return image want to convert to byte[]
	 * @throws IOException exception when reading the file
	 */
	public byte[] getByteImages(String name) throws IOException {
		
		String p = 
			Paths.get("").toAbsolutePath().toString()	// current path
			+ "\\src\\main\\resources\\images\\"
			+ name;
		
		return  Files.readAllBytes(Paths.get(p));
	}
}
