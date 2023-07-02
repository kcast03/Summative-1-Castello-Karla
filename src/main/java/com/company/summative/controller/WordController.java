package com.company.summative.controller;

import com.company.summative.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {

    private List<Definition> wordList;

    //list of words and their id and definitions
    public WordController() {
        Definition Resilient = new Definition( "Resilient", "The ability to bounce back after a challenge or setback");
        Definition Abundant = new Definition( "Abundant", "More than enough");
        Definition Diligent = new Definition( "Diligent", "hardworking");
        Definition Impartial = new Definition( "Impartial", "The act of being fair or unbiased");
        Definition Novice = new Definition( "Novice", "A person with little experience in a field or situation");
        Definition Frugal = new Definition("Frugal", "Being diligent when spending on resources such as food, money, or time. Not being wasteful  ");
        Definition Lucid = new Definition("Lucid", "Easily understandable");
        Definition Tenacious = new Definition("Tenacious", "Being persistent");
        Definition Melancholy = new Definition("Melancholy", "Feeling a reflective sadness with no reason");
        Definition Nebulous = new Definition("Nebulous", "vague or unclear");

        wordList = Arrays.asList(Resilient, Abundant, Diligent, Impartial, Novice, Frugal, Lucid, Tenacious, Melancholy, Nebulous);
    }

    //retrieve a random word and its definition
    //URI: /word
    //Method: GET
    //Request Body: None
    //Response Body: Definition
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWordAndDef(){

        if (wordList.isEmpty()) { // if the list is empty
            return null;
        }

        Random random = new Random();

        int idx = random.nextInt(wordList.size());

        return wordList.get(idx);
    }
}
