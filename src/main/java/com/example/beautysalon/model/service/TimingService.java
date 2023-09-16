package com.example.beautysalon.model.service;

import com.example.beautysalon.controller.exceptionHandler.NotFoundException;
import com.example.beautysalon.model.entity.Timing;
import com.example.beautysalon.model.repository.CrudRepository;
import com.example.beautysalon.model.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
public class TimingService implements ServiceImpl<Timing, Long> {
    private static TimingService timingService = new TimingService();

    private TimingService() {
    }

    public static TimingService getService() {
        return timingService;
    }

    @Override
    public Timing save(Timing timing) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Timing Saved");
//            MDC.put("data",timing);
//            MDC.clear();
            return crudRepository.insert(timing);
        }
    }

    @Override
    public Timing edit(Timing timing) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Timing Updated");
//            MDC.put("data",timing);
//            MDC.clear();
            return crudRepository.update(timing);
        }
    }


    @Override
    public Timing remove(Long id) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            if(findById(id) != null){
            log.info("Timing Removed");
//            MDC.put("data", id);
//            MDC.clear();
            return crudRepository.delete(Timing.class, id);
            }else {
                log.error("Timing Not Found");
//                MDC.put("data", id);
//                MDC.clear();
                throw  new NotFoundException();
            }


        }
    }

    @Override
    public Timing findById(Long id) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            if(crudRepository.selectById(Timing.class, id) != null) {
                log.info("Time Find By Id");
//                MDC.put("data", id);
//                MDC.clear();
                return crudRepository.selectById(Timing.class, id);
            }
            else {
                log.error("Timing Not Found");
//                MDC.put("data", id);
//                MDC.clear();
                throw new NotFoundException();
            }
        }
    }

    @Override
    public List<Timing> findAll() throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time List");
            return crudRepository.selectAll(Timing.class);
        }
    }

    public Timing findByDay(String day) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By Day");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("day", LocalDate.parse(day));
            if(crudRepository.executeQuery("timing.FindByDay", map) != null){
                List<Timing> days = crudRepository.executeQuery("timing.FindByDay", map);
        return (days.size()==1)? days.get(0) : null;
        }
            else {
            throw new NotFoundException();
            }
        }
    }

    public List<Timing> findByBeauty(String beautyService) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By beautyService");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("beautyService", beautyService);
            return crudRepository.executeQuery("timing.FindByBeauty", map);
        }
    }

    public Timing findByUser(Long userId) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By User");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            if(crudRepository.executeQuery("timing.FindByUser", map) != null){
                List<Timing> user = crudRepository.executeQuery("timing.FindByUser", map);
                return (user.size()==1)? user.get(0) : null;
            }
            else {
                throw new NotFoundException();
            }
        }
    }

    public List<Timing> findByTime(String time) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By time");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("startTime", LocalTime.parse(time));
            return crudRepository.executeQuery("timing.FindByTime", map);
        }
    }

    public List<Timing> findByBeautyDay(String beautyService , String day) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By beauty day time");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("beautyService", beautyService);
            map.put("day", LocalDate.parse(day));
            return crudRepository.executeQuery("timing.FindByBeautyDay", map);
        }
    }

    public List<Timing> findByBeautyUser(String beautyService , Long id) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By beauty day time");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("beautyService", beautyService);
            map.put("userId", id);
            return crudRepository.executeQuery("timing.FindByBeautyUser", map);
        }
    }

    public List<Timing> findByBeautyUserDay(String beautyService , Long id , String day) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By beauty day time");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("beautyService", beautyService);
            map.put("userId", id);
            map.put("day", LocalDate.parse(day));
            return crudRepository.executeQuery("timing.FindByBeautyUserDay", map);
        }
    }
    public Timing findByBeautyUserDayTime(String time ,Long id, String beautyService , String day) throws Exception {
        try (CrudRepository<Timing, Long> crudRepository = new CrudRepository<>()) {
            log.info("Time Find By beauty day time");
//            MDC.put("data", day);
//            MDC.clear();
            Map<String, Object> map = new HashMap<>();
            map.put("startTime", LocalTime.parse(time));
            map.put("beautyService", beautyService);
            map.put("userId",id);
            map.put("day", LocalDate.parse(day));
            if(crudRepository.executeQuery("timing.FindByBeautyUserDayTime", map) != null){
                List<Timing> timeList = crudRepository.executeQuery("timing.FindByBeautyUserDayTime", map);
                return (timeList.size()==1)? timeList.get(0) : null;
            }
            else {
                throw new NotFoundException();
            }

        }
    }

}
