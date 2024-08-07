package data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "pincode")
    private long pincode;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonIgnore
    private List<Car> cars ;
}
