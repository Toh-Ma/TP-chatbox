package fr.ensim.interop.introrest.model.Joke;

import java.util.ArrayList;

public class JokeList {
    // liste de blagues
    ArrayList<Joke> jokes = new ArrayList<Joke>();
    ArrayList<Joke> goodJokes = new ArrayList<Joke>();
    ArrayList<Joke> badJokes = new ArrayList<Joke>();


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


        for (Joke joke: jokes) {
            if (joke.getNote() > 5)
                goodJokes.add(joke);
            else
                badJokes.add(joke);
        }
    }


    //Retourne une blague aléatoire dans la liste jokes
    public Joke getRandomJoke(){
        int randomId = 0 + (int)(Math.random() * ((jokes.size() - 1) + 1));
        return jokes.get(randomId);
    }

    //Retourne une blague aléatoire dans la liste goodJokes
    public Joke getRandomGoodJoke(){
        int randomId = 0 + (int)(Math.random() * ((goodJokes.size() - 1) + 1));
        return goodJokes.get(randomId);
    }

    //Retourne une blague aléatoire dans la liste badJokes
    public Joke getRandomBadJoke(){
        int randomId = 0 + (int)(Math.random() * ((badJokes.size() - 1) + 1));
        return badJokes.get(randomId);
    }

    public String getDataJoke(int id){
        return jokes.get(id).getData();
    }

    public Integer getNoteJoke(int id) { return jokes.get(id).getNote();}
    /**
     * Méthode qui renvoie une blague.
     */
    public ArrayList<Joke> getJokes(){
        return jokes;
    }

    public ArrayList<Joke> getGoodJokes() {
        return goodJokes;
    }

    public void setGoodJokes(ArrayList<Joke> goodJokes) {
        this.goodJokes = goodJokes;
    }

    public ArrayList<Joke> getBadJokes() {
        return badJokes;
    }

    public void setBadJokes(ArrayList<Joke> badJokes) {
        this.badJokes = badJokes;
    }

}
