package com.example.task.Model;

public class Deals_details {

    String percent;
    String item_name;
    int imageid;
    public Deals_details(String percent, String item_name, int imageid) {
        this.percent = percent;
        this.item_name = item_name;
        this.imageid = imageid;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
