package org.itstep.helloworldspring.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_Id", nullable = false)
    private Long car_Id;
    @Column(name = "car_Name", nullable = false)
    private String carName;
    @Column(name = "car_Color", nullable = false)
    private String carColor;
    @Column(name = "car_Model", nullable = false)
    private String carModel;
    @JsonManagedReference
    @OneToOne(mappedBy = "car")
    private Country country;

}