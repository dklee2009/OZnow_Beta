package com.example.dklee.oznow_beta;

import android.view.inputmethod.ExtractedText;

/**
 * Created by kyounghee on 2015-08-19.
 */
public class ContentVO {
    private int id;
    private String content;
    private String kind;
    private String bookmark;
    private String c_name;
    private String c_color;

    public ContentVO(){
        super();
    }

    public ContentVO(int id, String content, String kind, String  bookmark, String c_name, String c_color){
        super();
        this.id=id;
        this.content=content;
        this.kind=kind;
        this.bookmark=bookmark;
        this.c_name=c_name;
        this.c_color=c_color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setBookmark(String  bookmark) {
        this.bookmark = bookmark;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_color(String c_color) {
        this.c_color = c_color;
    }

    public String getC_color() {
        return c_color;
    }
}
