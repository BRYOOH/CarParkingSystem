package login;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginPage implements ActionListener {
	
	JFrame logFrame= new JFrame();
	JTextField name= new JTextField();
	JTextField email= new JTextField();
	JTextField carInfo= new JTextField();
	JTextField phoneNo= new JTextField();
	JPasswordField password = new JPasswordField();
	
	JLabel nameLabel = new JLabel("Name");
	JLabel emailLabel = new JLabel("Email");
	JLabel carInfoLabel = new JLabel("CarInfo");
	JLabel phoneNoLabel = new JLabel("PhoneNo");
	JLabel passwordLabel = new JLabel("Password");
	JLabel success = new JLabel();
	
	JButton login = new JButton("login");
	JButton reset = new JButton("reset");
	
	Font myFont = new Font("Ink Free", Font.BOLD,20);
	
	public loginPage(){
		
		login.setBounds(50, 350, 100, 50);
		login.addActionListener(this);
		login.setFocusable(false);
		
		reset.setBounds(200, 350, 100, 50);
		reset.addActionListener(this);
		reset.setFocusable(false);
		
		name.setBounds(125,50,200,25);
		name.setFont(myFont);
		email.setBounds(125,100,200,25);
		email.setFont(myFont);
		carInfo.setBounds(125,150,200,25);
		carInfo.setFont(myFont);
		phoneNo.setBounds(125,200,200,25);
		phoneNo.setFont(myFont);
		password.setBounds(125,250,200,25);
		password.setFont(myFont);
		
		nameLabel.setBounds(50, 50, 100, 25);
		emailLabel.setBounds(50, 100, 100, 25);
		carInfoLabel.setBounds(50, 150, 100, 25);
		phoneNoLabel.setBounds(50, 200, 100, 25);
		passwordLabel.setBounds(50, 250, 100, 25);
		success.setBounds(100,300,200,20);
		success.setForeground(Color.RED);
		
		logFrame.add(login);
		logFrame.add(reset);
		
		logFrame.add(name);
		logFrame.add(email);
		logFrame.add(carInfo);
		logFrame.add(phoneNo);
		logFrame.add(password);
		
		
		logFrame.add(nameLabel);
		logFrame.add(emailLabel);
		logFrame.add(carInfoLabel);
		logFrame.add(phoneNoLabel);
		logFrame.add(passwordLabel);
		logFrame.add(success);
		
		logFrame.setLayout(null);
		logFrame.setTitle("Please register your info!");
		logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logFrame.setVisible(true);
		logFrame.setSize(450,450);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reset) {
			name.setText("");
			email.setText("");
			carInfo.setText("");
			phoneNo.setText("");
			password.setText("");
		}
		
		if(e.getSource()==login) {
			String Name = name.getText() ;
			String Email = email.getText();
			String CarInfo = carInfo.getText();
			String PhoneNo = phoneNo.getText();
			String Password = password.getText();
			
			
			  try {
				  //Creates a java connection with mySQL database
				  
				  String myDriver = "com.mysql.cj.jdbc.Driver";
				  Class.forName(myDriver);
                  Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/car_owners",
                      "root", "Muriukis@01");

                  // Insert the values in the db
                  PreparedStatement st = (PreparedStatement) connection
                      .prepareStatement("insert into owners(id,username,email,carInfo,phoneNo,pass_word)" + "values(?,?,?,?,?,?)");

                  st.setLong(1,0);
                  st.setString(2, Name);
                  st.setString(3, Email);
                  st.setString(4, CarInfo);
                  st.setString(5, PhoneNo);
                  st.setString(6, Password);
                  
                  st.execute();
                  
                  connection.close();
                  }
				  catch (Exception a)
				    {
				      System.err.println("Got an exception!");
				      System.err.println(a.getMessage());
			  }
			  success.setText("LOGIN WAS SUCCESSIFUL!!!!");
			
		}
		
	}
	
}

