/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import Interfaces.PruebaTabbed;
import java.util.concurrent.Semaphore;

/**
 *
 * @author fabriziospiotta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PruebaTabbed main = new PruebaTabbed();
        main.show();
        
        Semaphore mutex = new Semaphore(1);
        Drive drive = new Drive();
        
        Worker hilo1 = new Worker(0, 3000, drive, mutex);
        Worker hilo2 = new Worker(1, 3000, drive, mutex);
        Worker hilo3 = new Worker(2, 3000, drive, mutex);
        Worker hilo4 = new Worker(3, 3000, drive, mutex);
        Worker hilo5 = new Worker(4, 3000, drive, mutex);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
    
}
