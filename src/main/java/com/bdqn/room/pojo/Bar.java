package com.bdqn.room.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor //全参构造器
@NoArgsConstructor //无参构造器
public class Bar implements Serializable {
    private int bid;
    private String bname;
    private int bprice;
    private String bcolor;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }



    public String getBcolor() {
        return bcolor;
    }

    public void setBcolor(String bcolor) {
        this.bcolor = bcolor;
    }

    public Double getBvol() {
        return bvol;
    }

    public void setBvol(Double bvol) {
        this.bvol = bvol;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public int getBprice() {
        return bprice;
    }

    public void setBprice(int bprice) {
        this.bprice = bprice;
    }

    private Double bvol;
    private String btime;
}
