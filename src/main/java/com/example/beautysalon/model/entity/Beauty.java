package com.example.beautysalon.model.entity;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity(name = "beautyServiceEntity")
@Table(name = "beautyService_tbl")
@NamedQueries(
        {@NamedQuery(name = "beauty.FindByName", query = "select oo from beautyServiceEntity oo where beautyName.name=:service_name"),
                @NamedQuery(name = "beauty.FindByAllName", query = "select distinct oo.beautyName.name from beautyServiceEntity oo "),
                @NamedQuery(name = "beauty.FindByUser", query = "select oo from beautyServiceEntity oo where user.id=:user_id"),
                @NamedQuery(name = "beauty.FindByUserAndBeauty", query = "select oo from beautyServiceEntity oo where beautyName.name=:service_name and user.id=:user_id")}
)
public class Beauty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beauty_id")
    private long id;


    @OneToOne
    private BeautyName beautyName;

    @Column(name = "price", columnDefinition = "number")
    private long price;

    @Column(name = "duration", columnDefinition = "number")
    private int duration;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Timing> timing;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


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
