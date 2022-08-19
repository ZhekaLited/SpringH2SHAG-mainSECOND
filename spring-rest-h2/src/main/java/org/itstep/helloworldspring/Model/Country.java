package org.itstep.helloworldspring.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@ToString(exclude = "car_id")
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_Id", nullable = false)
    private Long country_Id;
    @Column(name = "country_Name", nullable = false)
    private String countryName;
    @Column(name = "city_Name", nullable = false)
    private String cityName;
    @OneToOne
    @JoinColumn(name = "car_id", unique = true, nullable = false)
    @JsonBackReference
    private Car car;
    @OneToOne(mappedBy = "country")
    private Price price;

}
