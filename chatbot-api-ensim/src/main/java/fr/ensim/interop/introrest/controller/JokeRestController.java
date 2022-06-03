package fr.ensim.interop.introrest.controller;

import fr.ensim.interop.introrest.model.Joke.Joke;
import fr.ensim.interop.introrest.model.Joke.JokeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeRestController {
    private JokeList list = new JokeList();

    @GetMapping("/joke")
    public ResponseEntity<Joke> getRandomJoke(@RequestParam("type") String type){
        if (type.equals("bien"))
            return ResponseEntity.ok().body(list.getRandomGoodJoke());
        else if (type.equals("nulle"))
            return ResponseEntity.ok().body(list.getRandomBadJoke());

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/randomJoke")
    public ResponseEntity<Joke> getRandomJoke(){
        return ResponseEntity.ok().body(list.getRandomJoke());
    }
}
