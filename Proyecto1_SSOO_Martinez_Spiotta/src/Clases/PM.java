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
    private int discounted;
    private String status;
    private int hoursCounter;
    private int minutesCounter;
    private int daysPassedTotal; // solo para el pm, que el lo cambie 
    private JLabel[] labels;
    private Semaphore mutex;
    private Company company;
    private Semaphore mutex2;
    private Semaphore mutex3;
    private GraphManager grafico;
 
    public PM(int dayDuration, Semaphore mutex, Semaphore mutex2, Semaphore mutex3, Company company){
        this.salaryAcumulate = 0;
        this.dayDuration = dayDuration;
        this.salary = 40;
        this.fault = 0;
        this.discounted = 0;
        this.daysPassedTotal = 0;
        this.status = "Viendo One Piece (anime)";
        this.mutex = mutex;
        this.mutex3 = mutex3;
        this.mutex2 = mutex2;
        this.company = company;
    }
    
    
    @Override
    public void run(){
        while(true) {
            try {
                paySalary();
                calculate();
                // Primeras 16 horas
                long startTime = System.currentTimeMillis();
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
                setDaysPassedTotal(getDaysPassedTotal() + 1);
                this.labels[4].setText(Integer.toString(getDaysPassedTotal()));
                if (company.getMaxWorkers() == 13) {
                    this.labels[5].setText(Integer.toString(getDaysPassedTotal()));
                    this.grafico.actualizarGrafico(); // Actualiza el grafico cada dia solo el pm de una compania para que no de error en la terminal
                }
                sleep((dayDuration/24)*8);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void paySalary(){
        try {
          this.mutex3.acquire(); //wait
          salaryAcumulate = this.salaryAcumulate + (this.salary* 24); //critica
          this.mutex3.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
     public void calculate(){
         try {
            this.mutex3.acquire(); //wait
            this.company.costosCalculate(); //critica
            this.labels[1].setText(Integer.toString(this.company.getCostos()));
            this.company.utilidadesTotales();
            this.labels[2].setText(Integer.toString(this.company.getUtilidad()));
            this.mutex3.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
       
    public void work(){
        try {
            this.mutex2.acquire(); //wait
            this.company.setDeadline(this.company.getDeadline() - 1); //critica
            this.labels[3].setText(Integer.toString(this.company.getDeadline()));
            this.mutex2.release(); // signal
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

    public int getDiscounted() {
        return discounted;
    }

    public void setDiscounted(int discounted) {
        this.discounted = discounted;
    }

    /**
     * @return the daysPassedTotal
     */
    public int getDaysPassedTotal() {
        return daysPassedTotal;
    }

    /**
     * @param daysPassedTotal the daysPassedTotal to set
     */
    public void setDaysPassedTotal(int daysPassedTotal) {
        this.daysPassedTotal = daysPassedTotal;
    }

    public GraphManager getGrafico() {
        return grafico;
    }

    public void setGrafico(GraphManager grafico) {
        this.grafico = grafico;
    }
    
    
    
    
}
