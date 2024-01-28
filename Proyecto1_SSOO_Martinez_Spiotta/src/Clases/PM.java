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
    private JLabel[] labels;
    private Semaphore mutex;
    private Company company;
    private Semaphore mutex2;
 
    public PM(int dayDuration, Semaphore mutex, Semaphore mutex2, Company company){
        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.salary = 40;
        this.fault = 0;
        this.hoursCounter = 0;
        this.minutesCounter = 0;
        this.mutex = mutex;
        this.status = "Anime";
        this.mutex2 = mutex2;
        this.company = company;
    }
    
    
    @Override
    public void run(){
        while(true) {
            try {
                this.company.costosCalculate();
                this.labels[1].setText(Integer.toString(this.company.getCostos()));
                this.company.utilidadesTotales();
                this.labels[2].setText(Integer.toString(this.company.getUtilidad()));
                paySalary();
                // Primeras 16 horas
                long startTime = System.currentTimeMillis();
                // Ni idea si esto funcione pero es como para simular ese bucle de ver anime y trabajar por las primeras 16 horas
                while(System.currentTimeMillis() - startTime <= ((dayDuration/24)*16)){
                    status = "Viendo One Piece (anime)";
                    this.labels[0].setText(status);
                    sleep(((dayDuration/24)/2));

                    status = "Revisando";
                    this.labels[0].setText(status);
                    // check();
                    sleep(((dayDuration/24)/2));
                }
                
                // Restantes 8 horas
                status = "Trabajando";
                this.labels[0].setText(status);
                work();
                sleep((dayDuration/24)*8);
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
            this.mutex2.acquire(); //wait
            this.company.setDeadline(this.company.getDeadline() - 1); //critica
            this.mutex2.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
//    public void check(){
//        try {
//            this.mutex.acquire(); //wait
//            // chequea deadline ; //critica
//            this.mutex.release(); // signal
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getFault() {
        return fault;
    }

    public void setFault(int fault) {
        this.fault = fault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHoursCounter() {
        return hoursCounter;
    }

    public void setHoursCounter(int hoursCounter) {
        this.hoursCounter = hoursCounter;
    }

    public int getMinutesCounter() {
        return minutesCounter;
    }

    public void setMinutesCounter(int minutesCounter) {
        this.minutesCounter = minutesCounter;
    }

    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
}
