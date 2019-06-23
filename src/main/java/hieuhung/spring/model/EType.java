package hieuhung.spring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "eatery_types")
public class EType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public EType() {}

    public EType(String name) {
        this.name = name;
    }
}
