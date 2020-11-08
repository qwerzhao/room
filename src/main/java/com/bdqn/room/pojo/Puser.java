package com.bdqn.room.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor //全参构造器
@NoArgsConstructor //无参构造器
public class Puser {

  private long pid;
  private String pname;
  private long pmoney;
  private String pwd;


  public long getPid() {
    return pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }


  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }


  public long getPmoney() {
    return pmoney;
  }

  public void setPmoney(long pmoney) {
    this.pmoney = pmoney;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

}
