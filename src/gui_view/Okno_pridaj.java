package gui_view;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;

public class Okno_pridaj {

	private JFrame frmPridaj;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textAddress;
	private JTextField textPhonenum;
	private JButton btnPridaj = new JButton("Register");
	private JComboBox comboBox_1 = new JComboBox();
	private JComboBox comboBox_2 = new JComboBox();
	private JComboBox comboBox = new JComboBox();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno_pridaj window = new Okno_pridaj();
				    window.getFrmPridaj().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end main

	
	public Okno_pridaj() {
		initialize();
		getFrmPridaj().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initialize() {
		
		frmPridaj = new JFrame();
		frmPridaj.setResizable(false);
		frmPridaj.setTitle("Registration");
		frmPridaj.setBounds(100, 100, 364, 292);
		frmPridaj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPridaj.getContentPane().setLayout(null);
		
		textName = new JTextField();
		textName.setToolTipText("Enter pacient's name");
		textName.setBounds(147, 33, 117, 20);
		frmPridaj.getContentPane().add(textName);
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setBounds(147, 76, 117, 20);
		frmPridaj.getContentPane().add(textSurname);
		textSurname.setColumns(10);
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name");
		lblName.setBounds(45, 36, 92, 14);
		frmPridaj.getContentPane().add(lblName);
		
		JLabel lblSurname = DefaultComponentFactory.getInstance().createLabel("Surname");
		lblSurname.setBounds(45, 79, 92, 14);
		frmPridaj.getContentPane().add(lblSurname);
		
		JLabel lblBirthDate = DefaultComponentFactory.getInstance().createLabel("Birth date");
		lblBirthDate.setBounds(45, 113, 92, 14);
		frmPridaj.getContentPane().add(lblBirthDate);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30","31"}));
		comboBox.setBounds(145, 110, 56, 20);
		frmPridaj.getContentPane().add(comboBox);
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_1.setBounds(211, 110, 53, 20);
		frmPridaj.getContentPane().add(comboBox_1);
		
		comboBox_2.setBounds(270, 110, 64, 20);
		frmPridaj.getContentPane().add(comboBox_2);
		for (int i=1910; i<= 2016; i++){
			comboBox_2.addItem(i);
		}
		
		JLabel lblAddress = DefaultComponentFactory.getInstance().createLabel("Address");
		lblAddress.setBounds(45, 153, 92, 14);
		frmPridaj.getContentPane().add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(147, 150, 155, 20);
		frmPridaj.getContentPane().add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblPhoneNumber = DefaultComponentFactory.getInstance().createLabel("Phone number");
		lblPhoneNumber.setBounds(45, 190, 92, 14);
		frmPridaj.getContentPane().add(lblPhoneNumber);
		
		textPhonenum = new JTextField();
		textPhonenum.setBounds(147, 187, 117, 20);
		frmPridaj.getContentPane().add(textPhonenum);
		textPhonenum.setColumns(10);
		btnPridaj.setBackground(new Color(0, 204, 255));
		btnPridaj.setToolTipText("Register new pacient\r\n");
		
						
		btnPridaj.setBounds(124, 229, 89, 23);
		frmPridaj.getContentPane().add(btnPridaj);
	}//end initialize
	
	public JTextField getTextName() {
		return textName;
	}
	public void setTextName(JTextField textName) {
		this.textName = textName;
	}
	public JTextField getTextSurname() {
		return textSurname;
	}
	public void setTextSurname(JTextField textSurname) {
		this.textSurname = textSurname;
	}

	public JTextField getTextAddress() {
		return textAddress;
	}
	public void setTextAddress(JTextField textAddress) {
		this.textAddress = textAddress;
	}
	public JTextField getTextPhonenum() {
		return textPhonenum;
	}

	public void setTextPhonenum(JTextField textPhonenum) {
		this.textPhonenum = textPhonenum;
	}

	public JFrame getFrmPridaj() {
		return frmPridaj;
	}
	public void setFrmPridaj(JFrame frmp) {
		this.frmPridaj = frmp;
	}

	public JButton getbtnPridaj() {
		return btnPridaj;
	}
	public void setbtnPridaj(JButton pridaj){
		this.btnPridaj = pridaj;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}
	public void setComboBox_1(JComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}
	public JComboBox getComboBox_2() {
		return comboBox_2;
	}

	public void setComboBox_2(JComboBox comboBox_2) {
		this.comboBox_2 = comboBox_2;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

}
