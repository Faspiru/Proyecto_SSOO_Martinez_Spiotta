/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Company;
import Clases.GraphManager;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author fabriziospiotta
 */
public class MainInterface extends javax.swing.JFrame {
    
    static Company nickelodeon;
    static Company disney;

    /**
     * Creates new form PruebaTabbed
     */
    public MainInterface(Company nickelodeon, Company disney, int[] initialQuantitiesN, int []initialQuantitiesD) {
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
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NickelodeonDash = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        faultsLabelText = new javax.swing.JLabel();
        faultsLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        qttyProjectsManagersNick = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        qttyDirectoresNick = new javax.swing.JLabel();
        pmStatusLabel = new javax.swing.JLabel();
        pmStatus = new javax.swing.JLabel();
        directorStatusLabel = new javax.swing.JLabel();
        directorStatus = new javax.swing.JLabel();
        ensambladorLabel = new javax.swing.JLabel();
        guionistasLabel = new javax.swing.JLabel();
        escenariosLabel = new javax.swing.JLabel();
        animadorLabel = new javax.swing.JLabel();
        doblajeLabel = new javax.swing.JLabel();
        plotTwistLabel = new javax.swing.JLabel();
        removeEnsamblador = new javax.swing.JButton();
        removePlotTwist = new javax.swing.JButton();
        removeDoblaje = new javax.swing.JButton();
        removeAnimador = new javax.swing.JButton();
        removeEscenarios = new javax.swing.JButton();
        removeGuionista = new javax.swing.JButton();
        qttyGuionistasNick = new javax.swing.JLabel();
        addGuionista = new javax.swing.JButton();
        addEscenarios = new javax.swing.JButton();
        qttyEscenariosNick = new javax.swing.JLabel();
        qttyAnimadoresNick = new javax.swing.JLabel();
        qttyDobladoresNick = new javax.swing.JLabel();
        qttyGuionistasPlotTwistsNick = new javax.swing.JLabel();
        qttyEnsambladoresNick = new javax.swing.JLabel();
        addEnsamblador = new javax.swing.JButton();
        addPlotTwist = new javax.swing.JButton();
        addDoblaje = new javax.swing.JButton();
        addAnimador = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        capsReadyLabel = new javax.swing.JLabel();
        qttyStandardCapsReadyNick = new javax.swing.JLabel();
        qttyPlotTwistsCapsReadyNick = new javax.swing.JLabel();
        capsPlotTwistReadyLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        discountedLabelText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        deadlineLabelText = new javax.swing.JLabel();
        costosLabelText1 = new javax.swing.JLabel();
        costosLabelText = new javax.swing.JLabel();
        gananciaLabelText = new javax.swing.JLabel();
        gananciasLabel = new javax.swing.JLabel();
        costosLabel = new javax.swing.JLabel();
        utilidadesLabel = new javax.swing.JLabel();
        deadlineLabel = new javax.swing.JLabel();
        daysPassedLabelN = new javax.swing.JLabel();
        discountedLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DisneyDash = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        gananciaLabelText1 = new javax.swing.JLabel();
        costosLabelText2 = new javax.swing.JLabel();
        costosLabelText3 = new javax.swing.JLabel();
        gananciasLabelDisney = new javax.swing.JLabel();
        costosLabelDisney = new javax.swing.JLabel();
        utilidadesLabelDisney = new javax.swing.JLabel();
        deadlineLabelText1 = new javax.swing.JLabel();
        deadlineLabelDisney = new javax.swing.JLabel();
        discountedLabelText1 = new javax.swing.JLabel();
        discountedLabelDisney = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        daysPassedLabelD = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        qttyPlotTwistsMaxNick1 = new javax.swing.JLabel();
        capsPlotTwistReadyLabel1 = new javax.swing.JLabel();
        capsReadyLabel1 = new javax.swing.JLabel();
        qttyStandardCapsReadyDisney = new javax.swing.JLabel();
        qttyPlotTwistsCapsReadyDisney = new javax.swing.JLabel();
        GuionesSavedLabelD = new javax.swing.JLabel();
        qttyGuionesSavedDisney = new javax.swing.JLabel();
        GuionesMaxLabelD = new javax.swing.JLabel();
        qttyGuionesMaxNick1 = new javax.swing.JLabel();
        EscenariosSavedLabelD = new javax.swing.JLabel();
        qttyEscenariosSavedDisney = new javax.swing.JLabel();
        EscenariosMaxLabelD = new javax.swing.JLabel();
        qttyEscenariosMaxNick1 = new javax.swing.JLabel();
        AnimacionesSavedLabelD = new javax.swing.JLabel();
        qttyAnimacionesSavedDisney = new javax.swing.JLabel();
        AnimacionesMaxLabelD = new javax.swing.JLabel();
        qttyAnimacionesMaxNick1 = new javax.swing.JLabel();
        doblajesSavedLabelD = new javax.swing.JLabel();
        qttyDoblajesSavedDisney = new javax.swing.JLabel();
        doblajesMaxLabelD = new javax.swing.JLabel();
        qttyDoblajesMaxNick1 = new javax.swing.JLabel();
        plotTwistsSavedLabelD = new javax.swing.JLabel();
        qttyPlotTwistsSavedDisney = new javax.swing.JLabel();
        plotTwistsMaxLabelD = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        qttyProjectsManagersNick1 = new javax.swing.JLabel();
        pmStatusLabelD = new javax.swing.JLabel();
        directorStatusLabelD = new javax.swing.JLabel();
        qttyDirectoresNick1 = new javax.swing.JLabel();
        pmStatusDisney = new javax.swing.JLabel();
        directorStatusDisney = new javax.swing.JLabel();
        faultsLabelText1 = new javax.swing.JLabel();
        faultsLabelDisney = new javax.swing.JLabel();
        guionistasLabelDisney = new javax.swing.JLabel();
        escenariosLabelDisney = new javax.swing.JLabel();
        animadorLabelDisney = new javax.swing.JLabel();
        doblajeLabelDisney = new javax.swing.JLabel();
        plotTwistLabelDisney = new javax.swing.JLabel();
        ensambladorLabelDisney = new javax.swing.JLabel();
        qttyGuionistasDisney = new javax.swing.JLabel();
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
        addAnimadorDisney = new javax.swing.JButton();
        removeDoblajeDisney = new javax.swing.JButton();
        addDoblajeDisney = new javax.swing.JButton();
        removePlotTwistDisney = new javax.swing.JButton();
        addPlotTwistDisney = new javax.swing.JButton();
        removeEnsambladorDisney = new javax.swing.JButton();
        addEnsambladorDisney = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        dinseyFondo = new javax.swing.JLabel();
        NickVSDisney = new javax.swing.JPanel();
        Grafico = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        daysPassedLabelGrafico = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ConfigurationDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        plotTwistLabel1.setForeground(new java.awt.Color(204, 204, 204));
        plotTwistLabel1.setText("Guionista de PlotTwist:");
        ConfigurationDashboard.add(plotTwistLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        removePlotTwist1.setText("-");
        removePlotTwist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwist1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removePlotTwist1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        addDoblaje1.setText("+");
        addDoblaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblaje1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addDoblaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        addAnimador1.setText("+");
        addAnimador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addAnimador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        GuionistasPlotTwistsNick.setForeground(new java.awt.Color(255, 255, 255));
        GuionistasPlotTwistsNick.setText("0");
        ConfigurationDashboard.add(GuionistasPlotTwistsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        removeAnimador1.setText("-");
        removeAnimador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeAnimador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        animadorLabel1.setForeground(new java.awt.Color(204, 204, 204));
        animadorLabel1.setText("Animador de personajes:");
        ConfigurationDashboard.add(animadorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        addPlotTwist1.setText("+");
        addPlotTwist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwist1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addPlotTwist1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, -1));

        AnimadoresNick.setForeground(new java.awt.Color(255, 255, 255));
        AnimadoresNick.setText("0");
        ConfigurationDashboard.add(AnimadoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        EnsambladoresNick.setForeground(new java.awt.Color(255, 255, 255));
        EnsambladoresNick.setText("0");
        ConfigurationDashboard.add(EnsambladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, -1));

        addEnsamblador1.setText("+");
        addEnsamblador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsamblador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEnsamblador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        removeDoblaje1.setText("-");
        removeDoblaje1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblaje1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeDoblaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        guionistasLabel1.setForeground(new java.awt.Color(204, 204, 204));
        guionistasLabel1.setText("Guionistas:");
        ConfigurationDashboard.add(guionistasLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        EscenariosNick.setForeground(new java.awt.Color(255, 255, 255));
        EscenariosNick.setText("0");
        ConfigurationDashboard.add(EscenariosNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        removeEscenarios1.setText("-");
        removeEscenarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenarios1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEscenarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        removeGuionista2.setText("-");
        removeGuionista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionista2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeGuionista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        addGuionista2.setText("+");
        addGuionista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionista2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addGuionista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        doblajeLabel1.setForeground(new java.awt.Color(204, 204, 204));
        doblajeLabel1.setText("Actores de doblaje:");
        ConfigurationDashboard.add(doblajeLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        DobladoresNick.setForeground(new java.awt.Color(255, 255, 255));
        DobladoresNick.setText("0");
        ConfigurationDashboard.add(DobladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        ensambladorLabel1.setForeground(new java.awt.Color(204, 204, 204));
        ensambladorLabel1.setText("Ensambladores:");
        ConfigurationDashboard.add(ensambladorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        addEscenarios1.setText("+");
        addEscenarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenarios1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEscenarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        removeEnsamblador1.setText("-");
        removeEnsamblador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsamblador1ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEnsamblador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, -1, -1));

        GuionistasNick.setForeground(new java.awt.Color(255, 255, 255));
        GuionistasNick.setText("0");
        ConfigurationDashboard.add(GuionistasNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        escenariosLabel1.setForeground(new java.awt.Color(204, 204, 204));
        escenariosLabel1.setText("Diseñador de escenarios:");
        ConfigurationDashboard.add(escenariosLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        guionistasLabel2.setForeground(new java.awt.Color(204, 204, 204));
        guionistasLabel2.setText("Guionistas:");
        ConfigurationDashboard.add(guionistasLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, -1, -1));

        removeGuionista3.setText("-");
        removeGuionista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionista3ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeGuionista3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, -1));

        escenariosLabel2.setForeground(new java.awt.Color(204, 204, 204));
        escenariosLabel2.setText("Diseñador de escenarios:");
        ConfigurationDashboard.add(escenariosLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, -1, -1));

        animadorLabel2.setForeground(new java.awt.Color(204, 204, 204));
        animadorLabel2.setText("Animador de personajes:");
        ConfigurationDashboard.add(animadorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, -1));

        doblajeLabel2.setForeground(new java.awt.Color(204, 204, 204));
        doblajeLabel2.setText("Actores de doblaje:");
        ConfigurationDashboard.add(doblajeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, -1, -1));

        plotTwistLabel2.setForeground(new java.awt.Color(204, 204, 204));
        plotTwistLabel2.setText("Guionista de PlotTwist:");
        ConfigurationDashboard.add(plotTwistLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, -1, -1));

