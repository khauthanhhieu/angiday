package hieuhung.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "eateries")
public class Eatery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "name")
    private String name;

    @Column(name = "local")
    private String local;

    @Column(name = "type")
    private Integer type;

    @Column(name = "open")
    private Integer open;

    @Column(name = "close")
    private Integer close;

    @Column(name = "des")
    private String des;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "point")
    private float point;


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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public Eatery() {}

    public Eatery(Integer id_user, String name, String local, Integer type, Integer open, Integer close, String des, Long phone) {
        this.id_user = id_user;
        this.name = name;
        this.local = local;
        this.type = type;
        this.open = open;
        this.close = close;
        this.des = des;
        this.phone = phone;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_user() {
        return  this.id_user;
    }
}
