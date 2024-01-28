/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

import Interfaces.PruebaTabbed;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

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
        
        int [] necessitiesNick = new int [6];
        // Cuando hagamos lo del TXT, sacamos con un .split una lista con c/valor y ya, no hace falta hacer esto
        // Luego esa lista se modifca cuando se desee eliminar o agregar
        necessitiesNick[0] = 2;
        necessitiesNick[1] = 1;
        necessitiesNick[2] = 4;
        necessitiesNick[3] = 4;
        necessitiesNick[4] = 2;
        necessitiesNick[5] = 5;
        
        int [] daysToFinoshNick = new int[5];
        daysToFinoshNick[0] = 2;
        daysToFinoshNick[1] = 2;
        daysToFinoshNick[2] = 1;
        daysToFinoshNick[3] = 1;
        daysToFinoshNick[4] = 3;
        
        int [] initialQuantityNick = new int[6];
        // Lo mismo aqui con lo del TXT
        // Aqui hay que validar en algun lado de la lectura del txt que no se pongan mas de 12 trabajadores en total y ese 13 tmb tiene que ser sacado del txt pienso yo 
        initialQuantityNick[0] = 2;
        initialQuantityNick[1] = 2;
        initialQuantityNick[2] = 1;
        initialQuantityNick[3] = 1;
        initialQuantityNick[4] = 3;
        initialQuantityNick[5] = 3;
        
        Company nickelodeon = new Company(necessitiesNick, daysToFinoshNick, initialQuantityNick, 12, 3000, 450000, 500000, 5);
        
        
        int [] necessitiesD = new int [6];
        // Cuando hagamos lo del TXT, sacamos con un .split una lista con c/valor y ya, no hace falta hacer esto
        // Luego esa lista se modifca cuando se desee eliminar o agregar
        necessitiesD[0] = 1;
        necessitiesD[1] = 1;
        necessitiesD[2] = 2;
        necessitiesD[3] = 4;
        necessitiesD[4] = 3;
        necessitiesD[5] = 2;
        
        int [] daysToFinoshD = new int[5];
        daysToFinoshD[0] = 2;
        daysToFinoshD[1] = 2;
        daysToFinoshD[2] = 1;
        daysToFinoshD[3] = 1;
        daysToFinoshD[4] = 3;
        
        int [] initialQuantityD = new int[6];
        // Lo mismo aqui con lo del TXT
        initialQuantityD[0] = 1;
        initialQuantityD[1] = 1;
        initialQuantityD[2] = 1;
        initialQuantityD[3] = 1;
        initialQuantityD[4] = 1;
        initialQuantityD[5] = 1;
        
        Company disney = new Company(necessitiesD, daysToFinoshD, initialQuantityD, 13, 3000, 250000, 600000, 5);
//        
        PruebaTabbed main = new PruebaTabbed(nickelodeon, disney);
        main.show();
        
        
        // Aqui se tienen que pasar las dos companys como parametro
        
        
    }
    
}
