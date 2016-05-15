package hello.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "profile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profile {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "profile_seq")
    @SequenceGenerator(
            name="profile_seq",
            sequenceName="profile_sequence",
            allocationSize=20
    )
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "city")
    private String city;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "avatar")
    private byte[] avatar;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
