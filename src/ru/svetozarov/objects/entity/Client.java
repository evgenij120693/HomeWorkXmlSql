package ru.svetozarov.objects.entity;

import com.mysql.management.util.Str;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by E. Svetozarov on 18.02.2017.
 */
@XmlRootElement(name = "client  ")
@XmlType(propOrder = {"id", "name","sex", "phone", "login", "password"})
public class Client {
    private int id;
    private String name;
    private int sex;
    private String phone;
    private String login;
    private String password;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    @XmlElement
    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

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
}
