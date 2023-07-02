package com.company.summative.controller;

import com.company.summative.models.Quote;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {

    private List<Quote> quoteList;

    Random random = new Random();

    public QuoteController(){

        Quote quote1 = new Quote("Education is the passport to the future, for tomorrow belongs to those who prepare for it today.", "Malcom X");
        Quote quote2 = new Quote("All our dreams can come true, if we have the courage to pursue them.", "Walt Disney");
        Quote quote3 = new Quote("You’ve gotta dance like there’s nobody watching, love like you’ll never be hurt, sing like there’s nobody listening, and live like it’s heaven on earth.", "William W. Purkey");
        Quote quote4 = new Quote("Do one thing every day that scares you.", "Eleanor Roosevelt");
        Quote quote5 = new Quote("Smart people learn from everything and everyone, average people from their experiences, stupid people already have all the answers", "Socrates");
        Quote quote6 = new Quote("Impossible is just an opinion.", "Paulo Coelho");
        Quote quote7 = new Quote("If you hear a voice within you say, ‘You cannot paint,’ then by all means paint, and that voice will be silenced.", "Vincent Van Gogh");
        Quote quote8 = new Quote("You can waste your lives drawing lines. Or you can live your life crossing them.", "Shonda Rhimes");
        Quote quote9 = new Quote("If opportunity doesn’t knock, build a door.", "Kurt Cobain");
        Quote quote10 = new Quote("Work hard in silence, let your success be the noise.", "Frank Ocean");

        quoteList = Arrays.asList(quote1, quote2, quote3, quote4, quote5, quote6, quote7, quote8, quote9, quote10);
    }


    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public Quote getQuoteOfTheDay(){
        Quote randomQuote = null;
        int index = random.nextInt(quoteList.size());

        randomQuote = quoteList.get(index);

        return randomQuote;
    }




}
