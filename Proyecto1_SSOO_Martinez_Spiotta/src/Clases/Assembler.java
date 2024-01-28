package Clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariv
 */
public class Assembler extends Thread{
    private float salaryAcumulate;
    private int dayDuration;
    private int quantityWorkers;
    private int salary;
    private Drive drive;
    private int daysCounter;
    private int daysToFinishWork;
    private Semaphore mutex;

    public Assembler(int dayDuration, int quantity, Drive drive, Semaphore mutex) {
        this.quantityWorkers = quantity;
        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.drive = drive;
        this.daysCounter = 0;
        this.mutex = mutex;
        this.salary = 50;
        this.daysToFinishWork = 2;
    }
    
    @Override
    public void run(){
        while(true) {
            try {  
                paySalary();
                if (daysCounter == 0){
                    if (check()){
                        work();
                    }
                }else{
                    work();
                }
                System.out.println("Trabajador: Ensamblador" + ". Gana: "+this.salaryAcumulate+"$");
                sleep(this.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void paySalary(){
        this.salaryAcumulate = this.salaryAcumulate + ((this.salary * 24) * this.quantityWorkers);
    }
    
    public void work(){
        this.daysCounter = this.daysCounter + 1;
        if (this.daysCounter == this.daysToFinishWork){ // ese valor de 2 depende de la compania
            try {
                this.mutex.acquire(); //wait
                this.drive.addChapter(this.quantityWorkers); //critica
                this.mutex.release(); // signal
                this.daysCounter = 0;
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    public boolean check(){
        boolean ready = false;
        try {
            this.mutex.acquire(); //wait
            ready = this.drive.check();
            System.out.println("\nCHEQUEO --> " + ready);
            this.mutex.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ready;
    }
     
    public void deleteWorker() {
        if (this.quantityWorkers != 1) {
            this.quantityWorkers = this.quantityWorkers - 1;
        }
    }
    
    public void addWorker(){
        this.quantityWorkers = this.quantityWorkers + 1;
    }

    public float getSalaryAcumulate() {
        return salaryAcumulate;
    }

    public void setSalaryAcumulate(float salaryAcumulate) {
        this.salaryAcumulate = salaryAcumulate;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public int getQuantityWorkers() {
        return quantityWorkers;
    }

    public void setQuantityWorkers(int quantityWorkers) {
        this.quantityWorkers = quantityWorkers;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public int getDaysCounter() {
        return daysCounter;
    }

    public void setDaysCounter(int daysCounter) {
        this.daysCounter = daysCounter;
    }

    public int getDaysToFinishWork() {
        return daysToFinishWork;
    }

    public void setDaysToFinishWork(int daysToFinishWork) {
        this.daysToFinishWork = daysToFinishWork;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    
    
}
