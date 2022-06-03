package fr.ensim.interop.introrest;

import fr.ensim.interop.introrest.controller.MessageRestController;
import fr.ensim.interop.introrest.controller.WeatherRestController;
import fr.ensim.interop.introrest.model.Joke.Joke;
import fr.ensim.interop.introrest.model.Joke.JokeList;
import fr.ensim.interop.introrest.model.telegram.ApiResponseUpdateTelegram;
import fr.ensim.interop.introrest.model.telegram.Update;
import fr.ensim.interop.introrest.model.weather.Forecast;
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
	JokeList jokeList = new JokeList();

	@Override
	public void run(String... args) throws Exception {
		Logger.getLogger("ListenerUpdateTelegram").log(Level.INFO, "Démarage du listener d'updates Telegram...");

		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				//récupérer les derniers messages envoyés au bot
				ResponseEntity<ApiResponseUpdateTelegram> responseTelegram = MessageRestController.getUpdate();
				List<Update> response = responseTelegram.getBody().getResult();

				if(response.size()>0){
					String request = response.get(0).getMessage().getText();		//récupérer le message envoyé par l'utilisateur
					String[] splitRequest = request.split(" ", 2);		//sépare le premier terme de la commande voulue pour la traiter séparément
					String chatId = response.get(0).getMessage().getChatId().toString();	//récupérer l'id du chat où renvoyer la réponse de la requête

					//traitement de la requete "blague"
					if (splitRequest[0].equals("blague")){
						//Si on inscrit seulement "blague" dans le chat il renverra une blague aléatoirement
						if (splitRequest.length == 1){
							Joke randomJoke = jokeList.getRandomJoke();
							MessageRestController.sendMessage(randomJoke.getData(), chatId);
						}
						//traitement des option de la blague voulue indiquée dans la requête
						else {
							//Si on inscrit "blague nulle" dans le chat il renverra une blague aléatoirement dont la note est inférieure ou égale à 5
							if (splitRequest[1].equals("nulle")){
								Joke randomBadJoke = jokeList.getRandomBadJoke();
								MessageRestController.sendMessage(randomBadJoke.getData(), chatId);
							}

							//Si on inscrit "blague bien" dans le chat il renverra une blague aléatoirement dont la note est suppérieure à 5
							else if (splitRequest[1].equals("bien")){
								Joke randomGoodJoke = jokeList.getRandomGoodJoke();
								MessageRestController.sendMessage(randomGoodJoke.getData(), chatId);
							}

							else MessageRestController.sendMessage("Commande non reconnue", chatId);
						}
					}

					//traitement de la requete "meteo"
					else if (splitRequest[0].equals("meteo")) {
						//si aucune ville n'est mentionnée dans la requête, le bot renvoit par défaut la météo du Mans
						if (splitRequest.length < 2){
							ResponseEntity<Forecast> forecast = WeatherRestController.getWeatherForecast("Le Mans");
							MessageRestController.sendMessage(forecast.getBody().toString(), chatId);
						}
						else {
							//si la ville n'est pas reconnue, getWeatherForecast() renvoit null
							ResponseEntity<Forecast> forecast = WeatherRestController.getWeatherForecast(splitRequest[1]);

							if (forecast == null)
								MessageRestController.sendMessage("Erreur : la ville saisie n'est pas reconnue", chatId);
							else
								MessageRestController.sendMessage(forecast.getBody().toString(), chatId);
						}


					}

					//message d'erreur si la requete n'est pas reconnue
					else {
						MessageRestController.sendMessage("Commande non-reconnue. Veuillez utiliser l'une de ces commandes : \n\n" +
										"blague \n" +
										"blague bien \n" +
										"blague nulle\n" +
										"meteo \n" +
										"meteo ville_à_saisir"
							, chatId);
					}

					//mettre à jour les message obtenue par getUpdate pour ne recevoir que les nouveaux messages
					MessageRestController.deleteUpdate((response.get(response.size()-1).getUpdateId()+1));
				}

			}
		}, 0, 1000);

		for (int i = 0; i < 3; i++) {
			Thread.sleep(1000);
		}
	}
}
