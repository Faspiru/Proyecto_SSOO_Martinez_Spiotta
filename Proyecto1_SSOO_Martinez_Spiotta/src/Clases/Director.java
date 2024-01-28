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
    private String status;
    private Semaphore mutex;
    private Semaphore mutex2;
    private Semaphore mutex3;
    private Company company;
    private int reinicioDeadline;
    private boolean directorMode;
    
    public Director(int dayDuration, Drive drive, Semaphore mutex, Semaphore mutex2, Semaphore mutex3, Company company) {
        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.drive = drive;
        this.daysCounter = 0;
        this.mutex = mutex;
        this.mutex2 = mutex2;
        this.mutex3 = mutex3;
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
                    status = "Enviando Capitulos";
                    // LABEL DE STATUS DIRECTOR
                    work();
                    sleep(this.dayDuration);
                }else{
                    double randomHour = Math.random( )*23;
                    int random = (int)randomHour;
                    sleep((this.dayDuration*random)/24);
                    
                    status = "Revisando PM";
                    // LABEL DE STATUS DIRECTOR
                    checkPM();
                    sleep((dayDuration*30)/(24*60));
                    checkPM();
                    sleep((dayDuration*5)/(24*60));                    
                    
                    status = "Labores Administrativos";
                    // LABEL DE STATUS DIRECTOR
                    sleep((dayDuration*25)/(60*24));
                    sleep((this.dayDuration*(23-random))/24);
                }
                
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
    
    public void checkPM(){
        if (company.getPm().getStatus().equals("Viendo One Piece (anime)")){
            company.getPm().setFault(company.getPm().getFault() + 1);
            company.getPm().setDiscounted(company.getPm().getDiscounted()+ 100); 
            // LABELS PARA CAMBIAR ESTOS VALORES
            try {
                this.mutex3.acquire(); //wait
                company.getPm().setSalaryAcumulate(company.getPm().getSalaryAcumulate() - 100);//critica   
                this.mutex3.release(); // signal
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public float getSalaryAcumulate() {
        return salaryAcumulate;
    }

    public void setSalaryAcumulate(float salaryAcumulate) {
        this.salaryAcumulate = salaryAcumulate;
    }
    
    
    
}
