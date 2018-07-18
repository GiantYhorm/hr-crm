package com.erkprog.zensofthrcrm.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Message {
  private String task = "send";
  private List<Recipient> recipients;
  private Integer template = 0;
  private String subject;
  private String content;
  private List<Attachment> attachments;

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public List<Recipient> getRecipients() {
    return recipients;
  }

  public void setRecipients(List<Recipient> recipients) {
    this.recipients = recipients;
  }

  public Integer getTemplate() {
    return template;
  }

  public void setTemplate(Integer template) {
    this.template = template;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }
}