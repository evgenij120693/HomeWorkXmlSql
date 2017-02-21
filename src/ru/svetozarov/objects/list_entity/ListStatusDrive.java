package ru.svetozarov.objects.list_entity;

import ru.svetozarov.objects.entity.Auto;
import ru.svetozarov.objects.entity.Status_driver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by E. Svetozarov on 20.02.2017.
 */
@XmlRootElement(name = "StatusDrive")
@XmlType(propOrder = {"statusDriveList"})
public class ListStatusDrive {
    private List<Status_driver> statusDriveList = new ArrayList<>();

    public List<Status_driver> getStatusDriveList() {
        return statusDriveList;
    }

    @XmlElement(name = "status_driver")
    public void setStatusDriveList(List<Status_driver> statusDriveList) {
        this.statusDriveList = statusDriveList;
    }
}
