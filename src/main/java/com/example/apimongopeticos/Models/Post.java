package com.example.apimongopeticos.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Document(collection = "post")
public class Post {
    @Id
    private String id;
    private BigInteger user_id;
    private List likes;
    private List shares;
    private String picture;
    private String caption;
    private List<BigInteger> pets;

    private Date post_date;
    private boolean is_mei;
    private  Double price;
    private String telephone;

    private String product_name;

    public Post() {
    }

    public Post(String id, BigInteger userId, List likes, List shares, String picture, String caption, List<BigInteger> pets, Date postDate, boolean isMei, Double price, String telephone, String productName) {
        this.id = id;
        this.user_id = userId;
        this.likes = likes;
        this.shares = shares;
        this.picture = picture;
        this.caption = caption;
        this.pets = pets;
        this.post_date = postDate;
        this.is_mei = isMei;
        this.price = price;
        this.telephone = telephone;
        this.product_name = productName;
    }

    public Post(String id, BigInteger userId, List likes, List shares, String picture, String caption, Date postDate, boolean isMei, Double price, String telephone, String productName) {
        this.id = id;
        this.user_id = userId;
        this.likes = likes;
        this.shares = shares;
        this.picture = picture;
        this.caption = caption;
        this.post_date = postDate;
        this.is_mei = isMei;
        this.price = price;
        this.telephone = telephone;
        this.product_name = productName;
    }

    public Post(String id, BigInteger user_id, List likes, List shares, String picture, String caption, List<BigInteger> pets, Date post_date, boolean is_mei) {
        this.id = id;
        this.user_id = user_id;
        this.likes = likes;
        this.shares = shares;
        this.picture = picture;
        this.caption = caption;
        this.pets = pets;
        this.post_date = post_date;
        this.is_mei = is_mei;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List getLikes() {
        return likes;
    }

    public void setLikes(List likes) {
        this.likes = likes;
    }

    public List getShares() {
        return shares;
    }

    public void setShares(List shares) {
        this.shares = shares;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<BigInteger> getPets() {
        return pets;
    }

    public void setPets(List<BigInteger> pets) {
        this.pets = pets;
    }

    public boolean isIs_mei() {
        return is_mei;
    }

    public void setIs_mei(boolean is_mei) {
        this.is_mei = is_mei;
    }
}
