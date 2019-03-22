package views;

import bin.UserManage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.*;

// ！
// 四个用来识别格式的方法被抽离并单独构建成了一个类
import static views.FormatCheck.*;

public class RegisterInputFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame myFrame2;//The general frame
	JPanel idPanel;
	JPanel namePanel;
	JPanel addPanel;
	JPanel emptyPanel1;
//	JPanel emptyPanel2;
	JPanel submitPanel;
	JPanel checkPanel;
	JPanel buttonPanel;
	
	JTextField idText;
	JTextField nameText;
	JTextField addText;
	JLabel checkLabel;
	
	
	RegisterInputFrame(){
		this.setTitle("Please register a new user.");
		
		emptyPanel1=new EmptyPanel();
		idPanel=new IdPanel();
		namePanel=new NamePanel();
		addPanel=new AddPanel();
//		emptyPanel2=new EmptyPanel();
		submitPanel=new SubmitPanel();
		checkPanel=new CheckPanel();
		buttonPanel=new ButtonPanel();
		
		this.add(emptyPanel1);
		this.add(idPanel);
		this.add(namePanel);
		this.add(addPanel);
		this.add(submitPanel);
//		this.add(emptyPanel2);
		this.add(checkPanel);
		this.add(buttonPanel);
		
		this.setLayout(new GridLayout(7,1));
		this.setSize(1200, 1000);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
		
	}
	
	class IdPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		IdPanel(){
			JLabel idLabel=new JLabel("ID:                 ");
			idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
			idText=new JTextField(15);
			idText.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
		
			this.add(idLabel);
			this.add(idText);
		}
	}
	
	class NamePanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		NamePanel(){
			JLabel nameLabel=new JLabel("Full Name:     ");
			nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
			nameText=new JTextField(15);
			nameText.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
			
			this.add(nameLabel);
			this.add(nameText);
		}
	}
	
	class AddPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		AddPanel(){
			JLabel addLabel=new JLabel("Email Add:     ");
			addLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
			addText=new JTextField(15);
			addText.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
			
			this.add(addLabel);
			this.add(addText);
		}
	}
	
	class SubmitPanel extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		SubmitPanel(){
			JButton submitButton=new JButton("Submit");
			submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 50)); 
			
			this.add(submitButton);
			submitButton.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e){
			if (idText.getText().length()==0) {
				checkLabel.setText("You haven't entered the ID!");
			} 
			else if(isID(idText.getText())==0) {
				checkLabel.setText("Invalid ID. You must enter 9 digits!");
			}
			else if(nameText.getText().length()==0) {
				checkLabel.setText("You haven't entered the full name!");
			}
			else if(isName(nameText.getText())==0) {
				checkLabel.setText("<html>Invalid name.<br/> Example: Xiaoming Wang</html>");
			}
			else if(addText.getText().length()==0) {
				checkLabel.setText("You haven't entered the email address!");
			}
			else if(isAddress(addText.getText())==0) {
				checkLabel.setText("<html>Invalid email address. <br/>Example:qmul123_uk@qmul.ac.uk.</html>");
			}
			else {
				// Login Successful
				if (UserManage.registration(Integer.parseInt(idText.getText()), nameText.getText(), addText.getText())) {
					JFrame littleFrame =new JFrame("Successful");
					JLabel littleLabel=new JLabel("Successful Input.");
					littleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
					littleFrame.add(littleLabel);

					checkLabel.setText("Successful Input.");

					littleFrame.setSize(500, 500);
					//littleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					littleFrame.setVisible(true);
				}
				// Duplicate
				else {
					checkLabel.setText("Duplicate qmNumber or Email!");
				}
			}
		}
		

			
		
		
	}
	
	class CheckPanel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		CheckPanel(){
			checkLabel=new JLabel("Please enter info.");
			this.add(checkLabel);
			//checkLabel.setSize(5, 100);
			checkLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50)); 
			
		}
	}
	
	class ButtonPanel extends JPanel implements ActionListener{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		ButtonPanel(){
			JButton clearButton=new JButton("Clear");
			clearButton.setFont(new Font("Times New Roman", Font.PLAIN, 50)); 
			this.add(clearButton);
			clearButton.addActionListener(this);
			
//			JButton backButton=new JButton("Back");
//			backButton.setFont(new Font("Times New Roman", Font.PLAIN, 50)); 
//			this.add(backButton);
//			backButton.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent e){
			String actionCommand = e.getActionCommand();
			if(actionCommand=="Clear") {
    			idText.setText("");
    			nameText.setText("");
    			addText.setText("");
    		}
			
//			if(actionCommand=="Back") {
//				
//    		}
		}
	}
	
	class EmptyPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}

}