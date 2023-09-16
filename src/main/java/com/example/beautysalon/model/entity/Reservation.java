package com.example.beautysalon.model.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

//todo
@NamedQueries(
        {@NamedQuery(name="reserve.findByUserId",
                query = "select oo from reservationEntity oo where beauty.user.id=:userId")
//                ,
//        @NamedQuery(name="reserve.findByBeautyServiceNameAndDays",
//                query = "select oo from reservationEntity oo where timing.beautyService.name=:beautyServiceName and timing.day=:day"),
//        @NamedQuery(name="reserve.findByBeautyServiceNameAndDaysAndTimes",
//                query = "select oo from reservationEntity oo where timing.beautyService.name=:beautyServiceName and timing.day=:day and timing.startTime=:starTime"),
        }
)

@Entity(name = "reservationEntity")
@Table(name = "reservation_tbl")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "timing_id")
    private Timing timing;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @OneToOne
    @JoinColumn(name = "beauty_id")
    private Beauty beauty;

    @Column(name = "pre_pay")
    private int prePay;

    @Column(name = "reserve_time")
    private LocalTime reservationTime;


    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);  // todo : write wrapper with try .... catch
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
