/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author fabriziospiotta
 */
public class Worker extends Thread{
    
    private int type;
    private float salaryAcumulate;
    private int dayDuration;
    private int quantityWorkers;
    private int salary;
    private Drive drive;
    private int daysCounter;
    private int daysToFinishWork;
    private Semaphore mutex;

    public Worker(int type, int dayDuration, int quantity, Drive drive, Semaphore mutex, int [] daysToFinish) {
        this.type = type;
        this.quantityWorkers = quantity;
        this.daysToFinishWork = daysToFinish[type];
        if (this.type == 0) {
            this.salary = 20;
        }
        else if (this.type == 1) {
            this.salary = 26;
        }
        else if (this.type == 2) {
            this.salary = 40;
        }
        else if (this.type == 3) {
            this.salary = 16;
        }
        else if (this.type == 4) {
            this.salary = 34;
        } 

        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.drive = drive;
        this.daysCounter = 0;
        this.mutex = mutex;
    }
    
    @Override
    public void run(){
        while(true) {
            try {
                paySalary();
                work();
                System.out.println("Trabajador: "+ this.getType() + " gana: "+this.getSalaryAcumulate()+"$");
                sleep(this.getDayDuration());
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void paySalary(){
        this.setSalaryAcumulate(this.getSalaryAcumulate() + ((this.getSalary() * 24)) * this.getQuantityWorkers());
    }
    
    public void work(){
        this.setDaysCounter(this.getDaysCounter() + 1);
        if (this.getDaysCounter() == this.getDaysToFinishWork()){ // ese valor de 2 depende de la compania
            try {
                this.getMutex().acquire(); //wait
                this.getDrive().addPart(this.getType(), this.getQuantityWorkers()); //critica
                this.getMutex().release(); // signal
                this.setDaysCounter(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
     
    public void deleteWorker() {
        if (this.getQuantityWorkers() != 1) {
            this.setQuantityWorkers(this.quantityWorkers - 1);
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        }
    }
    
    public void addWorker(){
        this.setQuantityWorkers(quantityWorkers + 1);
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the salaryAcumulate
     */
    public float getSalaryAcumulate() {
        return salaryAcumulate;
    }

    /**
     * @param salaryAcumulate the salaryAcumulate to set
     */
    public void setSalaryAcumulate(float salaryAcumulate) {
        this.salaryAcumulate = salaryAcumulate;
    }

    /**
     * @return the dayDuration
     */
    public int getDayDuration() {
        return dayDuration;
    }

    /**
     * @param dayDuration the dayDuration to set
     */
    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return the drive
     */
    public Drive getDrive() {
        return drive;
    }

    /**
     * @param drive the drive to set
     */
    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    /**
     * @return the daysCounter
     */
    public int getDaysCounter() {
        return daysCounter;
    }

    /**
     * @param daysCounter the daysCounter to set
     */
    public void setDaysCounter(int daysCounter) {
        this.daysCounter = daysCounter;
    }

    /**
     * @return the daysToFinishWork
     */
    public int getDaysToFinishWork() {
        return daysToFinishWork;
    }

    /**
     * @param daysToFinishWork the daysToFinishWork to set
     */
    public void setDaysToFinishWork(int daysToFinishWork) {
        this.daysToFinishWork = daysToFinishWork;
    }

    /**
     * @return the mutex
     */
    public Semaphore getMutex() {
        return mutex;
    }

    /**
     * @param mutex the mutex to set
     */
    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    /**
     * @return the quantityWorkers
     */
    public int getQuantityWorkers() {
        return quantityWorkers;
    }

    /**
     * @param quantityWorkers the quantityWorkers to set
     */
    public void setQuantityWorkers(int quantityWorkers) {
        this.quantityWorkers = quantityWorkers;
    }
    
    
}
