package com.company.summative.models;

import java.util.Objects;

//The Definition model include the following:
//id
//word
//definition
public class Definition {
    private int id;
    private String word;
    private String definition;

    private static int count = 0;
    //constructor
    public Definition(String word, String definition) {
        this.word = word;
        this.definition = definition;
        count++;
        this.id = count;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return id == that.id && Objects.equals(word, that.word) && Objects.equals(definition, that.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, definition);
    }

    @Override
    public String toString() {
        return "Definition{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
