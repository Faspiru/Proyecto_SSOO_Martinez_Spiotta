/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Company;
import Clases.GraphManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Second;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author fabriziospiotta
 */
public class PruebaTabbed extends javax.swing.JFrame {
    
    static Company nickelodeon;
    static Company disney;

    /**
     * Creates new form PruebaTabbed
     */
    public PruebaTabbed(Company nickelodeon, Company disney, int[] initialQuantitiesN, int []initialQuantitiesD) {
        initComponents();
        
        this.nickelodeon = nickelodeon;
        this.disney = disney;
        
        // Labels para el driev de nickelodeon y disney
        JLabel[] qttySavedPartsLabelsNick = {qttyGuionesSavedNick, qttyEscenariosSavedNick, qttyAnimacionesSavedNick, qttyDoblajesSavedNick, qttyPlotTwistsSavedNick, qttyStandardCapsReadyNick, qttyPlotTwistsCapsReadyNick, gananciasLabel};
        nickelodeon.getDrive().setLabels(qttySavedPartsLabelsNick);
        
        JLabel[] qttySavedPartsLabelsDisney = {qttyGuionesSavedDisney, qttyEscenariosSavedDisney, qttyAnimacionesSavedDisney, qttyDoblajesSavedDisney, qttyPlotTwistsSavedDisney, qttyStandardCapsReadyDisney, qttyPlotTwistsCapsReadyDisney, gananciasLabelDisney};
        disney.getDrive().setLabels(qttySavedPartsLabelsDisney);
        
        // Labels para el status del pm y el se encarga de actualizar diariamente los costos y las utilidades
        JLabel[] pmLabelsN = {pmStatus, costosLabel, utilidadesLabel, deadlineLabel, daysPassedLabelN, daysPassedLabelN}; // Aca pasar tmb el del grafico?
        nickelodeon.getPm().setLabels(pmLabelsN);
        
        JLabel[] pmLabelsD = {pmStatusDisney, costosLabelDisney, utilidadesLabelDisney, deadlineLabelDisney, daysPassedLabelD, daysPassedLabelGrafico};
        disney.getPm().setLabels(pmLabelsD);
        
        // Labels para el status del director
        JLabel[] directorLabelsN = {directorStatus, deadlineLabel, faultsLabel, discountedLabel};
        nickelodeon.getDirector().setLabels(directorLabelsN);
        
        JLabel[] directorLabelsD = {directorStatusDisney, deadlineLabelDisney, faultsLabelDisney, discountedLabelDisney};
        disney.getDirector().setLabels(directorLabelsD);
        
        GraphManager grafico = new GraphManager(Grafico, nickelodeon, disney);
        disney.getPm().setGrafico(grafico);
        
        nickelodeon.startEmployees();
        disney.startEmployees();
        
        this.qttyGuionistasNick.setText(String.valueOf(initialQuantitiesN[0]));
        this.qttyEscenariosNick.setText(String.valueOf(initialQuantitiesN[1]));
        this.qttyAnimadoresNick.setText(String.valueOf(initialQuantitiesN[2]));
        this.qttyDobladoresNick.setText(String.valueOf(initialQuantitiesN[3]));
        this.qttyGuionistasPlotTwistsNick.setText(String.valueOf(initialQuantitiesN[4]));
        this.qttyEnsambladoresNick.setText(String.valueOf(initialQuantitiesN[5]));
        
        this.GuionistasNick.setText(String.valueOf(initialQuantitiesN[0]));
        this.EscenariosNick.setText(String.valueOf(initialQuantitiesN[1]));
        this.AnimadoresNick.setText(String.valueOf(initialQuantitiesN[2]));
        this.DobladoresNick.setText(String.valueOf(initialQuantitiesN[3]));
        this.GuionistasPlotTwistsNick.setText(String.valueOf(initialQuantitiesN[4]));
        this.EnsambladoresNick.setText(String.valueOf(initialQuantitiesN[5]));
        
        this.qttyGuionistasDisney.setText(String.valueOf(initialQuantitiesD[0]));
        this.qttyEscenariosDisney.setText(String.valueOf(initialQuantitiesD[1]));
        this.qttyAnimadoresDisney.setText(String.valueOf(initialQuantitiesD[2]));
        this.qttyDobladoresDisney.setText(String.valueOf(initialQuantitiesD[3]));
        this.qttyGuionistasPlotTwistsDisney.setText(String.valueOf(initialQuantitiesD[4]));
        this.qttyEnsambladoresDisney.setText(String.valueOf(initialQuantitiesD[5]));
        
        this.GuionistasDisney.setText(String.valueOf(initialQuantitiesD[0]));
        this.EscenariosDisney.setText(String.valueOf(initialQuantitiesD[1]));
        this.AnimadoresDisney.setText(String.valueOf(initialQuantitiesD[2]));
        this.DobladoresDisney.setText(String.valueOf(initialQuantitiesD[3]));
        this.GuionistasPlotTwistsDisney.setText(String.valueOf(initialQuantitiesD[4]));
        this.EnsambladoresDisney.setText(String.valueOf(initialQuantitiesD[5]));
        
        this.ammount.setText(Integer.toString(nickelodeon.getDeadline()));
        this.dia.setText(Integer.toString(nickelodeon.getDayDuration()));
        this.deadlineLabel.setText(Integer.toString(nickelodeon.getDeadline()));
        this.deadlineLabelDisney.setText(Integer.toString(disney.getDeadline()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        ConfigurationDashboard = new javax.swing.JPanel();
        plotTwistLabel1 = new javax.swing.JLabel();
        removePlotTwist1 = new javax.swing.JButton();
        addDoblaje1 = new javax.swing.JButton();
        addAnimador1 = new javax.swing.JButton();
        GuionistasPlotTwistsNick = new javax.swing.JLabel();
        removeAnimador1 = new javax.swing.JButton();
        animadorLabel1 = new javax.swing.JLabel();
        addPlotTwist1 = new javax.swing.JButton();
        AnimadoresNick = new javax.swing.JLabel();
        EnsambladoresNick = new javax.swing.JLabel();
        addEnsamblador1 = new javax.swing.JButton();
        removeDoblaje1 = new javax.swing.JButton();
        guionistasLabel1 = new javax.swing.JLabel();
        EscenariosNick = new javax.swing.JLabel();
        removeEscenarios1 = new javax.swing.JButton();
        removeGuionista2 = new javax.swing.JButton();
        addGuionista2 = new javax.swing.JButton();
        doblajeLabel1 = new javax.swing.JLabel();
        DobladoresNick = new javax.swing.JLabel();
        ensambladorLabel1 = new javax.swing.JLabel();
        addEscenarios1 = new javax.swing.JButton();
        removeEnsamblador1 = new javax.swing.JButton();
        GuionistasNick = new javax.swing.JLabel();
        escenariosLabel1 = new javax.swing.JLabel();
        guionistasLabel2 = new javax.swing.JLabel();
        removeGuionista3 = new javax.swing.JButton();
        escenariosLabel2 = new javax.swing.JLabel();
        animadorLabel2 = new javax.swing.JLabel();
        doblajeLabel2 = new javax.swing.JLabel();
        plotTwistLabel2 = new javax.swing.JLabel();
        ensambladorLabel2 = new javax.swing.JLabel();
        removeEnsamblador2 = new javax.swing.JButton();
        EnsambladoresDisney = new javax.swing.JLabel();
        addEnsamblador2 = new javax.swing.JButton();
        addPlotTwist2 = new javax.swing.JButton();
        GuionistasPlotTwistsDisney = new javax.swing.JLabel();
        removePlotTwist2 = new javax.swing.JButton();
        removeDoblaje2 = new javax.swing.JButton();
        removeAnimador2 = new javax.swing.JButton();
        removeEscenarios2 = new javax.swing.JButton();
        GuionistasDisney = new javax.swing.JLabel();
        EscenariosDisney = new javax.swing.JLabel();
        AnimadoresDisney = new javax.swing.JLabel();
        DobladoresDisney = new javax.swing.JLabel();
        addDoblaje2 = new javax.swing.JButton();
        addAnimador2 = new javax.swing.JButton();
        addEscenarios2 = new javax.swing.JButton();
        addGuionista3 = new javax.swing.JButton();
        dayDuration = new javax.swing.JLabel();
        removeDia = new javax.swing.JButton();
        dia = new javax.swing.JLabel();
        addDia = new javax.swing.JButton();
        deadline = new javax.swing.JLabel();
        removeAmmount = new javax.swing.JButton();
        ammount = new javax.swing.JLabel();
        addAmmount = new javax.swing.JButton();
        txt = new javax.swing.JButton();
        NickelodeonDash = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        guionistasLabel = new javax.swing.JLabel();
        escenariosLabel = new javax.swing.JLabel();
        animadorLabel = new javax.swing.JLabel();
        doblajeLabel = new javax.swing.JLabel();
        plotTwistLabel = new javax.swing.JLabel();
        ensambladorLabel = new javax.swing.JLabel();
        qttyGuionistasNick = new javax.swing.JLabel();
        qttyEscenariosNick = new javax.swing.JLabel();
        qttyAnimadoresNick = new javax.swing.JLabel();
        qttyDobladoresNick = new javax.swing.JLabel();
        qttyGuionistasPlotTwistsNick = new javax.swing.JLabel();
        qttyEnsambladoresNick = new javax.swing.JLabel();
        removeGuionista = new javax.swing.JButton();
        addGuionista = new javax.swing.JButton();
        removeEscenarios = new javax.swing.JButton();
        addEscenarios = new javax.swing.JButton();
        removeAnimador = new javax.swing.JButton();
        addAnimador = new javax.swing.JButton();
        removeDoblaje = new javax.swing.JButton();
        addDoblaje = new javax.swing.JButton();
        removePlotTwist = new javax.swing.JButton();
        addPlotTwist = new javax.swing.JButton();
        removeEnsamblador = new javax.swing.JButton();
        addEnsamblador = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        qttyProjectsManagersNick = new javax.swing.JLabel();
        qttyDirectoresNick = new javax.swing.JLabel();
        GuionesSavedLabel = new javax.swing.JLabel();
        qttyGuionesSavedNick = new javax.swing.JLabel();
        GuionesMaxLabel = new javax.swing.JLabel();
        qttyGuionesMaxNick = new javax.swing.JLabel();
        EscenariosSavedLabel = new javax.swing.JLabel();
        qttyEscenariosSavedNick = new javax.swing.JLabel();
        EscenariosMaxLabel = new javax.swing.JLabel();
        qttyEscenariosMaxNick = new javax.swing.JLabel();
        AnimacionesSavedLabel = new javax.swing.JLabel();
        qttyAnimacionesSavedNick = new javax.swing.JLabel();
        AnimacionesMaxLabel2 = new javax.swing.JLabel();
        qttyAnimacionesMaxNick = new javax.swing.JLabel();
        doblajesSavedLabel3 = new javax.swing.JLabel();
        qttyDoblajesSavedNick = new javax.swing.JLabel();
        doblajesMaxLabel3 = new javax.swing.JLabel();
        qttyDoblajesMaxNick = new javax.swing.JLabel();
        plotTwistsSavedLabel4 = new javax.swing.JLabel();
        qttyPlotTwistsSavedNick = new javax.swing.JLabel();
        plotTwistsMaxLabel4 = new javax.swing.JLabel();
        qttyPlotTwistsMaxNick = new javax.swing.JLabel();
        capsPlotTwistReadyLabel = new javax.swing.JLabel();
        capsReadyLabel = new javax.swing.JLabel();
        qttyStandardCapsReadyNick = new javax.swing.JLabel();
        qttyPlotTwistsCapsReadyNick = new javax.swing.JLabel();
        pmStatusLabel = new javax.swing.JLabel();
        directorStatusLabel = new javax.swing.JLabel();
        pmStatus = new javax.swing.JLabel();
        directorStatus = new javax.swing.JLabel();
        gananciaLabelText = new javax.swing.JLabel();
        costosLabelText = new javax.swing.JLabel();
        costosLabelText1 = new javax.swing.JLabel();
        gananciasLabel = new javax.swing.JLabel();
        costosLabel = new javax.swing.JLabel();
        utilidadesLabel = new javax.swing.JLabel();
        deadlineLabelText = new javax.swing.JLabel();
        deadlineLabel = new javax.swing.JLabel();
        faultsLabelText = new javax.swing.JLabel();
        faultsLabel = new javax.swing.JLabel();
        discountedLabelText = new javax.swing.JLabel();
        discountedLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        daysPassedLabelN = new javax.swing.JLabel();
        DisneyDash = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        qttyProjectsManagersNick1 = new javax.swing.JLabel();
        qttyPlotTwistsMaxNick1 = new javax.swing.JLabel();
        capsPlotTwistReadyLabel1 = new javax.swing.JLabel();
        capsReadyLabel1 = new javax.swing.JLabel();
        qttyStandardCapsReadyDisney = new javax.swing.JLabel();
        qttyPlotTwistsCapsReadyDisney = new javax.swing.JLabel();
        pmStatusLabelD = new javax.swing.JLabel();
        directorStatusLabelD = new javax.swing.JLabel();
        qttyDirectoresNick1 = new javax.swing.JLabel();
        pmStatusDisney = new javax.swing.JLabel();
        GuionesSavedLabelD = new javax.swing.JLabel();
        directorStatusDisney = new javax.swing.JLabel();
        qttyGuionesSavedDisney = new javax.swing.JLabel();
        gananciaLabelText1 = new javax.swing.JLabel();
        GuionesMaxLabelD = new javax.swing.JLabel();
        qttyGuionesMaxNick1 = new javax.swing.JLabel();
        EscenariosSavedLabelD = new javax.swing.JLabel();
        qttyEscenariosSavedDisney = new javax.swing.JLabel();
        EscenariosMaxLabelD = new javax.swing.JLabel();
        qttyEscenariosMaxNick1 = new javax.swing.JLabel();
        AnimacionesSavedLabelD = new javax.swing.JLabel();
        costosLabelText2 = new javax.swing.JLabel();
        costosLabelText3 = new javax.swing.JLabel();
        gananciasLabelDisney = new javax.swing.JLabel();
        costosLabelDisney = new javax.swing.JLabel();
        utilidadesLabelDisney = new javax.swing.JLabel();
        deadlineLabelText1 = new javax.swing.JLabel();
        deadlineLabelDisney = new javax.swing.JLabel();
        faultsLabelText1 = new javax.swing.JLabel();
        faultsLabelDisney = new javax.swing.JLabel();
        discountedLabelText1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        guionistasLabelDisney = new javax.swing.JLabel();
        escenariosLabelDisney = new javax.swing.JLabel();
        animadorLabelDisney = new javax.swing.JLabel();
        doblajeLabelDisney = new javax.swing.JLabel();
        plotTwistLabelDisney = new javax.swing.JLabel();
        ensambladorLabelDisney = new javax.swing.JLabel();
        qttyGuionistasDisney = new javax.swing.JLabel();
        discountedLabelDisney = new javax.swing.JLabel();
        qttyEscenariosDisney = new javax.swing.JLabel();
        qttyAnimadoresDisney = new javax.swing.JLabel();
        qttyDobladoresDisney = new javax.swing.JLabel();
        qttyGuionistasPlotTwistsDisney = new javax.swing.JLabel();
        qttyEnsambladoresDisney = new javax.swing.JLabel();
        removeGuionistaDisney = new javax.swing.JButton();
        addGuionistaDisney = new javax.swing.JButton();
        removeEscenariosDisney = new javax.swing.JButton();
        addEscenariosDisney = new javax.swing.JButton();
        removeAnimadorDisney = new javax.swing.JButton();
        qttyAnimacionesSavedDisney = new javax.swing.JLabel();
        AnimacionesMaxLabelD = new javax.swing.JLabel();
        qttyAnimacionesMaxNick1 = new javax.swing.JLabel();
        doblajesSavedLabelD = new javax.swing.JLabel();
        qttyDoblajesSavedDisney = new javax.swing.JLabel();
        doblajesMaxLabelD = new javax.swing.JLabel();
        qttyDoblajesMaxNick1 = new javax.swing.JLabel();
        addAnimadorDisney = new javax.swing.JButton();
        plotTwistsSavedLabelD = new javax.swing.JLabel();
        removeDoblajeDisney = new javax.swing.JButton();
        qttyPlotTwistsSavedDisney = new javax.swing.JLabel();
        addDoblajeDisney = new javax.swing.JButton();
        plotTwistsMaxLabelD = new javax.swing.JLabel();
        removePlotTwistDisney = new javax.swing.JButton();
        addPlotTwistDisney = new javax.swing.JButton();
        removeEnsambladorDisney = new javax.swing.JButton();
        addEnsambladorDisney = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        daysPassedLabelD = new javax.swing.JLabel();
        NickVSDisney = new javax.swing.JPanel();
        Grafico = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        daysPassedLabelGrafico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        plotTwistLabel1.setText("Guionista de PlotTwist:");

        removePlotTwist1.setText("-");
        removePlotTwist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwist1ActionPerformed(evt);
            }
        });

