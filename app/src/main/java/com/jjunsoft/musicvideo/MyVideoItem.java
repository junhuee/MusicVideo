package com.jjunsoft.musicvideo;

/**
 * Created by alfo06-05 on 2018-05-01.
 */

public class MyVideoItem {
    String title;
    String date;
    int goodNum;
    int playNum;
    String videoImg;

    public MyVideoItem(String title, String date, int goodNum, int playNum, String videoImg) {
        this.title = title;
        this.date = date;
        this.goodNum = goodNum;
        this.playNum = playNum;
        this.videoImg = videoImg;
    }
}
