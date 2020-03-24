package com.example.task.Model;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userid;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public Post(int userid, String title, String text) {
        this.userid = userid;
        this.title = title;
        this.text = text;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
