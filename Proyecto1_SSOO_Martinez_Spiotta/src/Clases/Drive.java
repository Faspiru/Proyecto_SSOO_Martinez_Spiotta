/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author fabriziospiotta
 */
public class Drive {
    
    private int guiones;
    private int escenarios;
    private int animaciones;
    private int doblajes;
    private int plotTwists;

    public Drive() {
        this.guiones = 0;
        this.escenarios = 0;
        this.animaciones = 0;
        this.doblajes = 0;
        this.plotTwists = 0;
    }
    
    public void addPart(int type, int cautity) {
        if (type == 0 && this.getGuiones() < 25){
            int calc = this.getGuiones() + (1 * cautity);
            if (calc < 25) {
                this.setGuiones(calc);
            } else {
                this.setGuiones(25);
            }
            System.out.println("Guiones disponibles:" + this.getGuiones());
        }
        else if (type == 1 && this.getEscenarios() < 20){
            int calc = this.getEscenarios() + (1 * cautity);
            if (calc < 20) {
                this.setEscenarios(calc);
            } else {
                this.setEscenarios(20);
            }
            System.out.println("Escenarios disponibles:" + this.getEscenarios());
        }
        else if (type == 2 && this.getAnimaciones() < 55){
            int calc = this.getAnimaciones() + (3 * cautity);
            if (calc < 55) {
                this.setAnimaciones(calc);
            } else {
                this.setAnimaciones(55);
            }
            System.out.println("Animaciones disponibles:" + this.getAnimaciones());
        }
        else if (type == 3 && this.getDoblajes() < 35){
            int calc = this.getDoblajes() + (3 * cautity);
            if (calc < 35) {
                this.setDoblajes(calc);
            } else {
                this.setDoblajes(35);
            }
            System.out.println("Doblajes disponibles:" + this.getDoblajes());
        }
        else if (type == 4 && this.getPlotTwists() < 10){
            int calc = this.getPlotTwists() + (1 * cautity);
            if (calc < 10) {
                this.setPlotTwists(calc);
            } else {
                this.setPlotTwists(10);
            }
            System.out.println("PlotTwists disponibles:" + this.getPlotTwists());
        }
    }
   
    /**
     * @return the guiones
     */
    public int getGuiones() {
        return guiones;
    }

    /**
     * @param guiones the guiones to set
     */
    public void setGuiones(int guiones) {
        this.guiones = guiones;
    }

    /**
     * @return the animaciones
     */
    public int getAnimaciones() {
        return animaciones;
    }

    /**
     * @param animaciones the animaciones to set
     */
    public void setAnimaciones(int animaciones) {
        this.animaciones = animaciones;
    }

    /**
     * @return the escenarios
     */
    public int getEscenarios() {
        return escenarios;
    }

    /**
     * @param escenarios the escenarios to set
     */
    public void setEscenarios(int escenarios) {
        this.escenarios = escenarios;
    }

    /**
     * @return the doblajes
     */
    public int getDoblajes() {
        return doblajes;
    }

    /**
     * @param doblajes the doblajes to set
     */
    public void setDoblajes(int doblajes) {
        this.doblajes = doblajes;
    }

    /**
     * @return the plotTwists
     */
    public int getPlotTwists() {
        return plotTwists;
    }

    /**
     * @param plotTwists the plotTwists to set
     */
    public void setPlotTwists(int plotTwists) {
        this.plotTwists = plotTwists;
    }
    
    
    
    
    
    
    
}
