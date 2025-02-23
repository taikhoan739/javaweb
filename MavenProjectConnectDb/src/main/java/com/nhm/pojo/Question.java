/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhm.pojo;

/**
 *
 * @author admin
 */
public class Question {
    private String id;
    private String content;
    
    private int cateId;

    public Question(String id, String content, int cateId) {
        this.id = id;
        this.content = content;
        this.cateId = cateId;
    }
    public Question() {
    }

    @Override
    public String toString() {
        return this.content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }
    
}
