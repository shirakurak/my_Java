package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.ByteUtils;

@RestController
public class ByteController {
	
	@Autowired
	ByteUtils util;
	
	@RequestMapping("/byte")
	public ResponseEntity<byte[]> home() throws IOException {
		byte[] byteImage = util.getByteImages("sample.jpg");
		return new ResponseEntity<byte[]>(byteImage, HttpStatus.OK);
	}
	
	/**
	 * 以下を参考：
	 * https://gist.github.com/komiya-atsushi/d878e6e4bf9ba6dae8fa
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/byte2")
	public ResponseEntity<String> home2() throws IOException {
		byte[] byteImage = util.getByteImages("sample.jpg");
		
		String encoded = Base64.getEncoder()
				.encodeToString(byteImage);
		
		return new ResponseEntity<String>(encoded, HttpStatus.OK);
	}
}
