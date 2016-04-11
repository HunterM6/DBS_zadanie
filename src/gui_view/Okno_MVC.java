package gui_view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Okno_MVC extends JFrame{ //view
	
	private JFrame frame;
	private JTable table = new JTable();
	private JButton btnPacienti = new JButton("All pacients");
	private JButton btnEdit = new JButton("Edit pacients");
	private JButton btnPridaj = new JButton("Registration");
	private JTextArea textArea = new JTextArea();
	private JLabel lblVypis = DefaultComponentFactory.getInstance().createLabel("Notes:");
	private JScrollPane scroll_table ;
	private JScrollPane scroll_vypis ;
	private JLabel lblTabulka = DefaultComponentFactory.getInstance().createLabel("Table:");
    private DefaultListModel DLM = new DefaultListModel();
    private DefaultTableModel model;
    private JButton btnAdd = new JButton("Add visit");


	public Okno_MVC() {
		
		getContentPane().setBackground(Color.LIGHT_GRAY);		
		setBounds(100, 100, 690, 485);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		setTitle("IS");
		
		getContentPane().add(lblTabulka);
		btnPacienti.setToolTipText("Show all pacients in table");
				
		btnPacienti.setBounds(10, 11, 108, 23);
		getContentPane().add(btnPacienti);
		btnEdit.setToolTipText("Edit or Delete pacient");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
						
		btnEdit.setBounds(128, 45, 115, 23);
		getContentPane().add(btnEdit);
		btnPridaj.setToolTipText("Register new pacient");
			
		btnPridaj.setBounds(10, 45, 108, 23);
		getContentPane().add(btnPridaj);
			
		lblVypis.setBounds(436, 316, 73, 23);
		getContentPane().add(lblVypis);
		
		lblTabulka.setBounds(10, 135, 73, 41);
		
		textArea.setBounds(332, 323, 346, 111);
		table.setBounds(10, 133, 312, 301);
		
		DefaultTableModel model = new DefaultTableModel();
		setModel(model);
		String[] columnNames = {"Name", "Surname", "Birthdate", "Address","Phone num"};
	    model.setColumnIdentifiers(columnNames);
	      
		JTable table = new JTable(model);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		scroll_table = new JScrollPane(table);
		scroll_vypis = new JScrollPane(textArea);
		
		scroll_vypis.setBounds(436, 340, 209, 92);
		scroll_table.setBounds(10, 164, 404, 268);
		getContentPane().add(scroll_table);
		getContentPane().add(scroll_vypis);
		
		btnAdd.setToolTipText("Show and Add visits");
		btnAdd.setBounds(128, 11, 115, 23);
		getContentPane().add(btnAdd);
	  
		setVisible(true);	
	 }//end method okno

	public JButton getbtnPacienti() {
		return btnPacienti;
	}
	public void setbtnPacienti(JButton btnPacienti) {
		this.btnPacienti = btnPacienti;
	}
	
	public JButton getbtnVyhladaj() {
		return btnPacienti;
	}
	
	public JButton getbtnEdit() {
		return btnEdit;
	}
	public void setbtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}
	
	public JButton getbtnDetail() {
		return btnEdit;
	}
		
	public JButton getbtnPridaj() {
		return btnPridaj;
	}
	public void setbtnPridaj(JButton btnPridaj) {
		this.btnPridaj = btnPridaj;
	}
	
	public JTextArea getTextarea() {
		return textArea;
	}
	public void settextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public JTable getTable() {
		return table;
	}
	public void setjtable(JTable table) {
		this.table = table;
	}

	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public DefaultListModel getDLM() {
		return DLM;
	}

	public void setDLM(DefaultListModel dLM) {
		DLM = dLM;
	}

	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

}//end class
