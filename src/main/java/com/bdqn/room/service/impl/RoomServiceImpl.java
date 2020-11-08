package com.bdqn.room.service.impl;

import com.bdqn.room.dao.RoomDao;
import com.bdqn.room.pojo.Bar;
import com.bdqn.room.pojo.Room;
import com.bdqn.room.pojo.Roomaddress;
import com.bdqn.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    RoomDao rd;
    @Override
    public List<Room> getAll(String address1, String address2, Integer price, Integer pageSize, Integer pageNo) {
        return rd.getAll(address1, address2, price, (pageSize-1)*pageNo, pageNo);
    }

    @Override
    public int count(String address1, String address2, Integer price) {
        return rd.count(address1,address2,price);
    }

    @Override
    public List<Roomaddress> getOne() {
        return rd.getOne();
    }

    @Override
    public List<Roomaddress> getTwo(Integer id) {
        return rd.getTwo(id);
    }

    @Override
    public int all(String type, String dateLimit, Integer id) {
        return rd.all(type,dateLimit,id);
    }

    @Override
    public List<Room> gets() {
        return rd.gets();
    }

    @Override
    public Bar login(Integer bid, String bname) {
        return rd.login(bid,bname);
    }

    @Override
    public List<Bar> findAll(Integer bprice, String bname, String bcolor, Integer pageNo, Integer pageSize) {
        return rd.findAll(bprice,bname,bcolor, (pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int counts(Integer bprice, String bname, String bcolor) {
        return rd.counts(bprice,bname,bcolor);
    }

    @Override
    public int del(int bid) {
        return rd.del(bid);
    }

    @Override
    public Bar getbyid(int bid) {
        return rd.getbyid(bid);
    }


}
