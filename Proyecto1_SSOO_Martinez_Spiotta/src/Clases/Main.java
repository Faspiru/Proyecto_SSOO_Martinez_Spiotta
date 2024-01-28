/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import Interfaces.PruebaTabbed;
import java.awt.TextField;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
        
         try{
            FileReader lector = new FileReader ("DatosIniciales.txt");
            String contenido = "";
            int valor = lector.read( );

            while (valor != -1){
                contenido += (char)valor;
                valor = lector.read( );
            }

            String [] divide1 = contenido.split(" / ");

            lector = new FileReader ("InitialQuantity.txt");
            contenido = "";
            valor = lector.read( );

            while (valor != -1){
                contenido += (char)valor;
                valor = lector.read( );
            }

            String [] divide2 = contenido.split(" / ");

            int dayDuration = Integer.parseInt(divide1[0].replaceAll("\\p{C}", ""));
            int deadline = Integer.parseInt(divide1[1].replaceAll("\\p{C}", ""));


            int [] initialQuantityNick = new int [6];

            for (int i = 0; i < 6; i++){
                initialQuantityNick[i] = Integer.parseInt(divide2[0].split(", ")[i]);
            }

            int [] necessitiesNick = new int [6]; 
            necessitiesNick[0] = 2;
            necessitiesNick[1] = 1;
            necessitiesNick[2] = 4;
            necessitiesNick[3] = 4;
            necessitiesNick[4] = 2;
            necessitiesNick[5] = 5;

            int [] daysToFinoshNick = new int[5]; // Maria 20221110420
            daysToFinoshNick[0] = 2;
            daysToFinoshNick[1] = 2;
            daysToFinoshNick[2] = 1;
            daysToFinoshNick[3] = 1;
            daysToFinoshNick[4] = 3;


            Company nickelodeon = new Company(necessitiesNick, daysToFinoshNick, initialQuantityNick, 12, dayDuration, 450000, 500000, deadline);

            int [] initialQuantityD= new int [6];

            for (int i = 0; i < 6; i++){
                initialQuantityD[i] = Integer.parseInt(divide2[1].split(", ")[i]);
            }

            int [] necessitiesD = new int [6];
            // Cuando hagamos lo del TXT, sacamos con un .split una lista con c/valor y ya, no hace falta hacer esto
            // Luego esa lista se modifca cuando se desee eliminar o agregar
            necessitiesD[0] = 1;
            necessitiesD[1] = 1;
            necessitiesD[2] = 2;
            necessitiesD[3] = 4;
            necessitiesD[4] = 3;
            necessitiesD[5] = 2;

            int [] daysToFinoshD = new int[5]; // Fabrizio 20221110261
            daysToFinoshD[0] = 2;
            daysToFinoshD[1] = 2;
            daysToFinoshD[2] = 1;
            daysToFinoshD[3] = 1;
            daysToFinoshD[4] = 3;

            Company disney = new Company(necessitiesD, daysToFinoshD, initialQuantityD, 13, dayDuration, 250000, 600000, deadline);

            PruebaTabbed main = new PruebaTabbed(nickelodeon, disney, initialQuantityNick, initialQuantityD);
            main.show();

        } catch (Exception e){
            e.printStackTrace( );
        }
        
        
        // Aqui se tienen que pasar las dos companys como parametro
        
        
    }
   
    
}
