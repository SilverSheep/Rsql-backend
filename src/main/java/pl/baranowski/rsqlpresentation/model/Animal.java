package pl.baranowski.rsqlpresentation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer age;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @Column(length = 9999999)
    private String image;

    public void setKind(AnimalKind kind) {
        this.kind = kind.name();
    }

    public AnimalKind getKind() {
        return Enum.valueOf(AnimalKind.class, kind);
    }
}
