package com.bdqn.room.controller;

import com.alibaba.fastjson.JSON;
import com.bdqn.room.pojo.Bar;
import com.bdqn.room.pojo.Room;
import com.bdqn.room.pojo.Roomaddress;
import com.bdqn.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomService rs;
    //跨域注解
    @CrossOrigin
    @ResponseBody
    @RequestMapping("/getAll")
    public String getAll(Integer pid,Integer index,String address1,String address2,Integer price){
        int count = rs.count(address1,address2,price);
        count=count%2==0?count/2:count/2+1;
        System.out.println("个数"+count);
        if(index<0){
            index=1;
        }
        if(index>=count){
            index=count;
        }
        List<Room> firstList = rs.getAll(address1,address2,price,index,2);
        System.out.println("长度："+firstList.size());
        Object [] array = new Object[count];
        array[0]=count;
        array[1]=firstList;
        String str = JSON.toJSONString(array);
        return str ;
    }
    @ResponseBody
    @RequestMapping("/getOne")
    public  String getOne(){
        List<Roomaddress> list = rs.getOne();
        String str =JSON.toJSONString(list);
        return str;
    }
    @ResponseBody
    @RequestMapping("/geTwo")
    public  String geTwo(Integer id){
        List<Roomaddress> list = rs.getTwo(id);
        String str =JSON.toJSONString(list);
        return str;
    }
    @ResponseBody
    @RequestMapping("/all")
    public String all(String type , String dateLimit, Integer id){
        int num = rs.all(type,dateLimit,id);
        String str = JSON.toJSONString(num);
        return str;
    }
    //demo
    @ResponseBody
    @RequestMapping("/gets")
    public String gets(){
        List<Room> firstList = rs.gets();
        String str = JSON.toJSONString(firstList);
        return str;
    }
    @ResponseBody
    @RequestMapping("/hello")
    public List<Room> hello(String name){
        System.out.println(name);
        List<Room> firstList = rs.gets();
        return firstList;
    }
    @ResponseBody
    @RequestMapping("/login")
    public Bar login(Integer bid, String bname){
        System.out.println(bname);
        Bar bar = rs.login(bid,bname);
        System.out.println(bar);
        return bar ;
    }
    @ResponseBody
    @RequestMapping("/findAll")
    public List<Bar> findAll(Integer index,String bname,String bcolor,Integer bprice ){
        System.out.println("值："+index);
        int count =rs.counts(bprice,bname,bcolor);
        count=count%2==0?count/2:count/2+1;
        if(index<0){
            index=1;
        }
        if(index>count){
            index=count;
        }
        List<Bar> firstList = rs.findAll(bprice,bname,bcolor,index,2);
        return firstList;
    }
    @ResponseBody
    @RequestMapping("/del")
    public Boolean del(Integer bid){
        int num = rs.del(bid);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }
    @ResponseBody
    @RequestMapping("/getbyid")
    public Bar getbyid(Integer bid){
      Bar bar = rs.getbyid(bid);
      return bar ;
    }
}
