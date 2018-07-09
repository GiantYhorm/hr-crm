package com.erkprog.zensofthrcrm.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Vacancy {
  @SerializedName("id")
  private Integer id;
  @SerializedName("name")
  private String name;
  @SerializedName("date_created")
  private String dateCreated;
  @SerializedName("date_last_published")
  private String dateLastPublished;
  @SerializedName("status")
  private Integer status;

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

  public String getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(String dateCreated) {
    this.dateCreated = dateCreated;
  }

  public String getDateLastPublished() {
    return dateLastPublished;
  }

  public void setDateLastPublished(String dateLastPublished) {
    this.dateLastPublished = dateLastPublished;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
