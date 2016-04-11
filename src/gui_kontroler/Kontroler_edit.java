package gui_kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dbs.Pacient;
import gui_model.Model_MVC;
import gui_model.Model_edit;
import gui_model.Model_navsteva;
import gui_view.Okno_MVC;
import gui_view.Okno_edit;
import gui_view.Okno_pridaj;

public class Kontroler_edit {

	private Model_MVC model;
	private Okno_edit view;
	private Okno_MVC okno_mvc;
	private Model_navsteva model_navsteva;
	
	private ActionListener btnEdit;
	private ActionListener btnUpdate;
	private ActionListener btnDelete;

	public Kontroler_edit(Model_MVC model, Okno_edit view, Okno_MVC okno_mvc, Model_navsteva navsteva){
		this.model = model;
		this.view = view;
		this.okno_mvc = okno_mvc;
		this.model_navsteva = navsteva;
	}
	
	public String extractDigits(String src) {
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < src.length(); i++) {
	        char c = src.charAt(i);
	        if (Character.isDigit(c)) {
	            builder.append(c);
	        }
	    }
	    return builder.toString();
	}	
	
	public void control() {
		
		btnUpdate = new ActionListener() {
			public void actionPerformed(ActionEvent e) { //zobrazi tabulku pacientov	
				String string_date = "02091998";
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, Integer.parseInt(view.getComboBox_2().getSelectedItem().toString()));
				cal.set(Calendar.MONTH, Integer.parseInt(view.getComboBox_1().getSelectedItem().toString()));
				cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(view.getComboBox().getSelectedItem().toString()));
				Date datee = new Date(cal.getTime().getTime());
				
				String update_name = view.getTextName().getText();
				String update_surname = view.getTextSurname().getText();
				String update_address = view.getTextAddress().getText();
				String update_phonenum = view.getTextPhonenum().getText();
				try {
					model.updatePacient(model.getId(), update_name, update_surname, datee, update_address, update_phonenum);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Update pacient");
			}
			};view.getBtnUpdate().addActionListener(btnUpdate);
		
		btnEdit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getDLM().removeAllElements(); //vynuluje list pri dalsom zobrazeni
				try {
					for (Pacient pacos : model.getAllPacients()) {
						view.getDLM().addElement(pacos.getName()+" "+pacos.getSurname()+ " "+ pacos.getPhonenum()); //pridam do listu meno a prizvisko						
					}
					view.getList().setModel(view.getDLM()); //nastavim list na DLM ->zobrazi list
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			 							
			}
			};view.getbtnEdit().addActionListener(btnEdit);
			
			
			
		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// vyberem si hodnoty : Meno a telefonne cislo
				String fullname = (String) view.getList().getSelectedValue();
				int index = fullname.indexOf(" "); 				
				String name = fullname.substring(0 , index);				
				String phonenum = extractDigits(fullname);
				Integer id = null;
				try {
					for (Pacient pacos : model.getAllPacients()){
						if (pacos.getName().equals(name) && pacos.getPhonenum().equals(phonenum)){
							view.getTextName().setText(pacos.getName());
							view.getTextSurname().setText(pacos.getSurname());
							view.getTextAddress().setText(pacos.getAddress());
							view.getTextPhonenum().setText(pacos.getPhonenum());
							id = pacos.getId();
						}
					}
					model.setId(id);
				} catch (SQLException e1) { e1.printStackTrace(); }
				index= 0;
			}
		});
		
		btnDelete = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.deletePacient(model.getId());
					model_navsteva.deleteVisit(model.getId());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Pacient deleted!");							
			}
			};view.getBtnDelete().addActionListener(btnDelete);
			
	}//end control


}//end class
