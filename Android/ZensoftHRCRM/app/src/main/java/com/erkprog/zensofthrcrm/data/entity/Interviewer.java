package com.erkprog.zensofthrcrm.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Interviewer {
  @SerializedName("id")
  private Integer id;
  @SerializedName("user")
  private User user;
  @SerializedName("comment")
  private String comment;
  @SerializedName("evaluations")
  private List<Evaluation> evaluationList;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public List<Evaluation> getEvaluationList() {
    return evaluationList;
  }

  public void setEvaluationList(List<Evaluation> evaluationList) {
    this.evaluationList = evaluationList;
  }
}
