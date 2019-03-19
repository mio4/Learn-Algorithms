package com.mio4.model;

/**
 * CREATE TABLE `user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(64) DEFAULT NULL,
 *   `password` varchar(64) DEFAULT NULL,
 *   `salt` varchar(16) DEFAULT NULL,
 *   `head_url` varchar(64) DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String head_url;


    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", head_url='" + head_url + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }
}
