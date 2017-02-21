package ru.svetozarov.objects.collections;

import ru.svetozarov.objects.entity.*;

import java.util.HashSet;

/**
 * Created by E. Svetozarov on 21.02.2017.
 */
public class ListAddedEntries {
    private HashSet<Integer>  listStatusDriver = new HashSet<>();
    private HashSet<Integer>  listStatusOrder = new HashSet<>();
    private HashSet<Integer>  listAuto = new HashSet<>();
    private HashSet<Integer>  listOrder = new HashSet<>();
    private HashSet<Integer> listClient = new HashSet<>();
    private HashSet<Integer> listDriver = new HashSet<>();


    public void addedStatusDriver(int id){
        synchronized (listStatusDriver){
            listStatusDriver.add(id);
        }
    }

    public boolean checkStatusDriver(int id){
        synchronized (listStatusDriver){
            return  listStatusDriver.contains(id);
        }
    }

    public void addedStatusOrder(int id){
        synchronized (listStatusOrder){
            listStatusOrder.add(id);
        }
    }

    public boolean checkStatusOrder(int id){
        synchronized (listStatusOrder){
            return  listStatusOrder.contains(id);
        }
    }

    public void addedAuto(int id){
        synchronized (listAuto){
            listAuto.add(id);
        }
    }

    public boolean checkAuto(int id){
        synchronized (listAuto){
            return listAuto.contains(id);
        }
    }

    public void addedOrder(int id){
        synchronized (listOrder){
            listOrder.add(id);
        }
    }

    public boolean checkOrder(int id){
        synchronized (listOrder){
            return  listOrder.contains(id);
        }
    }

    public void addedClient(int id){
        synchronized (listClient){
            listClient.add(id);
        }
    }

    public boolean checkClient(int id){
        synchronized (listClient){
            return  listClient.contains(id);
        }
    }

    public void addedDriver(int id){
        synchronized (listDriver){
            listDriver.add(id);
        }
    }

    public boolean checkDriver(int id){
        synchronized (listDriver){
            return  listDriver.contains(id);
        }
    }







}
