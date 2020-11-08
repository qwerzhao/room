package com.bdqn.room.pojo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor //全参构造器
@NoArgsConstructor //无参构造器
public class Room implements Serializable {

  private long id;
  private String name;
  private long price;
  private long address1;
  private long address2;
  private String status;
  private String dateLimit;
  private long masterPrice;
  private long bedPrice;
  private String payMethod;
  private String one;
  private String two;

  public String getOne() {
    return one;
  }

  public void setOne(String one) {
    this.one = one;
  }

  public String getTwo() {
    return two;
  }

  public void setTwo(String two) {
    this.two = two;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }


  public long getAddress1() {
    return address1;
  }

  public void setAddress1(long address1) {
    this.address1 = address1;
  }


  public long getAddress2() {
    return address2;
  }

  public void setAddress2(long address2) {
    this.address2 = address2;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getDateLimit() {
    return dateLimit;
  }

  public void setDateLimit(String dateLimit) {
    this.dateLimit = dateLimit;
  }


  public long getMasterPrice() {
    return masterPrice;
  }

  public void setMasterPrice(long masterPrice) {
    this.masterPrice = masterPrice;
  }


  public long getBedPrice() {
    return bedPrice;
  }

  public void setBedPrice(long bedPrice) {
    this.bedPrice = bedPrice;
  }


  public String getPayMethod() {
    return payMethod;
  }

  public void setPayMethod(String payMethod) {
    this.payMethod = payMethod;
  }

}
