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
    
    public void addPart(int type) {
        if (type == 0 && this.getGuiones() < 25){
            this.setGuiones(this.getGuiones() + 1);
            System.out.println("Guiones disponibles:" + this.getGuiones());
        }
        else if (type == 1 && this.getEscenarios() < 20){
            this.setEscenarios(this.getEscenarios() + 1);
            System.out.println("Escenarios disponibles:" + this.getEscenarios());
        }
        else if (type == 2 && this.getAnimaciones() < 55){
            this.setAnimaciones(this.getAnimaciones() + 3);
            System.out.println("Animaciones disponibles:" + this.getAnimaciones());
        }
        else if (type == 3 && this.getDoblajes() < 35){
            this.setDoblajes(this.getDoblajes() + 3);
            System.out.println("Doblajes disponibles:" + this.getDoblajes());
        }
        else if (type == 4 && this.getPlotTwists() < 10){
            this.setPlotTwists(this.getPlotTwists() + 1);
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
