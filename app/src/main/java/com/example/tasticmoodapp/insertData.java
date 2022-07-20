package com.example.tasticmoodapp;

public class insertData {
    String names;
    String age_num;
    String emotion;
    String type1;
    String date1;

    public insertData(String names, String age_num, String emotion, String type1, String date1) {
        this.names = names;
        this.age_num = age_num;
        this.emotion = emotion;
        this.type1 = type1;
        this.date1 = date1;
    }

    public String getNames() {
        return names;
    }

    public String getAge_num() {
        return age_num;
    }

    public String getEmotion() {
        return emotion;
    }

    public String getType1() {
        return type1;
    }

    public String getDate1() {
        return date1;
    }
}
