package com.jjunsoft.musicvideo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DetailVideoActivity extends AppCompatActivity {

    TextView good;
    TextView play;
    int goodnum;
    int playnum;
    TextView detailTitle;
    TextView detailDate;
    TextView detailContents;
    VideoView detailVideo;
    ImageView detailImg;
    TextView detailNickname;


    ArrayList<page1Fragment> item1 = new ArrayList<>();

    String title;
    String img;
    String video;
    String contents;
    String videopath = "http://wjdwnsgnl.dothome.co.kr/rookiestar/";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_video);

        Toolbar toolbar = findViewById(R.id.detailVideo_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        good = findViewById(R.id.detailVideo_goodtv);
        play = findViewById(R.id.detailVideo_playtv);
        detailTitle = findViewById(R.id.detailVideo_title);
        detailDate = findViewById(R.id.detailVideo_date);
        detailContents = findViewById(R.id.detailVideo_contents);
        detailVideo = findViewById(R.id.detailVideo_vv);
        detailImg = findViewById(R.id.detailVideo_img);
        detailNickname = findViewById(R.id.detailVideo_nickname);



        Intent intent = getIntent();
        detailTitle.setText(intent.getStringExtra("title"));
        Uri img = Uri.parse(intent.getStringExtra("video"));
        detailVideo.setVideoURI(img);
        detailVideo.start();
        detailContents.setText(intent.getStringExtra("contents"));

        GregorianCalendar calendar = new GregorianCalendar(Locale.KOREA);
        int y = calendar.get(Calendar.YEAR);
        int mo = calendar.get(Calendar.MONTH)+1;
        int dm = calendar.get(Calendar.DAY_OF_MONTH);
        detailDate.setText(y+"-"+mo+"-"+dm);












    }

    public void clickGoodnumber(View v){


    }

    public void clickPlaynumber(View v){

    }

    public void clickcomment(View v){

        Intent intent = new Intent(this, CommentActivity.class);
        startActivity(intent);


    }
}
