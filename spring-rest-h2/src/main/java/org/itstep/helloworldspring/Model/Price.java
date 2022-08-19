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
@ToString(exclude = "country_id")
@Table(name = "price")

public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_Id", nullable = false)
    private Long price_Id;
    @Column(name = "price_Car", nullable = false)
    private int priceCar;
    @Column(name = "credit_Price", nullable = false)
    private int credit_Price;
    @OneToOne
    @JoinColumn(name = "country_Id", unique = true, nullable = false)
    @JsonBackReference
    private Country country;


}
