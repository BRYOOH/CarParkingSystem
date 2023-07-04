import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import login.loginPage;

public class Frame extends JFrame implements ActionListener {

	static final int SCREEN_HEIGHT =700 ;
	static final int SCREEN_WIDTH =700 ;
	static final int UNIT_SIZE= 25;
	static final int GAME_UNITS= (SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE ;
	static final int DELAY= 60 ;
	
	JPanel panel = new JPanel();
	JPanel border = new JPanel();
	JButton [] buttons = new JButton[8];
	JLabel label = new JLabel();
	Font myFont = new Font("Ink Free",Font.BOLD,30);	
	
	
	Frame(){
		label.setForeground(new Color(255,0,255));
		label.setBackground(Color.BLACK);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("WELCOME TO THE PARKING GARAGE");
		label.setOpaque(true);
		label.setFont(myFont);
		
		border.setBounds(0, 0, SCREEN_WIDTH, 200);
		border.setLayout(new BorderLayout());
		border.add(label);
		
		for (int i=0;i<8;i++) {
			buttons[i] =new JButton(String.valueOf(i));
			buttons[i].addActionListener(this);
			buttons[i].setFocusable(false);
			buttons[i].setFont(myFont);
			buttons[i].setBackground(Color.GREEN);
			
			}
		
		panel.add(buttons[0]);
		panel.add(buttons[1]);
		panel.add(buttons[2]);
		panel.add(buttons[3]);
		panel.add(buttons[4]);
		panel.add(buttons[5]);
		panel.add(buttons[6]);
		panel.add(buttons[7]);
		
		panel.setBounds(100,0,SCREEN_WIDTH,500);
		panel.setFocusable(true);
		panel.setLayout(new GridLayout(4,2,15,5));
     	panel.setBackground(Color.black);
		
		
		this.setVisible(true);
		this.setTitle("SMART CAR PARKING SYSTEM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setResizable(false);
		
		
        this.add(border,BorderLayout.NORTH);
	    this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<8;i++) {
			if(e.getSource()==buttons[i]) {
			buttons[i].setBackground(Color.RED);
			buttons[i].setEnabled(false);
			label.setText("Free space at " +  i  + " is occupied");
		}
			
	}
		new loginPage();
}
}

	
