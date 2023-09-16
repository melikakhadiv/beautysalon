package com.example.beautysalon.model.service;

import com.example.beautysalon.controller.exceptionHandler.DataIsCreatedException;
import com.example.beautysalon.controller.exceptionHandler.InvalidDataException;
import com.example.beautysalon.controller.exceptionHandler.NotFoundException;
import com.example.beautysalon.model.entity.User;
import com.example.beautysalon.model.repository.CrudRepository;
import com.example.beautysalon.model.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.MDC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
public class UserService implements ServiceImpl<User, Long> {
    private static UserService userService = new UserService();

    private UserService() {
    }

    public static UserService getService() {
        return userService;
    }

    @Override
    public User save(User user) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            if (findByUser(user.getUserName()) == null) {
                user.setStatus(true);
//                MDC.put("data", user);
//                MDC.clear();
                return crudRepository.insert(user);
            } else {
                throw new DataIsCreatedException();
            }
        }
    }

    @Override
    public User edit(User user) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
//                MDC.put("data", user);
//                MDC.clear();
                return crudRepository.update(user);

        }
    }

    @Override
    public User remove(Long id) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            if (findById(id) != null) {
                log.info("User Removed");
//                MDC.put("data", id);
//                MDC.clear();
                return crudRepository.delete(User.class, id);
            } else {
                log.error("User Not Found");
//                MDC.put("data", id);
//                MDC.clear();
                throw new NotFoundException();
            }

        }
    }

    @Override
    public User findById(Long id) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            if (crudRepository.selectById(User.class, id) != null) {
                log.info("User Find By Id");
                MDC.put("data", id);
                MDC.clear();
                return crudRepository.selectById(User.class, id);
            } else {
                log.error("User Not Found");
                MDC.put("data", id);
                MDC.clear();
                throw new NotFoundException();
            }

        }
    }

    @Override
    public List<User> findAll() throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            if (!crudRepository.selectAll(User.class).isEmpty()) {
                log.info("User List");
                return crudRepository.selectAll(User.class);
            } else {
                log.error("User Not Found");
                throw new NotFoundException();
            }

        }
    }


    public User findByUserAndPass(String userName, String password) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            log.info("username and Password found");
            Map<String, Object> map = new HashMap<>();
            map.put("username", userName);
            map.put("password", password);
            MDC.put("data", map);
            MDC.clear();
            if (crudRepository.executeQuery("user.FindByUserAndPass", map) != null) {
                List<User> userList = crudRepository.executeQuery("user.FindByUserAndPass", map);
                return (userList.size() == 1) ? userList.get(0) : null;
            } else {
                log.error("username and Password not found");
//                MDC.put("data", map);
//                MDC.clear();
                throw new NotFoundException();
            }

        }
    }

    public User findByUser(String userName) throws Exception {
        try (CrudRepository<User, Long> crudRepository = new CrudRepository<>()) {
            log.info("username  found");
            Map<String, Object> map = new HashMap<>();
            map.put("username", userName);
//            MDC.put("data", map);
//            MDC.clear();
            if (crudRepository.executeQuery("user.FindByUser", map) != null) {
                List<User> userList = crudRepository.executeQuery("user.FindByUser", map);
                return (userList.size() == 1) ? userList.get(0) : null;
            } else {
                log.error("username not found");
//                MDC.put("data", map);
//                MDC.clear();
                throw new NotFoundException();
            }

        }
    }
}
