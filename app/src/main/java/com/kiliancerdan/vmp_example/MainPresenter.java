package com.kiliancerdan.vmp_example;

import java.util.List;

class MainPresenter implements ImagesInteractor.Callback {

    private MainView view;
    private ImagesInteractor interactor;

    public MainPresenter(MainView view) {
        this.view = view;
        interactor = new ImagesInteractor(this);
    }

    public void getImages() {
        interactor.generateImages();
    }

    @Override
    public void getImagesFromInternet(List<CatImage> catImages) {
        view.setCatsImages(catImages);
    }


    interface MainView {
        void setCatsImages(List<CatImage> catImages);
    }
}
