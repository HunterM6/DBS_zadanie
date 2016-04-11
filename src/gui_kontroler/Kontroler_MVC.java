package gui_kontroler;

import gui_model.Model_MVC;
import gui_view.Okno_MVC;
import gui_view.Okno_edit;
import gui_view.Okno_navsteva;
import gui_view.Okno_pridaj;

import java.awt.EventQueue;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dbs.Pacient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class Kontroler_MVC {

	private Model_MVC model;
	private Okno_MVC view;
	private Okno_pridaj okno_pridaj;
	private Okno_edit okno_edit;
	private Okno_navsteva okno_navsteva;
	
	private ActionListener btnPacienti;
	private ActionListener btnVyhladaj; 
	private ActionListener btnEdit; 
	private ActionListener btnPridaj;
	private ActionListener btnAdd;

	public Kontroler_MVC(Model_MVC model, Okno_MVC view,Okno_pridaj okno_pridaj, Okno_edit okno_edit, Okno_navsteva okno_navsteva){
		this.model = model;
		this.view = view;
		this.okno_pridaj = okno_pridaj;
		this.okno_edit = okno_edit;
		this.okno_navsteva = okno_navsteva;
	}
	
	public void control() {
		
		btnPacienti = new ActionListener() {
			int row_count;
			public void actionPerformed(ActionEvent e) { //zobrazi tabulku pacientov
				
				 row_count = view.getModel().getRowCount(); //vynuluje tabulku pri dalsom zobrazeni
				 for (int i= row_count - 1; i>= 0; i--){
					 view.getModel().removeRow(i);
				 }
				
				try {
					for (Pacient pacos : model.getAllPacients()) {
						view.getModel().addRow(new Object[]{pacos.getName(),pacos.getSurname(),
								               pacos.getDatee(),pacos.getAddress(),pacos.getPhonenum()}); //tabulka pacientov
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				 row_count = view.getModel().getRowCount();
			}
			};view.getbtnPacienti().addActionListener(btnPacienti);
		
			
		btnVyhladaj = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
			};view.getbtnVyhladaj().addActionListener(btnVyhladaj);

			
		btnEdit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			okno_edit.getFrmEdit().setVisible(true);	
		}
		};view.getbtnEdit().addActionListener(btnEdit);
		
		btnAdd = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("BTN add");
				okno_navsteva.getFrmNavsteva().setVisible(true);
			}
			};view.getBtnAdd().addActionListener(btnAdd);

			
		btnPridaj = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			okno_pridaj.getFrmPridaj().setVisible(true);			
		}
		};view.getbtnPridaj().addActionListener(btnPridaj);
		
	}//end control	

}//end class