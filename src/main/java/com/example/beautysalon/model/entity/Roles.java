package com.example.beautysalon.model.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@NamedQueries(@NamedQuery(name = "roles.FindByRoles" , query = "select oo from rolesEntity oo where role=:role"))
@Entity(name = "rolesEntity")
@Table(name = "role_tbl")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;
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
