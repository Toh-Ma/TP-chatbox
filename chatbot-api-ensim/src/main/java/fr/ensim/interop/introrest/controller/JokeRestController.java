package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.ListenerUpdateTelegram;
import fr.ensim.interop.introrest.model.Joke.Joke;
import fr.ensim.interop.introrest.model.Joke.JokeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class JokeRestController {
//    private JokeList list = new JokeList();
    JokeList list = ListenerUpdateTelegram.getJokeList();

    //retourne une blague aléatoire dans goodJokes ou badJokes selon le paramètre
    @GetMapping("/joke")
    public ResponseEntity<Joke> getRandomJoke(@RequestParam("type") String type){

        if (type.equals("bien"))
            return ResponseEntity.ok().body(list.getRandomGoodJoke());
        else if (type.equals("nulle"))
            return ResponseEntity.ok().body(list.getRandomBadJoke());

        //retourne un code 400 si le paramètre ne correspond pas à bien ou nulle
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/allJoke")
    public ResponseEntity<ArrayList<Joke>> getAllJoke(){
            return ResponseEntity.ok().body(list.getJokes());
    }

    //retourne une blague aléatoire de list
    @GetMapping("/randomJoke")
    public ResponseEntity<Joke> getRandomJoke(){
        return ResponseEntity.ok().body(list.getRandomJoke());
    }



    @PostMapping("/addJoke")
    public ResponseEntity<Joke> addJoke(@RequestParam("content") String content, @RequestParam("note") Integer note){
        list.addJoke(new Joke(content, note, list.getJokes().size()));

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
