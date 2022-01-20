package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ByteUtils {
	
	/**
	 * convert image to byte[]
	 * @param name name of image want to convert to byte[]
	 * @return image want to convert to byte[]
	 * @throws IOException exception when reading the file
	 */
	public byte[] getByteImages(String name) throws IOException {
		
		String path = 
			Paths.get("").toAbsolutePath().toString()	// current path
			+ "\\src\\main\\resources\\images\\"
			+ name;
		File file = new File(path);
		
		return  Files.readAllBytes(file.toPath());
	}
}
