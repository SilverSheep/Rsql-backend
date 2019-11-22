package pl.baranowski.rsqlpresentation.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class Animal {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AnimalKind kind;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Date date;
}
