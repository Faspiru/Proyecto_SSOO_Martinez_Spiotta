/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariv
 */
public class PM extends Thread{
    
    private float salaryAcumulate;
    private int dayDuration;
    private int salary;
    private int fault;
    private String status;
    // private atributo deadline 
    private int hoursCounter;
    private int minutesCounter;
    private Semaphore mutex;
    
    
    public PM(int dayDuration, Semaphore mutex){
        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.salary = 40;
        this.fault = 0;
        this.hoursCounter = 0;
        this.minutesCounter = 0;
        this.mutex = mutex;
        this.status = "Anime";
    }
    
    
    @Override
    public void run(){
        while(true) {
            try {
                paySalary();
                
                // Primeras 16 horas
                long startTime = System.currentTimeMillis();
                // Ni idea si esto funcione pero es como para simular ese bucle de ver anime y trabajar por las primeras 16 horas
                while(System.currentTimeMillis() - startTime <= ((24/dayDuration)*16)){
                    status = "Anime";
                    sleep((60/(24/dayDuration))*30);

                    status = "Trabajando";
                    sleep((60/(24/dayDuration))*30);
                }
                
                // Restantes 8 horas
                work();
                
                System.out.println("Trabajador: PM. Gana: "+this.salaryAcumulate+"$");
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
       public void paySalary(){
        salaryAcumulate = this.salaryAcumulate + (this.salary* 24);
    }
       
       
    public void work(){
        try {
            this.mutex.acquire(); //wait
            // modifica deadline -1 ; //critica
            this.mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void check(){
        try {
            this.mutex.acquire(); //wait
            // chequea deadline ; //critica
            this.mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