        ensambladorLabel2.setForeground(new java.awt.Color(204, 204, 204));
        ensambladorLabel2.setText("Ensambladores:");
        ConfigurationDashboard.add(ensambladorLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, -1, -1));

        removeEnsamblador2.setText("-");
        removeEnsamblador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsamblador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEnsamblador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, -1, -1));

        EnsambladoresDisney.setForeground(new java.awt.Color(255, 255, 255));
        EnsambladoresDisney.setText("0");
        ConfigurationDashboard.add(EnsambladoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, -1, -1));

        addEnsamblador2.setText("+");
        addEnsamblador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsamblador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEnsamblador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, -1, -1));

        addPlotTwist2.setText("+");
        addPlotTwist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwist2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addPlotTwist2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, -1, -1));

        GuionistasPlotTwistsDisney.setForeground(new java.awt.Color(255, 255, 255));
        GuionistasPlotTwistsDisney.setText("0");
        ConfigurationDashboard.add(GuionistasPlotTwistsDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, -1, -1));

        removePlotTwist2.setText("-");
        removePlotTwist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwist2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removePlotTwist2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, -1, -1));

        removeDoblaje2.setText("-");
        removeDoblaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblaje2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeDoblaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, -1, -1));

        removeAnimador2.setText("-");
        removeAnimador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeAnimador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, -1, -1));

        removeEscenarios2.setText("-");
        removeEscenarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenarios2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeEscenarios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, -1, -1));

        GuionistasDisney.setForeground(new java.awt.Color(255, 255, 255));
        GuionistasDisney.setText("0");
        ConfigurationDashboard.add(GuionistasDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, -1, -1));

        EscenariosDisney.setForeground(new java.awt.Color(255, 255, 255));
        EscenariosDisney.setText("0");
        ConfigurationDashboard.add(EscenariosDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, -1, -1));

        AnimadoresDisney.setForeground(new java.awt.Color(255, 255, 255));
        AnimadoresDisney.setText("0");
        ConfigurationDashboard.add(AnimadoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 260, -1, -1));

        DobladoresDisney.setForeground(new java.awt.Color(255, 255, 255));
        DobladoresDisney.setText("0");
        ConfigurationDashboard.add(DobladoresDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 310, -1, -1));

        addDoblaje2.setText("+");
        addDoblaje2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblaje2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addDoblaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 310, -1, -1));

        addAnimador2.setText("+");
        addAnimador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimador2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addAnimador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, -1, -1));

        addEscenarios2.setText("+");
        addEscenarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenarios2ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addEscenarios2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 210, -1, -1));

        addGuionista3.setText("+");
        addGuionista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionista3ActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addGuionista3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, -1, -1));

        dayDuration.setForeground(new java.awt.Color(204, 204, 204));
        dayDuration.setText("Duracion de un dia");
        ConfigurationDashboard.add(dayDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        removeDia.setText("-");
        removeDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDiaActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, -1, -1));

        dia.setForeground(new java.awt.Color(255, 255, 255));
        dia.setText("0");
        ConfigurationDashboard.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        addDia.setText("+");
        addDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDiaActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, -1, -1));

        deadline.setForeground(new java.awt.Color(204, 204, 204));
        deadline.setText("Deadline");
        ConfigurationDashboard.add(deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        removeAmmount.setText("-");
        removeAmmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAmmountActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(removeAmmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        ammount.setForeground(new java.awt.Color(255, 255, 255));
        ammount.setText("0");
        ConfigurationDashboard.add(ammount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        addAmmount.setText("+");
        addAmmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAmmountActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(addAmmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        txt.setBackground(new java.awt.Color(51, 51, 51));
        txt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt.setForeground(new java.awt.Color(204, 204, 204));
        txt.setText("Guardar");
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });
        ConfigurationDashboard.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NickelodeonLogoTiny.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel18)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(323, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(17, 17, 17))
        );

        ConfigurationDashboard.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 320, 400));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoDisneyTiny.png"))); // NOI18N
        jLabel19.setText("Disney");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 306, Short.MAX_VALUE)
                .addComponent(jLabel19))
        );

        ConfigurationDashboard.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 320, 400));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        ConfigurationDashboard.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 290, 130));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Configuracion");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(33, 33, 33))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConfigurationDashboard.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 340, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Configuracion.png"))); // NOI18N
        ConfigurationDashboard.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jTabbedPane1.addTab("ConfigurationDashboard", ConfigurationDashboard);

        NickelodeonDash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/NickelodeonLogo.png"))); // NOI18N
        NickelodeonDash.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 130));

        GuionesSavedLabel.setText("Guiones en el Drive:");
        NickelodeonDash.add(GuionesSavedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        qttyGuionesSavedNick.setText("0");
        NickelodeonDash.add(qttyGuionesSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        GuionesMaxLabel.setText("Capacidad Máx:");
        NickelodeonDash.add(GuionesMaxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, -1, -1));

        qttyGuionesMaxNick.setText("25");
        NickelodeonDash.add(qttyGuionesMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));

        EscenariosSavedLabel.setText("Escenarios en el Drive:");
        NickelodeonDash.add(EscenariosSavedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));

        qttyEscenariosSavedNick.setText("0");
        NickelodeonDash.add(qttyEscenariosSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, -1, -1));

        EscenariosMaxLabel.setText("Capacidad Máx:");
        NickelodeonDash.add(EscenariosMaxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, -1, -1));

        qttyEscenariosMaxNick.setText("20");
        NickelodeonDash.add(qttyEscenariosMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, -1, -1));

        AnimacionesSavedLabel.setText("Animaciones en el Drive:");
        NickelodeonDash.add(AnimacionesSavedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        qttyAnimacionesSavedNick.setText("0");
        NickelodeonDash.add(qttyAnimacionesSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));

        AnimacionesMaxLabel2.setText("Capacidad Máx:");
        NickelodeonDash.add(AnimacionesMaxLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, -1, -1));

        qttyAnimacionesMaxNick.setText("55");
        NickelodeonDash.add(qttyAnimacionesMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 330, -1, -1));

        doblajesSavedLabel3.setText("Doblajes en el Drive:");
        NickelodeonDash.add(doblajesSavedLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, -1));

        qttyDoblajesSavedNick.setText("0");
        NickelodeonDash.add(qttyDoblajesSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, -1, -1));

        doblajesMaxLabel3.setText("Capacidad Máx:");
        NickelodeonDash.add(doblajesMaxLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, -1, -1));

        qttyDoblajesMaxNick.setText("35");
        NickelodeonDash.add(qttyDoblajesMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, -1, -1));

        plotTwistsSavedLabel4.setText("PlotTwists en el Drive:");
        NickelodeonDash.add(plotTwistsSavedLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, -1));

        qttyPlotTwistsSavedNick.setText("0");
        NickelodeonDash.add(qttyPlotTwistsSavedNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));

        plotTwistsMaxLabel4.setText("Capacidad Máx:");
        NickelodeonDash.add(plotTwistsMaxLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, -1, -1));

        qttyPlotTwistsMaxNick.setText("10");
        NickelodeonDash.add(qttyPlotTwistsMaxNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        faultsLabelText.setText("Faltas del Project Manager:");
        jPanel1.add(faultsLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        faultsLabel.setText("0");
        jPanel1.add(faultsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, -1));

        jLabel3.setText("Projects Managers:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        qttyProjectsManagersNick.setText("1");
        jPanel1.add(qttyProjectsManagersNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        jLabel4.setText("Directores Ejecutivos:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        qttyDirectoresNick.setText("1");
        jPanel1.add(qttyDirectoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        pmStatusLabel.setText("Project Manager Status:");
        jPanel1.add(pmStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        pmStatus.setText("...");
        jPanel1.add(pmStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        directorStatusLabel.setText("Director Status:");
        jPanel1.add(directorStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        directorStatus.setText("...");
        jPanel1.add(directorStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        ensambladorLabel.setText("Ensambladores:");
        jPanel1.add(ensambladorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        guionistasLabel.setText("Guionistas:");
        jPanel1.add(guionistasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        escenariosLabel.setText("Diseñador de escenarios:");
        jPanel1.add(escenariosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        animadorLabel.setText("Animador de personajes:");
        jPanel1.add(animadorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        doblajeLabel.setText("Actores de doblaje:");
        jPanel1.add(doblajeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        plotTwistLabel.setText("Guionista de PlotTwist:");
        jPanel1.add(plotTwistLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        removeEnsamblador.setText("-");
        removeEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnsambladorActionPerformed(evt);
            }
        });
        jPanel1.add(removeEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        removePlotTwist.setText("-");
        removePlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePlotTwistActionPerformed(evt);
            }
        });
        jPanel1.add(removePlotTwist, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        removeDoblaje.setText("-");
        removeDoblaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblajeActionPerformed(evt);
            }
        });
        jPanel1.add(removeDoblaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        removeAnimador.setText("-");
        removeAnimador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAnimadorActionPerformed(evt);
            }
        });
        jPanel1.add(removeAnimador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        removeEscenarios.setText("-");
        removeEscenarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEscenariosActionPerformed(evt);
            }
        });
        jPanel1.add(removeEscenarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        removeGuionista.setText("-");
        removeGuionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeGuionistaActionPerformed(evt);
            }
        });
        jPanel1.add(removeGuionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        qttyGuionistasNick.setText("0");
        jPanel1.add(qttyGuionistasNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        addGuionista.setText("+");
        addGuionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGuionistaActionPerformed(evt);
            }
        });
        jPanel1.add(addGuionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        addEscenarios.setText("+");
        addEscenarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEscenariosActionPerformed(evt);
            }
        });
        jPanel1.add(addEscenarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        qttyEscenariosNick.setText("0");
        jPanel1.add(qttyEscenariosNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        qttyAnimadoresNick.setText("0");
        jPanel1.add(qttyAnimadoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        qttyDobladoresNick.setText("0");
        jPanel1.add(qttyDobladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        qttyGuionistasPlotTwistsNick.setText("0");
        jPanel1.add(qttyGuionistasPlotTwistsNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        qttyEnsambladoresNick.setText("0");
        jPanel1.add(qttyEnsambladoresNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        addEnsamblador.setText("+");
        addEnsamblador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnsambladorActionPerformed(evt);
            }
        });
        jPanel1.add(addEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        addPlotTwist.setText("+");
        addPlotTwist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlotTwistActionPerformed(evt);
            }
        });
        jPanel1.add(addPlotTwist, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        addDoblaje.setText("+");
        addDoblaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblajeActionPerformed(evt);
            }
        });
        jPanel1.add(addDoblaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, -1));

        addAnimador.setText("+");
        addAnimador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimadorActionPerformed(evt);
            }
        });
        jPanel1.add(addAnimador, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        jPanel5.setBackground(new java.awt.Color(232, 114, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, -1));

        jLabel14.setBackground(new java.awt.Color(232, 114, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(232, 114, 0));
        jLabel14.setText("Trabajadores");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 190, -1));

        jPanel7.setBackground(new java.awt.Color(19, 139, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanel8.setBackground(new java.awt.Color(232, 114, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 330, 10));

        NickelodeonDash.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 540));

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(42, 140, 35));
        jLabel13.setText("Drive");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(19, 139, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 310, 10));

        capsReadyLabel.setText("Capitulos Standar Listos:");
        jPanel2.add(capsReadyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        qttyStandardCapsReadyNick.setText("0");
        jPanel2.add(qttyStandardCapsReadyNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        qttyPlotTwistsCapsReadyNick.setText("0");
        jPanel2.add(qttyPlotTwistsCapsReadyNick, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        capsPlotTwistReadyLabel.setText("Capitulos PlotTwists Listos:");
        jPanel2.add(capsPlotTwistReadyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gary.png"))); // NOI18N
        jLabel16.setText("jLabel16");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 190, 130));

        NickelodeonDash.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 330, 400));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        discountedLabelText.setText("Dinero Descontado al PM:");
        jPanel3.add(discountedLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel1.setText("Dias totales transcurridos:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        deadlineLabelText.setText("Deadline:");
        jPanel3.add(deadlineLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        costosLabelText1.setText("Utilidad Total:");
        jPanel3.add(costosLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        costosLabelText.setText("Costos Totales:");
        jPanel3.add(costosLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        gananciaLabelText.setText("Ganancias Totales:");
        jPanel3.add(gananciaLabelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        gananciasLabel.setText("0");
        jPanel3.add(gananciasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        costosLabel.setText("0");
        jPanel3.add(costosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        utilidadesLabel.setText("0");
        jPanel3.add(utilidadesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        deadlineLabel.setText("0");
        jPanel3.add(deadlineLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        daysPassedLabelN.setText("0");
        jPanel3.add(daysPassedLabelN, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        discountedLabel.setText("0");
        jPanel3.add(discountedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        jPanel6.setBackground(new java.awt.Color(149, 47, 250));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, 198, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 51, 255));
        jLabel15.setText("Estadisticas");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 6, 155, -1));

        NickelodeonDash.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 210, 300));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoBikini.png"))); // NOI18N
        NickelodeonDash.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1030, 600));

        jTabbedPane1.addTab("Nickelodeon", NickelodeonDash);

        DisneyDash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(34, 94, 135));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gananciaLabelText1.setBackground(new java.awt.Color(255, 255, 255));
        gananciaLabelText1.setForeground(new java.awt.Color(255, 255, 255));
        gananciaLabelText1.setText("Ganancias Totales:");
        jPanel17.add(gananciaLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        costosLabelText2.setBackground(new java.awt.Color(255, 255, 255));
        costosLabelText2.setForeground(new java.awt.Color(255, 255, 255));
        costosLabelText2.setText("Costos Totales:");
        jPanel17.add(costosLabelText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        costosLabelText3.setBackground(new java.awt.Color(255, 255, 255));
        costosLabelText3.setForeground(new java.awt.Color(255, 255, 255));
        costosLabelText3.setText("Utilidad Total:");
        jPanel17.add(costosLabelText3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        gananciasLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        gananciasLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        gananciasLabelDisney.setText("0");
        jPanel17.add(gananciasLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        costosLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        costosLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        costosLabelDisney.setText("0");
        jPanel17.add(costosLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        utilidadesLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        utilidadesLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        utilidadesLabelDisney.setText("0");
        jPanel17.add(utilidadesLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        deadlineLabelText1.setBackground(new java.awt.Color(255, 255, 255));
        deadlineLabelText1.setForeground(new java.awt.Color(255, 255, 255));
        deadlineLabelText1.setText("Deadline:");
        jPanel17.add(deadlineLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        deadlineLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        deadlineLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        deadlineLabelDisney.setText("0");
        jPanel17.add(deadlineLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        discountedLabelText1.setBackground(new java.awt.Color(255, 255, 255));
        discountedLabelText1.setForeground(new java.awt.Color(255, 255, 255));
        discountedLabelText1.setText("Dinero Descontado al PM:");
        jPanel17.add(discountedLabelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        discountedLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        discountedLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        discountedLabelDisney.setText("0");
        jPanel17.add(discountedLabelDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dias totales transcurridos:");
        jPanel17.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        daysPassedLabelD.setBackground(new java.awt.Color(255, 255, 255));
        daysPassedLabelD.setForeground(new java.awt.Color(255, 255, 255));
        daysPassedLabelD.setText("0");
        jPanel17.add(daysPassedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, -1, -1));

        jPanel18.setBackground(new java.awt.Color(185, 219, 253));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 198, -1));

        jLabel23.setBackground(new java.awt.Color(185, 219, 253));
        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(185, 219, 253));
        jLabel23.setText("Estadisticas");
        jPanel17.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 155, -1));

        DisneyDash.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 220, 300));

        jPanel15.setBackground(new java.awt.Color(56, 55, 125));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qttyPlotTwistsMaxNick1.setBackground(new java.awt.Color(255, 255, 255));
        qttyPlotTwistsMaxNick1.setForeground(new java.awt.Color(255, 255, 255));
        qttyPlotTwistsMaxNick1.setText("10");
        jPanel15.add(qttyPlotTwistsMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        capsPlotTwistReadyLabel1.setBackground(new java.awt.Color(255, 255, 255));
        capsPlotTwistReadyLabel1.setForeground(new java.awt.Color(255, 255, 255));
        capsPlotTwistReadyLabel1.setText("Capitulos PlotTwists Listos:");
        jPanel15.add(capsPlotTwistReadyLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        capsReadyLabel1.setBackground(new java.awt.Color(255, 255, 255));
        capsReadyLabel1.setForeground(new java.awt.Color(255, 255, 255));
        capsReadyLabel1.setText("Capitulos Standar Listos:");
        jPanel15.add(capsReadyLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        qttyStandardCapsReadyDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyStandardCapsReadyDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyStandardCapsReadyDisney.setText("0");
        jPanel15.add(qttyStandardCapsReadyDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        qttyPlotTwistsCapsReadyDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyPlotTwistsCapsReadyDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyPlotTwistsCapsReadyDisney.setText("0");
        jPanel15.add(qttyPlotTwistsCapsReadyDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        GuionesSavedLabelD.setBackground(new java.awt.Color(255, 255, 255));
        GuionesSavedLabelD.setForeground(new java.awt.Color(255, 255, 255));
        GuionesSavedLabelD.setText("Guiones en el Drive:");
        jPanel15.add(GuionesSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        qttyGuionesSavedDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyGuionesSavedDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyGuionesSavedDisney.setText("0");
        jPanel15.add(qttyGuionesSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        GuionesMaxLabelD.setBackground(new java.awt.Color(255, 255, 255));
        GuionesMaxLabelD.setForeground(new java.awt.Color(255, 255, 255));
        GuionesMaxLabelD.setText("Capacidad Máx:");
        jPanel15.add(GuionesMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        qttyGuionesMaxNick1.setBackground(new java.awt.Color(255, 255, 255));
        qttyGuionesMaxNick1.setForeground(new java.awt.Color(255, 255, 255));
        qttyGuionesMaxNick1.setText("25");
        jPanel15.add(qttyGuionesMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        EscenariosSavedLabelD.setBackground(new java.awt.Color(255, 255, 255));
        EscenariosSavedLabelD.setForeground(new java.awt.Color(255, 255, 255));
        EscenariosSavedLabelD.setText("Escenarios en el Drive:");
        jPanel15.add(EscenariosSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        qttyEscenariosSavedDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyEscenariosSavedDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyEscenariosSavedDisney.setText("0");
        jPanel15.add(qttyEscenariosSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        EscenariosMaxLabelD.setBackground(new java.awt.Color(255, 255, 255));
        EscenariosMaxLabelD.setForeground(new java.awt.Color(255, 255, 255));
        EscenariosMaxLabelD.setText("Capacidad Máx:");
        jPanel15.add(EscenariosMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        qttyEscenariosMaxNick1.setBackground(new java.awt.Color(255, 255, 255));
        qttyEscenariosMaxNick1.setForeground(new java.awt.Color(255, 255, 255));
        qttyEscenariosMaxNick1.setText("20");
        jPanel15.add(qttyEscenariosMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        AnimacionesSavedLabelD.setBackground(new java.awt.Color(255, 255, 255));
        AnimacionesSavedLabelD.setForeground(new java.awt.Color(255, 255, 255));
        AnimacionesSavedLabelD.setText("Animaciones en el Drive:");
        jPanel15.add(AnimacionesSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        qttyAnimacionesSavedDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyAnimacionesSavedDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyAnimacionesSavedDisney.setText("0");
        jPanel15.add(qttyAnimacionesSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        AnimacionesMaxLabelD.setBackground(new java.awt.Color(255, 255, 255));
        AnimacionesMaxLabelD.setForeground(new java.awt.Color(255, 255, 255));
        AnimacionesMaxLabelD.setText("Capacidad Máx:");
        jPanel15.add(AnimacionesMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        qttyAnimacionesMaxNick1.setBackground(new java.awt.Color(255, 255, 255));
        qttyAnimacionesMaxNick1.setForeground(new java.awt.Color(255, 255, 255));
        qttyAnimacionesMaxNick1.setText("55");
        jPanel15.add(qttyAnimacionesMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        doblajesSavedLabelD.setBackground(new java.awt.Color(255, 255, 255));
        doblajesSavedLabelD.setForeground(new java.awt.Color(255, 255, 255));
        doblajesSavedLabelD.setText("Doblajes en el Drive:");
        jPanel15.add(doblajesSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        qttyDoblajesSavedDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyDoblajesSavedDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyDoblajesSavedDisney.setText("0");
        jPanel15.add(qttyDoblajesSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        doblajesMaxLabelD.setBackground(new java.awt.Color(255, 255, 255));
        doblajesMaxLabelD.setForeground(new java.awt.Color(255, 255, 255));
        doblajesMaxLabelD.setText("Capacidad Máx:");
        jPanel15.add(doblajesMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        qttyDoblajesMaxNick1.setBackground(new java.awt.Color(255, 255, 255));
        qttyDoblajesMaxNick1.setForeground(new java.awt.Color(255, 255, 255));
        qttyDoblajesMaxNick1.setText("35");
        jPanel15.add(qttyDoblajesMaxNick1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        plotTwistsSavedLabelD.setBackground(new java.awt.Color(255, 255, 255));
        plotTwistsSavedLabelD.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistsSavedLabelD.setText("PlotTwists en el Drive:");
        jPanel15.add(plotTwistsSavedLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        qttyPlotTwistsSavedDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyPlotTwistsSavedDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyPlotTwistsSavedDisney.setText("0");
        jPanel15.add(qttyPlotTwistsSavedDisney, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        plotTwistsMaxLabelD.setBackground(new java.awt.Color(255, 255, 255));
        plotTwistsMaxLabelD.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistsMaxLabelD.setText("Capacidad Máx:");
        jPanel15.add(plotTwistsMaxLabelD, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        jLabel22.setBackground(new java.awt.Color(153, 0, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 255));
        jLabel22.setText("Drive");
        jPanel15.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jPanel16.setBackground(new java.awt.Color(153, 0, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, 10));
        jPanel15.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        DisneyDash.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 340, 420));

        jPanel13.setBackground(new java.awt.Color(7, 37, 57));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Directores Ejecutivos:");

        qttyProjectsManagersNick1.setBackground(new java.awt.Color(255, 255, 255));
        qttyProjectsManagersNick1.setForeground(new java.awt.Color(255, 255, 255));
        qttyProjectsManagersNick1.setText("1");

        pmStatusLabelD.setBackground(new java.awt.Color(255, 255, 255));
        pmStatusLabelD.setForeground(new java.awt.Color(255, 255, 255));
        pmStatusLabelD.setText("Project Manager Status:");

        directorStatusLabelD.setBackground(new java.awt.Color(255, 255, 255));
        directorStatusLabelD.setForeground(new java.awt.Color(255, 255, 255));
        directorStatusLabelD.setText("Director Status:");

        qttyDirectoresNick1.setBackground(new java.awt.Color(255, 255, 255));
        qttyDirectoresNick1.setForeground(new java.awt.Color(255, 255, 255));
        qttyDirectoresNick1.setText("1");

        pmStatusDisney.setBackground(new java.awt.Color(255, 255, 255));
        pmStatusDisney.setForeground(new java.awt.Color(255, 255, 255));
        pmStatusDisney.setText("...");

        directorStatusDisney.setBackground(new java.awt.Color(255, 255, 255));
        directorStatusDisney.setForeground(new java.awt.Color(255, 255, 255));
        directorStatusDisney.setText("...");

        faultsLabelText1.setBackground(new java.awt.Color(255, 255, 255));
        faultsLabelText1.setForeground(new java.awt.Color(255, 255, 255));
        faultsLabelText1.setText("Faltas del Project Manager:");

        faultsLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        faultsLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        faultsLabelDisney.setText("0");

        guionistasLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        guionistasLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        guionistasLabelDisney.setText("Guionistas:");

        escenariosLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        escenariosLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        escenariosLabelDisney.setText("Diseñador de escenarios:");

        animadorLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        animadorLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        animadorLabelDisney.setText("Animador de personajes:");

        doblajeLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        doblajeLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        doblajeLabelDisney.setText("Actores de doblaje:");

        plotTwistLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        plotTwistLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        plotTwistLabelDisney.setText("Guionista de PlotTwist:");

        ensambladorLabelDisney.setBackground(new java.awt.Color(255, 255, 255));
        ensambladorLabelDisney.setForeground(new java.awt.Color(255, 255, 255));
        ensambladorLabelDisney.setText("Ensambladores:");

        qttyGuionistasDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyGuionistasDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyGuionistasDisney.setText("0");

        qttyEscenariosDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyEscenariosDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyEscenariosDisney.setText("0");

        qttyAnimadoresDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyAnimadoresDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyAnimadoresDisney.setText("0");

        qttyDobladoresDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyDobladoresDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyDobladoresDisney.setText("0");

        qttyGuionistasPlotTwistsDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyGuionistasPlotTwistsDisney.setForeground(new java.awt.Color(255, 255, 255));
        qttyGuionistasPlotTwistsDisney.setText("0");

        qttyEnsambladoresDisney.setBackground(new java.awt.Color(255, 255, 255));
        qttyEnsambladoresDisney.setForeground(new java.awt.Color(255, 255, 255));
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

        addAnimadorDisney.setText("+");
        addAnimadorDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnimadorDisneyActionPerformed(evt);
            }
        });

        removeDoblajeDisney.setText("-");
        removeDoblajeDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDoblajeDisneyActionPerformed(evt);
            }
        });

        addDoblajeDisney.setText("+");
        addDoblajeDisney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoblajeDisneyActionPerformed(evt);
            }
        });

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

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Projects Managers:");

        jLabel20.setBackground(new java.awt.Color(147, 193, 252));
        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(147, 193, 252));
        jLabel20.setText("Trabajadores");

        jPanel14.setBackground(new java.awt.Color(147, 193, 252));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(animadorLabelDisney)
                                .addGap(14, 14, 14)
                                .addComponent(removeAnimadorDisney)
                                .addGap(37, 37, 37)
                                .addComponent(qttyAnimadoresDisney)
                                .addGap(23, 23, 23)
                                .addComponent(addAnimadorDisney))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(doblajeLabelDisney)
                                .addGap(46, 46, 46)
                                .addComponent(removeDoblajeDisney)
                                .addGap(37, 37, 37)
                                .addComponent(qttyDobladoresDisney)
                                .addGap(23, 23, 23)
                                .addComponent(addDoblajeDisney))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(plotTwistLabelDisney)
                                .addGap(25, 25, 25)
                                .addComponent(removePlotTwistDisney)
                                .addGap(37, 37, 37)
                                .addComponent(qttyGuionistasPlotTwistsDisney)
                                .addGap(23, 23, 23)
                                .addComponent(addPlotTwistDisney))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(ensambladorLabelDisney)
                                .addGap(75, 75, 75)
                                .addComponent(removeEnsambladorDisney)
                                .addGap(27, 27, 27)
                                .addComponent(qttyEnsambladoresDisney)
                                .addGap(23, 23, 23)
                                .addComponent(addEnsambladorDisney))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(8, 8, 8)
                                .addComponent(qttyProjectsManagersNick1)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5)
                                .addGap(13, 13, 13)
                                .addComponent(qttyDirectoresNick1))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(pmStatusLabelD)
                                .addGap(11, 11, 11)
                                .addComponent(pmStatusDisney))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(directorStatusLabelD)
                                .addGap(60, 60, 60)
                                .addComponent(directorStatusDisney))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(faultsLabelText1)
                                .addGap(11, 11, 11)
                                .addComponent(faultsLabelDisney))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                    .addComponent(guionistasLabelDisney)
                                    .addGap(94, 94, 94)
                                    .addComponent(removeGuionistaDisney)
                                    .addGap(37, 37, 37)
                                    .addComponent(qttyGuionistasDisney)
                                    .addGap(23, 23, 23)
                                    .addComponent(addGuionistaDisney))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(escenariosLabelDisney)
                                    .addGap(11, 11, 11)
                                    .addComponent(removeEscenariosDisney)
                                    .addGap(37, 37, 37)
                                    .addComponent(qttyEscenariosDisney)
                                    .addGap(23, 23, 23)
                                    .addComponent(addEscenariosDisney))))))
                .addGap(14, 14, 14))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(10, 10, 10)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(guionistasLabelDisney))
                    .addComponent(removeGuionistaDisney)
                    .addComponent(qttyGuionistasDisney)
                    .addComponent(addGuionistaDisney))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeEscenariosDisney)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escenariosLabelDisney)
                            .addComponent(qttyEscenariosDisney)
                            .addComponent(addEscenariosDisney))))
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(animadorLabelDisney))
                    .addComponent(removeAnimadorDisney)
                    .addComponent(qttyAnimadoresDisney)
                    .addComponent(addAnimadorDisney))
                .addGap(23, 23, 23)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeDoblajeDisney)
                    .addComponent(addDoblajeDisney)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doblajeLabelDisney)
                            .addComponent(qttyDobladoresDisney))))
                .addGap(33, 33, 33)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(plotTwistLabelDisney))
                    .addComponent(removePlotTwistDisney)
                    .addComponent(qttyGuionistasPlotTwistsDisney)
                    .addComponent(addPlotTwistDisney))
                .addGap(23, 23, 23)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeEnsambladorDisney)
                    .addComponent(addEnsambladorDisney)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ensambladorLabelDisney)
                            .addComponent(qttyEnsambladoresDisney))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(qttyProjectsManagersNick1)
                    .addComponent(jLabel5)
                    .addComponent(qttyDirectoresNick1))
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pmStatusLabelD)
                    .addComponent(pmStatusDisney))
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(directorStatusLabelD)
                    .addComponent(directorStatusDisney))
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(faultsLabelText1)
                    .addComponent(faultsLabelDisney))
                .addGap(24, 24, 24))
        );

        DisneyDash.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 540));
        DisneyDash.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, -50, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DisneyLogo.png"))); // NOI18N
        DisneyDash.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, -40, -1, -1));

        dinseyFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoDisney.jpeg"))); // NOI18N
        DisneyDash.add(dinseyFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        jTabbedPane1.addTab("DisneyChannel", DisneyDash);

        NickVSDisney.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Grafico.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout GraficoLayout = new javax.swing.GroupLayout(Grafico);
        Grafico.setLayout(GraficoLayout);
        GraficoLayout.setHorizontalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        GraficoLayout.setVerticalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        NickVSDisney.add(Grafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 710, 400));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Dias totales transcurridos:");
        NickVSDisney.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        daysPassedLabelGrafico.setBackground(new java.awt.Color(0, 0, 0));
        daysPassedLabelGrafico.setForeground(new java.awt.Color(255, 255, 255));
        daysPassedLabelGrafico.setText("0");
        NickVSDisney.add(daysPassedLabelGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));
        NickVSDisney.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoGrafico.png"))); // NOI18N
        NickVSDisney.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1080, 600));

        jTabbedPane1.addTab("Nick_VS_Disney", NickVSDisney);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        int nuevo = Integer.parseInt(dia.getText())+1000;
        dia.setText(String.valueOf(nuevo));
    }//GEN-LAST:event_addDiaActionPerformed

    private void removeDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDiaActionPerformed
        if(Integer.parseInt(dia.getText())==2000){
            JOptionPane.showMessageDialog(null, "EL DIA DEBE DURAR MINIMO 2000MS");
        } else {
            int nuevo = Integer.parseInt(dia.getText())-1000;
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
    private javax.swing.JLabel dinseyFondo;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
