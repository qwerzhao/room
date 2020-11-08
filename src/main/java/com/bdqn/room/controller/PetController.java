package com.bdqn.room.controller;

import com.bdqn.room.pojo.Count;
import com.bdqn.room.pojo.Pet;
import com.bdqn.room.pojo.Puser;
import com.bdqn.room.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PetController {
    @Autowired
    PetService ps;
    //登录
    @ResponseBody
    @RequestMapping("/petLogin")
    public Puser  petLogin(String pwd,String pname){
        Puser p = ps.petLogin(pname,pwd);
        return p;
    }
    //注册
    @ResponseBody
    @RequestMapping("/register")
    public Boolean register(Puser user){
        int num = ps.register(user);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }
    @ResponseBody
    @RequestMapping("/getPet")
    public Object[] getPet(Integer pid,Integer price,String name,String pname ,Integer index){
        System.out.println(price+""+name+""+pname);
        int count = ps.count(pid,name,price,pname);
        count=count%2==0?count/2:count/2+1;
        System.out.println("个数"+count);
        if(index<0){
            index=1;
        }
        if(index>=count){
            index=count;
        }
        List<Pet> list = ps.getPet(pid,name,price,pname,index,2);
        System.out.println("长度："+list.size());
        Object [] array=null;
        if(count==1){
            array = new Object[count+1];
            array[0]=count;
            array[1]=list;
        }else{
            array = new Object[count];
            array[0]=count;
            array[1]=list;
        }
        return array ;
    }
    @ResponseBody
    @RequestMapping("/buy")
    public Boolean buy(Integer id,Integer pid){
        int num = ps.buy(id,pid);//买宠物
        Pet pet = ps.findbyid(id);
        long mid = pet.getPid();//得到卖家Id
        Date now = new Date();//获取时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");//可以方便地修改日期格式
        String hehe = dateFormat.format( now );
        System.out.println(hehe);
        int c = ps.insert(hehe,(int)mid,pid);
        int m =ps.insert(hehe,pid,(int)mid);
        if(c>0&&m>0&&num>0){
            return true ;
        }else{
            return false;
        }
    }
    @ResponseBody
    @RequestMapping("/spet")
    public List<Pet> spet(Integer pid){
        List<Pet> list = ps.spet(pid);
        return list;
    }
    //跨域注解
    @ResponseBody
/*    @CrossOrigin*/
    @RequestMapping("/All")
    public  Object [] All(Integer index){
        int count = ps.cc();
        count=count%2==0?count/2:count/2+1;
        System.out.println("个数"+count);
        List<Pet> list =ps.All(index,2);
        System.out.println("长度："+list.size());
        Object [] array=null;
        if(count==1){
            array = new Object[count+1];
            array[0]=count;
            array[1]=list;
        }else{
            array = new Object[count];
            array[0]=count;
            array[1]=list;
        }
        return array ;
    }
    //跨域注解
    @ResponseBody
/*    @CrossOrigin*/
    @RequestMapping("/dels")
    public Boolean dels(Integer id){
        int num = ps.dels(id);
        if(num>0){
            return true;
        }else{
            return false;
        }
    }
}
