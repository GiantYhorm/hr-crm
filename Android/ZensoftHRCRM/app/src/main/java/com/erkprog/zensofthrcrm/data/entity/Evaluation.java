package com.erkprog.zensofthrcrm.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Evaluation {

  private Integer id;
  @SerializedName("rate")
  private Integer rate;

  public Integer getRate() {
    return rate;
  }

  public void setRate(Integer rate) {
    this.rate = rate;
  }

  public List<Criteria> getCriterias() {
    return criterias;
  }

  public void setCriterias(List<Criteria> criterias) {
    this.criterias = criterias;
  }

  @SerializedName("criteria")
  private List<Criteria> criterias;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
