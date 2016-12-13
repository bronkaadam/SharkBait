/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharkbait;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;


public class SharkBait extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5450089908763220582L;
	private JPanel contentPane;
	JButton btn1 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn2 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn3 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn4 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn5 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn6 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn7 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn8 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btn9 = new JButton("<html><b><font size=+5>?</font></b></html>");
	JButton btnStart = new JButton("START");
	JButton btnExit = new JButton("EXIT");
	List<String> wyniki = new ArrayList<String>();
	boolean[] flags = new boolean[9];
	boolean flag = false;
	
	List<String> losoweMiejsca = new ArrayList<String>();
	List<String> losoweMiejsca2 = new ArrayList<String>(); // ustala losowe miejsca kwot
	List<String> kwoty = new ArrayList<String>();
	List<String> kwoty2 = new ArrayList<String>(); // losuje kwoty(tylko 4 pierwsze wchodza w sklad losowaneKwoty)
	String[] wylosowaneKwoty = new String[9]; // przechowuje kwoty na ustalonych miejscach
	String shark = "SHARK";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SharkBait frame = new SharkBait();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public SharkBait() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btn1.setBounds(89, 88, 90, 90);
		contentPane.add(btn1);
		
		
		btn2.setBounds(189, 88, 90, 90);
		contentPane.add(btn2);
		
		
		btn3.setBounds(289, 88, 90, 90);
		contentPane.add(btn3);
		
		
		btn4.setBounds(89, 189, 90, 90);
		contentPane.add(btn4);
		
		
		btn5.setBounds(189, 189, 90, 90);
		contentPane.add(btn5);
		
		
		btn6.setBounds(289, 189, 90, 90);
		contentPane.add(btn6);
		
		
		btn7.setBounds(89, 290, 90, 90);
		contentPane.add(btn7);
		
		
		btn8.setBounds(189, 290, 90, 90);
		contentPane.add(btn8);
		
		
		btn9.setBounds(289, 290, 90, 90);
		contentPane.add(btn9);
		
		JLabel lblSharkBait = new JLabel("Shark Bait");
		lblSharkBait.setForeground(Color.BLUE);
		lblSharkBait.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 40));
		lblSharkBait.setHorizontalAlignment(SwingConstants.CENTER);
		lblSharkBait.setBounds(89, 11, 290, 50);
		contentPane.add(lblSharkBait);
		Listen4Button l4Button = new Listen4Button();
		btnStart.addActionListener(l4Button);
		btnExit.addActionListener(l4Button);
		btnStart.setBounds(290, 409, 89, 23);
		btn1.addActionListener(l4Button);
		btn2.addActionListener(l4Button);
		btn3.addActionListener(l4Button);
		btn4.addActionListener(l4Button);
		btn5.addActionListener(l4Button);
		btn6.addActionListener(l4Button);
		btn7.addActionListener(l4Button);
		btn8.addActionListener(l4Button);
		btn9.addActionListener(l4Button);
		contentPane.add(btnStart);
				
		btnExit.setBounds(383, 409, 89, 23);
		contentPane.add(btnExit);
	}
	private class Listen4Button implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			  
					   
			if(e.getSource() == btnStart){
				for(int i = 0; i < 9; i++){
					flags[i] = false;
				}
				flag = false;
				btn1.setText("<html><b><font size=+5>?</font></b></html>");
				btn2.setText("<html><b><font size=+5>?</font></b></html>");
				btn3.setText("<html><b><font size=+5>?</font></b></html>");
				btn4.setText("<html><b><font size=+5>?</font></b></html>");
				btn5.setText("<html><b><font size=+5>?</font></b></html>");
				btn6.setText("<html><b><font size=+5>?</font></b></html>");
				btn7.setText("<html><b><font size=+5>?</font></b></html>");
				btn8.setText("<html><b><font size=+5>?</font></b></html>");
				btn9.setText("<html><b><font size=+5>?</font></b></html>");
				wyniki.clear();
				kwoty.clear();
				kwoty2.clear();
				losoweMiejsca.clear();
				losoweMiejsca2.clear();
				// wype³nianie listy liczbami z zakresu 1 - 9
				
				for(int i = 0; i <= 8; i++){
					losoweMiejsca.add(""+i);
				}
				// przemieszanie liczb na liœcie i zapisanie ich na inn¹ listê (ustalenie miejsc startowych dla kwot)
				 for (String a : losoweMiejsca){
			            losoweMiejsca2.add(a);
			        Collections.shuffle(losoweMiejsca2, new Random());
				 }
			      
				
				// Dodaje kwoty do listy kwoty
			    kwoty.add(""+1);
			    kwoty.add(""+2);
			    kwoty.add(""+3);
			    kwoty.add(""+4);
			    kwoty.add(""+5);
			    kwoty.add(""+10);
			    kwoty.add(""+20);
			    kwoty.add(""+50);
			    kwoty.add(""+100);
			    kwoty.add(""+500);
			    kwoty.add(""+1000);
			    kwoty.add(""+2000);
			    // wypelniam liste kwoty2 losowymi kwotami z kwoty
			    for(String b: kwoty){
			    	kwoty2.add(b);
			    	Collections.shuffle(kwoty2, new Random());
			    }
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(0))] = shark;
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(1))] = kwoty2.get(1);
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(2))] = kwoty2.get(1);
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(3))] = kwoty2.get(2);
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(4))] = kwoty2.get(2);
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(5))] = kwoty2.get(3);
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(6))] = kwoty2.get(3);
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(7))] = kwoty2.get(4);
			    wylosowaneKwoty[Integer.parseInt(losoweMiejsca2.get(8))] = kwoty2.get(4);
			
						
			}			
			if(e.getSource() == btnExit){
				dispose();
			}
						
			if(e.getSource() == btn1 && flag != true){
				btn1.setText(wylosowaneKwoty[0]);
				
				if(flags[0]==false){
				flags[0] = true;
				
				if(wyniki.contains(btn1.getText())){
					flag = true;
					JOptionPane.showMessageDialog(null,"you win "+ btn1.getText() + " euro");
					
				}
				wyniki.add(btn1.getText());
				}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			if(e.getSource() == btn2 && flag != true){
				btn2.setText(wylosowaneKwoty[1]);
				
				if(flags[1]==false){
					flags[1] = true;
					
					if(wyniki.contains(btn2.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn2.getText() + " euro");
					}
					wyniki.add(btn2.getText());
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			if(e.getSource() == btn3 && flag != true){
				btn3.setText(wylosowaneKwoty[2]);
				
				if(flags[2]==false){
					flags[2] = true;
					
					if(wyniki.contains(btn3.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn3.getText() + " euro");
					}
					wyniki.add(btn3.getText());
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			if(e.getSource() == btn4 && flag != true){
				btn4.setText(wylosowaneKwoty[3]);
				
				if(flags[3]==false){
					flags[3] = true;
					
					if(wyniki.contains(btn4.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn4.getText() + " euro");
					}
					wyniki.add(btn4.getText()); 
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			if(e.getSource() == btn5 && flag != true){
				btn5.setText(wylosowaneKwoty[4]);
				
				if(flags[4]==false){
					flags[4] = true;
					 
					if(wyniki.contains(btn5.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn5.getText() + " euro");
					}
					wyniki.add(btn5.getText());
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			if(e.getSource() == btn6 && flag != true){
				btn6.setText(wylosowaneKwoty[5]);
				
				if(flags[5]==false){
					flags[5] = true;
					 
					if(wyniki.contains(btn6.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn6.getText() + " euro");
					}
					wyniki.add(btn6.getText());
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			if(e.getSource() == btn7 && flag != true){
				btn7.setText(wylosowaneKwoty[6]);
				
				if(flags[6]==false){
					flags[6] = true;
					
					if(wyniki.contains(btn7.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn7.getText() + " euro");
					}
					wyniki.add(btn7.getText());
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			
			if(e.getSource() == btn8 && flag != true){
				btn8.setText(wylosowaneKwoty[7]);
				
				if(flags[7]==false){
					flags[7] = true;
			
					if(wyniki.contains(btn8.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn8.getText() + " euro");
					}
					wyniki.add(btn8.getText()); 
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			if(e.getSource() == btn9 && flag != true){
				btn9.setText(wylosowaneKwoty[8]);
				
				if(flags[8]==false){
					flags[8] = true;
					
					if(wyniki.contains(btn9.getText())){
						flag = true;
						JOptionPane.showMessageDialog(null,"you win "+ btn9.getText() + " euro");
					}
					wyniki.add(btn9.getText()); 
					}else{JOptionPane.showMessageDialog(null,"You Can't chose the same button twice");}
			}
			for(String a: wyniki){
				if(a.contains("SHARK")){
					JOptionPane.showMessageDialog(btnStart, "SHARK !!!");
					flag = true;
					wyniki.clear();
					break;
				}
			}
			
			
		}
		
	}
}
