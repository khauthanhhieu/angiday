package hieuhung.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {}

    public User(int id, String fullname, String email, boolean sex, String username, String password) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.sex = sex;
        this.username = username;
        this.password = password;
    }

    public User(String fullname, String email, boolean sex, String username, String password) {
        this.fullname = fullname;
        this.email = email;
        this.sex = sex;
        this.username = username;
        this.password = password;
    }
}