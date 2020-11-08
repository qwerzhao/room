package com.bdqn.room.dao;

import com.bdqn.room.pojo.Bar;
import com.bdqn.room.pojo.Room;
import com.bdqn.room.pojo.Roomaddress;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface RoomDao {
    List<Room> getAll(@Param("address1") String address1,@Param("address2")String address2,@Param("price")Integer price,@Param("pageSize")Integer pageSize,@Param("pageNo")Integer pageNo);
    int count(@Param("address1") String address1,@Param("address2")String address2,@Param("price")Integer price);
    @Select("select * from roomaddress where parentId=0")
    List<Roomaddress> getOne();
    @Select("select * from roomaddress where parentId=#{id}")
    List<Roomaddress> getTwo(Integer id);
    @Update("update room set dateLimit=#{dateLimit},payMethod=#{type} where id=#{id}")
    int all(@Param("type")String type,@Param("dateLimit") String dateLimit,@Param("id")Integer id);
    @Select("select * from room")
    List<Room> gets();
    @Select("select * from bar where bid=#{bid} and bname =#{bname}")
    Bar login (@Param("bid")Integer bid,@Param("bname") String bname);
    List<Bar> findAll(@Param("bprice") Integer bprice,@Param("bname") String bname,@Param("bcolor") String bcolor,@Param("pageNo") Integer pageNo,@Param("pageSize")Integer pageSize);
    int counts(@Param("bprice") Integer bprice,@Param("bname") String bname,@Param("bcolor") String bcolor);
    @Delete("delete from bar  where bid=#{bid}")
    int del(int bid);
    @Select("select * from bar where  bid =#{bid}")
    Bar getbyid(int bid);
}
