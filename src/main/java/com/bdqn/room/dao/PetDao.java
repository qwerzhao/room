package com.bdqn.room.dao;

import com.bdqn.room.pojo.Count;
import com.bdqn.room.pojo.Pet;
import com.bdqn.room.pojo.Puser;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PetDao {
    @Select("select * from Puser where pname=#{pname} and pwd =#{pwd}")
    Puser petLogin(@Param("pname")String pname,@Param("pwd") String pwd);
    @Insert("insert into puser(pname,pmoney,pwd)values(#{pname},#{pmoney},#{pwd})")
    int register(Puser user);
    List<Pet> getPet(@Param("pid") Integer pid, @Param("name") String name,@Param("price") Integer price,@Param("pname")String pname,@Param("pageNo")Integer pageNo,@Param("pageSize") Integer pageSize);
    int count(@Param("pid") Integer pid,@Param("name") String name,@Param("price") Integer price,@Param("pname")String pname);
    @Update("update Pet set pid =#{pid} where id=#{id}")
    int buy(@Param("id")Integer id,@Param("pid") Integer pid);
    @Select("select * from Pet where id=#{id}")
    Pet findbyid(Integer id);
    @Insert("insert into `count`(cdate,mid,cid)values(#{cdate},#{mid},#{cid}) ")
    int insert(@Param("cdate")String cdate,@Param("mid")Integer mid,@Param("cid")Integer cid);//新增买卖记录
    @Select("select * from pet where pid=#{pid}")
    List<Pet> spet (Integer pid);
    @Select("select * from Pet limit #{pageNo},#{pageSize}")
    List<Pet> All(@Param("pageNo")Integer pageNo,@Param("pageSize") Integer pageSize);
    @Delete("delete from pet where id=#{id} ")
    int dels(Integer id);
    @Select("SELECT count(*) from pet")
    int cc();
}
