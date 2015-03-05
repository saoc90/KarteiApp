package ch.zbw.karteiSystem;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class ViewDiagramm extends JPanel {
	
	private ViewMainFrame mainframe;
	private Strings strings;

	/**
	 * @param mainframe
	 */
	public ViewDiagramm(ViewMainFrame mainframe) {
		super();
		this.mainframe = mainframe;
		this.strings = mainframe.getStrings();
	}
	
	public JPanel getIt(){
		add(pieChartRightWrong(Color.ORANGE,400	,300));
		add(getStatusBar(Color.ORANGE, 200, 400));
		return this;
	}
	
	private ChartPanel pieChartRightWrong(Color c,int width, int hight){
		PieDataset dataset = createDataset();
		JFreeChart chart = createPieChart(dataset, strings.getString("pieChartTitle"),c);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(width, hight));
		chartPanel.setBackground(c);
		chart.setBackgroundPaint(c);
		return chartPanel;
	}

	private JFreeChart createPieChart(PieDataset dataset, String title, Color c) {
		 JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
		 PiePlot plot = (PiePlot) chart.getPlot();
	        plot.setStartAngle(290);
	        plot.setDirection(Rotation.CLOCKWISE);
	        plot.setSectionPaint(strings.getString("RightAnswers%"), Color.GREEN);
	        plot.setSectionPaint(strings.getString("WrongAnswers%"), Color.RED);
	        plot.setBackgroundPaint(c);
	        plot.setLabelBackgroundPaint(c);
	        plot.setOutlinePaint(c);
	        return chart;
	}


	private  PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int rightAnswers = mainframe.getMainHandler().getPercentOfRights();
        dataset.setValue(strings.getString("RightAnswers%"), rightAnswers);
        dataset.setValue(strings.getString("WrongAnswers%"), 100-rightAnswers);
        return dataset;   
    }
	
	public static void main(String[] args){
		JFrame main = new JFrame("Hallo");
		ViewDiagramm d = new ViewDiagramm(new ViewMainFrame());
		main.add(d.getIt());
		main.setSize(800, 600);
		main.setVisible(true);
	}
	
	private JPanel getStatusBar(Color c,int width,int hight){
		JPanel bar = new JPanel(); //vertical bar
		JPanel backpanel = new JPanel(); 
		
		int score = mainframe.getMainHandler().getScore();
		score = 2500;
		score = score*350/2500;//matching to bar.
		
		
		int barHight = 350;
		bar.setBackground(Color.GRAY);
		bar.setPreferredSize(new Dimension(20,barHight));
		bar.setLayout(new GridLayout(barHight, 1));
		
		

		
		for(int i=score;i<barHight;i++){
			JPanel clear = new JPanel();
			clear.setBackground(Color.LIGHT_GRAY);
			bar.add(clear);
		}
		
		for(int i=0;i<score;i++){
			JPanel status = new JPanel(); //status
			status.setBackground(new Color((((i+(barHight-score)*255)/barHight)),255-((( i+ (barHight-score)*250)/barHight)) , 0));
			bar.add(status);
			i+=20;
		}
		
	

		
		backpanel.add(bar);
		backpanel.setBackground(c);
		backpanel.setPreferredSize(new Dimension(width ,hight));
		

		return backpanel;
	}
}
