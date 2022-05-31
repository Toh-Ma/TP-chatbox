package fr.ensim.interop.introrest;

import fr.ensim.interop.introrest.controller.MessageRestController;
//import fr.ensim.interop.introrest.controller.OpenWeatherRestController;
import fr.ensim.interop.introrest.model.Joke.JokeList;
import fr.ensim.interop.introrest.model.telegram.ApiResponseTelegram;
import fr.ensim.interop.introrest.model.telegram.ApiResponseUpdateTelegram;
import fr.ensim.interop.introrest.model.telegram.Update;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ListenerUpdateTelegram implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		Logger.getLogger("ListenerUpdateTelegram").log(Level.INFO, "Démarage du listener d'updates Telegram...");




		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {


				ResponseEntity<ApiResponseUpdateTelegram> responseTelegram = MessageRestController.getUpdate();
				List<Update> response = responseTelegram.getBody().getResult();

				if(response.size()>0){
					String text =response.get(0).getMessage().getText();
					String[] text2=text.split(" ");

					if(text.equals("blague")){
						JokeList jokes = new JokeList();
						int nAlea = 0 + (int)(Math.random() * ((jokes.getJokes().size() - 1) + 1));
						MessageRestController.sendMessage(jokes.getDataJoke(nAlea), response.get(0).getMessage().getChatId().toString());
					}


					MessageRestController.deleteUpdate((response.get(response.size()-1).getUpdateId()+1));
				}


			}
		}, 0, 1000);

		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
		}





	}
}
