package com.example.beautysalon.model.service;

import com.example.beautysalon.controller.exceptionHandler.NotFoundException;
import com.example.beautysalon.model.entity.Reservation;
import com.example.beautysalon.model.repository.CrudRepository;
import com.example.beautysalon.model.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
public class ReservationService implements ServiceImpl<Reservation, Long> {
    private static ReservationService reservationService = new ReservationService();

    private ReservationService() {
    }

    public static ReservationService getService() {
        return reservationService;
    }

    @Override
    public Reservation save(Reservation reservation) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.insert(reservation);
        }
    }

    //    @Override
//    public Reservation save(Reservation reservation) throws Exception {
//        try(CrudRepository<Reservation,Long> crudRepository =new CrudRepository<>()) {
//            //todo: between time schedule
//            //todo: half of beauty service price
////            if (reservation.getTiming().getUser().getRole().equals("customer")
////            && reservation.getTiming().getUser().getRole().equals("admin")
////                    && reservation.getTiming().getUser().getRole().equals("stylist")) {
////                if (reservation.getReservationTime().isBefore(reservation.getTiming().getEndTime())
////                        && reservation.getReservationTime().isAfter(reservation.getTiming().getStartTime()) ) {
//                    log.info("Reservation Saved");
////                    MDC.put("data", reservation);
////                    MDC.clear();
//                    return crudRepository.insert(reservation);
//////                } else {
////                    log.error("Reservation not Saved");
//////                    MDC.put("data", reservation);
//////                    MDC.clear();
////                    throw new AccessDeniedException();
//////                }
////            }
//        }
//    }

    @Override
    public Reservation edit(Reservation reservation) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            //todo : between time schedule
            log.info("Reservation Updated");
//            MDC.put("data",reservation);
//            MDC.clear();
            return crudRepository.update(reservation);
        }
    }

    @Override
    public Reservation remove(Long id) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            log.info("Reservation Removed");
//            MDC.put("data",id);
//            MDC.clear();
            return crudRepository.delete(Reservation.class, id);
        }
    }

    @Override
    public Reservation findById(Long id) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            log.info("Reservation Find By Id");
//            MDC.put("data",id);
//            MDC.clear();
            return crudRepository.selectById(Reservation.class, id);
        }
    }

    @Override
    public List<Reservation> findAll() throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            log.info("Reservation List");
            return crudRepository.selectAll(Reservation.class);
        }
    }


    public Reservation findByUSerID(Long stylistId) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            log.info("Reservation Showed!!");
            Map<String, Object> map = new HashMap<>();
            map.put("userId", stylistId);
            if (crudRepository.executeQuery("reserve.findByUserId", map) != null) {
                List<Reservation> stylistList = crudRepository.executeQuery("reserve.findByUserId", map);
                return (stylistList.size() == 1) ? stylistList.get(0) : null;
            } else {
                throw new NotFoundException();
            }
        }
    }

    public List<Reservation> findByBeautyAndDay(String beautyName , String day) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            log.info("Reservation Showed!!");
            Map<String, Object> map = new HashMap<>();
            map.put("beautyServiceName", beautyName);
            map.put("day", LocalDate.parse(day));
            return crudRepository.executeQuery("reserve.findByBeautyServiceNameAndDays", map);
        }
    }

    public Reservation findByBeautyServiceNam(String beautyName) throws Exception {
        try (CrudRepository<Reservation, Long> crudRepository = new CrudRepository<>()) {
            log.info("Reservation Showed!!");
            Map<String, Object> map = new HashMap<>();
            map.put("beautyServiceName", beautyName);
            if (crudRepository.executeQuery("reserve.findByUserId", map) != null) {
                List<Reservation> beautyList = crudRepository.executeQuery("reserve.findByBeautyServiceName", map);
                return (beautyList.size() == 1) ? beautyList.get(0) : null;
            } else {
                throw new NotFoundException();
            }
        }
    }
}
