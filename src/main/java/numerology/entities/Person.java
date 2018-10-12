package numerology.entities;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private LocalDate birthday;

}


