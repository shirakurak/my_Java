package com.example.demo.controller;

import java.io.IOException;

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
}
