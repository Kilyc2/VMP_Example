package com.kiliancerdan.vmp_example;

public class CatImage {

    final private String title;
    final private String url;

    public CatImage(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
