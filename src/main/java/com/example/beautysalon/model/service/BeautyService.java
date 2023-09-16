package com.example.beautysalon.model.service;

import com.example.beautysalon.controller.exceptionHandler.NotFoundException;
import com.example.beautysalon.model.entity.Beauty;
import com.example.beautysalon.model.repository.CrudRepository;
import com.example.beautysalon.model.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
public class BeautyService implements ServiceImpl<Beauty, Long> {
    private static BeautyService beautyService = new BeautyService();

    private BeautyService() {
    }

    public static BeautyService getService() {
        return beautyService;
    }

    @Override
    public Beauty save(Beauty beauty) throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service Saved!!");
//            MDC.put("data",beautyService);
//            MDC.clear();
            return crudRepository.insert(beauty);
        }
    }

    @Override
    public Beauty edit(Beauty beauty) throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service updated");
//            MDC.put("data",beautyService);
//            MDC.clear();
            return crudRepository.update(beauty);
        }
    }

    @Override
    public Beauty remove(Long id) throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service removed");
//            MDC.put("data",id);
//            MDC.clear();
            return crudRepository.delete(Beauty.class, id);
        }
    }

    @Override
    public Beauty findById(Long id) throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service Find By Id");
//            MDC.put("data",id);
//            MDC.clear();
            return crudRepository.selectById(Beauty.class, id);
        }
    }

    @Override
    public List<Beauty> findAll() throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service List");
            return crudRepository.selectAll(Beauty.class);
        }
    }

    public List<Beauty> findByAllName() throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service Find By Name");
//            MDC.put("data",name);
//            MDC.clear();
            return crudRepository.executeQuery("beauty.FindByAllName" , null);
        }
    }

    public List<Beauty> findByName(String name) throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service Find By Name");
//            MDC.put("data",name);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("service_name", name);
            return crudRepository.executeQuery("beauty.FindByName", map);
        }
    }


    public Beauty findByUser(Long userId) throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service Find By User");
//            MDC.put("data",name);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            if (crudRepository.executeQuery("beauty.FindByUser", map) != null){
                List<Beauty> list = crudRepository.executeQuery("beauty.FindByUser", map);
                return (list.size()==1)? list.get(0):null ;
            }else {
                throw new NotFoundException();
            }


        }
    }

    public Beauty findByUserAndBeauty(Long userId , String name) throws Exception {
        try (CrudRepository<Beauty, Long> crudRepository = new CrudRepository<>()) {
            log.info("Service Find By User");
//            MDC.put("data",name);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            map.put("service_name", name);

            if(crudRepository.executeQuery("beauty.FindByUserAndBeauty", map) != null){
                List<Beauty> stylist = crudRepository.executeQuery("beauty.FindByUserAndBeauty", map);
                return ((stylist).size()==1)? stylist.get(0):null;
            } else {
                log.error("user not found");
//                MDC.put("data", map);
//                MDC.clear();
                throw new NotFoundException();
            }

        }
    }
}
