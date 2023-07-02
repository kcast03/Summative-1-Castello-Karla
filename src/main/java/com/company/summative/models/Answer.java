package com.company.summative.models;

import java.util.Objects;

public class Answer {

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
    public String toString() {
        return "Magic8{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(question, answer.question) && Objects.equals(this.answer, answer.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
private int id;
    static int count = 0;
    public Answer(String ans){
        this.answer = ans;
        count +=1;
        id = count;
    }
}
