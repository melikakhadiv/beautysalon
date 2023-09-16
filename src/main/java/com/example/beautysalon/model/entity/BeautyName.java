package com.example.beautysalon.model.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@NamedQueries({@NamedQuery(name = "beautyName.FindByAllName" ,query = "select distinct oo.name from beautyNameEntity oo ") ,
@NamedQuery(name = "beautyName.FindByName" ,query = "select oo from beautyNameEntity oo  where name=:name")})

@Entity(name = "beautyNameEntity")
@Table(name = "beauty_name_tbl")
public class BeautyName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beauty_name_id")
    private int id;
    @Column(name = "beauty_name")
    private String name;
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
