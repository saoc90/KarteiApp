package ch.zbw.karteiSystem;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private ViewPanelTitleBar titleBar;
	private ImageIcon backIcon ;
	private JLabel backButton;

	/**
	 * @param mainframe
	 */
	public ViewDiagramm(ViewMainFrame mainframe) {
		super();
		this.mainframe = mainframe;
		this.strings = mainframe.getStrings();
		titleBar = new ViewPanelTitleBar(ViewMainFrame.COLOR2, "statsPanel", mainframe);
		paint();
	}
	
	private void paint(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 3;
		gc.insets = new Insets(20,0,0,0);
		gc.anchor = GridBagConstraints.NORTH;
		strings.add(titleBar);
		add(titleBar,gc);
		
		
		
		//Backbutton
		
				backIcon = new ImageIcon("png/back.png");
				backButton = new JLabel(backIcon);
				backButton.addMouseListener(new MouseListener() {
					
					@Override
					
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							mainframe.changeFrameTo("toStartPanel");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				gc.insets = new Insets(0,20,0,0);
				gc.gridx = 0;
				gc.gridy = 1;
				gc.weighty = 1;
				gc.gridwidth = 1;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.LINE_START;
				add(backButton,gc);
		
		//add pie chart
		gc.fill = GridBagConstraints.NONE;
		gc.gridy = 1;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.CENTER;
		add(pieChartRightWrong(ViewMainFrame.COLOR1,400	,300),gc);
		
		//add statusbar
		gc.gridx = 2;
		add(getStatusBar(ViewMainFrame.COLOR1, 200, 400),gc);
	}
	
	
//	public JPanel getIt(){
//		add(pieChartRightWrong(ViewMainFrame.COLOR4,400	,300));
//		add(getStatusBar(Color.ORANGE, 200, 400));
//		return this;
//	}
	
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
        int rightAnswers = 50;  //mainframe.getMainHandler().getPercentOfRights();
        dataset.setValue(strings.getString("RightAnswers%"), 50);
        dataset.setValue(strings.getString("WrongAnswers%"), 100);
        return dataset;   
    }
	
	
	private JPanel getStatusBar(Color c,int width,int hight){
		JPanel bar = new JPanel(); //vertical bar
		JPanel backpanel = new JPanel(); 
		int barHight = 350;
		int score = mainframe.getMainHandler().getScore();
		score = (score*barHight)/2500;//matching to bar.
		
		
		
		bar.setBackground(Color.GRAY);
		bar.setPreferredSize(new Dimension(20,barHight));
		bar.setLayout(new GridLayout(barHight, 1));
		
		int delatRedGreen = 0; 

		
		for(int i=score;i<barHight;i++){ //set gray part of bar.
			JPanel clear = new JPanel();
			clear.setBackground(Color.LIGHT_GRAY);
			bar.add(clear);
			delatRedGreen++;
		}
		
		delatRedGreen = (delatRedGreen*255)/barHight;
		
		for(int i=0;i<score;i++){ //set colored part of bar.
			JPanel status = new JPanel(); //status
			status.setBackground(new Color((i*255)/barHight+delatRedGreen,255-((i*255)/barHight)-delatRedGreen, 0));
			bar.add(status);
		}
		
	

		
		backpanel.add(bar);
		backpanel.setBackground(c);
		backpanel.setPreferredSize(new Dimension(width ,hight));
		

		return backpanel;
	}
}
