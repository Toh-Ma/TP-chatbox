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
	private static String telegramApiUrl, telegramToken;

	//récupérer l'url et le token de l'api telegram enregistré dans application.properties
	@Value("${telegram.api.url}")
	public void setUrl(String url){
		MessageRestController.telegramApiUrl = url;
	}

	@Value("${telegram.bot.id}")
	public void setToken(String token){
		MessageRestController.telegramToken = token;
	}

	static RestTemplate restTemplate = new RestTemplate();

	//recevoir les derniers messages obtenus par le bot
	@GetMapping
	public static ResponseEntity<ApiResponseUpdateTelegram> getUpdate(){
		String query = telegramApiUrl + "bot"+ telegramToken +"/getUpdates";
		ApiResponseUpdateTelegram update = restTemplate.getForObject( query, ApiResponseUpdateTelegram.class);

		return ResponseEntity.ok().body(update);
	}

	//Envoyer un message à une personne avec son chat_id
	@PostMapping("/sendMessage")
	public static void sendMessage(@RequestParam("text") String text, @RequestParam("chat_id") String chat_id) {
		String query = telegramApiUrl + "bot"+ telegramToken;
		ApiResponseTelegram sendMessage = restTemplate.getForObject(query +"/sendMessage?text={text}&chat_id={chat_id}",
				ApiResponseTelegram.class,text,chat_id);

//		return ResponseEntity.ok().body(sendMessage);
	}



	@PostMapping("/deleteUpdate")
	public static void deleteUpdate(@RequestParam("offset") int offset) {
		String query = telegramApiUrl + "bot"+ telegramToken + "/getupdates?offset=" + offset;
		ApiResponseTelegram deleteUpdate = restTemplate.getForObject(query, ApiResponseTelegram.class,offset);
//		return ResponseEntity.ok().body(deleteUpdate);
	}



}