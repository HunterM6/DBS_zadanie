package gui_kontroler;

import gui_model.Model_MVC;
import gui_model.Model_pridaj;
import gui_view.Okno_MVC;
import gui_view.Okno_pridaj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import dbs.Pacient;

public class Kontroler_pridaj {
	
	private Model_pridaj model;
	private Okno_pridaj view;
	
	private ActionListener btnPridaj;
	
	public Kontroler_pridaj(Model_pridaj model, Okno_pridaj view){
		this.model = model;
		this.view = view;
	}
	
	public void control(){
		
		btnPridaj = new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				String string_date = "03082001";
						
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, Integer.parseInt(view.getComboBox_2().getSelectedItem().toString()));
				cal.set(Calendar.MONTH, Integer.parseInt(view.getComboBox_1().getSelectedItem().toString()));
				cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(view.getComboBox().getSelectedItem().toString()));
				Date datee = new Date(cal.getTime().getTime());
				
				try {
					model.pridajPacienta(view.getTextName().getText(), view.getTextSurname().getText(), datee, view.getTextAddress().getText(), view.getTextPhonenum().getText());
					view.getTextName().setText("");
					view.getTextSurname().setText("");
					view.getTextAddress().setText("");
					view.getTextPhonenum().setText("");
					//view.getComboBox().setSelectedItem("02");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Registracia ");
			}
			};view.getbtnPridaj().addActionListener(btnPridaj);	
			
	
	}//end control

}//end class
