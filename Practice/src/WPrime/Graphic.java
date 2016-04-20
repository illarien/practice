package WPrime;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graphic {
//	private final static int[] SAMPLES = {300,300,300,300,300,300,300,300,300,300,200,200,100,100,100,100,100,100,100,100,100,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	private final static int[] SAMPLES = {500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,100,100,100,100,100,100,100,0,0,0,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,100,100};
	
	private final static int WP = 5000;
	
	 private static JFreeChart chart;
	
	 
	 private static JFreeChart createChart() {
		 XYSeries series1 = new XYSeries("Series 1");
	     series1.add(1.0, 1.0);
	     series1.add(2.0, 2.0);
	     series1.add(3.0, 3.0);
	     XYDataset dataset = new XYSeriesCollection(series1);
	     return ChartFactory.createXYLineChart("XY Line Chart", "Domain", "Range", dataset);
	    }
	 
	    
	public static void main(String[] args) {
		
		
		double summ = 0;
		int end = SAMPLES.length;
		
		PowerCache powerCache = new PowerCache();
		
		for (int j = 0; j < end; j++) {
			summ = 0;
			for (int i = 0; i <= j; i++) {
				summ = summ + powerCache.getTimedSample(SAMPLES[i], j-i); //timeline.get(i).get(j-i);
			}
			System.out.println("Wbal: " + j + " " + (WP - summ) );			
		}
		
		chart = createChart();
		
        try {
            BufferedImage image = new BufferedImage(200 , 100,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            chart.draw(g2, new Rectangle2D.Double(0, 0, 200, 100), null,
                    null);
            g2.dispose();
        }
        catch (Exception e) {
//          fail("No exception should be triggered.");
        }
	}

}
