package com.mio4.model;

/**
 * CREATE TABLE `user`(
 *   `id` int(11) primary key,
 *   `name` varchar(64),
 *   `password` varchar(64),
 *   `salt` varchar(16),
 *   `head_url` varchar(32)
 * )ENGINE = InnoDB,charset=UTF8;
 */
public class User {
    private Integer id;
    private String name;
    private String password;
    private String salt;
    private String headUrl;


    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", headUrl='" + headUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
}
