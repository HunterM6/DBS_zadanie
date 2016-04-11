package gui_view;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
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

import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;

public class Okno_edit {

	private JFrame frmEdit;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textAddress;
	private JTextField textPhonenum;
	private JButton btnEdit = new JButton("All pacients");
	private JButton btnUpdate = new JButton("Update");
	private JButton btnDelete = new JButton("Delete");
	private JComboBox comboBox_1 =  new JComboBox();
	private JComboBox comboBox_2 = new JComboBox();
	private JComboBox comboBox = new JComboBox();
	private JScrollPane scroll_list;
	private DefaultListModel DLM = new DefaultListModel();
	private JList list = new JList();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno_edit window = new Okno_edit();
				    window.getFrmEdit().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end main

	
	public Okno_edit() {
		initialize();
		getFrmEdit().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initialize() {
		
		frmEdit = new JFrame();
		frmEdit.setResizable(false);
		frmEdit.setTitle("Edit pacient");
		frmEdit.setBounds(100, 100, 579, 307);
		frmEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEdit.getContentPane().setLayout(null);
		
		textName = new JTextField();
		textName.setToolTipText("Enter pacient's name");
		textName.setBounds(365, 45, 117, 20);
		frmEdit.getContentPane().add(textName);
		textName.setColumns(10);
		
		textSurname = new JTextField();
		textSurname.setBounds(365, 76, 117, 20);
		frmEdit.getContentPane().add(textSurname);
		textSurname.setColumns(10);
		
		JLabel lblName = DefaultComponentFactory.getInstance().createLabel("Name");
		lblName.setBounds(263, 48, 92, 14);
		frmEdit.getContentPane().add(lblName);
		
		JLabel lblSurname = DefaultComponentFactory.getInstance().createLabel("Surname");
		lblSurname.setBounds(263, 79, 92, 14);
		frmEdit.getContentPane().add(lblSurname);
		
		JLabel lblBirthDate = DefaultComponentFactory.getInstance().createLabel("Birth date");
		lblBirthDate.setBounds(263, 113, 92, 14);
		frmEdit.getContentPane().add(lblBirthDate);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "23", "31"}));
		comboBox.setBounds(365, 110, 56, 20);
		frmEdit.getContentPane().add(comboBox);
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_1.setBounds(431, 110, 53, 20);
		frmEdit.getContentPane().add(comboBox_1);
		
		comboBox_2.setBounds(494, 110, 64, 20);
		frmEdit.getContentPane().add(comboBox_2);
		for (int i=1990; i<= 2016; i++){
			comboBox_2.addItem(i);
		}
		
		JLabel lblAddress = DefaultComponentFactory.getInstance().createLabel("Address");
		lblAddress.setBounds(263, 153, 92, 14);
		frmEdit.getContentPane().add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(365, 150, 155, 20);
		frmEdit.getContentPane().add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblPhoneNumber = DefaultComponentFactory.getInstance().createLabel("Phone number");
		lblPhoneNumber.setBounds(263, 190, 92, 14);
		frmEdit.getContentPane().add(lblPhoneNumber);
		
		textPhonenum = new JTextField();
		textPhonenum.setBounds(365, 187, 117, 20);
		frmEdit.getContentPane().add(textPhonenum);
		textPhonenum.setColumns(10);
		btnEdit.setToolTipText("Click here to show all pacients");
								
		btnEdit.setBounds(65, 13, 117, 23);
		frmEdit.getContentPane().add(btnEdit);
		
		btnDelete.setBackground(new Color(255, 0, 51));
		btnDelete.setBounds(469, 244, 89, 23);
		frmEdit.getContentPane().add(btnDelete);
			
		list.setBounds(22, 47, 200, 212);
		frmEdit.getContentPane().add(list);
		
		scroll_list = new JScrollPane();
		scroll_list.setBounds(22, 47, 200, 212);
		frmEdit.getContentPane().add(scroll_list);
		btnUpdate.setBackground(new Color(0, 204, 255));
		btnUpdate.setToolTipText("update information");
	
		btnUpdate.setBounds(318, 222, 89, 23);
		frmEdit.getContentPane().add(btnUpdate);

	}//end initialize
	
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

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

	public JFrame getFrmEdit() {
		return frmEdit;
	}
	public void setFrmEdit(JFrame frmp) {
		this.frmEdit = frmp;
	}

	public JButton getbtnEdit() {
		return btnEdit;
	}
	public void setbtnEdit(JButton edt){
		this.btnEdit = edt;
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

	public DefaultListModel getDLM() {
		return DLM;
	}

	public void setDLM(DefaultListModel dLM) {
		DLM = dLM;
	}
	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

}
