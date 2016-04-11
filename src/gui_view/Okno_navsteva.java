package gui_view;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
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
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Okno_navsteva {

	private JFrame frmNavsteva;
	private JButton btnPridaj = new JButton("Add");
	private JComboBox comboBox_1 = new JComboBox();
	private JComboBox comboBox_2 = new JComboBox();
	private JComboBox comboBox = new JComboBox();
	private final JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Date");
	private final JTextArea textAreaProblem = new JTextArea();
	private final JLabel lblProblem = DefaultComponentFactory.getInstance().createLabel("Problem");
	private final JLabel lblDiagnose = DefaultComponentFactory.getInstance().createLabel("Diagnose");
	private JButton btnAdd = new JButton("Add");
	private JScrollPane scroll_list;
	private JScrollPane scroll_list_problem;
	private JScrollPane scroll_list_diagnoza;
	private DefaultListModel DLM = new DefaultListModel();
	private DefaultListModel DLM_list_navstevy = new DefaultListModel();
	private JButton btnAllPacients = new JButton("All pacients");
	private JScrollPane scroll_list_navstevy;
	private JList list = new JList();
	private JList list_navstevy = new JList();
	private JTextField textFieldDiagnose = new JTextField();
	private final JLabel lblIddateproblem = DefaultComponentFactory.getInstance().createLabel("id/date/problem");
	//private JTable table = new JTable();
	//private DefaultTableModel model;
	//private JScrollPane scroll_table ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okno_navsteva window = new Okno_navsteva();
				    window.getFrmNavsteva().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end main

	
	public Okno_navsteva() {
		initialize();
		getFrmNavsteva().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void initialize() {
		textFieldDiagnose.setBounds(394, 156, 281, 62);
		textFieldDiagnose.setColumns(10);
		
		frmNavsteva = new JFrame();
		frmNavsteva.setResizable(false);
		frmNavsteva.setTitle("Navsteva");
		frmNavsteva.setBounds(100, 100, 698, 461);
		frmNavsteva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNavsteva.getContentPane().setLayout(null);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30","31"}));
		comboBox.setBounds(394, 37, 56, 20);
		frmNavsteva.getContentPane().add(comboBox);
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_1.setBounds(475, 37, 53, 20);
		frmNavsteva.getContentPane().add(comboBox_1);
		
		comboBox_2.setBounds(554, 37, 64, 20);
		frmNavsteva.getContentPane().add(comboBox_2);
		lblNewJgoodiesLabel.setBounds(312, 37, 64, 20);
		
		frmNavsteva.getContentPane().add(lblNewJgoodiesLabel);
		textAreaProblem.setBounds(394, 76, 281, 49);
		
		frmNavsteva.getContentPane().add(textAreaProblem);
		lblProblem.setBounds(312, 68, 72, 31);
		
		frmNavsteva.getContentPane().add(lblProblem);
		lblDiagnose.setBounds(312, 138, 72, 38);
		
		frmNavsteva.getContentPane().add(lblDiagnose);
		btnAdd.setBounds(495, 248, 89, 23);
		
		frmNavsteva.getContentPane().add(btnAdd);
		btnAllPacients.setBounds(53, 34, 110, 23);
		frmNavsteva.getContentPane().add(btnAllPacients);
		
		list.setBounds(27, 68, 207, 119);		
		frmNavsteva.getContentPane().add(list);
		
		list_navstevy.setBounds(27, 231, 267, 190);
		frmNavsteva.getContentPane().add(list_navstevy);
		
		frmNavsteva.getContentPane().add(textFieldDiagnose);
		lblIddateproblem.setBounds(37, 199, 126, 38);
		
		frmNavsteva.getContentPane().add(lblIddateproblem);
		
		//table.setBounds(27, 418, 638, 75);
		//frmNavsteva.getContentPane().add(table);
						
		for (int i=1910; i<= 2016; i++){
			comboBox_2.addItem(i);
		/*
		DefaultTableModel model = new DefaultTableModel();
		setModel(model);
		String[] columnNames = {"Name", "Surname", "Date", "Problem","Diagnose"};
		model.setColumnIdentifiers(columnNames);	      
		JTable table = new JTable(model);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	
		scroll_table = new JScrollPane(table);	
		scroll_table.setBounds(27, 418, 638, 75);
		frmNavsteva.getContentPane().add(scroll_table);*/
			
		
		}
		
	}//end initialize

	public JFrame getFrmNavsteva() {
		return frmNavsteva;
	}
	public void setFrmNavsteva(JFrame frmp) {
		this.frmNavsteva = frmp;
	}
	public JButton getbtnAdd() {
		return btnAdd;
	}
	public void setbtnAdd(JButton add){
		this.btnAdd = add;
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
	public JButton getBtnAllPacients() {
		return btnAllPacients;
	}
	public void setBtnAllPacients(JButton btnAllPacients) {
		this.btnAllPacients = btnAllPacients;
	}
	public JList getList() {
		return list;
	}
	public JList getList_navstevy() {
		return list_navstevy;
	}
	public void setList_navstevy(JList list_navstevy) {
		this.list_navstevy = list_navstevy;
	}

	public DefaultListModel getDLM_list_navstevy() {
		return DLM_list_navstevy;
	}
	public void setDLM_list_navstevy(DefaultListModel dLM_list_navstevy) {
		DLM_list_navstevy = dLM_list_navstevy;
	}
	public JTextArea getTextAreaProblem() {
		return textAreaProblem;
	}

	public JScrollPane getScroll_list_problem() {
		return scroll_list_problem;
	}


	public void setScroll_list_problem(JScrollPane scroll_list_problem) {
		this.scroll_list_problem = scroll_list_problem;
	}

	public JScrollPane getScroll_list_diagnoza() {
		return scroll_list_diagnoza;
	}
	public void setScroll_list_diagnoza(JScrollPane scroll_list_diagnoza) {
		this.scroll_list_diagnoza = scroll_list_diagnoza;
	}
	public JTextField getTextFieldDiagnose() {
		return textFieldDiagnose;
	}

	public void setTextFieldDiagnose(JTextField textFieldDiagnose) {
		this.textFieldDiagnose = textFieldDiagnose;
	}
}
