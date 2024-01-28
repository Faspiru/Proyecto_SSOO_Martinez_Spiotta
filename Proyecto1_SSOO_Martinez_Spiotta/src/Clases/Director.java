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
 * @author fabriziospiotta
 */
public class Director extends Thread{
    
    private float salaryAcumulate;
    private int dayDuration;
    private int salary;
    private Drive drive;
    private int daysCounter;
    private int daysToFinishWork;
    private Semaphore mutex;
    private Semaphore mutex2;
    private Company company;
    private int reinicioDeadline;
    private boolean directorMode;
    
    public Director(int dayDuration, Drive drive, Semaphore mutex, Semaphore mutex2, Company company) {
        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.drive = drive;
        this.daysCounter = 0;
        this.mutex = mutex;
        this.mutex2 = mutex2;
        this.salary = 60;
        this.daysToFinishWork = 1;
        this.company = company;
        this.reinicioDeadline = company.getDeadline();
        this.directorMode = false;
    }
    
     @Override
    public void run(){
        while(true) {
            try {  
                paySalary();
                checkDeadline();
                if (directorMode) {
                    work();
                }
                sleep(this.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void paySalary(){
        this.salaryAcumulate = this.salaryAcumulate + (this.salary * 24);
    }
    

    public void checkDeadline(){
        try {
            this.mutex2.acquire(); //wait
            if (this.company.getDeadline() == 0) {
                directorMode = true;
                System.out.println("reinicio deadline: " + reinicioDeadline);
                this.company.setDeadline(reinicioDeadline);
            }
            this.mutex2.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void work(){
        this.daysCounter = this.daysCounter + 1;
        if (this.daysCounter == this.daysToFinishWork){ // ese valor de 2 depende de la compania
            try {
                this.mutex.acquire(); //wait
                drive.sendChapters();
                this.mutex.release(); // signal
                this.daysCounter = 0;
                directorMode = false;
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
}
