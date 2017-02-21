package ru.svetozarov.objects.list_entity;

import ru.svetozarov.objects.entity.OrderComplex;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by E. Svetozarov on 20.02.2017.
 */
@XmlRootElement(name = "ListOrderComplex")
@XmlType(propOrder = {"orderComplexList"})
public class ListOrderComplex {

    private List<OrderComplex> orderComplexList = new ArrayList<>();

    public List<OrderComplex> getOrderComplexList() {
        return orderComplexList;
    }
    @XmlElement(name = "")
    public void setOrderComplexList(List<OrderComplex> driverList) {
        this.orderComplexList = driverList;
    }
}
