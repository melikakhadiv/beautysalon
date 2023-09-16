package com.example.beautysalon.model.service;

import com.example.beautysalon.controller.exceptionHandler.DataIsCreatedException;
import com.example.beautysalon.controller.exceptionHandler.NotFoundException;
import com.example.beautysalon.model.entity.Roles;
import com.example.beautysalon.model.repository.CrudRepository;
import com.example.beautysalon.model.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleService implements ServiceImpl<Roles,Integer> {
    private RoleService(){}
    private static RoleService roleService = new RoleService();
    public static RoleService getSevice(){return  roleService;}
    @Override
    public Roles save(Roles roles) throws Exception {
        try(CrudRepository<Roles,Integer> crudRepository = new CrudRepository<>()) {
            if (findByRoles(roles.getRole()) == null) {
                return crudRepository.insert(roles);
            }else {
                throw new DataIsCreatedException();
            }
        }
    }

    @Override
    public Roles edit(Roles roles) throws Exception {
        try(CrudRepository<Roles,Integer> crudRepository = new CrudRepository<>()){
            if (findByRoles(roles.getRole()) == null) {
                return crudRepository.update(roles);
            }else {
                throw new DataIsCreatedException();
            }
        }
    }

    @Override
    public Roles remove(Integer id) throws Exception {
        try(CrudRepository<Roles,Integer> crudRepository = new CrudRepository<>()){
            return crudRepository.delete(Roles.class,id);
        }
    }

    @Override
    public Roles findById(Integer id) throws Exception {
        try(CrudRepository<Roles,Integer> crudRepository = new CrudRepository<>()){
            return crudRepository.selectById(Roles.class,id);
        }
    }

    @Override
    public List<Roles> findAll() throws Exception {
        try(CrudRepository<Roles,Integer> crudRepository = new CrudRepository<>()){
            return crudRepository.selectAll(Roles.class);
        }
    }

    public Roles findByRoles(String roles) throws Exception{
        try(CrudRepository<Roles,Integer> crudRepository =new CrudRepository<>()) {
            Map<String, Object> map = new HashMap<>();
            map.put("role", roles);
            if (crudRepository.executeQuery("roles.FindByRoles", map) != null) {
                List<Roles> rolesList = crudRepository.executeQuery("roles.FindByRoles", map);

                return (rolesList.size()==1)? rolesList.get(0):null;
            }
            else {
                throw new NotFoundException();
            }
        }
    }
}
