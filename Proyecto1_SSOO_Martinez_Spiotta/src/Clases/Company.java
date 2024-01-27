/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.concurrent.Semaphore;

/**
 *
 * @author fabriziospiotta
 */
public class Company {
        
    private Worker guionistas;
    private Worker escenarios;
    private Worker animadores;
    private Worker dobladores;
    private Worker guionistasPlotTwists;
    private Assembler ensambladores;
    // private Director director;
    // private PM pm;
    // private Semaphore mutex2;  Creo que como el pm y el director acceden al deadline, deberia haber un semaforo aparte para eso
    
    private int [] necessities;
    private int [] daysToFinishWork;
    private int [] initialQuantity;
    private int dayDuration;
    private int chapterPrice;
    private int ptPrice;
    private int ganancias;  // No se si tener estos tres atributos aqui o en una clase aparte
    private int costos;
    private int utilidad;
    
    private Semaphore mutex;
    private Drive drive;
    
    // Atributos de dinero
    
    
    public Company(int [] necessities, int [] daysToFinishWork, int [] initialQuantity, int dayDuration, int chapterPrice, int ptPrice){
        this.necessities = necessities;
        this.daysToFinishWork = daysToFinishWork;
        this.initialQuantity = initialQuantity;
        this.dayDuration = dayDuration;
        this.ganancias = 0;
        this.costos = 0;
        this.utilidad = 0;
        this.chapterPrice = chapterPrice;
        this.ptPrice = ptPrice;
        this.drive = new Drive(necessities);
        this.mutex = new Semaphore(1);
        startEmployees();
    }
    
    public void startEmployees(){
        guionistas = new Worker(0, dayDuration, initialQuantity[0], drive, mutex, daysToFinishWork);
        escenarios = new Worker(1, dayDuration, initialQuantity[1], drive, mutex, daysToFinishWork);
        animadores = new Worker(2, dayDuration, initialQuantity[2], drive, mutex, daysToFinishWork);
        dobladores = new Worker(3, dayDuration, initialQuantity[3], drive, mutex, daysToFinishWork);
        guionistasPlotTwists = new Worker(4, dayDuration, initialQuantity[4], drive, mutex, daysToFinishWork);
        ensambladores = new Assembler(dayDuration, initialQuantity[5], drive, mutex);
        // director = new Director();
        // pm = new PM();
        
        guionistas.start();
        escenarios.start();
        animadores.start();
        dobladores.start();
        guionistasPlotTwists.start();
        ensambladores.start();
        // director.start();
        // pm.start();    PM y Director son hilos porque ambos tienen acceso al contador del deadline
        
        
    }

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

    
}
