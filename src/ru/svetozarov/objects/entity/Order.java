package ru.svetozarov.objects.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by E. Svetozarov on 21.02.2017.
 */
@XmlRootElement(name = "Order")
@XmlType(propOrder = {"id", "id_client","date_registration", "price", "id_driver", "start_date", "end_date", "id_status"})
public class Order {
        private int id;
        private int id_client;
        private String date_registration;
        private int price;
        private int  id_driver;
        private String start_date;
        private String end_date;
        private int id_status;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    @XmlElement
    public void setId_client(int id_client) {
        this.id_client = id_client;
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

    public int getId_driver() {
        return id_driver;
    }

    @XmlElement
    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
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

    public int getId_status() {
        return id_status;
    }

    @XmlElement
    public void setId_status(int id_status) {
        this.id_status = id_status;
    }
}
