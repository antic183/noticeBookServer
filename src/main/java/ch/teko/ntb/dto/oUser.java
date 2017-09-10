package ch.teko.ntb.dto;

import ch.teko.ntb.model.Notice;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antic-software-ing on 04.09.2017.
 */

@XmlRootElement
public class oUser {
  private int id;
  private String email;
  private String jwtToken;

  private List<Notice> noticeList;

  public oUser() {
    noticeList = new ArrayList<>();
  }

  public oUser(int id, String email) {
    this();
    this.id = id;
    this.email = email;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }

  public List<Notice> getNoticeList() {
    return noticeList;
  }

  public void addNotice(Notice notice) {
    noticeList.add(notice);
  }

  public void addNoticeList(List<Notice> noticeList) {
    this.noticeList.clear();
    this.noticeList.addAll(noticeList);
  }

  public void deleteNotice(Notice notice) {
    noticeList.remove(notice);
  }
}