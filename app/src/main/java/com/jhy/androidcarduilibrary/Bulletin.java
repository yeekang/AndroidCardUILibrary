package com.jhy.androidcarduilibrary;

public class Bulletin {
    public String title;
    public String publishTS;
    public String snippet;
    public String newsId;
    public String sourceUrl;
    public String imageId;
    public String showContent;

    public Bulletin(String title, String publishTS, String snippet, String newsId, String sourceUrl, String imageId, String showContent) {
        this.title = title;
        this.publishTS = publishTS;
        this.snippet = snippet;
        this.newsId = newsId;
        this.sourceUrl = sourceUrl;
        this.imageId = imageId;
        this.showContent = showContent;
    }
}