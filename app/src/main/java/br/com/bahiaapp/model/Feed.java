package br.com.bahiaapp.model;

import java.io.Serializable;

/**
 * Created by Igor Faria on 27/12/17.
 */
public class Feed implements Serializable{

    private Long id;
    private String title;
    private String shortDescription;
    private String textCompleate;
    private String datePublished;
    private String imageUrl;
    private String link;
    private Boolean mainNew;

    public Feed(Long id, String title, String shortDescription, String textCompleate,
                String datePublished, String imageUrl, String link, Boolean mainNew){
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.textCompleate = textCompleate;
        this.datePublished = datePublished;
        this.imageUrl = imageUrl;
        this.setLink(link);
        this.mainNew = mainNew;
    }

    public Feed(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTextCompleate() {
        return textCompleate;
    }

    public void setTextCompleate(String textCompleate) {
        this.textCompleate = textCompleate;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean isMainNew() {
        return mainNew;
    }

    public void setMainNew(Boolean mainNew) {
        this.mainNew = mainNew;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
