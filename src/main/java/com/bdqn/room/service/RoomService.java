package com.bdqn.room.service;

import com.bdqn.room.pojo.Bar;
import com.bdqn.room.pojo.Room;
import com.bdqn.room.pojo.Roomaddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {
    List<Room> getAll(@Param("address1") String address1, @Param("address2")String address2, @Param("price")Integer price, @Param("pageSize")Integer pageSize, @Param("pageNo")Integer pageNo);
    int count(@Param("address1") String address1,@Param("address2")String address2,@Param("price")Integer price);
    List<Roomaddress> getOne();
    List<Roomaddress> getTwo(Integer id);
    int all(@Param("type")String type,@Param("dateLimit") String dateLimit,@Param("id")Integer id);
    List<Room> gets();
    Bar login (@Param("bid")Integer bid, @Param("bname") String bname);
    List<Bar> findAll(@Param("bprice") Integer bprice,@Param("bname") String bname,@Param("bcolor") String bcolor,@Param("pageNo") Integer pageNo,@Param("pageSize")Integer pageSize);
    int counts(@Param("bprice") Integer bprice,@Param("bname") String bname,@Param("bcolor") String bcolor);
    int del(int bid);
    Bar getbyid(int bid);
}
