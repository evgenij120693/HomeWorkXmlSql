package ru.svetozarov.objects.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by E. Svetozarov on 20.02.2017.
 */
@XmlRootElement(name = "satus_order")
@XmlType(propOrder = {"id", "name", "description"})
public class Status_order {
    private int id;
    private String name;
    private String description;


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


    public String getDescription() {
        return description;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }
}