        addDoblaje1.setText("+");
        addDoblaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblaje1ActionPerformed(evt);
            }
        });

        addAnimador1.setText("+");
        addAnimador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimador1ActionPerformed(evt);
            }
        });

        GuionistasPlotTwistsNick.setText("0");

        removeAnimador1.setText("-");
        removeAnimador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimador1ActionPerformed(evt);
            }
        });

        animadorLabel1.setText("Animador de personajes:");

        addPlotTwist1.setText("+");
        addPlotTwist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwist1ActionPerformed(evt);
            }
        });

        AnimadoresNick.setText("0");

        EnsambladoresNick.setText("0");

        addEnsamblador1.setText("+");
        addEnsamblador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsamblador1ActionPerformed(evt);
            }
        });

        removeDoblaje1.setText("-");
        removeDoblaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblaje1ActionPerformed(evt);
            }
        });

        guionistasLabel1.setText("Guionistas:");

        EscenariosNick.setText("0");

        removeEscenarios1.setText("-");
        removeEscenarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenarios1ActionPerformed(evt);
            }
        });

        removeGuionista2.setText("-");
        removeGuionista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionista2ActionPerformed(evt);
            }
        });

        addGuionista2.setText("+");
        addGuionista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionista2ActionPerformed(evt);
            }
        });

        doblajeLabel1.setText("Actores de doblaje:");

        DobladoresNick.setText("0");

        ensambladorLabel1.setText("Ensambladores:");

        addEscenarios1.setText("+");
        addEscenarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenarios1ActionPerformed(evt);
            }
        });

        removeEnsamblador1.setText("-");
        removeEnsamblador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsamblador1ActionPerformed(evt);
            }
        });

        GuionistasNick.setText("0");

        escenariosLabel1.setText("Diseñador de escenarios:");

        guionistasLabel2.setText("Guionistas:");

        removeGuionista3.setText("-");
        removeGuionista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionista3ActionPerformed(evt);
            }
        });

        escenariosLabel2.setText("Diseñador de escenarios:");

        animadorLabel2.setText("Animador de personajes:");

        doblajeLabel2.setText("Actores de doblaje:");

        plotTwistLabel2.setText("Guionista de PlotTwist:");

        ensambladorLabel2.setText("Ensambladores:");

        removeEnsamblador2.setText("-");
        removeEnsamblador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsamblador2ActionPerformed(evt);
            }
        });

        EnsambladoresDisney.setText("0");

        addEnsamblador2.setText("+");
        addEnsamblador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsamblador2ActionPerformed(evt);
            }
        });

        addPlotTwist2.setText("+");
        addPlotTwist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwist2ActionPerformed(evt);
            }
        });

        GuionistasPlotTwistsDisney.setText("0");

        removePlotTwist2.setText("-");
        removePlotTwist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwist2ActionPerformed(evt);
            }
        });

        removeDoblaje2.setText("-");
        removeDoblaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblaje2ActionPerformed(evt);
            }
        });

        removeAnimador2.setText("-");
        removeAnimador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimador2ActionPerformed(evt);
            }
        });

        removeEscenarios2.setText("-");
        removeEscenarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenarios2ActionPerformed(evt);
            }
        });

        GuionistasDisney.setText("0");

        EscenariosDisney.setText("0");

        AnimadoresDisney.setText("0");

        DobladoresDisney.setText("0");

        addDoblaje2.setText("+");
        addDoblaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblaje2ActionPerformed(evt);
            }
        });

        addAnimador2.setText("+");
        addAnimador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimador2ActionPerformed(evt);
            }
        });

        addEscenarios2.setText("+");
        addEscenarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenarios2ActionPerformed(evt);
            }
        });

        addGuionista3.setText("+");
        addGuionista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionista3ActionPerformed(evt);
            }
        });

        dayDuration.setText("Duracion de un dia");

        removeDia.setText("-");
        removeDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDiaActionPerformed(evt);
            }
        });

        dia.setText("0");

        addDia.setText("+");
        addDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiaActionPerformed(evt);
            }
        });

        deadline.setText("Deadline");

        removeAmmount.setText("-");
        removeAmmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAmmountActionPerformed(evt);
            }
        });

        ammount.setText("0");

        addAmmount.setText("+");
        addAmmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAmmountActionPerformed(evt);
            }
        });

        txt.setText("Guardar");
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfigurationDashboardLayout = new javax.swing.GroupLayout(ConfigurationDashboard);
        ConfigurationDashboard.setLayout(ConfigurationDashboardLayout);
        ConfigurationDashboardLayout.setHorizontalGroup(
            ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(guionistasLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(removeGuionista2)
                        .addGap(12, 12, 12)
                        .addComponent(GuionistasNick)
                        .addGap(12, 12, 12)
                        .addComponent(addGuionista2)
                        .addGap(252, 252, 252)
                        .addComponent(guionistasLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(removeGuionista3)
                        .addGap(12, 12, 12)
                        .addComponent(GuionistasDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addGuionista3))
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(escenariosLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(removeEscenarios1)
                        .addGap(12, 12, 12)
                        .addComponent(EscenariosNick)
                        .addGap(12, 12, 12)
                        .addComponent(addEscenarios1)
                        .addGap(206, 206, 206)
                        .addComponent(escenariosLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(removeEscenarios2)
                        .addGap(12, 12, 12)
                        .addComponent(EscenariosDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addEscenarios2))
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(animadorLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(removeAnimador1)
                        .addGap(12, 12, 12)
                        .addComponent(AnimadoresNick)
                        .addGap(12, 12, 12)
                        .addComponent(addAnimador1)
                        .addGap(209, 209, 209)
                        .addComponent(animadorLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(removeAnimador2)
                        .addGap(12, 12, 12)
                        .addComponent(AnimadoresDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addAnimador2))
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(doblajeLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(removeDoblaje1)
                        .addGap(12, 12, 12)
                        .addComponent(DobladoresNick)
                        .addGap(12, 12, 12)
                        .addComponent(addDoblaje1)
                        .addGap(230, 230, 230)
                        .addComponent(doblajeLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(removeDoblaje2)
                        .addGap(12, 12, 12)
                        .addComponent(DobladoresDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addDoblaje2))
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(plotTwistLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(removePlotTwist1)
                        .addGap(12, 12, 12)
                        .addComponent(GuionistasPlotTwistsNick)
                        .addGap(12, 12, 12)
                        .addComponent(addPlotTwist1)
                        .addGap(220, 220, 220)
                        .addComponent(plotTwistLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(removePlotTwist2)
                        .addGap(12, 12, 12)
                        .addComponent(GuionistasPlotTwistsDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addPlotTwist2))
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(ensambladorLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(removeEnsamblador1)
                        .addGap(12, 12, 12)
                        .addComponent(EnsambladoresNick)
                        .addGap(12, 12, 12)
                        .addComponent(addEnsamblador1)
                        .addGap(238, 238, 238)
                        .addComponent(ensambladorLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(removeEnsamblador2)
                        .addGap(12, 12, 12)
                        .addComponent(EnsambladoresDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addEnsamblador2))
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(dayDuration)
                        .addGap(18, 18, 18)
                        .addComponent(removeDia)
                        .addGap(11, 11, 11)
                        .addComponent(dia)
                        .addGap(12, 12, 12)
                        .addComponent(addDia)
                        .addGap(69, 69, 69)
                        .addComponent(txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deadline)
                        .addGap(18, 18, 18)
                        .addComponent(removeAmmount)
                        .addGap(11, 11, 11)
                        .addComponent(ammount)
                        .addGap(12, 12, 12)
                        .addComponent(addAmmount)))
                .addGap(169, 169, 169))
        );
        ConfigurationDashboardLayout.setVerticalGroup(
            ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeGuionista2)
                    .addComponent(addGuionista2)
                    .addComponent(removeGuionista3)
                    .addComponent(addGuionista3)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guionistasLabel1)
                            .addComponent(GuionistasNick)
                            .addComponent(guionistasLabel2)
                            .addComponent(GuionistasDisney))))
                .addGap(25, 25, 25)
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeEscenarios1)
                    .addComponent(addEscenarios1)
                    .addComponent(removeEscenarios2)
                    .addComponent(addEscenarios2)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escenariosLabel1)
                            .addComponent(EscenariosNick)
                            .addComponent(escenariosLabel2)
                            .addComponent(EscenariosDisney))))
                .addGap(36, 36, 36)
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeAnimador1)
                    .addComponent(addAnimador1)
                    .addComponent(removeAnimador2)
                    .addComponent(addAnimador2)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animadorLabel1)
                            .addComponent(AnimadoresNick)
                            .addComponent(animadorLabel2)
                            .addComponent(AnimadoresDisney))))
                .addGap(37, 37, 37)
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeDoblaje1)
                    .addComponent(addDoblaje1)
                    .addComponent(removeDoblaje2)
                    .addComponent(addDoblaje2)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doblajeLabel1)
                            .addComponent(DobladoresNick)
                            .addComponent(doblajeLabel2)
                            .addComponent(DobladoresDisney))))
                .addGap(34, 34, 34)
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removePlotTwist1)
                    .addComponent(addPlotTwist1)
                    .addComponent(removePlotTwist2)
                    .addComponent(addPlotTwist2)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plotTwistLabel1)
                            .addComponent(GuionistasPlotTwistsNick)
                            .addComponent(plotTwistLabel2)
                            .addComponent(GuionistasPlotTwistsDisney))))
                .addGap(30, 30, 30)
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeEnsamblador1)
                    .addComponent(addEnsamblador1)
                    .addComponent(removeEnsamblador2)
                    .addComponent(addEnsamblador2)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ensambladorLabel1)
                            .addComponent(EnsambladoresNick)
                            .addComponent(ensambladorLabel2)
                            .addComponent(EnsambladoresDisney))))
                .addGap(58, 58, 58)
                .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeDia)
                    .addComponent(addDia)
                    .addComponent(txt)
                    .addComponent(removeAmmount)
                    .addComponent(addAmmount)
                    .addGroup(ConfigurationDashboardLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(ConfigurationDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dayDuration)
                            .addComponent(dia)
                            .addComponent(deadline)
                            .addComponent(ammount))))
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab("ConfigurationDashboard", ConfigurationDashboard);

        jLabel2.setText("NICKELODEON");

        guionistasLabel.setText("Guionistas:");

        escenariosLabel.setText("Diseñador de escenarios:");

        animadorLabel.setText("Animador de personajes:");

        doblajeLabel.setText("Actores de doblaje:");

        plotTwistLabel.setText("Guionista de PlotTwist:");

        ensambladorLabel.setText("Ensambladores:");

        qttyGuionistasNick.setText("0");

        qttyEscenariosNick.setText("0");

        qttyAnimadoresNick.setText("0");

        qttyDobladoresNick.setText("0");

        qttyGuionistasPlotTwistsNick.setText("0");

        qttyEnsambladoresNick.setText("0");

        removeGuionista.setText("-");
        removeGuionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionistaActionPerformed(evt);
            }
        });

        addGuionista.setText("+");
        addGuionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionistaActionPerformed(evt);
            }
        });

        removeEscenarios.setText("-");
        removeEscenarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenariosActionPerformed(evt);
            }
        });

        addEscenarios.setText("+");
        addEscenarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenariosActionPerformed(evt);
            }
        });

        removeAnimador.setText("-");
        removeAnimador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimadorActionPerformed(evt);
            }
        });

        addAnimador.setText("+");
        addAnimador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimadorActionPerformed(evt);
            }
        });

        removeDoblaje.setText("-");
        removeDoblaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblajeActionPerformed(evt);
            }
        });

        addDoblaje.setText("+");
        addDoblaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblajeActionPerformed(evt);
            }
        });

        removePlotTwist.setText("-");
        removePlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwistActionPerformed(evt);
            }
        });

        addPlotTwist.setText("+");
        addPlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwistActionPerformed(evt);
            }
        });

        removeEnsamblador.setText("-");
        removeEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsambladorActionPerformed(evt);
            }
        });

        addEnsamblador.setText("+");
        addEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsambladorActionPerformed(evt);
            }
        });

        jLabel3.setText("Projects Managers:");

        jLabel4.setText("Directores Ejecutivos:");

        qttyProjectsManagersNick.setText("1");

        qttyDirectoresNick.setText("1");

        GuionesSavedLabel.setText("Guiones en el Drive:");

        qttyGuionesSavedNick.setText("0");

        GuionesMaxLabel.setText("Capacidad Máx:");

        qttyGuionesMaxNick.setText("25");

        EscenariosSavedLabel.setText("Escenarios en el Drive:");

        qttyEscenariosSavedNick.setText("0");

        EscenariosMaxLabel.setText("Capacidad Máx:");

        qttyEscenariosMaxNick.setText("20");

        AnimacionesSavedLabel.setText("Animaciones en el Drive:");

        qttyAnimacionesSavedNick.setText("0");

        AnimacionesMaxLabel2.setText("Capacidad Máx:");

        qttyAnimacionesMaxNick.setText("55");

        doblajesSavedLabel3.setText("Doblajes en el Drive:");

        qttyDoblajesSavedNick.setText("0");

        doblajesMaxLabel3.setText("Capacidad Máx:");

        qttyDoblajesMaxNick.setText("35");

        plotTwistsSavedLabel4.setText("PlotTwists en el Drive:");

        qttyPlotTwistsSavedNick.setText("0");

        plotTwistsMaxLabel4.setText("Capacidad Máx:");

        qttyPlotTwistsMaxNick.setText("10");

        capsPlotTwistReadyLabel.setText("Capitulos PlotTwists Listos:");

        capsReadyLabel.setText("Capitulos Standar Listos:");

        qttyStandardCapsReadyNick.setText("0");

        qttyPlotTwistsCapsReadyNick.setText("0");

        pmStatusLabel.setText("Project Manager Status:");

        directorStatusLabel.setText("Director Status:");

        pmStatus.setText("...");

        directorStatus.setText("...");

        gananciaLabelText.setText("Ganancias Totales:");

        costosLabelText.setText("Costos Totales:");

        costosLabelText1.setText("Utilidad Total:");

        gananciasLabel.setText("0");

        costosLabel.setText("0");

        utilidadesLabel.setText("0");

        deadlineLabelText.setText("Deadline:");

        deadlineLabel.setText("0");

        faultsLabelText.setText("Faltas del Project Manager:");

        faultsLabel.setText("0");

        discountedLabelText.setText("Dinero Descontado al Project Manager:");

        discountedLabel.setText("0");

        jLabel1.setText("Dias totales transcurridos:");

        daysPassedLabelN.setText("0");

        javax.swing.GroupLayout NickelodeonDashLayout = new javax.swing.GroupLayout(NickelodeonDash);
        NickelodeonDash.setLayout(NickelodeonDashLayout);
        NickelodeonDashLayout.setHorizontalGroup(
            NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(jLabel2))
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(doblajeLabel)
                        .addGap(29, 29, 29)
                        .addComponent(removeDoblaje)
                        .addGap(12, 12, 12)
                        .addComponent(qttyDobladoresNick)
                        .addGap(12, 12, 12)
                        .addComponent(addDoblaje)
                        .addGap(31, 31, 31)
                        .addComponent(doblajesSavedLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(qttyDoblajesSavedNick)
                        .addGap(30, 30, 30)
                        .addComponent(doblajesMaxLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(qttyDoblajesMaxNick))
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(ensambladorLabel)
                        .addGap(40, 40, 40)
                        .addComponent(removeEnsamblador)
                        .addGap(12, 12, 12)
                        .addComponent(qttyEnsambladoresNick)
                        .addGap(12, 12, 12)
                        .addComponent(addEnsamblador))
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(plotTwistLabel)
                                .addGap(18, 18, 18)
                                .addComponent(removePlotTwist)
                                .addGap(12, 12, 12)
                                .addComponent(qttyGuionistasPlotTwistsNick)
                                .addGap(12, 12, 12)
                                .addComponent(addPlotTwist)
                                .addGap(31, 31, 31)
                                .addComponent(plotTwistsSavedLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(qttyPlotTwistsSavedNick)
                                .addGap(30, 30, 30)
                                .addComponent(plotTwistsMaxLabel4))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(305, 305, 305)
                                .addComponent(capsReadyLabel)
                                .addGap(12, 12, 12)
                                .addComponent(qttyStandardCapsReadyNick))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3)
                                .addGap(60, 60, 60)
                                .addComponent(qttyProjectsManagersNick)
                                .addGap(66, 66, 66)
                                .addComponent(pmStatusLabel)
                                .addGap(18, 18, 18)
                                .addComponent(pmStatus))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4)
                                .addGap(60, 60, 60)
                                .addComponent(qttyDirectoresNick)
                                .addGap(92, 92, 92)
                                .addComponent(directorStatusLabel)
                                .addGap(41, 41, 41)
                                .addComponent(directorStatus))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(305, 305, 305)
                                .addComponent(capsPlotTwistReadyLabel)
                                .addGap(12, 12, 12)
                                .addComponent(qttyPlotTwistsCapsReadyNick)))
                        .addGap(6, 6, 6)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addComponent(faultsLabelText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(faultsLabel))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addComponent(discountedLabelText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(discountedLabel))
                            .addComponent(qttyPlotTwistsMaxNick)))
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(guionistasLabel)
                                .addGap(55, 55, 55)
                                .addComponent(removeGuionista)
                                .addGap(12, 12, 12)
                                .addComponent(qttyGuionistasNick)
                                .addGap(12, 12, 12)
                                .addComponent(addGuionista)
                                .addGap(31, 31, 31)
                                .addComponent(GuionesSavedLabel)
                                .addGap(6, 6, 6)
                                .addComponent(qttyGuionesSavedNick)
                                .addGap(30, 30, 30)
                                .addComponent(GuionesMaxLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(qttyGuionesMaxNick))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(escenariosLabel)
                                .addGap(18, 18, 18)
                                .addComponent(removeEscenarios)
                                .addGap(12, 12, 12)
                                .addComponent(qttyEscenariosNick)
                                .addGap(12, 12, 12)
                                .addComponent(addEscenarios)
                                .addGap(31, 31, 31)
                                .addComponent(EscenariosSavedLabel)
                                .addGap(6, 6, 6)
                                .addComponent(qttyEscenariosSavedNick)
                                .addGap(30, 30, 30)
                                .addComponent(EscenariosMaxLabel)
                                .addGap(6, 6, 6)
                                .addComponent(qttyEscenariosMaxNick))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(animadorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(removeAnimador)
                                .addGap(12, 12, 12)
                                .addComponent(qttyAnimadoresNick)
                                .addGap(12, 12, 12)
                                .addComponent(addAnimador)
                                .addGap(31, 31, 31)
                                .addComponent(AnimacionesSavedLabel)
                                .addGap(6, 6, 6)
                                .addComponent(qttyAnimacionesSavedNick)
                                .addGap(30, 30, 30)
                                .addComponent(AnimacionesMaxLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(qttyAnimacionesMaxNick)))
                        .addGap(70, 70, 70)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addComponent(deadlineLabelText)
                                .addGap(21, 21, 21)
                                .addComponent(deadlineLabel))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addComponent(gananciaLabelText)
                                .addGap(18, 18, 18)
                                .addComponent(gananciasLabel))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addComponent(costosLabelText1)
                                .addGap(18, 18, 18)
                                .addComponent(utilidadesLabel))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addComponent(costosLabelText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(costosLabel))
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(daysPassedLabelN)))))
                .addGap(130, 130, 130))
        );
        NickelodeonDashLayout.setVerticalGroup(
            NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeGuionista)
                            .addComponent(addGuionista)
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guionistasLabel)
                                    .addComponent(qttyGuionistasNick)
                                    .addComponent(GuionesSavedLabel)
                                    .addComponent(qttyGuionesSavedNick)
                                    .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(GuionesMaxLabel)
                                        .addComponent(qttyGuionesMaxNick)))))
                        .addGap(27, 27, 27)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeEscenarios)
                            .addComponent(addEscenarios)
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(escenariosLabel)
                                    .addComponent(qttyEscenariosNick)
                                    .addComponent(EscenariosSavedLabel)
                                    .addComponent(qttyEscenariosSavedNick)
                                    .addComponent(EscenariosMaxLabel)
                                    .addComponent(qttyEscenariosMaxNick)))))
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gananciaLabelText)
                            .addComponent(gananciasLabel))
                        .addGap(9, 9, 9)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(costosLabelText)
                            .addComponent(costosLabel))
                        .addGap(4, 4, 4)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(costosLabelText1)
                            .addComponent(utilidadesLabel))
                        .addGap(36, 36, 36)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deadlineLabelText)
                            .addComponent(deadlineLabel))))
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeAnimador)
                            .addComponent(addAnimador)
                            .addGroup(NickelodeonDashLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(animadorLabel)
                                    .addComponent(qttyAnimadoresNick)
                                    .addComponent(AnimacionesSavedLabel)
                                    .addComponent(qttyAnimacionesSavedNick)
                                    .addComponent(AnimacionesMaxLabel2)
                                    .addComponent(qttyAnimacionesMaxNick)))))
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(daysPassedLabelN))))
                .addGap(45, 45, 45)
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeDoblaje)
                    .addComponent(addDoblaje)
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doblajeLabel)
                            .addComponent(qttyDobladoresNick)
                            .addComponent(doblajesSavedLabel3)
                            .addComponent(qttyDoblajesSavedNick)
                            .addComponent(doblajesMaxLabel3)
                            .addComponent(qttyDoblajesMaxNick))))
                .addGap(34, 34, 34)
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removePlotTwist)
                    .addComponent(addPlotTwist)
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plotTwistLabel)
                            .addComponent(qttyGuionistasPlotTwistsNick)
                            .addComponent(plotTwistsSavedLabel4)
                            .addComponent(qttyPlotTwistsSavedNick)
                            .addComponent(plotTwistsMaxLabel4)
                            .addComponent(qttyPlotTwistsMaxNick))))
                .addGap(30, 30, 30)
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeEnsamblador)
                    .addComponent(addEnsamblador)
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ensambladorLabel)
                            .addComponent(qttyEnsambladoresNick))))
                .addGap(38, 38, 38)
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(capsReadyLabel)
                    .addComponent(qttyStandardCapsReadyNick))
                .addGap(18, 18, 18)
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(capsPlotTwistReadyLabel)
                    .addComponent(qttyPlotTwistsCapsReadyNick))
                .addGap(24, 24, 24)
                .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(qttyProjectsManagersNick)
                            .addComponent(pmStatusLabel)
                            .addComponent(pmStatus))
                        .addGap(18, 18, 18)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(qttyDirectoresNick)
                            .addComponent(directorStatusLabel)
                            .addComponent(directorStatus)))
                    .addGroup(NickelodeonDashLayout.createSequentialGroup()
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faultsLabel)
                            .addComponent(faultsLabelText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(NickelodeonDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discountedLabelText)
                            .addComponent(discountedLabel))))
                .addGap(69, 69, 69))
        );

        jTabbedPane1.addTab("Nickelodeon", NickelodeonDash);

        jLabel5.setText("Directores Ejecutivos:");

        qttyProjectsManagersNick1.setText("1");

        qttyPlotTwistsMaxNick1.setText("10");

        capsPlotTwistReadyLabel1.setText("Capitulos PlotTwists Listos:");

        capsReadyLabel1.setText("Capitulos Standar Listos:");

        qttyStandardCapsReadyDisney.setText("0");

        qttyPlotTwistsCapsReadyDisney.setText("0");

        pmStatusLabelD.setText("Project Manager Status:");

        directorStatusLabelD.setText("Director Status:");

        qttyDirectoresNick1.setText("1");

        pmStatusDisney.setText("...");

        GuionesSavedLabelD.setText("Guiones en el Drive:");

        directorStatusDisney.setText("...");

        qttyGuionesSavedDisney.setText("0");

        gananciaLabelText1.setText("Ganancias Totales:");

        GuionesMaxLabelD.setText("Capacidad Máx:");

        qttyGuionesMaxNick1.setText("25");

        EscenariosSavedLabelD.setText("Escenarios en el Drive:");

        qttyEscenariosSavedDisney.setText("0");

        EscenariosMaxLabelD.setText("Capacidad Máx:");

        qttyEscenariosMaxNick1.setText("20");

        AnimacionesSavedLabelD.setText("Animaciones en el Drive:");

        costosLabelText2.setText("Costos Totales:");

        costosLabelText3.setText("Utilidad Total:");

        gananciasLabelDisney.setText("0");

        costosLabelDisney.setText("0");

        utilidadesLabelDisney.setText("0");

        deadlineLabelText1.setText("Deadline:");

        deadlineLabelDisney.setText("0");

        faultsLabelText1.setText("Faltas del Project Manager:");

        faultsLabelDisney.setText("0");

        discountedLabelText1.setText("Dinero Descontado al Project Manager:");

        jLabel6.setText("DISNEY");

        guionistasLabelDisney.setText("Guionistas:");

        escenariosLabelDisney.setText("Diseñador de escenarios:");

        animadorLabelDisney.setText("Animador de personajes:");

        doblajeLabelDisney.setText("Actores de doblaje:");

        plotTwistLabelDisney.setText("Guionista de PlotTwist:");

        ensambladorLabelDisney.setText("Ensambladores:");

        qttyGuionistasDisney.setText("0");

        discountedLabelDisney.setText("0");

        qttyEscenariosDisney.setText("0");

        qttyAnimadoresDisney.setText("0");

        qttyDobladoresDisney.setText("0");

        qttyGuionistasPlotTwistsDisney.setText("0");

        qttyEnsambladoresDisney.setText("0");

        removeGuionistaDisney.setText("-");
        removeGuionistaDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionistaDisneyActionPerformed(evt);
            }
        });

        addGuionistaDisney.setText("+");
        addGuionistaDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionistaDisneyActionPerformed(evt);
            }
        });

        removeEscenariosDisney.setText("-");
        removeEscenariosDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenariosDisneyActionPerformed(evt);
            }
        });

        addEscenariosDisney.setText("+");
        addEscenariosDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenariosDisneyActionPerformed(evt);
            }
        });

        removeAnimadorDisney.setText("-");
        removeAnimadorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimadorDisneyActionPerformed(evt);
            }
        });

        qttyAnimacionesSavedDisney.setText("0");

        AnimacionesMaxLabelD.setText("Capacidad Máx:");

        qttyAnimacionesMaxNick1.setText("55");

        doblajesSavedLabelD.setText("Doblajes en el Drive:");

        qttyDoblajesSavedDisney.setText("0");

        doblajesMaxLabelD.setText("Capacidad Máx:");

        qttyDoblajesMaxNick1.setText("35");

        addAnimadorDisney.setText("+");
        addAnimadorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimadorDisneyActionPerformed(evt);
            }
        });

        plotTwistsSavedLabelD.setText("PlotTwists en el Drive:");

        removeDoblajeDisney.setText("-");
        removeDoblajeDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblajeDisneyActionPerformed(evt);
            }
        });

        qttyPlotTwistsSavedDisney.setText("0");

        addDoblajeDisney.setText("+");
        addDoblajeDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblajeDisneyActionPerformed(evt);
            }
        });

        plotTwistsMaxLabelD.setText("Capacidad Máx:");

        removePlotTwistDisney.setText("-");
        removePlotTwistDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwistDisneyActionPerformed(evt);
            }
        });

        addPlotTwistDisney.setText("+");
        addPlotTwistDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwistDisneyActionPerformed(evt);
            }
        });

        removeEnsambladorDisney.setText("-");
        removeEnsambladorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsambladorDisneyActionPerformed(evt);
            }
        });

        addEnsambladorDisney.setText("+");
        addEnsambladorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsambladorDisneyActionPerformed(evt);
            }
        });

        jLabel7.setText("Projects Managers:");

        jLabel8.setText("Dias totales transcurridos:");

        daysPassedLabelD.setText("0");

        javax.swing.GroupLayout DisneyDashLayout = new javax.swing.GroupLayout(DisneyDash);
        DisneyDash.setLayout(DisneyDashLayout);
        DisneyDashLayout.setHorizontalGroup(
            DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisneyDashLayout.createSequentialGroup()
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(jLabel6))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(ensambladorLabelDisney)
                        .addGap(40, 40, 40)
                        .addComponent(removeEnsambladorDisney)
                        .addGap(12, 12, 12)
                        .addComponent(qttyEnsambladoresDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addEnsambladorDisney))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(plotTwistLabelDisney)
                        .addGap(18, 18, 18)
                        .addComponent(removePlotTwistDisney)
                        .addGap(12, 12, 12)
                        .addComponent(qttyGuionistasPlotTwistsDisney)
                        .addGap(12, 12, 12)
                        .addComponent(addPlotTwistDisney)
                        .addGap(31, 31, 31)
                        .addComponent(plotTwistsSavedLabelD)
                        .addGap(6, 6, 6)
                        .addComponent(qttyPlotTwistsSavedDisney))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(capsReadyLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(qttyStandardCapsReadyDisney))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7)
                        .addGap(60, 60, 60)
                        .addComponent(qttyProjectsManagersNick1)
                        .addGap(66, 66, 66)
                        .addComponent(pmStatusLabelD)
                        .addGap(18, 18, 18)
                        .addComponent(pmStatusDisney))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addGap(60, 60, 60)
                        .addComponent(qttyDirectoresNick1)
                        .addGap(92, 92, 92)
                        .addComponent(directorStatusLabelD)
                        .addGap(41, 41, 41)
                        .addComponent(directorStatusDisney))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(capsPlotTwistReadyLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(qttyPlotTwistsCapsReadyDisney))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DisneyDashLayout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(guionistasLabelDisney)
                                        .addGap(55, 55, 55)
                                        .addComponent(removeGuionistaDisney)
                                        .addGap(12, 12, 12)
                                        .addComponent(qttyGuionistasDisney)
                                        .addGap(12, 12, 12)
                                        .addComponent(addGuionistaDisney)
                                        .addGap(31, 31, 31)
                                        .addComponent(GuionesSavedLabelD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(qttyGuionesSavedDisney))
                                    .addGroup(DisneyDashLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(escenariosLabelDisney)
                                        .addGap(18, 18, 18)
                                        .addComponent(removeEscenariosDisney)
                                        .addGap(12, 12, 12)
                                        .addComponent(qttyEscenariosDisney)
                                        .addGap(12, 12, 12)
                                        .addComponent(addEscenariosDisney)
                                        .addGap(31, 31, 31)
                                        .addComponent(EscenariosSavedLabelD)
                                        .addGap(6, 6, 6)
                                        .addComponent(qttyEscenariosSavedDisney)))
                                .addGap(0, 0, 0)
                                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DisneyDashLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(EscenariosMaxLabelD)
                                        .addGap(6, 6, 6)
                                        .addComponent(qttyEscenariosMaxNick1))
                                    .addGroup(DisneyDashLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(GuionesMaxLabelD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(qttyGuionesMaxNick1))))
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(DisneyDashLayout.createSequentialGroup()
                                        .addComponent(animadorLabelDisney)
                                        .addGap(18, 18, 18)
                                        .addComponent(removeAnimadorDisney)
                                        .addGap(12, 12, 12)
                                        .addComponent(qttyAnimadoresDisney)
                                        .addGap(12, 12, 12)
                                        .addComponent(addAnimadorDisney)
                                        .addGap(31, 31, 31)
                                        .addComponent(AnimacionesSavedLabelD)
                                        .addGap(6, 6, 6)
                                        .addComponent(qttyAnimacionesSavedDisney)
                                        .addGap(30, 30, 30)
                                        .addComponent(AnimacionesMaxLabelD)
                                        .addGap(6, 6, 6)
                                        .addComponent(qttyAnimacionesMaxNick1))
                                    .addGroup(DisneyDashLayout.createSequentialGroup()
                                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(plotTwistsMaxLabelD)
                                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                                .addComponent(doblajeLabelDisney)
                                                .addGap(29, 29, 29)
                                                .addComponent(removeDoblajeDisney)
                                                .addGap(12, 12, 12)
                                                .addComponent(qttyDobladoresDisney)
                                                .addGap(12, 12, 12)
                                                .addComponent(addDoblajeDisney)
                                                .addGap(31, 31, 31)
                                                .addComponent(doblajesSavedLabelD)
                                                .addGap(6, 6, 6)
                                                .addComponent(qttyDoblajesSavedDisney)
                                                .addGap(53, 53, 53)
                                                .addComponent(doblajesMaxLabelD)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(qttyDoblajesMaxNick1)
                                            .addComponent(qttyPlotTwistsMaxNick1))))))
                        .addGap(58, 58, 58)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addComponent(deadlineLabelText1)
                                .addGap(21, 21, 21)
                                .addComponent(deadlineLabelDisney))
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addComponent(costosLabelText3)
                                .addGap(18, 18, 18)
                                .addComponent(utilidadesLabelDisney))
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addComponent(costosLabelText2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(costosLabelDisney))
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addComponent(gananciaLabelText1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gananciasLabelDisney))
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(daysPassedLabelD))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisneyDashLayout.createSequentialGroup()
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addComponent(faultsLabelText1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(faultsLabelDisney))
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addComponent(discountedLabelText1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(discountedLabelDisney)))
                        .addGap(19, 19, 19)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        DisneyDashLayout.setVerticalGroup(
            DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisneyDashLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeGuionistaDisney)
                            .addComponent(addGuionistaDisney)
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(guionistasLabelDisney)
                                    .addComponent(qttyGuionistasDisney)
                                    .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(GuionesSavedLabelD)
                                        .addComponent(qttyGuionesSavedDisney)))))
                        .addGap(27, 27, 27)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeEscenariosDisney)
                            .addComponent(addEscenariosDisney)
                            .addGroup(DisneyDashLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(escenariosLabelDisney)
                                    .addComponent(qttyEscenariosDisney)
                                    .addComponent(EscenariosSavedLabelD)
                                    .addComponent(qttyEscenariosSavedDisney)))))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gananciaLabelText1)
                            .addComponent(gananciasLabelDisney))
                        .addGap(9, 9, 9)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(costosLabelText2)
                            .addComponent(costosLabelDisney))
                        .addGap(4, 4, 4)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(costosLabelText3)
                            .addComponent(utilidadesLabelDisney))
                        .addGap(36, 36, 36)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deadlineLabelText1)
                            .addComponent(deadlineLabelDisney)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisneyDashLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GuionesMaxLabelD)
                            .addComponent(qttyGuionesMaxNick1))
                        .addGap(33, 33, 33)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EscenariosMaxLabelD)
                            .addComponent(qttyEscenariosMaxNick1))
                        .addGap(35, 35, 35)))
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeAnimadorDisney)
                    .addComponent(addAnimadorDisney)
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animadorLabelDisney)
                            .addComponent(qttyAnimadoresDisney)
                            .addComponent(AnimacionesSavedLabelD)
                            .addComponent(qttyAnimacionesSavedDisney)
                            .addComponent(AnimacionesMaxLabelD)
                            .addComponent(qttyAnimacionesMaxNick1)))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(daysPassedLabelD))))
                .addGap(25, 25, 25)
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeDoblajeDisney)
                    .addComponent(addDoblajeDisney)
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doblajeLabelDisney)
                            .addComponent(qttyDobladoresDisney)
                            .addComponent(doblajesSavedLabelD)
                            .addComponent(qttyDoblajesSavedDisney)
                            .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(doblajesMaxLabelD)
                                .addComponent(qttyDoblajesMaxNick1)))))
                .addGap(34, 34, 34)
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removePlotTwistDisney)
                    .addComponent(addPlotTwistDisney)
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plotTwistLabelDisney)
                            .addComponent(qttyGuionistasPlotTwistsDisney)
                            .addComponent(plotTwistsSavedLabelD)
                            .addComponent(qttyPlotTwistsSavedDisney)
                            .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(plotTwistsMaxLabelD)
                                .addComponent(qttyPlotTwistsMaxNick1)))))
                .addGap(30, 30, 30)
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeEnsambladorDisney)
                    .addComponent(addEnsambladorDisney)
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ensambladorLabelDisney)
                            .addComponent(qttyEnsambladoresDisney))))
                .addGap(38, 38, 38)
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(capsReadyLabel1)
                    .addComponent(qttyStandardCapsReadyDisney))
                .addGap(18, 18, 18)
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(capsPlotTwistReadyLabel1)
                    .addComponent(qttyPlotTwistsCapsReadyDisney))
                .addGap(24, 24, 24)
                .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(qttyProjectsManagersNick1)
                            .addComponent(pmStatusLabelD)
                            .addComponent(pmStatusDisney))
                        .addGap(18, 18, 18)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(qttyDirectoresNick1)
                            .addComponent(directorStatusLabelD)
                            .addComponent(directorStatusDisney)))
                    .addGroup(DisneyDashLayout.createSequentialGroup()
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faultsLabelDisney)
                            .addComponent(faultsLabelText1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DisneyDashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discountedLabelText1)
                            .addComponent(discountedLabelDisney))))
                .addGap(69, 69, 69))
        );

        jTabbedPane1.addTab("DisneyChannel", DisneyDash);

        Grafico.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout GraficoLayout = new javax.swing.GroupLayout(Grafico);
        Grafico.setLayout(GraficoLayout);
        GraficoLayout.setHorizontalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        GraficoLayout.setVerticalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        jLabel9.setText("Dias totales transcurridos:");

        daysPassedLabelGrafico.setText("0");

        javax.swing.GroupLayout NickVSDisneyLayout = new javax.swing.GroupLayout(NickVSDisney);
        NickVSDisney.setLayout(NickVSDisneyLayout);
        NickVSDisneyLayout.setHorizontalGroup(
            NickVSDisneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NickVSDisneyLayout.createSequentialGroup()
                .addGroup(NickVSDisneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NickVSDisneyLayout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(daysPassedLabelGrafico))
                    .addGroup(NickVSDisneyLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(Grafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(199, 199, 199))
        );
        NickVSDisneyLayout.setVerticalGroup(
            NickVSDisneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NickVSDisneyLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(NickVSDisneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(daysPassedLabelGrafico))
                .addGap(47, 47, 47)
                .addComponent(Grafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nick_VS_Disney", NickVSDisney);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void removeGuionista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeGuionista2ActionPerformed
        if (Integer.parseInt(GuionistasNick.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(GuionistasNick.getText())-1;
            GuionistasNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeGuionista2ActionPerformed

    private void removeEnsamblador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEnsamblador1ActionPerformed
        if (Integer.parseInt(EnsambladoresNick.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(EnsambladoresNick.getText())-1;
            EnsambladoresNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeEnsamblador1ActionPerformed

    private void addEnsamblador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnsamblador1ActionPerformed
        if (calculateQuantityN() == 12){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(EnsambladoresNick.getText())+1;
            EnsambladoresNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addEnsamblador1ActionPerformed

    private void addPlotTwist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlotTwist1ActionPerformed
        if (calculateQuantityN() == 12){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(GuionistasPlotTwistsNick.getText())+1;
            GuionistasPlotTwistsNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addPlotTwist1ActionPerformed

    private void removePlotTwist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlotTwist1ActionPerformed
        if (Integer.parseInt(GuionistasPlotTwistsNick.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(GuionistasPlotTwistsNick.getText())-1;
            GuionistasPlotTwistsNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removePlotTwist1ActionPerformed

    private void removeDoblaje1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDoblaje1ActionPerformed
        if (Integer.parseInt(DobladoresNick.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(DobladoresNick.getText())-1;
            DobladoresNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeDoblaje1ActionPerformed

    private void removeAnimador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAnimador1ActionPerformed
        if (Integer.parseInt(AnimadoresNick.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(AnimadoresNick.getText())-1;
            AnimadoresNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeAnimador1ActionPerformed

    private void removeEscenarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEscenarios1ActionPerformed
        if (Integer.parseInt(EscenariosNick.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(EscenariosNick.getText())-1;
            EscenariosNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeEscenarios1ActionPerformed

    private void addDoblaje1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoblaje1ActionPerformed
        if (calculateQuantityN() == 12){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(DobladoresNick.getText())+1;
            DobladoresNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addDoblaje1ActionPerformed

    private void addAnimador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnimador1ActionPerformed
        if (calculateQuantityN() == 12){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(AnimadoresNick.getText())+1;
            AnimadoresNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addAnimador1ActionPerformed

    private void addEscenarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEscenarios1ActionPerformed
       if (calculateQuantityN() == 12){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(EscenariosNick.getText())+1;
            EscenariosNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addEscenarios1ActionPerformed

    private void addGuionista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGuionista2ActionPerformed
        if (calculateQuantityN() == 12){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(GuionistasNick.getText())+1;
            GuionistasNick.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addGuionista2ActionPerformed

    private void removeGuionista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeGuionista3ActionPerformed
        if (Integer.parseInt(GuionistasDisney.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(GuionistasDisney.getText())-1;
            GuionistasDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeGuionista3ActionPerformed

    private void removeEnsamblador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEnsamblador2ActionPerformed
        if (Integer.parseInt(EnsambladoresDisney.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(EnsambladoresDisney.getText())-1;
            EnsambladoresDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeEnsamblador2ActionPerformed

    private void addEnsamblador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnsamblador2ActionPerformed
        if (calculateQuantityD() == 13){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(EnsambladoresDisney.getText())+1;
            EnsambladoresDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addEnsamblador2ActionPerformed

    private void addPlotTwist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlotTwist2ActionPerformed
        if (calculateQuantityD() == 13){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(GuionistasPlotTwistsDisney.getText())+1;
            GuionistasPlotTwistsDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addPlotTwist2ActionPerformed

    private void removePlotTwist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlotTwist2ActionPerformed
        if (Integer.parseInt(GuionistasPlotTwistsDisney.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(GuionistasPlotTwistsDisney.getText())-1;
            GuionistasPlotTwistsDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removePlotTwist2ActionPerformed

    private void removeDoblaje2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDoblaje2ActionPerformed
        if (Integer.parseInt(DobladoresDisney.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(DobladoresDisney.getText())-1;
            DobladoresDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeDoblaje2ActionPerformed

    private void removeAnimador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAnimador2ActionPerformed
        if (Integer.parseInt(AnimadoresDisney.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(AnimadoresDisney.getText())-1;
            AnimadoresDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeAnimador2ActionPerformed

    private void removeEscenarios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEscenarios2ActionPerformed
        if (Integer.parseInt(EscenariosDisney.getText()) == 1){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DEJAR UN DEPARTAMENTO SIN TRABAJADORES");
        } else{
            int nuevo = Integer.parseInt(EscenariosDisney.getText())-1;
            EscenariosDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeEscenarios2ActionPerformed

    private void addDoblaje2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoblaje2ActionPerformed
        if (calculateQuantityD() == 13){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(DobladoresDisney.getText())+1;
            DobladoresDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addDoblaje2ActionPerformed

    private void addAnimador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnimador2ActionPerformed
        if (calculateQuantityD() == 13) {
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(AnimadoresDisney.getText()) + 1;
            AnimadoresDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addAnimador2ActionPerformed

    private void addEscenarios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEscenarios2ActionPerformed
        if (calculateQuantityD() == 13){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(EscenariosDisney.getText())+1;
            EscenariosDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addEscenarios2ActionPerformed

    private void addGuionista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGuionista3ActionPerformed
        if (calculateQuantityD() == 13){
            JOptionPane.showMessageDialog(null, "SE HA SUPERADO LA CANTIDAD LIMITE DE TRABAJADORES!");
        } else {
            int nuevo = Integer.parseInt(GuionistasDisney.getText())+1;
            GuionistasDisney.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_addGuionista3ActionPerformed

    private void removeAmmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAmmountActionPerformed
        if(Integer.parseInt(ammount.getText())== 1){
            JOptionPane.showMessageDialog(null, "SE DEBE TENER POR LO MENOS UN DIA COMO DEADLINE DE ENTREGA");
        } else {
            int nuevo = Integer.parseInt(ammount.getText())-1;
            ammount.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeAmmountActionPerformed

    private void addAmmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAmmountActionPerformed
        int nuevo = Integer.parseInt(ammount.getText())+1;
        ammount.setText(String.valueOf(nuevo));
    }//GEN-LAST:event_addAmmountActionPerformed

    private void addDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDiaActionPerformed
        int nuevo = Integer.parseInt(dia.getText())+1;
        dia.setText(String.valueOf(nuevo));
    }//GEN-LAST:event_addDiaActionPerformed

    private void removeDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDiaActionPerformed
        if(Integer.parseInt(dia.getText())==2000){
            JOptionPane.showMessageDialog(null, "EL DIA DEBE DURAR MINIMO 2000MS");
        } else {
            int nuevo = Integer.parseInt(dia.getText())-1;
            dia.setText(String.valueOf(nuevo));
        }
    }//GEN-LAST:event_removeDiaActionPerformed

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        String quantities = GuionistasNick.getText() + ", " + EscenariosNick.getText() + ", " + AnimadoresNick.getText() + ", " + DobladoresNick.getText() + ", " + GuionistasPlotTwistsNick.getText() + ", " + EnsambladoresNick.getText() + " / " + GuionistasDisney.getText() + ", " + EscenariosDisney.getText() + ", " + AnimadoresDisney.getText() + ", " + DobladoresDisney.getText() + ", " + GuionistasPlotTwistsDisney.getText() + ", " + EnsambladoresDisney.getText();
        String data = dia.getText() + " / " + ammount.getText();
        
        // DATOS INICIALES
        File fichero = new File("DatosIniciales.txt");
        String contenido = "";
        
        try{
            PrintWriter salida = new PrintWriter(fichero);
            salida.print(data);
            salida.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
        // CANTIDADES INICIALES
        
        fichero = new File("InitialQuantity.txt");
        
        try{
            PrintWriter salida = new PrintWriter(fichero);
            salida.print(quantities);
            salida.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_txtActionPerformed

    private void addEnsambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnsambladorActionPerformed
        // TODO add your handling code here:
        nickelodeon.addWorkers(5);
        this.qttyEnsambladoresNick.setText(Integer.toString(nickelodeon.getEnsambladores().getQuantityWorkers()));
    }//GEN-LAST:event_addEnsambladorActionPerformed

    private void removeEnsambladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEnsambladorActionPerformed
        // TODO add your handling code here:
        nickelodeon.getEnsambladores().deleteWorker();
        this.qttyEnsambladoresNick.setText(Integer.toString(nickelodeon.getEnsambladores().getQuantityWorkers()));
    }//GEN-LAST:event_removeEnsambladorActionPerformed

    private void addPlotTwistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlotTwistActionPerformed
        // TODO add your handling code here:
        nickelodeon.addWorkers(4);
        this.qttyGuionistasPlotTwistsNick.setText(Integer.toString(nickelodeon.getGuionistasPlotTwists().getQuantityWorkers()));
    }//GEN-LAST:event_addPlotTwistActionPerformed

    private void removePlotTwistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlotTwistActionPerformed
        // TODO add your handling code here:
        nickelodeon.getGuionistasPlotTwists().deleteWorker();
        this.qttyGuionistasPlotTwistsNick.setText(Integer.toString(nickelodeon.getGuionistasPlotTwists().getQuantityWorkers()));
    }//GEN-LAST:event_removePlotTwistActionPerformed

    private void addDoblajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoblajeActionPerformed
        // TODO add your handling code here:
        nickelodeon.addWorkers(3);
        this.qttyDobladoresNick.setText(Integer.toString(nickelodeon.getDobladores().getQuantityWorkers()));
    }//GEN-LAST:event_addDoblajeActionPerformed

    private void removeDoblajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDoblajeActionPerformed
        // TODO add your handling code here:
        nickelodeon.getDobladores().deleteWorker();
        this.qttyDobladoresNick.setText(Integer.toString(nickelodeon.getDobladores().getQuantityWorkers()));

    }//GEN-LAST:event_removeDoblajeActionPerformed

    private void addAnimadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnimadorActionPerformed
        // TODO add your handling code here:
        nickelodeon.addWorkers(2);
        this.qttyAnimadoresNick.setText(Integer.toString(nickelodeon.getAnimadores().getQuantityWorkers()));
    }//GEN-LAST:event_addAnimadorActionPerformed

    private void removeAnimadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAnimadorActionPerformed
        // TODO add your handling code here:
        nickelodeon.getAnimadores().deleteWorker();
        this.qttyAnimadoresNick.setText(Integer.toString(nickelodeon.getAnimadores().getQuantityWorkers()));
    }//GEN-LAST:event_removeAnimadorActionPerformed

    private void addEscenariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEscenariosActionPerformed
        // TODO add your handling code here:
        nickelodeon.addWorkers(1);
        this.qttyEscenariosNick.setText(Integer.toString(nickelodeon.getEscenarios().getQuantityWorkers()));
    }//GEN-LAST:event_addEscenariosActionPerformed

    private void removeEscenariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEscenariosActionPerformed
        // TODO add your handling code here:
        nickelodeon.getEscenarios().deleteWorker();
        this.qttyEscenariosNick.setText(Integer.toString(nickelodeon.getEscenarios().getQuantityWorkers()));
    }//GEN-LAST:event_removeEscenariosActionPerformed

    private void addGuionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGuionistaActionPerformed
        // TODO add your handling code here:
        nickelodeon.addWorkers(0);
        this.qttyGuionistasNick.setText(Integer.toString(nickelodeon.getGuionistas().getQuantityWorkers()));
    }//GEN-LAST:event_addGuionistaActionPerformed

    private void removeGuionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeGuionistaActionPerformed
        // TODO add your handling code here:
        nickelodeon.getGuionistas().deleteWorker();
        this.qttyGuionistasNick.setText(Integer.toString(nickelodeon.getGuionistas().getQuantityWorkers()));
    }//GEN-LAST:event_removeGuionistaActionPerformed

    private void removeGuionistaDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeGuionistaDisneyActionPerformed
        // TODO add your handling code here:
        disney.getGuionistas().deleteWorker();
        this.qttyGuionistasDisney.setText(Integer.toString(disney.getGuionistas().getQuantityWorkers()));
    }//GEN-LAST:event_removeGuionistaDisneyActionPerformed

    private void addGuionistaDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGuionistaDisneyActionPerformed
        // TODO add your handling code here:
        disney.addWorkers(0);
        this.qttyGuionistasDisney.setText(Integer.toString(disney.getGuionistas().getQuantityWorkers()));
    }//GEN-LAST:event_addGuionistaDisneyActionPerformed

    private void removeEscenariosDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEscenariosDisneyActionPerformed
        // TODO add your handling code here:
        disney.getEscenarios().deleteWorker();
        this.qttyEscenariosDisney.setText(Integer.toString(disney.getEscenarios().getQuantityWorkers()));
    }//GEN-LAST:event_removeEscenariosDisneyActionPerformed

    private void addEscenariosDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEscenariosDisneyActionPerformed
        // TODO add your handling code here:
        disney.addWorkers(1);
        this.qttyEscenariosDisney.setText(Integer.toString(disney.getEscenarios().getQuantityWorkers()));
    }//GEN-LAST:event_addEscenariosDisneyActionPerformed

    private void removeAnimadorDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAnimadorDisneyActionPerformed
        // TODO add your handling code here:
        disney.getAnimadores().deleteWorker();
        this.qttyAnimadoresDisney.setText(Integer.toString(disney.getAnimadores().getQuantityWorkers()));
    }//GEN-LAST:event_removeAnimadorDisneyActionPerformed

    private void addAnimadorDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnimadorDisneyActionPerformed
        // TODO add your handling code here:
        disney.addWorkers(2);
        this.qttyAnimadoresDisney.setText(Integer.toString(disney.getAnimadores().getQuantityWorkers()));
    }//GEN-LAST:event_addAnimadorDisneyActionPerformed

    private void removeDoblajeDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDoblajeDisneyActionPerformed
        // TODO add your handling code here:
        disney.getDobladores().deleteWorker();
        this.qttyDobladoresDisney.setText(Integer.toString(disney.getDobladores().getQuantityWorkers()));
    }//GEN-LAST:event_removeDoblajeDisneyActionPerformed

    private void addDoblajeDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoblajeDisneyActionPerformed
        // TODO add your handling code here:
        disney.addWorkers(3);
        this.qttyDobladoresDisney.setText(Integer.toString(disney.getDobladores().getQuantityWorkers()));
    }//GEN-LAST:event_addDoblajeDisneyActionPerformed

    private void removePlotTwistDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePlotTwistDisneyActionPerformed
        // TODO add your handling code here:
        disney.getGuionistasPlotTwists().deleteWorker();
        this.qttyGuionistasPlotTwistsDisney.setText(Integer.toString(disney.getGuionistasPlotTwists().getQuantityWorkers()));
    }//GEN-LAST:event_removePlotTwistDisneyActionPerformed

    private void addPlotTwistDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlotTwistDisneyActionPerformed
        // TODO add your handling code here:
        disney.addWorkers(4);
        this.qttyGuionistasPlotTwistsDisney.setText(Integer.toString(disney.getGuionistasPlotTwists().getQuantityWorkers()));
    }//GEN-LAST:event_addPlotTwistDisneyActionPerformed

    private void removeEnsambladorDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEnsambladorDisneyActionPerformed
        // TODO add your handling code here:
        disney.getEnsambladores().deleteWorker();
        this.qttyEnsambladoresDisney.setText(Integer.toString(disney.getEnsambladores().getQuantityWorkers()));
    }//GEN-LAST:event_removeEnsambladorDisneyActionPerformed

    private void addEnsambladorDisneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnsambladorDisneyActionPerformed
        // TODO add your handling code here:
        disney.addWorkers(5);
        this.qttyEnsambladoresDisney.setText(Integer.toString(disney.getEnsambladores().getQuantityWorkers()));
    }//GEN-LAST:event_addEnsambladorDisneyActionPerformed

    private int calculateQuantityN(){
        int cantidadTotal = Integer.parseInt(GuionistasNick.getText()) + Integer.parseInt(EscenariosNick.getText()) + Integer.parseInt(AnimadoresNick.getText()) + Integer.parseInt(DobladoresNick.getText()) + Integer.parseInt(GuionistasPlotTwistsNick.getText()) + Integer.parseInt(EnsambladoresNick.getText());
        System.out.println(cantidadTotal);
        return cantidadTotal;
    }
    
    private int calculateQuantityD(){
        int cantidadTotal = Integer.parseInt(GuionistasDisney.getText()) + Integer.parseInt(EscenariosDisney.getText()) + Integer.parseInt(AnimadoresDisney.getText()) + Integer.parseInt(DobladoresDisney.getText()) + Integer.parseInt(GuionistasPlotTwistsDisney.getText()) + Integer.parseInt(EnsambladoresDisney.getText());
        return cantidadTotal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnimacionesMaxLabel2;
    private javax.swing.JLabel AnimacionesMaxLabelD;
    private javax.swing.JLabel AnimacionesSavedLabel;
    private javax.swing.JLabel AnimacionesSavedLabelD;
    private javax.swing.JLabel AnimadoresDisney;
    private javax.swing.JLabel AnimadoresNick;
    private javax.swing.JPanel ConfigurationDashboard;
    private javax.swing.JPanel DisneyDash;
    private javax.swing.JLabel DobladoresDisney;
    private javax.swing.JLabel DobladoresNick;
    private javax.swing.JLabel EnsambladoresDisney;
    private javax.swing.JLabel EnsambladoresNick;
    private javax.swing.JLabel EscenariosDisney;
    private javax.swing.JLabel EscenariosMaxLabel;
    private javax.swing.JLabel EscenariosMaxLabelD;
    private javax.swing.JLabel EscenariosNick;
    private javax.swing.JLabel EscenariosSavedLabel;
    private javax.swing.JLabel EscenariosSavedLabelD;
    private javax.swing.JPanel Grafico;
    private javax.swing.JLabel GuionesMaxLabel;
    private javax.swing.JLabel GuionesMaxLabelD;
    private javax.swing.JLabel GuionesSavedLabel;
    private javax.swing.JLabel GuionesSavedLabelD;
    private javax.swing.JLabel GuionistasDisney;
    private javax.swing.JLabel GuionistasNick;
    private javax.swing.JLabel GuionistasPlotTwistsDisney;
    private javax.swing.JLabel GuionistasPlotTwistsNick;
    private javax.swing.JPanel NickVSDisney;
    private javax.swing.JPanel NickelodeonDash;
    private javax.swing.JButton addAmmount;
    private javax.swing.JButton addAnimador;
    private javax.swing.JButton addAnimador1;
    private javax.swing.JButton addAnimador2;
    private javax.swing.JButton addAnimadorDisney;
    private javax.swing.JButton addDia;
    private javax.swing.JButton addDoblaje;
    private javax.swing.JButton addDoblaje1;
    private javax.swing.JButton addDoblaje2;
    private javax.swing.JButton addDoblajeDisney;
    private javax.swing.JButton addEnsamblador;
    private javax.swing.JButton addEnsamblador1;
    private javax.swing.JButton addEnsamblador2;
    private javax.swing.JButton addEnsambladorDisney;
    private javax.swing.JButton addEscenarios;
    private javax.swing.JButton addEscenarios1;
    private javax.swing.JButton addEscenarios2;
    private javax.swing.JButton addEscenariosDisney;
    private javax.swing.JButton addGuionista;
    private javax.swing.JButton addGuionista2;
    private javax.swing.JButton addGuionista3;
    private javax.swing.JButton addGuionistaDisney;
    private javax.swing.JButton addPlotTwist;
    private javax.swing.JButton addPlotTwist1;
    private javax.swing.JButton addPlotTwist2;
    private javax.swing.JButton addPlotTwistDisney;
    private javax.swing.JLabel ammount;
    private javax.swing.JLabel animadorLabel;
    private javax.swing.JLabel animadorLabel1;
    private javax.swing.JLabel animadorLabel2;
    private javax.swing.JLabel animadorLabelDisney;
    private javax.swing.JLabel capsPlotTwistReadyLabel;
    private javax.swing.JLabel capsPlotTwistReadyLabel1;
    private javax.swing.JLabel capsReadyLabel;
    private javax.swing.JLabel capsReadyLabel1;
    private javax.swing.JLabel costosLabel;
    private javax.swing.JLabel costosLabelDisney;
    private javax.swing.JLabel costosLabelText;
    private javax.swing.JLabel costosLabelText1;
    private javax.swing.JLabel costosLabelText2;
    private javax.swing.JLabel costosLabelText3;
    private javax.swing.JLabel dayDuration;
    private javax.swing.JLabel daysPassedLabelD;
    private javax.swing.JLabel daysPassedLabelGrafico;
    private javax.swing.JLabel daysPassedLabelN;
    private javax.swing.JLabel deadline;
    private javax.swing.JLabel deadlineLabel;
    private javax.swing.JLabel deadlineLabelDisney;
    private javax.swing.JLabel deadlineLabelText;
    private javax.swing.JLabel deadlineLabelText1;
    private javax.swing.JLabel dia;
    private javax.swing.JLabel directorStatus;
    private javax.swing.JLabel directorStatusDisney;
    private javax.swing.JLabel directorStatusLabel;
    private javax.swing.JLabel directorStatusLabelD;
    private javax.swing.JLabel discountedLabel;
    private javax.swing.JLabel discountedLabelDisney;
    private javax.swing.JLabel discountedLabelText;
    private javax.swing.JLabel discountedLabelText1;
    private javax.swing.JLabel doblajeLabel;
    private javax.swing.JLabel doblajeLabel1;
    private javax.swing.JLabel doblajeLabel2;
    private javax.swing.JLabel doblajeLabelDisney;
    private javax.swing.JLabel doblajesMaxLabel3;
    private javax.swing.JLabel doblajesMaxLabelD;
    private javax.swing.JLabel doblajesSavedLabel3;
    private javax.swing.JLabel doblajesSavedLabelD;
    private javax.swing.JLabel ensambladorLabel;
    private javax.swing.JLabel ensambladorLabel1;
    private javax.swing.JLabel ensambladorLabel2;
    private javax.swing.JLabel ensambladorLabelDisney;
    private javax.swing.JLabel escenariosLabel;
    private javax.swing.JLabel escenariosLabel1;
    private javax.swing.JLabel escenariosLabel2;
    private javax.swing.JLabel escenariosLabelDisney;
    private javax.swing.JLabel faultsLabel;
    private javax.swing.JLabel faultsLabelDisney;
    private javax.swing.JLabel faultsLabelText;
    private javax.swing.JLabel faultsLabelText1;
    private javax.swing.JLabel gananciaLabelText;
    private javax.swing.JLabel gananciaLabelText1;
    private javax.swing.JLabel gananciasLabel;
    private javax.swing.JLabel gananciasLabelDisney;
    private javax.swing.JLabel guionistasLabel;
    private javax.swing.JLabel guionistasLabel1;
    private javax.swing.JLabel guionistasLabel2;
    private javax.swing.JLabel guionistasLabelDisney;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel plotTwistLabel;
    private javax.swing.JLabel plotTwistLabel1;
    private javax.swing.JLabel plotTwistLabel2;
    private javax.swing.JLabel plotTwistLabelDisney;
    private javax.swing.JLabel plotTwistsMaxLabel4;
    private javax.swing.JLabel plotTwistsMaxLabelD;
    private javax.swing.JLabel plotTwistsSavedLabel4;
    private javax.swing.JLabel plotTwistsSavedLabelD;
    private javax.swing.JLabel pmStatus;
    private javax.swing.JLabel pmStatusDisney;
    private javax.swing.JLabel pmStatusLabel;
    private javax.swing.JLabel pmStatusLabelD;
    private javax.swing.JLabel qttyAnimacionesMaxNick;
    private javax.swing.JLabel qttyAnimacionesMaxNick1;
    private javax.swing.JLabel qttyAnimacionesSavedDisney;
    private javax.swing.JLabel qttyAnimacionesSavedNick;
    private javax.swing.JLabel qttyAnimadoresDisney;
    private javax.swing.JLabel qttyAnimadoresNick;
    private javax.swing.JLabel qttyDirectoresNick;
    private javax.swing.JLabel qttyDirectoresNick1;
    private javax.swing.JLabel qttyDobladoresDisney;
    private javax.swing.JLabel qttyDobladoresNick;
    private javax.swing.JLabel qttyDoblajesMaxNick;
    private javax.swing.JLabel qttyDoblajesMaxNick1;
    private javax.swing.JLabel qttyDoblajesSavedDisney;
    private javax.swing.JLabel qttyDoblajesSavedNick;
    private javax.swing.JLabel qttyEnsambladoresDisney;
    private javax.swing.JLabel qttyEnsambladoresNick;
    private javax.swing.JLabel qttyEscenariosDisney;
    private javax.swing.JLabel qttyEscenariosMaxNick;
    private javax.swing.JLabel qttyEscenariosMaxNick1;
    private javax.swing.JLabel qttyEscenariosNick;
    private javax.swing.JLabel qttyEscenariosSavedDisney;
    private javax.swing.JLabel qttyEscenariosSavedNick;
    private javax.swing.JLabel qttyGuionesMaxNick;
    private javax.swing.JLabel qttyGuionesMaxNick1;
    private javax.swing.JLabel qttyGuionesSavedDisney;
    private javax.swing.JLabel qttyGuionesSavedNick;
    private javax.swing.JLabel qttyGuionistasDisney;
    private javax.swing.JLabel qttyGuionistasNick;
    private javax.swing.JLabel qttyGuionistasPlotTwistsDisney;
    private javax.swing.JLabel qttyGuionistasPlotTwistsNick;
    private javax.swing.JLabel qttyPlotTwistsCapsReadyDisney;
    private javax.swing.JLabel qttyPlotTwistsCapsReadyNick;
    private javax.swing.JLabel qttyPlotTwistsMaxNick;
    private javax.swing.JLabel qttyPlotTwistsMaxNick1;
    private javax.swing.JLabel qttyPlotTwistsSavedDisney;
    private javax.swing.JLabel qttyPlotTwistsSavedNick;
    private javax.swing.JLabel qttyProjectsManagersNick;
    private javax.swing.JLabel qttyProjectsManagersNick1;
    private javax.swing.JLabel qttyStandardCapsReadyDisney;
    private javax.swing.JLabel qttyStandardCapsReadyNick;
    private javax.swing.JButton removeAmmount;
    private javax.swing.JButton removeAnimador;
    private javax.swing.JButton removeAnimador1;
    private javax.swing.JButton removeAnimador2;
    private javax.swing.JButton removeAnimadorDisney;
    private javax.swing.JButton removeDia;
    private javax.swing.JButton removeDoblaje;
    private javax.swing.JButton removeDoblaje1;
    private javax.swing.JButton removeDoblaje2;
    private javax.swing.JButton removeDoblajeDisney;
    private javax.swing.JButton removeEnsamblador;
    private javax.swing.JButton removeEnsamblador1;
    private javax.swing.JButton removeEnsamblador2;
    private javax.swing.JButton removeEnsambladorDisney;
    private javax.swing.JButton removeEscenarios;
    private javax.swing.JButton removeEscenarios1;
    private javax.swing.JButton removeEscenarios2;
    private javax.swing.JButton removeEscenariosDisney;
    private javax.swing.JButton removeGuionista;
    private javax.swing.JButton removeGuionista2;
    private javax.swing.JButton removeGuionista3;
    private javax.swing.JButton removeGuionistaDisney;
    private javax.swing.JButton removePlotTwist;
    private javax.swing.JButton removePlotTwist1;
    private javax.swing.JButton removePlotTwist2;
    private javax.swing.JButton removePlotTwistDisney;
    private javax.swing.JButton txt;
    private javax.swing.JLabel utilidadesLabel;
    private javax.swing.JLabel utilidadesLabelDisney;
    // End of variables declaration//GEN-END:variables
}
