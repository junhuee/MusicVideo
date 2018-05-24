package com.jjunsoft.musicvideo;

/**
 * Created by alfo06-05 on 2018-03-21.
 */

public class Page1Item {

    String title;
    String day;
    int good;
    int player;
    boolean bookm;
    String videoImg;

    public Page1Item(String title, String day, int good, int player, boolean bookm, String videoImg) {
        this.title = title;
        this.day = day;
        this.good = good;
        this.player = player;
        this.bookm = bookm;
        this.videoImg = videoImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public boolean isBookm() {
        return bookm;
    }

    public void setBookm(boolean bookm) {
        this.bookm = bookm;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }
}
