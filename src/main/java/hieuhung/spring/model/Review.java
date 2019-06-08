package hieuhung.spring.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "id_eatery")
    private int idEatery;

    @Column(name = "point")
    private int point;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "cost")
    private int cost;

    @Column(name = "tel")
    private String tel;

    @Column(name = "wname")
    private String wname;

    @Column(name = "wpass")
    private String wpass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getIdEatery() {
        return idEatery;
    }

    public void setIdEatery(int idEatery) {
        this.idEatery = idEatery;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWpass() {
        return wpass;
    }

    public void setWpass(String wpass) {
        this.wpass = wpass;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return this.idUser;
    }
}
