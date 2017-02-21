package ru.svetozarov.objects.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by E. Svetozarov on 18.02.2017.
 */

@XmlRootElement(name = "driver")
@XmlType(propOrder = {"id", "last_name","first_name", "phone_number", "login","password", "rating", "auto", "status"})
public class Driver {
    private int id;
    private String last_name;
    private String first_name;
    private String phone_number;
    private String login;
    private String password;
    private int rating;
    private Auto auto;
    private Status_driver status;

    public String getLogin() {
        return login;
    }

    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public Auto getAuto() {
        return auto;
    }

    @XmlElement
    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Status_driver getStatus() {
        return status;
    }

    @XmlElement
    public void setStatus(Status_driver status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    @XmlElement
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    @XmlElement
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    @XmlElement
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getRating() {
        return rating;
    }

    @XmlElement
    public void setRating(int rating) {
        this.rating = rating;
    }




}
