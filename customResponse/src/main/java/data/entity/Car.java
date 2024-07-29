package data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId; // Changed from `Number` to `carId` for clarity

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private Integer model;

    @Column(name = "variant") // Fixed typo from `varient` to `variant`
    private String variant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id") // Correct column name
    private City city;

}
