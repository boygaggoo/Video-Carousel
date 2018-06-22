package com.assignment.carouselonvideoexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.assignment.carouselonvideoexample.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ZeeZee on 11/4/2017.
 */

public class ImagesCarouselRecyclerViewAdapter extends RecyclerView.Adapter<ImagesCarouselRecyclerViewAdapter.FavouriteViewHolder>
{
    ArrayList<String> imagesUrls;
    Context context;

    public ImagesCarouselRecyclerViewAdapter(ArrayList<String> imagesUrls, Context context)
    {
        this.imagesUrls = imagesUrls;
        this.context = context;
    }

    @Override
    public FavouriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_item, parent, false);
        return new FavouriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavouriteViewHolder holder, int position)
    {
        holder.bindView(position);
    }

    @Override
    public int getItemCount()
    {
        return imagesUrls.size();
    }

    public class FavouriteViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivImage;

        public FavouriteViewHolder(View itemView)
        {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
        }

        public void bindView(int position)
        {
            Picasso.get()
                    .load(imagesUrls.get(position))
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivImage);

        }
    }
}
