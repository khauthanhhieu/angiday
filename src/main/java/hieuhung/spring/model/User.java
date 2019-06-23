package hieuhung.spring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "sex")
    private int sex;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private boolean role;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public boolean getRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public User() {}

    public User(int id, String fullname, String email, int sex, String username, String password, boolean role) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String fullname, String email, int sex, String username, String password, boolean role) {
        this.fullname = fullname;
        this.email = email;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Username = %s, Email = %s", username, email);
    }
}