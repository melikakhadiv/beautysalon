package com.example.beautysalon.model.service;

import com.example.beautysalon.controller.exceptionHandler.NotFoundException;
import com.example.beautysalon.model.entity.BeautyName;
import com.example.beautysalon.model.repository.CrudRepository;
import com.example.beautysalon.model.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeautyNameService implements ServiceImpl<BeautyName,Integer> {
    private static BeautyNameService beautyNameService =new BeautyNameService();
    private BeautyNameService(){}

    public static BeautyNameService getService(){return beautyNameService;}

    @Override
    public BeautyName save(BeautyName beautyName) throws Exception {
        try(CrudRepository<BeautyName,Integer> crudRepository =new CrudRepository<>()){
            return crudRepository.insert(beautyName);
        }
    }

    @Override
    public BeautyName edit(BeautyName beautyName) throws Exception {
        try(CrudRepository<BeautyName,Integer> crudRepository =new CrudRepository<>()){
            return crudRepository.update(beautyName);
        }
    }

    @Override
    public BeautyName remove(Integer id) throws Exception {
        try(CrudRepository<BeautyName,Integer> crudRepository =new CrudRepository<>()){
            return crudRepository.delete(BeautyName.class,id);
        }
    }

    @Override
    public BeautyName findById(Integer id) throws Exception {
        try(CrudRepository<BeautyName,Integer> crudRepository =new CrudRepository<>()){
            return crudRepository.selectById(BeautyName.class,id);
        }
    }

    @Override
    public List<BeautyName> findAll() throws Exception {
        try(CrudRepository<BeautyName,Integer> crudRepository =new CrudRepository<>()){
            return crudRepository.selectAll(BeautyName.class);
        }
    }

    public BeautyName findByName(String name) throws Exception{
        try(CrudRepository<BeautyName,Integer> crudRepository =new CrudRepository<>()){
            Map<String,Object> map =new HashMap<>();
            map.put("name",name);
            if(crudRepository.executeQuery("beautyName.FindByName" , map) != null){
                List<BeautyName> beautyNames =crudRepository.executeQuery("beautyName.FindByName" , map);
                return (beautyNames.size()==1)? beautyNames.get(0):null;
            }else {
                throw new NotFoundException();
            }

        }
    }

    public List<BeautyName> findByAllName() throws Exception{
        try(CrudRepository<BeautyName,Long> crudRepository =new CrudRepository<>()){
            return crudRepository.executeQuery("beautyName.FindByAllName" , null);
        }
    }
}
