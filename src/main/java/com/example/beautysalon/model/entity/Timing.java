package com.example.beautysalon.model.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "timingEntity")
@Table(name = "timing_tbl")
@NamedQueries(
        {@NamedQuery(name = "timing.FindByDay", query = "select oo from timingEntity oo where day=:day")
                ,@NamedQuery(name = "timing.FindByTime", query = "select oo from timingEntity oo where startTime=:startTime")
                , @NamedQuery(name = "timing.FindByBeauty",
                query = "select oo from timingEntity oo where beauty.beautyName.name=:beautyService")
                , @NamedQuery(name = "timing.FindByUser",
                query = "select oo from timingEntity oo where beauty.user.id=:userId")
                , @NamedQuery(name = "timing.FindByBeautyUser",
                query = "select oo from timingEntity oo where beauty.beautyName.name=:beautyService and beauty.user.id=:userId")
                ,@NamedQuery(name = "timing.FindByBeautyUserDay",
                query = "select oo from timingEntity oo where beauty.beautyName.name=:beautyService and beauty.user.id=:userId and day=:day")
                , @NamedQuery(name = "timing.FindByBeautyDay",
                query = "select oo from timingEntity oo where beauty.beautyName.name=:beautyService and day=:day")
                , @NamedQuery(name = "timing.FindByBeautyUserDayTime",
                query = "select oo from timingEntity oo where beauty.beautyName.name=:beautyService and beauty.user.id=:userId and day=:day and startTime=:startTime")}
)

public class Timing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "timing_id")
    private long id;

    @Column(name = "day", length = 10)
    private LocalDate day;


    @Column(name = "start_time", length = 5)
    private LocalTime startTime;

    @Column(name = "end_time", length = 5)
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "beauty_service_id")
    private Beauty beauty;

//    @OneToOne
//    private User user;


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
