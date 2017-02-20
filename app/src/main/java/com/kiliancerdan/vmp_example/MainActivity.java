package com.kiliancerdan.vmp_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ImageAdapter adapter;
    private MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        ButterKnife.bind(this);
        adapter = new ImageAdapter();
        recyclerView.setAdapter(adapter);
        presenter = new MainPresenter(this);
        presenter.getImages();
    }

    @Override
    public void setCatsImages(List<CatImage> catsImages) {
        adapter.setCats(catsImages);
    }
}
