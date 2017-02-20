package com.kiliancerdan.vmp_example;

import java.util.ArrayList;
import java.util.List;

public class ImagesInteractor {

    private static final String THUMB_BASE = "http://lorempixel.com/400/400/cats/";

    private Callback callback;

    public ImagesInteractor(Callback callback) {
        this.callback = callback;
    }

    public void generateImages() {
        List<CatImage> urls = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            String number = String.valueOf(i);
            urls.add(new CatImage("Cat ".concat(number),THUMB_BASE.concat(number)));
        }
        callback.getImagesFromInternet(urls);
    }

    interface Callback {
        void getImagesFromInternet(List<CatImage> catImages);
    }
}
