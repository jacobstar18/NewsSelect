package Eunsung.com;

import java.io.Serializable;

public class NewsData implements Serializable {

    private String title;
    private String urlToImage;
    private String content;
    private String pubDate;
    private String link;
    private String originallink;

    public String getPubDate() {
        return pubDate;
    }

    public String getLink() {
        return link;
    }

    public String getOriginallink() {
        return originallink;
    }


    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setOriginallink(String originallink) {
        this.originallink = originallink;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
