package ru.svetozarov.thread_manager;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.svetozarov.objects.collections.ListAddedEntries;

import java.util.List;

/**
 * Класс, реализущий создание и старт потоков
 * Created by E. Svetozarov on 21.02.2017.
 */
public class ManagerThread {
    private static final Logger logger = Logger.getLogger(ManagerThread.class);

    static {
        DOMConfigurator.configure("src/ru/svetozarov/resources/log4j.xml");
    }
    private volatile boolean flagError = false;
    private ListAddedEntries listAddedEntries;
    private final String listTableName[] = {"status_driver", "status_order",
            "driver", "order", "auto", "client"};
    private boolean mode;
    private List<ThreadSQL> listThread;

    public ManagerThread(boolean mode, List<ThreadSQL> listThread) {
        this.mode = mode;
        this.listThread = listThread;
        if(!mode) {
            listAddedEntries = new ListAddedEntries();
        }
    }

    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    private void createThread(){
        for (String file:
             listTableName  ) {
            ThreadSQL thread = new ThreadSQL();
            thread.setEntries(listAddedEntries);
            thread.setNameTable(file);
            thread.setMode(mode);
            listThread.add(thread);
        }
    }

    private void startThread(){
        for (ThreadSQL thread :
                listThread) {
            thread.start();
        }
    }

    private void joinThread() throws InterruptedException {
        for (ThreadSQL thread :
                listThread) {
            thread.join();
        }
    }

    /**
     * Функция старта процесса выгрузки/загрузки из/в БД
     */
    public void start(){
        createThread();
        startThread();
        try {
            joinThread();
        } catch (InterruptedException e) {
            logger.error("Error joinThread......\n"+e.getMessage());
        }
        if(mode){
            logger.info("Export from database sucessfull.");
        }else {
            logger.info("Import in database successfull.");
        }
    }


}
