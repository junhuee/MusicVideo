package com.jjunsoft.musicvideo;

/**
 * Created by alfo06-05 on 2018-05-01.
 */

public class BookMarkItem {

    String title;
    String date;
    int goodNum;
    int playNum;
    boolean bookm;
    String videoImg;

    public BookMarkItem(String title, String date, int goodNum, int playNum, boolean bookm, String videoImg) {
        this.title = title;
        this.date = date;
        this.goodNum = goodNum;
        this.playNum = playNum;
        this.bookm = bookm;
        this.videoImg = videoImg;
    }
}
