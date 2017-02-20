package com.kiliancerdan.vmp_example;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<CatImage> cats;

    public ImageAdapter() {
        this.cats = new ArrayList<>();
    }

    public void setCats(List<CatImage> cats) {
        this.cats.clear();
        this.cats.addAll(cats);
        notifyDataSetChanged();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        CatImage cat = cats.get(position);
        holder.setImage(cat.getUrl());
        holder.setTitle(cat.getTitle());
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;

        ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setTitle(String title) {
            this.title.setText(title);
        }

        void setImage(String url) {
            Picasso.with(image.getContext()).load(url).into(image);
        }
    }
}
