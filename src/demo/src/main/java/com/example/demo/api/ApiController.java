package com.example.demo.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	/**
	 * OpenWeatherMapを使用して天気情報を取得してくるサンプル。
	 * refactorできるところは多そうだが、いったん動くことを確認するまで。
	 * 
	 * @return 取得結果
	 * @throws IOException 例外
	 */
	@RequestMapping("/api")
	public ResponseEntity<String> home() throws IOException {
		
		String apiKey = "";	// my APIkey
		String requestUrl = "https://api.openweathermap.org/data/2.5/weather?q=Tokyo,JP&appid=" + apiKey
				+ "&lang=ja&units=metric";
		
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responseCode = connection.getResponseCode();
		
		if(responseCode == HttpURLConnection.HTTP_OK) {
			System.out.println("取得できました");
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());	
			BufferedReader br = new BufferedReader(isr);
			
			return new ResponseEntity<String>(br.readLine(), HttpStatus.OK);
			
		} else {
			System.out.println("取得できませんでした。");
			return new ResponseEntity<String>("", HttpStatus.OK);
		}
	}
}
