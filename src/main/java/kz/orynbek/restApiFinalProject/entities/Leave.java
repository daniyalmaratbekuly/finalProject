package kz.orynbek.restApiFinalProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "leaves")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int StartDate;
    private int EndDate;
    private String status;
    private String employee;
}
