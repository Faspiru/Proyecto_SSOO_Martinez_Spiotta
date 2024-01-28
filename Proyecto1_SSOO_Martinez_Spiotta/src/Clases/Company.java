/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Interfaces.PruebaTabbed;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author fabriziospiotta
 */
public class Company extends Thread{
        
    private Worker guionistas;
    private Worker escenarios;
    private Worker animadores;
    private Worker dobladores;
    private Worker guionistasPlotTwists;
    private Assembler ensambladores;
    private Director director;
    private PM pm;
    
    private int [] necessities;
    private int [] daysToFinishWork;
    private int [] initialQuantity;
    private int maxWorkers;
    private int dayDuration;
    private int chapterPrice;
    private int ptPrice;
    private int ganancias;  // RUN
    private int costos;
    private int utilidad;
    private int deadline;
    
    // Labels
    
    //private JLabel [] qttyPartsSavedLabels;
    
    private Semaphore mutex;
    private Semaphore mutex2;
    private Semaphore mutex3;
    private Drive drive;
    
    // Atributos de dinero
    
    
    public Company(int [] necessities, int [] daysToFinishWork, int [] initialQuantity, int maxWorkers, int dayDuration, int chapterPrice, int ptPrice, int deadline){
        this.necessities = necessities;
        this.daysToFinishWork = daysToFinishWork;
        this.initialQuantity = initialQuantity;
        this.maxWorkers = maxWorkers;
        this.dayDuration = dayDuration;
        this.ganancias = 0;
        this.costos = 0;
        this.utilidad = 0;
        this.chapterPrice = chapterPrice;
        this.ptPrice = ptPrice;
        this.drive = new Drive(necessities, this);
        this.mutex = new Semaphore(1);
        this.mutex2 = new Semaphore(1);
        this.mutex3 = new Semaphore(1);
        this.deadline = deadline;
        //startEmployees();   
    }
    
    public void costosCalculate() {
       this.costos = (int) (guionistas.getSalaryAcumulate() + escenarios.getSalaryAcumulate() + animadores.getSalaryAcumulate() + dobladores.getSalaryAcumulate() + guionistasPlotTwists.getSalaryAcumulate() + ensambladores.getSalaryAcumulate() + pm.getSalaryAcumulate() + director.getSalaryAcumulate()); // falta el director//critica           
    }
    
    public void utilidadesTotales() {
        this.utilidad = this.ganancias - this.costos;
    }
    
    public void startEmployees(){
        guionistas = new Worker(0, dayDuration, initialQuantity[0], drive, mutex, daysToFinishWork);
        escenarios = new Worker(1, dayDuration, initialQuantity[1], drive, mutex, daysToFinishWork);
        animadores = new Worker(2, dayDuration, initialQuantity[2], drive, mutex, daysToFinishWork);
        dobladores = new Worker(3, dayDuration, initialQuantity[3], drive, mutex, daysToFinishWork);
        guionistasPlotTwists = new Worker(4, dayDuration, initialQuantity[4], drive, mutex, daysToFinishWork);
        ensambladores = new Assembler(dayDuration, initialQuantity[5], drive, mutex);
        pm = new PM(dayDuration, mutex, mutex2, mutex3, this);
        director = new Director(dayDuration, drive, mutex, mutex2, mutex3, this);
       
        guionistas.start();
        escenarios.start();
        animadores.start();
        dobladores.start();
        guionistasPlotTwists.start();
        ensambladores.start();  
        pm.start();   
        director.start();//PM y Director son hilos porque ambos tienen acceso al contador del deadline  
              
    }
    
    public void addWorkers(int type) {
        int actualWorkersCounter = (guionistas.getQuantityWorkers() + escenarios.getQuantityWorkers() + animadores.getQuantityWorkers() + dobladores.getQuantityWorkers() + guionistasPlotTwists.getQuantityWorkers() + ensambladores.getQuantityWorkers());
        if (actualWorkersCounter < maxWorkers) {
            if (type == 0) {
                guionistas.addWorker();  
            }
            if (type == 1) {
                escenarios.addWorker();   
            }
            if (type == 2) {
                animadores.addWorker();  
            }
            if (type == 3) {
                dobladores.addWorker();   
            }
            if (type == 4) {
                guionistasPlotTwists.addWorker();   
            }
            if (type == 5) {
                ensambladores.addWorker();   
            }    
        } else {
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        }
    }
    
//    @Override
//    public void run(){
//        while(true) {
//            try {
//                /// Funciones
//                sleep(this.dayDuration); // Sleep??
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    
    
    /// SI HILO -->
    /// Funcion cantidad trabajador y tipo (acceder atributos de cada tipo)
    /// Funcio cantidades de Drive
    /// Funcion cantidad de capitulos y pt (acceder atributo capitulo y plotwist)
    /// deadline ??
    /// Funcion PM y Director status, faltas y descontado (acceder atributo)
    /// Funcion ganancias, costos, utilidad
    

    public Worker getGuionistas() {
        return guionistas;
    }

    public Worker getEscenarios() {
        return escenarios;
    }

    public Worker getAnimadores() {
        return animadores;
    }

    public Worker getDobladores() {
        return dobladores;
    }

    public Worker getGuionistasPlotTwists() {
        return guionistasPlotTwists;
    }

    public Assembler getEnsambladores() {
        return ensambladores;
    }

    public int[] getInitialQuantity() {
        return initialQuantity;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }

    public int getCostos() {
        return costos;
    }

    public int getUtilidad() {
        return utilidad;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public Drive getDrive() {
        return drive;
    }    

    public PM getPm() {
        return pm;
    }

    public void setPm(PM pm) {
        this.pm = pm;
    }

    public int getChapterPrice() {
        return chapterPrice;
    }

    public void setChapterPrice(int chapterPrice) {
        this.chapterPrice = chapterPrice;
    }

    public int getPtPrice() {
        return ptPrice;
    }

    public void setPtPrice(int ptPrice) {
        this.ptPrice = ptPrice;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }
    
    
    
    
    
  
}
