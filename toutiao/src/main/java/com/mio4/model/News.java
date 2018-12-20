package com.mio4.model;

import java.util.Date;

/**
 * CREATE TABLE `news`(
 *   `id` int(11) unsigned not null auto_increment,
 *   `title` varchar(128) not null default '',
 *   `link` varchar(256) not null default '',
 *   `image` varchar(256)not null default '',
 *   `like_count` int(11) not null,
 *   `comment_count` int(11) not null,
 *   `created_date` datetime not null,
 *   `user_id` int(11) not null,
 *   primary key(`id`)
 * )ENGINE = InnoDB,auto_increment = 11,charset=UTF8;
 */
public class News {
    private int id;
    private String title;
    private String link;
    private String image;
    private int likeCount;
    private int commentCount;
    private Date createdDate;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
