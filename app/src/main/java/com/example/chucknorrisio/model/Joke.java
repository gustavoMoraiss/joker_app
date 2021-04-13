package com.example.chucknorrisio.model;

public class Joke {

    private final String iconUrl;
    private String value;

    public Joke(String iconUrl, String value) {
        this.iconUrl = iconUrl;
        this.value = value;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getValue() {
        return value;
    }
}
