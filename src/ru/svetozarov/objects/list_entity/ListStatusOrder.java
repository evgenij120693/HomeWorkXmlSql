package ru.svetozarov.objects.list_entity;

import ru.svetozarov.objects.entity.Status_driver;
import ru.svetozarov.objects.entity.Status_order;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by E. Svetozarov on 20.02.2017.
 */
@XmlRootElement(name = "StatusOrderList")
@XmlType(propOrder = {"statusOrderList"})
public class ListStatusOrder {
    private List<Status_order> statusOrderList = new ArrayList<>();

    public List<Status_order> getStatusOrderList() {
        return statusOrderList;
    }
    @XmlElement(name = "status_order")
    public void setStatusOrderList(List<Status_order> statusOrderList) {
        this.statusOrderList = statusOrderList;
    }
}
