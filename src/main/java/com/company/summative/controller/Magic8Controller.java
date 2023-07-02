package com.company.summative.controller;

import com.company.summative.models.Magic8;
import com.company.summative.models.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class Magic8Controller {

    private List<Magic8> magic8List = new ArrayList<>();
    Random random= new Random();
    public Magic8Controller(){
        magic8List.add(new Magic8("It is certain."));
        magic8List.add(new Magic8("Ask again later."));
        magic8List.add(new Magic8("It is decidedly so."));
        magic8List.add(new Magic8("Without a doubt."));
        magic8List.add(new Magic8("Don't count on it."));
        magic8List.add(new Magic8("Yes definitely."));
        magic8List.add(new Magic8("Concentrate and ask again."));
        magic8List.add(new Magic8("You may rely on it."));
        magic8List.add(new Magic8("As I see it, yes."));
        magic8List.add(new Magic8("Cannot predict now."));
        magic8List.add(new Magic8("Very doubtful."));
        magic8List.add(new Magic8("Most likely."));
        magic8List.add(new Magic8("Outlook good."));
        magic8List.add(new Magic8("My sources say no."));
        magic8List.add(new Magic8("Yes."));
        magic8List.add(new Magic8("Signs point to yes."));
        magic8List.add(new Magic8("Reply hazy, try again."));
        magic8List.add(new Magic8("Outlook not so good."));
        magic8List.add(new Magic8("Better not tell you now."));
        magic8List.add(new Magic8("My reply is no."));
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    @ResponseBody
    public Magic8 getAnswer(@RequestBody(required = false) Question question){
        int index = random.nextInt( magic8List.size());
        Magic8 m8 = magic8List.get(index);
        if(question != null){
            m8.setQuestion(question.getQuestion());
        }
        return m8;
    }





}
