package com.kashf.developer.bikewallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.material.internal.NavigationMenu;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class fullwallpaper extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    String name,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullwallpaper);

        imageView = findViewById(R.id.i_full);

        Bundle extras = getIntent().getExtras();
        if (extras != null){

            url = extras.getString("u");

        }else {

        }

        Picasso.get().load(url).into(imageView);
        AudienceNetworkAds.initialize(this);


        AdView adView = new AdView(this, "473569147185077_473572833851375", AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();

    }

    public void setwallpaper(View view) throws IOException {

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Bitmap bitmap  = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        wallpaperManager.setBitmap(bitmap);
        Toast.makeText(this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
    }

    public void DownloadWallpaperEvent(View view) {

        DownloadManager downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadManager.enqueue(request);
        Toast.makeText(this, "Downloading Start", Toast.LENGTH_SHORT).show();
    }


    public void shareimage(View view) {

        Bitmap bitmap  = ((BitmapDrawable)imageView.getDrawable()).getBitmap();



        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Image Description", null);
        Uri uri = Uri.parse(path);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/jpeg");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(intent, "Share Image"));
    }
}
