package com.example.isServer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String anons;
    String fullText;

    public Post(Long id, String title, String anons, String fullText, int views) {
        this.id = id;
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.views = views;
    }

    int views;

    public Post(String title, String anons, String fullText, int views) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.views = views;
    }

    public Post() {  }

    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
