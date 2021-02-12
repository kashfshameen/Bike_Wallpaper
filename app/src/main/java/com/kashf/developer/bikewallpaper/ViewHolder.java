package com.kashf.developer.bikewallpaper;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    LinearLayout linearLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void setDetails(Context context, String image){

        ImageView imageView = itemView.findViewById(R.id.imageViewItem);

        Picasso.get().load(image).into(imageView);


        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        itemView.setAnimation(animation);
    }
}