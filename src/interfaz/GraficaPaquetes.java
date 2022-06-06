package interfaz;


import org.knowm.xchart.*;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.pie.PieChart02;


public class GraficaPaquetes implements ExampleChart<PieChart>{

    

    public static void main(String[] args) {
  
      ExampleChart<PieChart> exampleChart = new PieChart02();
      PieChart chart = exampleChart.getChart();
      new SwingWrapper<PieChart>(chart).displayChart();
      
      
    }
  
    @Override
    public PieChart getChart() {
      
      // Create Chart
  
      PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
  
      // Customize Chart
      chart.setTitle("Porcentaje paquetes de trabajo");
      chart.addSeries("Completado", 40);
      chart.addSeries("Restante", 60);
      
      
  
      return chart;
    }

    @Override
    public String getExampleChartName() {
      // TODO Auto-generated method stub
      return null;
    }
  
  }

