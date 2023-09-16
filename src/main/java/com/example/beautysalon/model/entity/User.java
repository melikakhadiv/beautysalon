package com.example.beautysalon.model.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "userEntity")
@Table(name = "user_tbl")
@NamedQueries(
        {@NamedQuery(name = "user.FindByUserAndPass", query = "select oo from userEntity oo where userName=:username and password=:password"),
                @NamedQuery(name = "user.FindByUser", query = "select oo from userEntity oo where userName=:username")}
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_name", nullable = false, columnDefinition = "nvarchar2(20)")
    @Pattern(regexp = "^(?=.{6,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "Invalid Username")
    private String userName;

    @Column(name = "password", nullable = false, columnDefinition = "nvarchar2(20)")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "Invalid Password")
    private String password;

    @Column(name = "first_name", nullable = false, columnDefinition = "nvarchar2(20)")
    @Pattern(regexp = "^\\w{3,20}$", message = "Invalid Name")
    private String name;

    @Column(name = "last_name", nullable = false, columnDefinition = "nvarchar2(20)")
    @Pattern(regexp = "^\\w{3,20}$", message = "Invalid Family")
    private String family;

    @Column(name = "phone_number", nullable = false, columnDefinition = "nvarchar2(11)")
    @Pattern(regexp = "^\\d{11}$", message = "Invalid Phone Number")
    private String phoneNumber;

    @OneToOne
    private Roles role;

    @Column(name = "user_status")
    private boolean status;


//    @OneToOne
//    @JoinColumn(name = "beauty_id")
//    private BeautyService beautyService;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
