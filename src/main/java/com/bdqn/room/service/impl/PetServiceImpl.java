package com.bdqn.room.service.impl;

import com.bdqn.room.dao.PetDao;
import com.bdqn.room.pojo.Count;
import com.bdqn.room.pojo.Pet;
import com.bdqn.room.pojo.Puser;
import com.bdqn.room.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    PetDao pd;

    @Override
    public Puser petLogin(String pname, String pwd) {
        return pd.petLogin(pname,pwd);
    }

    @Override
    public int register(Puser user) {
        return pd.register(user);
    }

    @Override
    public List<Pet> getPet(Integer pid, String name, Integer price, String pname, Integer pageNo, Integer pageSize) {
        return pd.getPet(pid,"%"+name+"%",price,"%"+pname+"%",(pageNo-1)*pageSize,pageSize);
    }

    @Override
    public int count(Integer pid, String name, Integer price, String pname) {
        return pd.count(pid, "%" + name + "%", price, "%" + pname + "%");

    }

    @Override
    public int buy(Integer id, Integer pid) {
        return pd.buy(id,pid);
    }

    @Override
    public Pet findbyid(Integer id) {
        return pd.findbyid(id);
    }

    @Override
    public int insert(String cdate, Integer mid, Integer cid) {
        return pd.insert(cdate, mid, cid);
    }

    @Override
    public List<Pet> spet(Integer pid) {
        return pd.spet(pid);
    }

    @Override
    public List<Pet> All(Integer pageNo, Integer pageSize) {
        return pd.All((pageNo-1)*pageSize,pageSize);
    }
    @Override
    public int cc() {
        return pd.cc();
    }


    @Override
    public int dels(Integer id) {
        return pd.dels(id);
    }


}
