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
    private String category;

    public ContentVO(){
        super();
    }

    public ContentVO(int id, String content, String kind, String  bookmark, String category){
        super();
        this.id=id;
        this.content=content;
        this.kind=kind;
        this.bookmark=bookmark;
        this.category=category;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
