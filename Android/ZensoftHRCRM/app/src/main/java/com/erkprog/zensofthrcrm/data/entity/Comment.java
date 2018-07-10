package com.erkprog.zensofthrcrm.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Comment {
  @SerializedName("id")
  private Integer id;

  @SerializedName("text")
  private String text;

  @SerializedName("created_by")
  private User createdBy;

//    @SerializedName("created")
//    private Date created;


  @SerializedName("candidate")
  private Candidate candidate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }


  //    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
}