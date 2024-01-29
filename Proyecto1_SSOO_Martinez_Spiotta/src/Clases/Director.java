/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

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
    private JLabel[] labels;
    
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
                    this.labels[0].setText(status);
                    work();
                    sleep(this.dayDuration);
                }else{
                    double randomHour = Math.random( )*23;
                    int random = (int)randomHour;
                    sleep((this.dayDuration*random)/24);
                    
                    status = "Revisando PM";
                    this.labels[0].setText(status);
                    checkPM();
                    sleep((dayDuration*30)/(24*60));
                    checkPM();
                    sleep((dayDuration*5)/(24*60));                    
                    
                    status = "Labores Administrativos";
                    this.labels[0].setText(status);
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
                this.labels[1].setText(Integer.toString(this.company.getDeadline()));
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
                getDrive().sendChapters();
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
            this.labels[2].setText(Integer.toString(company.getPm().getFault()));
            company.getPm().setDiscounted(company.getPm().getDiscounted() + 100); 
            this.labels[3].setText(Integer.toString(company.getPm().getDiscounted()));
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

    /**
     * @return the drive
     */
    public Drive getDrive() {
        return drive;
    }

    /**
     * @return the labels
     */
    public JLabel[] getLabels() {
        return labels;
    }

    /**
     * @param labels the labels to set
     */
    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }
 
    
}
