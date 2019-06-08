package hieuhung.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "eatery")
public class Eatery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "local")
    private String local;

    @Column(name = "type")
    private String type;

    @Column(name = "open")
    private Integer open;

    @Column(name = "close")
    private Integer close;

    @Column(name = "des")
    private String des;

    @Column(name = "image")
    private String image;

    @Column(name = "phone")
    private Long phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getClose() {
        return close;
    }

    public void setClose(Integer close) {
        this.close = close;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Eatery() {}

    public Eatery(String name, String local, String type, Integer open, Integer close, String des, String image, Long phone) {
        this.name = name;
        this.local = local;
        this.type = type;
        this.open = open;
        this.close = close;
        this.des = des;
        this.image = image;
        this.phone = phone;
    }
}
