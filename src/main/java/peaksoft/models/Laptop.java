package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.OperationSystem;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString


public class Laptop {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Laptop_id_generator"
    )
    @SequenceGenerator(name = "Laptop_id_generator",
    sequenceName = "programmer_seq",
    allocationSize = 1)
    private Long id;
    @Enumerated(
            EnumType.STRING
    )
    @Column(name = "operation_system")
    private OperationSystem operationsystem;
    private  int memory;
    private double price;
    private LocalDate dateOfIssue;

    public Laptop(OperationSystem operationsystem, int memory, double price, LocalDate dateOfIssue) {
        this.operationsystem = operationsystem;
        this.memory = memory;
        this.price = price;
        this.dateOfIssue = dateOfIssue;
    }

    public Laptop() {

    }
}
