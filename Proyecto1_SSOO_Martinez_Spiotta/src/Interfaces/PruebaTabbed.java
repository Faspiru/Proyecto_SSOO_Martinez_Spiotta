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

        ConfigurationDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        plotTwistLabel1.setText("Guionista de PlotTwist:");
        ConfigurationDashboard.add(plotTwistLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 281, -1, -1));

        removePlotTwist1.setText("-");
        removePlotTwist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwist1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removePlotTwist1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 278, -1, -1));

        addDoblaje1.setText("+");
        addDoblaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblaje1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addDoblaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 221, -1, -1));

        addAnimador1.setText("+");
        addAnimador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addAnimador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 161, -1, -1));

        GuionistasPlotTwistsNick.setText("0");
        ConfigurationDashboard.add(GuionistasPlotTwistsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 281, -1, -1));

        removeAnimador1.setText("-");
        removeAnimador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeAnimador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 161, -1, -1));

        animadorLabel1.setText("Animador de personajes:");
        ConfigurationDashboard.add(animadorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 164, -1, -1));

        addPlotTwist1.setText("+");
        addPlotTwist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwist1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addPlotTwist1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 278, -1, -1));

        AnimadoresNick.setText("0");
        ConfigurationDashboard.add(AnimadoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 164, -1, -1));

        EnsambladoresNick.setText("0");
        ConfigurationDashboard.add(EnsambladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 334, -1, -1));

        addEnsamblador1.setText("+");
        addEnsamblador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsamblador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEnsamblador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 331, -1, -1));

        removeDoblaje1.setText("-");
        removeDoblaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblaje1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeDoblaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 221, -1, -1));

        guionistasLabel1.setText("Guionistas:");
        ConfigurationDashboard.add(guionistasLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 57, -1, -1));

        EscenariosNick.setText("0");
        ConfigurationDashboard.add(EscenariosNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 105, -1, -1));

        removeEscenarios1.setText("-");
        removeEscenarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenarios1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEscenarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 102, -1, -1));

        removeGuionista2.setText("-");
        removeGuionista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionista2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeGuionista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 54, -1, -1));

        addGuionista2.setText("+");
        addGuionista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionista2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addGuionista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 54, -1, -1));

        doblajeLabel1.setText("Actores de doblaje:");
        ConfigurationDashboard.add(doblajeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 224, -1, -1));

        DobladoresNick.setText("0");
        ConfigurationDashboard.add(DobladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 224, -1, -1));

        ensambladorLabel1.setText("Ensambladores:");
        ConfigurationDashboard.add(ensambladorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 334, -1, -1));

        addEscenarios1.setText("+");
        addEscenarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenarios1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEscenarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 102, -1, -1));

        removeEnsamblador1.setText("-");
        removeEnsamblador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsamblador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEnsamblador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 331, -1, -1));

        GuionistasNick.setText("0");
        ConfigurationDashboard.add(GuionistasNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 57, -1, -1));

        escenariosLabel1.setText("Diseñador de escenarios:");
        ConfigurationDashboard.add(escenariosLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 105, -1, -1));

        guionistasLabel2.setText("Guionistas:");
        ConfigurationDashboard.add(guionistasLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 57, -1, -1));

        removeGuionista3.setText("-");
        removeGuionista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionista3ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeGuionista3, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 54, -1, -1));

        escenariosLabel2.setText("Diseñador de escenarios:");
        ConfigurationDashboard.add(escenariosLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 105, -1, -1));

        animadorLabel2.setText("Animador de personajes:");
        ConfigurationDashboard.add(animadorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 164, -1, -1));

        doblajeLabel2.setText("Actores de doblaje:");
        ConfigurationDashboard.add(doblajeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 224, -1, -1));

        plotTwistLabel2.setText("Guionista de PlotTwist:");
        ConfigurationDashboard.add(plotTwistLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 281, -1, -1));

        ensambladorLabel2.setText("Ensambladores:");
        ConfigurationDashboard.add(ensambladorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 334, -1, -1));

        removeEnsamblador2.setText("-");
        removeEnsamblador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsamblador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEnsamblador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 331, -1, -1));

        EnsambladoresDisney.setText("0");
        ConfigurationDashboard.add(EnsambladoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 334, -1, -1));

        addEnsamblador2.setText("+");
        addEnsamblador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsamblador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEnsamblador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 331, -1, -1));

        addPlotTwist2.setText("+");
        addPlotTwist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwist2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addPlotTwist2, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 278, -1, -1));

        GuionistasPlotTwistsDisney.setText("0");
        ConfigurationDashboard.add(GuionistasPlotTwistsDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 281, -1, -1));

        removePlotTwist2.setText("-");
        removePlotTwist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwist2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removePlotTwist2, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 278, -1, -1));

        removeDoblaje2.setText("-");
        removeDoblaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblaje2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeDoblaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 221, -1, -1));

        removeAnimador2.setText("-");
        removeAnimador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeAnimador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 161, -1, -1));

        removeEscenarios2.setText("-");
        removeEscenarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenarios2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEscenarios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 102, -1, -1));

        GuionistasDisney.setText("0");
        ConfigurationDashboard.add(GuionistasDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 57, -1, -1));

        EscenariosDisney.setText("0");
        ConfigurationDashboard.add(EscenariosDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 105, -1, -1));

        AnimadoresDisney.setText("0");
        ConfigurationDashboard.add(AnimadoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 164, -1, -1));

        DobladoresDisney.setText("0");
        ConfigurationDashboard.add(DobladoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 224, -1, -1));

        addDoblaje2.setText("+");
        addDoblaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblaje2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addDoblaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 221, -1, -1));

        addAnimador2.setText("+");
        addAnimador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addAnimador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 161, -1, -1));

        addEscenarios2.setText("+");
        addEscenarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenarios2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEscenarios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 102, -1, -1));

        addGuionista3.setText("+");
        addGuionista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionista3ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addGuionista3, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 54, -1, -1));

        dayDuration.setText("Duracion de un dia");
        ConfigurationDashboard.add(dayDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 415, -1, -1));

        removeDia.setText("-");
        removeDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDiaActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 412, -1, -1));

        dia.setText("0");
        ConfigurationDashboard.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 415, -1, -1));

        addDia.setText("+");
        addDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiaActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 412, -1, -1));

        deadline.setText("Deadline");
        ConfigurationDashboard.add(deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 415, -1, -1));

        removeAmmount.setText("-");
        removeAmmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAmmountActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeAmmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(674, 412, -1, -1));

        ammount.setText("0");
        ConfigurationDashboard.add(ammount, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 415, -1, -1));

        addAmmount.setText("+");
        addAmmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAmmountActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addAmmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 412, -1, -1));

        txt.setText("Guardar");
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 412, -1, -1));

        jTabbedPane1.addTab("ConfigurationDashboard", ConfigurationDashboard);

        NickelodeonDash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("NICKELODEON");
        NickelodeonDash.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 40));

        guionistasLabel.setText("Guionistas:");
        NickelodeonDash.add(guionistasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 66, -1, -1));

        escenariosLabel.setText("Diseñador de escenarios:");
        NickelodeonDash.add(escenariosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 116, -1, -1));

        animadorLabel.setText("Animador de personajes:");
        NickelodeonDash.add(animadorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 173, -1, -1));

        doblajeLabel.setText("Actores de doblaje:");
        NickelodeonDash.add(doblajeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 253, -1, -1));

        plotTwistLabel.setText("Guionista de PlotTwist:");
        NickelodeonDash.add(plotTwistLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 310, -1, -1));

        ensambladorLabel.setText("Ensambladores:");
        NickelodeonDash.add(ensambladorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 363, -1, -1));

        qttyGuionistasNick.setText("0");
        NickelodeonDash.add(qttyGuionistasNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 66, -1, -1));

        qttyEscenariosNick.setText("0");
        NickelodeonDash.add(qttyEscenariosNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 116, -1, -1));

        qttyAnimadoresNick.setText("0");
        NickelodeonDash.add(qttyAnimadoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 173, -1, -1));

        qttyDobladoresNick.setText("0");
        NickelodeonDash.add(qttyDobladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 253, -1, -1));

        qttyGuionistasPlotTwistsNick.setText("0");
        NickelodeonDash.add(qttyGuionistasPlotTwistsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 310, -1, -1));

        qttyEnsambladoresNick.setText("0");
        NickelodeonDash.add(qttyEnsambladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 363, -1, -1));

        removeGuionista.setText("-");
        removeGuionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionistaActionPerformed(evt);
            }
        });
        NickelodeonDash.add(removeGuionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 63, -1, -1));

        addGuionista.setText("+");
        addGuionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionistaActionPerformed(evt);
            }
        });
        NickelodeonDash.add(addGuionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 63, -1, -1));

        removeEscenarios.setText("-");
        removeEscenarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenariosActionPerformed(evt);
            }
        });
        NickelodeonDash.add(removeEscenarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 113, -1, -1));

        addEscenarios.setText("+");
        addEscenarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenariosActionPerformed(evt);
            }
        });
        NickelodeonDash.add(addEscenarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 113, -1, -1));

        removeAnimador.setText("-");
        removeAnimador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimadorActionPerformed(evt);
            }
        });
        NickelodeonDash.add(removeAnimador, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 170, -1, -1));

        addAnimador.setText("+");
        addAnimador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimadorActionPerformed(evt);
            }
        });
        NickelodeonDash.add(addAnimador, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 170, -1, -1));

        removeDoblaje.setText("-");
        removeDoblaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblajeActionPerformed(evt);
            }
        });
        NickelodeonDash.add(removeDoblaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 250, -1, -1));

        addDoblaje.setText("+");
        addDoblaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblajeActionPerformed(evt);
            }
        });
        NickelodeonDash.add(addDoblaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 250, -1, -1));

        removePlotTwist.setText("-");
        removePlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwistActionPerformed(evt);
            }
        });
        NickelodeonDash.add(removePlotTwist, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 307, -1, -1));

        addPlotTwist.setText("+");
        addPlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwistActionPerformed(evt);
            }
        });
        NickelodeonDash.add(addPlotTwist, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 307, -1, -1));

        removeEnsamblador.setText("-");
        removeEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsambladorActionPerformed(evt);
            }
        });
        NickelodeonDash.add(removeEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 360, -1, -1));

        addEnsamblador.setText("+");
        addEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsambladorActionPerformed(evt);
            }
        });
        NickelodeonDash.add(addEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 360, -1, -1));

        jLabel3.setText("Projects Managers:");
        NickelodeonDash.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 495, -1, -1));

        jLabel4.setText("Directores Ejecutivos:");
        NickelodeonDash.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 529, -1, -1));

        qttyProjectsManagersNick.setText("1");
        NickelodeonDash.add(qttyProjectsManagersNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 495, -1, -1));

        qttyDirectoresNick.setText("1");
        NickelodeonDash.add(qttyDirectoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 529, -1, -1));

        GuionesSavedLabel.setText("Guiones en el Drive:");
        NickelodeonDash.add(GuionesSavedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 66, -1, -1));

        qttyGuionesSavedNick.setText("0");
        NickelodeonDash.add(qttyGuionesSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 66, -1, -1));

        GuionesMaxLabel.setText("Capacidad Máx:");
        NickelodeonDash.add(GuionesMaxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(442, 66, -1, -1));

        qttyGuionesMaxNick.setText("25");
        NickelodeonDash.add(qttyGuionesMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 66, -1, -1));

        EscenariosSavedLabel.setText("Escenarios en el Drive:");
        NickelodeonDash.add(EscenariosSavedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 116, -1, -1));

        qttyEscenariosSavedNick.setText("0");
        NickelodeonDash.add(qttyEscenariosSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 116, -1, -1));

        EscenariosMaxLabel.setText("Capacidad Máx:");
        NickelodeonDash.add(EscenariosMaxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 116, -1, -1));

        qttyEscenariosMaxNick.setText("20");
        NickelodeonDash.add(qttyEscenariosMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 116, -1, -1));

        AnimacionesSavedLabel.setText("Animaciones en el Drive:");
        NickelodeonDash.add(AnimacionesSavedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 173, -1, -1));

        qttyAnimacionesSavedNick.setText("0");
        NickelodeonDash.add(qttyAnimacionesSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 173, -1, -1));

        AnimacionesMaxLabel2.setText("Capacidad Máx:");
        NickelodeonDash.add(AnimacionesMaxLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 173, -1, -1));

        qttyAnimacionesMaxNick.setText("55");
        NickelodeonDash.add(qttyAnimacionesMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 173, -1, -1));

        doblajesSavedLabel3.setText("Doblajes en el Drive:");
        NickelodeonDash.add(doblajesSavedLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 253, -1, -1));

        qttyDoblajesSavedNick.setText("0");
        NickelodeonDash.add(qttyDoblajesSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 253, -1, -1));

        doblajesMaxLabel3.setText("Capacidad Máx:");
        NickelodeonDash.add(doblajesMaxLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 253, -1, -1));

        qttyDoblajesMaxNick.setText("35");
        NickelodeonDash.add(qttyDoblajesMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 253, -1, -1));

        plotTwistsSavedLabel4.setText("PlotTwists en el Drive:");
        NickelodeonDash.add(plotTwistsSavedLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 310, -1, -1));

        qttyPlotTwistsSavedNick.setText("0");
        NickelodeonDash.add(qttyPlotTwistsSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 310, -1, -1));

        plotTwistsMaxLabel4.setText("Capacidad Máx:");
        NickelodeonDash.add(plotTwistsMaxLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 310, -1, -1));

        qttyPlotTwistsMaxNick.setText("10");
        NickelodeonDash.add(qttyPlotTwistsMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 310, -1, -1));

        capsPlotTwistReadyLabel.setText("Capitulos PlotTwists Listos:");
        NickelodeonDash.add(capsPlotTwistReadyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 455, -1, -1));

        capsReadyLabel.setText("Capitulos Standar Listos:");
        NickelodeonDash.add(capsReadyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 421, -1, -1));

        qttyStandardCapsReadyNick.setText("0");
        NickelodeonDash.add(qttyStandardCapsReadyNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 421, -1, -1));

        qttyPlotTwistsCapsReadyNick.setText("0");
        NickelodeonDash.add(qttyPlotTwistsCapsReadyNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 455, -1, -1));

        pmStatusLabel.setText("Project Manager Status:");
        NickelodeonDash.add(pmStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 495, -1, -1));

        directorStatusLabel.setText("Director Status:");
        NickelodeonDash.add(directorStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 529, -1, -1));

        pmStatus.setText("...");
        NickelodeonDash.add(pmStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 495, -1, -1));

        directorStatus.setText("...");
        NickelodeonDash.add(directorStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 529, -1, -1));

        gananciaLabelText.setText("Ganancias Totales:");
        NickelodeonDash.add(gananciaLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 51, -1, -1));

        costosLabelText.setText("Costos Totales:");
        NickelodeonDash.add(costosLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 76, -1, -1));

        costosLabelText1.setText("Utilidad Total:");
        NickelodeonDash.add(costosLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 96, -1, -1));

        gananciasLabel.setText("0");
        NickelodeonDash.add(gananciasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 51, -1, -1));

        costosLabel.setText("0");
        NickelodeonDash.add(costosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 76, -1, -1));

        utilidadesLabel.setText("0");
        NickelodeonDash.add(utilidadesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 96, -1, -1));

        deadlineLabelText.setText("Deadline:");
        NickelodeonDash.add(deadlineLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 148, -1, -1));

        deadlineLabel.setText("0");
        NickelodeonDash.add(deadlineLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 148, -1, -1));

        faultsLabelText.setText("Faltas del Project Manager:");
        NickelodeonDash.add(faultsLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 495, -1, -1));

        faultsLabel.setText("0");
        NickelodeonDash.add(faultsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 495, -1, -1));

        discountedLabelText.setText("Dinero Descontado al Project Manager:");
        NickelodeonDash.add(discountedLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 523, -1, -1));

        discountedLabel.setText("0");
        NickelodeonDash.add(discountedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 523, -1, -1));

        jLabel1.setText("Dias totales transcurridos:");
        NickelodeonDash.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 189, -1, -1));

        daysPassedLabelN.setText("0");
        NickelodeonDash.add(daysPassedLabelN, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 189, -1, -1));

        jTabbedPane1.addTab("Nickelodeon", NickelodeonDash);

        DisneyDash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Directores Ejecutivos:");
        DisneyDash.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 502, -1, -1));

        qttyProjectsManagersNick1.setText("1");
        DisneyDash.add(qttyProjectsManagersNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 468, -1, -1));

        qttyPlotTwistsMaxNick1.setText("10");
        DisneyDash.add(qttyPlotTwistsMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 283, -1, -1));

        capsPlotTwistReadyLabel1.setText("Capitulos PlotTwists Listos:");
        DisneyDash.add(capsPlotTwistReadyLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 428, -1, -1));

        capsReadyLabel1.setText("Capitulos Standar Listos:");
        DisneyDash.add(capsReadyLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 394, -1, -1));

        qttyStandardCapsReadyDisney.setText("0");
        DisneyDash.add(qttyStandardCapsReadyDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 394, -1, -1));

        qttyPlotTwistsCapsReadyDisney.setText("0");
        DisneyDash.add(qttyPlotTwistsCapsReadyDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 428, -1, -1));

        pmStatusLabelD.setText("Project Manager Status:");
        DisneyDash.add(pmStatusLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 468, -1, -1));

        directorStatusLabelD.setText("Director Status:");
        DisneyDash.add(directorStatusLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 502, -1, -1));

        qttyDirectoresNick1.setText("1");
        DisneyDash.add(qttyDirectoresNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 502, -1, -1));

        pmStatusDisney.setText("...");
        DisneyDash.add(pmStatusDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 468, -1, -1));

        GuionesSavedLabelD.setText("Guiones en el Drive:");
        DisneyDash.add(GuionesSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 66, -1, -1));

        directorStatusDisney.setText("...");
        DisneyDash.add(directorStatusDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 502, -1, -1));

        qttyGuionesSavedDisney.setText("0");
        DisneyDash.add(qttyGuionesSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 66, -1, -1));

        gananciaLabelText1.setText("Ganancias Totales:");
        DisneyDash.add(gananciaLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 51, -1, -1));

        GuionesMaxLabelD.setText("Capacidad Máx:");
        DisneyDash.add(GuionesMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 64, -1, -1));

        qttyGuionesMaxNick1.setText("25");
        DisneyDash.add(qttyGuionesMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 64, -1, -1));

        EscenariosSavedLabelD.setText("Escenarios en el Drive:");
        DisneyDash.add(EscenariosSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 116, -1, -1));

        qttyEscenariosSavedDisney.setText("0");
        DisneyDash.add(qttyEscenariosSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 116, -1, -1));

        EscenariosMaxLabelD.setText("Capacidad Máx:");
        DisneyDash.add(EscenariosMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 113, -1, -1));

        qttyEscenariosMaxNick1.setText("20");
        DisneyDash.add(qttyEscenariosMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 113, -1, -1));

        AnimacionesSavedLabelD.setText("Animaciones en el Drive:");
        DisneyDash.add(AnimacionesSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 167, -1, -1));

        costosLabelText2.setText("Costos Totales:");
        DisneyDash.add(costosLabelText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 76, -1, -1));

        costosLabelText3.setText("Utilidad Total:");
        DisneyDash.add(costosLabelText3, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 96, -1, -1));

        gananciasLabelDisney.setText("0");
        DisneyDash.add(gananciasLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 51, -1, -1));

        costosLabelDisney.setText("0");
        DisneyDash.add(costosLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 76, -1, -1));

        utilidadesLabelDisney.setText("0");
        DisneyDash.add(utilidadesLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 96, -1, -1));

        deadlineLabelText1.setText("Deadline:");
        DisneyDash.add(deadlineLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 148, -1, -1));

        deadlineLabelDisney.setText("0");
        DisneyDash.add(deadlineLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(691, 148, -1, -1));

        faultsLabelText1.setText("Faltas del Project Manager:");
        DisneyDash.add(faultsLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 468, -1, -1));

        faultsLabelDisney.setText("0");
        DisneyDash.add(faultsLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 468, -1, -1));

        discountedLabelText1.setText("Dinero Descontado al Project Manager:");
        DisneyDash.add(discountedLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 496, -1, -1));

        jLabel6.setText("DISNEY");
        DisneyDash.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 17, -1, -1));

        guionistasLabelDisney.setText("Guionistas:");
        DisneyDash.add(guionistasLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 66, -1, -1));

        escenariosLabelDisney.setText("Diseñador de escenarios:");
        DisneyDash.add(escenariosLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 116, -1, -1));

        animadorLabelDisney.setText("Animador de personajes:");
        DisneyDash.add(animadorLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 167, -1, -1));

        doblajeLabelDisney.setText("Actores de doblaje:");
        DisneyDash.add(doblajeLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 226, -1, -1));

        plotTwistLabelDisney.setText("Guionista de PlotTwist:");
        DisneyDash.add(plotTwistLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 283, -1, -1));

        ensambladorLabelDisney.setText("Ensambladores:");
        DisneyDash.add(ensambladorLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 336, -1, -1));

        qttyGuionistasDisney.setText("0");
        DisneyDash.add(qttyGuionistasDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 66, -1, -1));

        discountedLabelDisney.setText("0");
        DisneyDash.add(discountedLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(749, 496, -1, -1));

        qttyEscenariosDisney.setText("0");
        DisneyDash.add(qttyEscenariosDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 116, -1, -1));

        qttyAnimadoresDisney.setText("0");
        DisneyDash.add(qttyAnimadoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 167, -1, -1));

        qttyDobladoresDisney.setText("0");
        DisneyDash.add(qttyDobladoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 226, -1, -1));

        qttyGuionistasPlotTwistsDisney.setText("0");
        DisneyDash.add(qttyGuionistasPlotTwistsDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 283, -1, -1));

        qttyEnsambladoresDisney.setText("0");
        DisneyDash.add(qttyEnsambladoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 336, -1, -1));

        removeGuionistaDisney.setText("-");
        removeGuionistaDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionistaDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(removeGuionistaDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 63, -1, -1));

        addGuionistaDisney.setText("+");
        addGuionistaDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionistaDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(addGuionistaDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 63, -1, -1));

        removeEscenariosDisney.setText("-");
        removeEscenariosDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenariosDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(removeEscenariosDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 113, -1, -1));

        addEscenariosDisney.setText("+");
        addEscenariosDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenariosDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(addEscenariosDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 113, -1, -1));

        removeAnimadorDisney.setText("-");
        removeAnimadorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimadorDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(removeAnimadorDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 164, -1, -1));

        qttyAnimacionesSavedDisney.setText("0");
        DisneyDash.add(qttyAnimacionesSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 167, -1, -1));

        AnimacionesMaxLabelD.setText("Capacidad Máx:");
        DisneyDash.add(AnimacionesMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 167, -1, -1));

        qttyAnimacionesMaxNick1.setText("55");
        DisneyDash.add(qttyAnimacionesMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 167, -1, -1));

        doblajesSavedLabelD.setText("Doblajes en el Drive:");
        DisneyDash.add(doblajesSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 226, -1, -1));

        qttyDoblajesSavedDisney.setText("0");
        DisneyDash.add(qttyDoblajesSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 226, -1, -1));

        doblajesMaxLabelD.setText("Capacidad Máx:");
        DisneyDash.add(doblajesMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 226, -1, -1));

        qttyDoblajesMaxNick1.setText("35");
        DisneyDash.add(qttyDoblajesMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 226, -1, -1));

        addAnimadorDisney.setText("+");
        addAnimadorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimadorDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(addAnimadorDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 164, -1, -1));

        plotTwistsSavedLabelD.setText("PlotTwists en el Drive:");
        DisneyDash.add(plotTwistsSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 283, -1, -1));

        removeDoblajeDisney.setText("-");
        removeDoblajeDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblajeDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(removeDoblajeDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 223, -1, -1));

        qttyPlotTwistsSavedDisney.setText("0");
        DisneyDash.add(qttyPlotTwistsSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 283, -1, -1));

        addDoblajeDisney.setText("+");
        addDoblajeDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblajeDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(addDoblajeDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 223, -1, -1));

        plotTwistsMaxLabelD.setText("Capacidad Máx:");
        DisneyDash.add(plotTwistsMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 283, -1, -1));

        removePlotTwistDisney.setText("-");
        removePlotTwistDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwistDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(removePlotTwistDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 280, -1, -1));

        addPlotTwistDisney.setText("+");
        addPlotTwistDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwistDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(addPlotTwistDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 280, -1, -1));

        removeEnsambladorDisney.setText("-");
        removeEnsambladorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsambladorDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(removeEnsambladorDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 333, -1, -1));

        addEnsambladorDisney.setText("+");
        addEnsambladorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsambladorDisneyActionPerformed(evt);
            }
        });
        DisneyDash.add(addEnsambladorDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 333, -1, -1));

        jLabel7.setText("Projects Managers:");
        DisneyDash.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 468, -1, -1));

        jLabel8.setText("Dias totales transcurridos:");
        DisneyDash.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 182, -1, -1));

        daysPassedLabelD.setText("0");
        DisneyDash.add(daysPassedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 182, -1, -1));

        jTabbedPane1.addTab("DisneyChannel", DisneyDash);

        NickVSDisney.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        NickVSDisney.add(Grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 88, -1, -1));

        jLabel9.setText("Dias totales transcurridos:");
        NickVSDisney.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 25, -1, -1));

        daysPassedLabelGrafico.setText("0");
        NickVSDisney.add(daysPassedLabelGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 25, -1, -1));

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
