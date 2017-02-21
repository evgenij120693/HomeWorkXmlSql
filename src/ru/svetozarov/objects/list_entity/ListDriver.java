package ru.svetozarov.objects.list_entity;

import ru.svetozarov.objects.entity.Driver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by E. Svetozarov on 20.02.2017.
 */
@XmlRootElement(name = "ListDriver")
@XmlType(propOrder = {"driverList"})
public class ListDriver {

    private List<Driver> driverList = new ArrayList<>();

    public List<Driver> getDriverList() {
        return driverList;
    }

    @XmlElement(name = "driver")
    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }
}
