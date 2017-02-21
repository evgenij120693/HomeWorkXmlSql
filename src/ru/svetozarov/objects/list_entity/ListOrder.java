package ru.svetozarov.objects.list_entity;

import ru.svetozarov.objects.entity.Order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by E. Svetozarov on 21.02.2017.
 */
@XmlRootElement(name = "ListOrder")
@XmlType(propOrder = {"orderList"})
public class ListOrder {
    private List<Order> orderList = new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }
    @XmlElement(name = "")
    public void setOrderList(List<Order> driverList) {
        this.orderList = driverList;
    }
}
