package com.example.apimongopeticos.Models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Document(collection = "post")
public class Post {
    @Id
    private BigInteger id;
    @Field(name = "user_id")
    private BigInteger userId;
    private int likes;
    private int shares;
    private String picture;
    private String caption;
    private List<BigInteger> pets;
    @Field(name = "post_date")

    private Date postDate;
    @Field(name = "is_mei")
    private boolean isMei;
    private  Double price;
    private String telephone;
    @Field(name = "product_name")

    private String productName;

    public Post() {
    }

    public Post(BigInteger id, BigInteger userId, int likes, int shares, String picture, String caption, List<BigInteger> pets, Date postDate, boolean isMei, Double price, String telephone, String productName) {
        this.id = id;
        this.userId = userId;
        this.likes = likes;
        this.shares = shares;
        this.picture = picture;
        this.caption = caption;
        this.pets = pets;
        this.postDate = postDate;
        this.isMei = isMei;
        this.price = price;
        this.telephone = telephone;
        this.productName = productName;
    }

    public Post(BigInteger id, BigInteger userId, int likes, int shares, String picture, String caption, Date postDate, boolean isMei, Double price, String telephone, String productName) {
        this.id = id;
        this.userId = userId;
        this.likes = likes;
        this.shares = shares;
        this.picture = picture;
        this.caption = caption;
        this.postDate = postDate;
        this.isMei = isMei;
        this.price = price;
        this.telephone = telephone;
        this.productName = productName;
    }

    public Post(BigInteger id, BigInteger user_id, int likes, int shares, String picture, String caption, List<BigInteger> pets, Date post_date, boolean is_mei) {
        this.id = id;
        this.userId = user_id;
        this.likes = likes;
        this.shares = shares;
        this.picture = picture;
        this.caption = caption;
        this.pets = pets;
        this.postDate = post_date;
        this.isMei = is_mei;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public boolean isMei() {
        return isMei;
    }

    public void setMei(boolean mei) {
        isMei = mei;
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

    public BigInteger getUser_id() {
        return userId;
    }

    public void setUser_id(BigInteger user_id) {
        this.userId = user_id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
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

    public Date getPost_date() {
        return postDate;
    }

    public void setPost_date(Date post_date) {
        this.postDate = post_date;
    }

    public boolean isIs_mei() {
        return isMei;
    }

    public void setIs_mei(boolean is_mei) {
        this.isMei = is_mei;
    }
}
