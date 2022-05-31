package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.telegram.ApiResponseTelegram;
import fr.ensim.interop.introrest.model.telegram.ApiResponseUpdateTelegram;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageRestController {
	
	@Value("${telegram.api.url}")
	private String telegramApiUrl;

	//Token: 5348334660:AAGeyqcd-6MqfuhFhElqoZYsjKCHeboiQZM
	//Opérations sur la ressource Message

	@GetMapping
	public static ResponseEntity<ApiResponseUpdateTelegram> getUpdate(){
		RestTemplate restTemplate = new RestTemplate();
		ApiResponseUpdateTelegram update = restTemplate.getForObject("https://api.telegram.org/bot5348334660:AAGeyqcd-6MqfuhFhElqoZYsjKCHeboiQZM/getUpdates",
				ApiResponseUpdateTelegram.class);
		return ResponseEntity.ok().body(update);
	}

	@PostMapping("/sendMessage")
	public static ResponseEntity<ApiResponseTelegram> sendMessage(@RequestParam("text") String text, @RequestParam("chat_id") String chat_id) {
		RestTemplate restTemplate = new RestTemplate();
		ApiResponseTelegram sendMessage = restTemplate.getForObject("https://api.telegram.org/bot5348334660:AAGeyqcd-6MqfuhFhElqoZYsjKCHeboiQZM/sendMessage?text={text}"+"&chat_id={chat_id}",
				ApiResponseTelegram.class,text,chat_id);
		return ResponseEntity.ok().body(sendMessage);
	}

	@PostMapping("/deleteUpdate")
	public static ResponseEntity<ApiResponseTelegram> deleteUpdate(@RequestParam("offset") int offset) {
		RestTemplate restTemplate = new RestTemplate();
		ApiResponseTelegram deleteUpdate = restTemplate.getForObject("https://api.telegram.org/bot5348334660:AAGeyqcd-6MqfuhFhElqoZYsjKCHeboiQZM/getupdates?offset={offset}",ApiResponseTelegram.class,offset);
		return ResponseEntity.ok().body(deleteUpdate);
	}
}
