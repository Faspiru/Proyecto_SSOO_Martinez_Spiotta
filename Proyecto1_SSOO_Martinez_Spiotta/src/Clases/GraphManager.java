/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author fabriziospiotta
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class GraphManager {
    private XYSeries seriesNickelodeon;
    private XYSeries seriesDisney;
    private XYPlot plot;
    private JPanel grafico;
    private Company nickelodeon;
    private Company disney;
    private int counter = 1;

    public GraphManager(JPanel grafico, Company nickelodeon, Company disney) {
        seriesNickelodeon = new XYSeries("Nickelodeon");
        seriesDisney = new XYSeries("Disney");
        this.grafico = grafico;
        this.nickelodeon = nickelodeon;
        this.disney = disney;

        JFreeChart lineChart = ChartFactory.createXYLineChart("Utility VS Time", "Days", "Utility", getDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(lineChart);
        
        XYPlot plot = lineChart.getXYPlot();

        // Declarar un NumberAxis para el eje X
//        NumberAxis xAxis = new NumberAxis("Days");
//        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits()); // Mostrar números enteros en los ticks
//
//        plot.setDomainAxis(xAxis);

        // Crear un renderizador de series personalizado (LineAndShapeRenderer para gráficos de líneas)
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.ORANGE);  // Serie 0 (Nickelodeon) en naranja
        renderer.setSeriesPaint(1, Color.BLUE);    // Serie 1 (Disney) en azul
        renderer.setSeriesShapesVisible(0, true);  // Mostrar puntos para la serie 0
        renderer.setSeriesShapesVisible(1, true);  // Mostrar puntos para la serie 1
        renderer.setSeriesLinesVisible(0, true);    // Mostrar líneas para la serie 0
        renderer.setSeriesLinesVisible(1, true);    // Mostrar líneas para la serie 1
        renderer.setSeriesStroke(0, new BasicStroke(3.0f)); // Grosor de la línea para la serie 0
        renderer.setSeriesStroke(1, new BasicStroke(3.0f)); // Grosor de la línea para la serie 1

        plot.setRenderer(renderer);

        chartpanel.setPreferredSize(new java.awt.Dimension(700, 500));
        //int delay = nickelodeon.getDayDuration();
        grafico.setLayout(new BorderLayout());
        grafico.add(chartpanel, BorderLayout.CENTER);
        grafico.validate();
//        new Timer(delay, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                actualizarGrafico();
//            }
//        }).start();
    }

    private XYSeriesCollection getDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesNickelodeon);
        dataset.addSeries(seriesDisney);
        return dataset;
    }

    // Método para actualizar las utilidades y el tiempo en el gráfico
    public void actualizarGrafico() {
        //nt tiempoActual = (int) System.currentTimeMillis(); // Obtener el tiempo actual
        System.out.println(counter);
        seriesNickelodeon.add(counter, nickelodeon.getUtilidad());
        seriesDisney.add(counter, disney.getUtilidad());
        counter ++;
    }
    
}
