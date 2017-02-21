package ru.svetozarov.objects.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;


/**
 * Created by E. Svetozarov on 20.02.2017.
 */
@XmlRootElement(name = "driver")
@XmlType(propOrder = {"id", "client","date_registration", "price", "driver", "start_date", "end_date", "status"})
public class OrderComplex {
    private int id;
    private Client client;

    private String date_registration;
    private int price;
    private Driver driver;
    private String start_date;
    private String end_date;
    private Status_order status;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    @XmlElement
    public void setClient(Client client) {
        this.client = client;
    }

    public String getDate_registration() {
        return date_registration;
    }

    @XmlElement
    public void setDate_registration(String date_registration) {
        this.date_registration = date_registration;
    }

    public int getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(int price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    @XmlElement
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getStart_date() {
        return start_date;
    }

    @XmlElement
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    @XmlElement
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Status_order getStatus() {
        return status;
    }

    @XmlElement
    public void setStatus(Status_order status) {
        this.status = status;
    }
}



