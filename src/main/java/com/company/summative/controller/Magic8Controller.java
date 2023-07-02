package com.company.summative.controller;

import com.company.summative.models.Answer;
import com.company.summative.models.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class Magic8Controller {

    private List<Answer> answerList = new ArrayList<>();
    Random random= new Random();
    public Magic8Controller(){
        answerList.add(new Answer("It is certain."));
        answerList.add(new Answer("Ask again later."));
        answerList.add(new Answer("It is decidedly so."));
        answerList.add(new Answer("Without a doubt."));
        answerList.add(new Answer("Don't count on it."));
        answerList.add(new Answer("Yes definitely."));
        answerList.add(new Answer("Concentrate and ask again."));
        answerList.add(new Answer("You may rely on it."));
        answerList.add(new Answer("As I see it, yes."));
        answerList.add(new Answer("Cannot predict now."));
        answerList.add(new Answer("Very doubtful."));
        answerList.add(new Answer("Most likely."));
        answerList.add(new Answer("Outlook good."));
        answerList.add(new Answer("My sources say no."));
        answerList.add(new Answer("Yes."));
        answerList.add(new Answer("Signs point to yes."));
        answerList.add(new Answer("Reply hazy, try again."));
        answerList.add(new Answer("Outlook not so good."));
        answerList.add(new Answer("Better not tell you now."));
        answerList.add(new Answer("My reply is no."));
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    @ResponseBody
    public Answer getAnswer(@RequestBody(required = false) Question question){
        int index = random.nextInt( answerList.size());
        Answer m8 = answerList.get(index);
        if(question != null){
            m8.setQuestion(question.getQuestion());
        }
        return m8;
    }





}
