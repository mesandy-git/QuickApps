package com.app.quickapp.Models;

public class DataModels {
    String s_No;
    String question;
    boolean select;

    public DataModels(String s_No, String question, boolean select) {
        this.s_No = s_No;
        this.question = question;
        this.select = select;
    }

    public String getS_No() {
        return s_No;
    }

    public void setS_No(String s_No) {
        this.s_No = s_No;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
