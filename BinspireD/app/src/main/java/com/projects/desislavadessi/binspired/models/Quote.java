package com.projects.desislavadessi.binspired.models;

public class Quote {

    public String author;
    public String quoteText;

    public Quote (){
       // empty constructor;
    }

    public Quote (String author, String quoteText){
        this.author=author;
        this.quoteText=quoteText;
    }

    @Override
    public String toString() {
        return author;
    }
}
