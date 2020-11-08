package com.bdqn.room.service;

import com.bdqn.room.dao.PetDao;
import com.bdqn.room.pojo.Count;
import com.bdqn.room.pojo.Pet;
import com.bdqn.room.pojo.Puser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetService {
    Puser petLogin(@Param("pname")String pname,@Param("pwd") String pwd);
    int register(Puser user);
    List<Pet> getPet(@Param("pid") Integer pid,@Param("name") String name, @Param("price") Integer price, @Param("pname")String pname, @Param("pageNo")Integer pageNo, @Param("pageSize") Integer pageSize);
    int count(@Param("pid") Integer pid,@Param("name") String name,@Param("price") Integer price,@Param("pname")String pname);
    int buy(@Param("id")Integer id,@Param("pid") Integer pid);
    Pet findbyid(Integer id);
    int insert(@Param("cdate")String cdate,@Param("mid")Integer mid,@Param("cid")Integer cid);//新增买卖记录
    List<Pet> spet (Integer pid);
    List<Pet> All(@Param("pageNo")Integer pageNo,@Param("pageSize") Integer pageSize);
    int cc();
    int dels(Integer id);
}
