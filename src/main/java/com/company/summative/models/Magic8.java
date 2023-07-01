package com.company.summative.models;

import java.util.Objects;

public class Magic8 {

    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }


    private String answer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magic8 magic8 = (Magic8) o;
        return Objects.equals(question, magic8.question) && Objects.equals(answer, magic8.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
private int id;
    static int count = 0;
    public Magic8(String ans){
        this.answer = ans;
        count +=1;
        id = count;
    }
}
