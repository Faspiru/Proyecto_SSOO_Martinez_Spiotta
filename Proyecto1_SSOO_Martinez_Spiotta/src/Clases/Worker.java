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
public class Worker extends Thread{
    
    private int type;
    private float salaryAcumulate;
    private int dayDuration;
    private int salary;
    private Drive drive;
    private int dayCounterForSalary;
    private int daysTofinishWork;
    private Semaphore mutex;

    public Worker(int type, int dayDuration, Drive drive, Semaphore mutex) {
        this.type = type;
        if (this.type == 0) {
            this.salary = 20;
            this.daysTofinishWork = 2; // Este numero deberia venir de la compania
        }
        if (this.type == 1) {
            this.salary = 26;
            this.daysTofinishWork = 2; // Este numero deberia venir de la compania
        }
        if (this.type == 2) {
            this.salary = 40;
            this.daysTofinishWork = 1; // Este numero deberia venir de la compania
        }
        if (this.type == 3) {
            this.salary = 16;
            this.daysTofinishWork = 1; // Este numero deberia venir de la compania
        }
        if (this.type == 4) {
            this.salary = 16;
            this.daysTofinishWork = 3; // Este numero deberia venir de la compania
        }
        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.drive = drive;
        this.dayCounterForSalary = 0;
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
        this.setSalaryAcumulate(this.getSalaryAcumulate() + this.getSalary() * 24);
    }
    
    public void work(){
        this.setDayCounterForSalary(this.getDayCounterForSalary() + 1);
        if (this.getDayCounterForSalary() == this.getDaysTofinishWork()){ // ese valor de 2 depende de la compania
            try {
                this.getMutex().acquire(); //wait
                this.getDrive().addPart(this.getType());//critica
                this.getMutex().release();// signal
                this.setDayCounterForSalary(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
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
     * @return the dayCounterForSalary
     */
    public int getDayCounterForSalary() {
        return dayCounterForSalary;
    }

    /**
     * @param dayCounterForSalary the dayCounterForSalary to set
     */
    public void setDayCounterForSalary(int dayCounterForSalary) {
        this.dayCounterForSalary = dayCounterForSalary;
    }

    /**
     * @return the daysTofinishWork
     */
    public int getDaysTofinishWork() {
        return daysTofinishWork;
    }

    /**
     * @param daysTofinishWork the daysTofinishWork to set
     */
    public void setDaysTofinishWork(int daysTofinishWork) {
        this.daysTofinishWork = daysTofinishWork;
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
    
    
}
