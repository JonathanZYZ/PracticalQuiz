package com.myapplicationdev.android.practicalquiz;

public class Tasks {
    private String item;
    private String desc;
    private String date;

    public Tasks(String item, String desc, String date) {
        this.item = item;
        this.desc = desc;
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
