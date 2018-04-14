package com.sid.vocabulary.bean;

/**
 * Created 2018/4/13.
 *
 * @author HongTao
 */

public class EnglishNews {

    /**
     * source : {"id":"fox-news","name":"Fox News"}
     * author : Greg Norman
     * title : North Carolina incest father told mother he killed daughter-wife and their child in shocking 911 call
     * description : The North Carolina incest dad, whose Thursday murder spree took the lives of the biological daughter he married and the infant child he fathered with the girl, reportedly explained his possible motive to his own mother in a stunning phone call moments before …
     * url : http://www.foxnews.com/us/2018/04/13/north-carolina-incest-father-told-mother-killed-daughter-wife-and-their-child-in-shocking-911-call.html
     * urlToImage : http://a57.foxnews.com/images.foxnews.com/content/fox-news/us/2018/04/13/north-carolina-incest-father-told-mother-killed-daughter-wife-and-their-child-in-shocking-911-call/_jcr_content/par/featured_image/media-0.img.jpg/0/0/1523619641052.jpg?ve=1
     * publishedAt : 2018-04-13T12:44:52Z
     */

    private SourceBean source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    public SourceBean getSource() {
        return source;
    }

    public void setSource(SourceBean source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public static class SourceBean {
        /**
         * id : fox-news
         * name : Fox News
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
