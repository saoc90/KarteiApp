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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
	private JPanel levels;
	private JLabel beginner;
	private JLabel rookie;
	private JLabel intermediate;
	private JLabel profi;
	private JLabel expert;
	private JLabel master;
	private JLabel grandmaster;
	private JLabel enlightenend;
	private Icon beginnerIcon;
	private Icon rookieIcon;
	private Icon intermediateIcon;
	private Icon profiIcon;
	private Icon expertIcon;
	private Icon masterIcon;
	private Icon grandmasterIcon;
	private Icon enlightenendIcon;
	private JLabel backButtonLabel;
	private JPanel levelsLabel;
	private JLabel beginnerLabel;
	private JLabel rookieLabel;
	private JLabel intermediateLabel;
	private JLabel profiLabel;
	private JLabel expertLabel;
	private JLabel masterLabel;
	private JLabel grandmasterLabel;
	private JLabel enlightenendLabel;

	/**
	 * @param mainframe
	 */
	public ViewDiagramm(ViewMainFrame mainframe) {
		super();
		this.mainframe = mainframe;
		this.strings = mainframe.getStrings();
		titleBar = new ViewPanelTitleBar(ViewMainFrame.COLOR2, "statsPanel", mainframe);
		levels = new JPanel();
		levels.setBackground(ViewMainFrame.COLOR1);
		beginnerIcon = new ImageIcon("png/anfänger.png");
		beginner = new JLabel(strings.getString("beginner"), beginnerIcon, SwingConstants.LEFT);
		rookieIcon  = new ImageIcon("png/neuling.png");
		rookie = new JLabel(strings.getString("rookie"),rookieIcon,SwingConstants.LEFT);
		intermediateIcon = new ImageIcon("png/fortgeschritten.png");
		intermediate = new JLabel(strings.getString("intermediate"),intermediateIcon,SwingConstants.LEFT);
		profiIcon = new ImageIcon("png/profi.png");
		profi = new JLabel(strings.getString("profi"),profiIcon,SwingConstants.LEFT);
		expertIcon = new ImageIcon("png/expterte.png");
		expert = new JLabel(strings.getString("exptert"),expertIcon,SwingConstants.LEFT);
		masterIcon = new ImageIcon("png/meister.png");
		master = new JLabel(strings.getString("master"), masterIcon, SwingConstants.LEFT);
		grandmasterIcon = new ImageIcon("png/grossmeister.png");
		grandmaster = new JLabel (strings.getString("grandmaster"),grandmasterIcon,SwingConstants.LEFT);
		enlightenendIcon = new ImageIcon("png/erleuchtet.png");
		enlightenend = new JLabel(strings.getString("enlightenend"),enlightenendIcon,SwingConstants.LEFT);
		beginnerLabel = new JLabel("0-->499");
		rookieLabel = new JLabel("500-->2499");
		intermediateLabel = new JLabel("2500-->4999");
		profiLabel = new JLabel("5000-->7499");
		expertLabel = new JLabel("7500-->9999");
		masterLabel = new JLabel("10000-->19999");
		grandmasterLabel = new JLabel("20000-->49999");
		enlightenendLabel = new JLabel("50000+");
		
		
		
		
		paint();
	}
	
	private void paint(){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 4;
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
				gc.gridy = 2;
				gc.weighty = 1;
				gc.gridwidth = 1;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.LINE_START;
				add(backButton,gc);
				
				
				
				
				
				//levels
				
				gc.weightx = 1;
				gc.gridx = 1;
				gc.gridy = 2;
				gc.anchor = GridBagConstraints.LINE_START;
				
				levels.setLayout(new GridBagLayout());
				GridBagConstraints gcl = new GridBagConstraints();
				
				gcl.gridx = 1;
				gcl.gridy = 0;
				levels.add(beginner, gcl);
				gcl.gridy =1;
				levels.add(rookie, gcl);
				gcl.gridy = 2;
				levels.add(intermediate, gcl);
				gcl.gridy = 3;
				levels.add(profi,gcl);
				gcl.gridy = 4;
				levels.add(expert, gcl);
				gcl.gridy = 5;
				levels.add(master,gcl);
				gcl.gridy = 6;
				levels.add(grandmaster,gcl);
				gcl.gridy = 7;
				levels.add(enlightenend,gcl);
				gcl.gridx = 0;
				gcl.gridy = 0;
				levels.add(beginnerLabel, gcl);
				gcl.gridy =1;
				levels.add(rookieLabel, gcl);
				gcl.gridy = 2;
				levels.add(intermediateLabel, gcl);
				gcl.gridy = 3;
				levels.add(profiLabel,gcl);
				gcl.gridy = 4;
				levels.add(expertLabel, gcl);
				gcl.gridy = 5;
				levels.add(masterLabel,gcl);
				gcl.gridy = 6;
				levels.add(grandmasterLabel,gcl);
				gcl.gridy = 7;
				levels.add(enlightenendLabel,gcl);
				
				add(levels,gc);
				
		
		//add pie chart
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridy = 2;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.CENTER;
		add(pieChartRightWrong(ViewMainFrame.COLOR1,320	,230),gc);
		
		//add statusbar
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
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
        int rightAnswers = mainframe.getMainHandler().getPercentOfRights();
        dataset.setValue(strings.getString("RightAnswers%"), rightAnswers);
        dataset.setValue(strings.getString("WrongAnswers%"), 100-rightAnswers);
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
