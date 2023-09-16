package com.example.beautysalon;


import com.example.beautysalon.model.entity.*;
import com.example.beautysalon.model.service.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {
//        Roles roles= Roles.builder().role("stylist").build();
//        RoleService.getSevice().save(roles);
//
//       User user1=User.builder()
//               .userName("sara55")
//               .password("sara55?")
//               .phoneNumber("09125648596")
//               .name("sara")
//               .family("saraii")
//               .role(RoleService.getSevice().findByRoles("stylist"))
//               .build();
//
//        System.out.println(UserService.getService().save(user1));

//        Roles roles= Roles.builder().role("admin").build();
//        RoleService.getSevice().save(roles);
//
//        User user2 = User.builder()
//                .userName("admin123")
//                .password("admin123?")
//                .phoneNumber("09120341108")
//                .name("admin1")
//                .family("admin1")
//                .role(RoleService.getSevice().findByRoles("admin"))
//                .build();
//
//        System.out.println(UserService.getService().save(user2));
//
//        Roles roles= Roles.builder().role("customer").build();
//        RoleService.getSevice().save(roles);
//                User user2 = User.builder()
//                .userName("fateme98")
//                .password("fateme98?")
//                .phoneNumber("09384521621")
//                .name("fateme")
//                .family("moslem")
//                .role(RoleService.getSevice().findByRoles("customer"))
//                .build();
//
//        System.out.println(UserService.getService().save(user2));




//        BeautyName beautyName = BeautyName.builder().name("nail").build();
//        BeautyNameService.getService().save(beautyName);
//
//     Beauty beauty= Beauty.builder()
//             .beautyName(BeautyNameService.getService().findByName("nail"))
//             .duration(90)
//             .price(400000)
//             .user(UserService.getService().findByUser("sara55"))
//             .build();
//     System.out.println(BeautyService.getService().save(beauty));




//        Timing timing = Timing.builder()
//                .startTime(LocalTime.of(10,00,0))
//                .endTime(LocalTime.of(17,00,0))
//                .day(LocalDate.of(2023,8,8))
//                .beauty(BeautyService.getService().findByUser(4l))
//                .build();
//
//        System.out.println(TimingService.getService().save(timing));
//
//
//
//
//        Reservation reservation = Reservation.builder()
//                .prePay(200000)
//                .customer(UserService.getService().findByUser("fateme98"))
//                .timing(TimingService.getService().findById(9l))
//                .beauty(BeautyService.getService().findById(8l))
//                .reservationTime(LocalTime.of(12, 00, 0))
//                .build();
//        System.out.println(ReservationService.getService().save(reservation));
//        reservation.getTiming().getUser();
//        reservation.getCustomer();
//
//        System.out.println(UserService.getService().findById(2L));
//        System.out.println(UserService.getService().edit(User.builder().id(2L).userName("jav12").password("20lk").name("sara").family("panah").phoneNumber("0215640555").status(false).role(Roles.valueOf("admin")).build()));
//        System.out.println(UserService.getService().findByUserAndPass("melika98", "melika98"));
//        System.out.println(UserService.getService().findByUserAndPass("melika8", "melika98"));
//        BeautyService.getService().save(BeautyService.builder().name(BeautyServices.valueOf("nail_stylist")).duration(60).price(500000).build());
//        BeautyService.getService().save(BeautyService.builder().name(BeautyServices.valueOf("hair_color_stylist")).duration(60).price(500000).build());
//        System.out.println(BeautyService.getService().findAll());
//        UserService.getService().save(User.builder()
//                .userName("melika98")
//                .password("melika98")
//                .role(Roles.valueOf("customer"))
//                .name("melika")
//                .family("khadiv")
//                .phoneNumber("09384204748")
//                .build());
//
//
//        UserService.getService().save(User.builder()
//                .userName("admin123")
//                .password("admin123")
//                .role(Roles.valueOf("admin"))
//                .name("admin1")
//                .family("admin1")
//                .phoneNumber("09120341108")
//                .build());
//
//        UserService.getService().save(User.builder()
//                .userName("sara12")
//                .password("sara12")
//                .role(Roles.valueOf("stylist"))
//                .name("sara")
//                .family("panah")
//                .phoneNumber("09384204748")
//                .build());
//        BeautyService.getService().save(
//                BeautyService
//                        .builder()
//                        .name(BeautyServices.valueOf("hair_color_stylist"))
//                        .price(10000000)
//                        .duration(120)
//                        .build()
//        );

//        System.out.println(UserService.getService().findByUserAndPass("admin123", "admin123"));
//        ReservationService.getService().save(Reservation.builder()
//                .prePay(500000)
//                .customer(UserService.getService().findById(11l))
//                .beautyService(BeautyService.getService().findById(4l))
//                .timing(TimingService.getService().findById(5l))
//                .reservationTime(LocalTime.now())
//                .build());

//        System.out.println(BeautyService.getService().findByAllName());
//        System.out.println(UserService.getService().findAll());
//        System.out.println(UserService.getService().findByUser("admin123"));


        System.out.println(UserService.getService().findAll());
//        System.out.println(RoleService.getSevice().findAll());

    }
}
