package ru.svetozarov.objects.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by E. Svetozarov on 18.02.2017.
 */
@XmlRootElement(name = "auto")
@XmlType(propOrder = {"id", "model","reg_number", "color"})
public class Auto {
    private int id;
    private String model;
    private String reg_number;
    private String color;

    public int getId() {
        return id;
    }
    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    @XmlElement
    public void setModel(String model) {
        this.model = model;
    }

    public String getReg_number() {
        return reg_number;
    }

    @XmlElement
    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public String getColor() {
        return color;
    }

    @XmlElement
    public void setColor(String color) {
        this.color = color;
    }
}


