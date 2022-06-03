package fr.ensim.interop.introrest.client;

import fr.ensim.interop.introrest.model.Joke.JokeList;

public class ClientRestTest {
	
	public static void main(String[] args) {

		JokeList list = new JokeList();

		for (int i = 0; i < 20; i++) {
			System.out.println(list.getRandomGoodJoke().getData());
		}



	}
}
