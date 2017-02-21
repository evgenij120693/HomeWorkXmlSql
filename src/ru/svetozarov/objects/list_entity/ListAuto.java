package ru.svetozarov.objects.list_entity;

import ru.svetozarov.objects.entity.Auto;
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
@XmlRootElement(name = "Autos")
@XmlType(propOrder = {"autoList"})
public class ListAuto {
    private List<Auto> autoList = new ArrayList<>();

    public List<Auto> getAutoList() {
        return autoList;
    }

    @XmlElement(name = "auto")
    public void setAutoList(List<Auto> autoList) {
        this.autoList = autoList;
    }
}
