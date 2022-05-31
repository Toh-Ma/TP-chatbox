package fr.ensim.interop.introrest.model.Joke;

import java.util.ArrayList;

public class JokeList {
    // liste de blagues
    ArrayList<Joke> jokes = new ArrayList<Joke>();
    public JokeList(){

        jokes.add(new Joke("La vitamine C...\n" +
                "\n" +
                "Mais ne dira rien.", 5, 1));
        jokes.add(new Joke("Comment appelle-t-on un chien qui n'a pas de pattes ? \n"
                +"\n" + "On ne l'appelle pas on va le chercher...", 6, 2));
        jokes.add(new Joke("Quesqu'un cadeau qui s'en va ?\n" +
                "\n" +
                "Une surprise party.", 4, 3));
        jokes.add(new Joke("Pourquoi la petite fille est elle tombé de la balançoire ?\n" +
                "\n" +
                "Parce qu'elle n'a pas de bras.", 6, 4));
        jokes.add(new Joke("Qu'est-ce qui est jaune et qui court vite ?\n" +
                "\n" +
                "Un citron pressé.", 5, 5));
        jokes.add(new Joke("Quel fruit le poisson déteste-il le plus ?\n" +
                "\n" +
                "La pêche.", 4, 6));
        jokes.add(new Joke("Comment appelle-t-on un nain qui travaille à la poste ?\n" +
                "\n" +
                "Un nain posteur.", 6, 7));
        jokes.add(new Joke("Pourquoi Robinson Cruzoé ?\n" +
                "\n" +
                "Car Zoé avait raison.", 5, 8));
        jokes.add(new Joke("Quel est le comble pour un dentiste ?\n" +
                "\n" +
                "De vivre dans un palais.", 7, 9));
        jokes.add(new Joke("C'est un boeuf qui court...\n" +
                "\n" +
                "Et qui se viande.", 6, 10));
        jokes.add(new Joke("Que dit un informaticien quand il s'ennuie ?\n" +
                "\n" +
                "Je me fichier.", 7, 11));
    }

    //String dataJoke = jokes.get(0).getData();

    public String getDataJoke(int id){
        return jokes.get(id).getData();
    }

    /**
     * Méthode qui renvoie une blague.
     */
    public ArrayList<Joke> getJokes(){
        return jokes;
    }

}
