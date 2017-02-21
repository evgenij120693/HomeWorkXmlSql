package ru.svetozarov.objects.list_entity;

import ru.svetozarov.objects.entity.Client;
import ru.svetozarov.objects.entity.Driver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by E. Svetozarov on 20.02.2017.
 */
@XmlRootElement(name = "ListClient")
@XmlType(propOrder = {"clientList"})
public class ListClient {
    private List<Client> clientList = new ArrayList<>();

    public List<Client> getClientList() {
        return clientList;
    }

    @XmlElement(name = "client")
    public void setClientList(List<Client> driverList) {
        this.clientList = driverList;
    }
}
