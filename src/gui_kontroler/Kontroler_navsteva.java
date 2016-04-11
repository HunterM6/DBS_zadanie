package gui_kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dbs.Navsteva;
import dbs.Pacient;
import gui_model.Model_MVC;
import gui_model.Model_edit;
import gui_model.Model_navsteva;
import gui_view.Okno_MVC;
import gui_view.Okno_edit;
import gui_view.Okno_navsteva;
import gui_view.Okno_pridaj;

public class Kontroler_navsteva {

	private Model_MVC model;
	private Okno_navsteva view;
	private Okno_MVC okno_mvc;
	private Model_navsteva model_navsteva;
	
	private ActionListener btnAllPacients;
	private ActionListener btnAdd;

	public Kontroler_navsteva(Model_MVC model, Model_navsteva model_navsteva, Okno_navsteva okno_navsteva, Okno_MVC okno_mvc) {
		this.model = model;
		this. view = okno_navsteva;
		this. okno_mvc = okno_mvc;
		this.model_navsteva = model_navsteva;
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
		/*
		btnUpdate = new ActionListener() {
			public void actionPerformed(ActionEvent e) { //zobrazi tabulku pacientov	
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, Integer.parseInt(view.getComboBox_2().getSelectedItem().toString()));
				cal.set(Calendar.MONTH, Integer.parseInt(view.getComboBox_1().getSelectedItem().toString()));
				cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(view.getComboBox().getSelectedItem().toString()));
				Date datee = new Date(cal.getTime().getTime());
				

				try {
					model.updatePacient(model.getId(), update_name, update_surname, datee, update_address, update_phonenum);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Update pacient");
			}
			};view.getBtnUpdate().addActionListener(btnUpdate);
		*/
		btnAllPacients = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getDLM().removeAllElements(); //vynuluje list pri dalsom zobrazeni
				view.getDLM_list_navstevy().removeAllElements(); //vynuluje list pri dalsom zobrazeni

				try {
					for (Pacient pacos : model.getAllPacients()) {
						view.getDLM().addElement(pacos.getName()+" "+pacos.getSurname()+" "+ pacos.getPhonenum()); //pridam do listu meno a prizvisko						
					}
					view.getList().setModel(view.getDLM()); //nastavim list na DLM ->zobrazi list
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			 							
			}
			};view.getBtnAllPacients().addActionListener(btnAllPacients);
			
			
			
		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				view.getDLM_list_navstevy().removeAllElements(); //vynuluje list pri dalsom zobrazeni
				// vyberem si hodnoty : Meno a telefonne cislo
				Integer index = null;
				String name = null;				
				String phonenum = null;
				String fullname = (String) view.getList().getSelectedValue();
				if (fullname!= null && fullname.length()>0){
				index = fullname.indexOf(" "); 				
				name = fullname.substring(0 , index);				
				phonenum = extractDigits(fullname);
				}
				try {
					for (Pacient pacos : model.getAllPacients()) {
						if(pacos.getName().equals(name) && pacos.getPhonenum().equals(phonenum)){
							model_navsteva.setId(pacos.getId());
							model_navsteva.setPacient_id(pacos.getId());
							System.out.println("pacos id = "+pacos.getId());
						}					
					}
					for (Navsteva navsteva : model_navsteva.getAllNavsteva()){
						System.out.println("model_navsteva id="+model_navsteva.getId());
						if (navsteva.getPacient_id()== model_navsteva.getPacient_id())
						view.getDLM_list_navstevy().addElement(navsteva.getId()+". "+navsteva.getDatee()+" "+navsteva.getProblem()); //pridam do listu navstevy
					}
						//model_navsteva.numberOfVisits(model_navsteva.getId());
						view.getList_navstevy().setModel(view.getDLM_list_navstevy()); //nastavim list na DLM ->zobrazi list
						
				} catch (SQLException e1) { e1.printStackTrace(); }
				index= 0;
			}
		});
		
		btnAdd = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//view.getDLM().removeAllElements(); //vynuluje list pri dalsom zobrazeni

				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, Integer.parseInt(view.getComboBox_2().getSelectedItem().toString()));
				cal.set(Calendar.MONTH, Integer.parseInt(view.getComboBox_1().getSelectedItem().toString()));
				cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(view.getComboBox().getSelectedItem().toString()));
				Date datee = new Date(cal.getTime().getTime());
				
				try {
					model_navsteva.addVisit(model_navsteva.getId(), datee, view.getTextAreaProblem().getText(), view.getTextFieldDiagnose().getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				view.getTextAreaProblem().setText("");
				view.getTextFieldDiagnose().setText("");
				view.getTextFieldDiagnose().setText("");
				JOptionPane.showMessageDialog(null,"Visit added ");
				view.getDLM_list_navstevy().removeAllElements(); //vynuluje list pri dalsom zobrazeni
				view.getDLM().removeAllElements();
			}
			};view.getbtnAdd().addActionListener(btnAdd);	
			
		view.getList_navstevy().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					//view.getDLM_list_navstevy().removeAllElements(); //vynuluje list pri dalsom zobrazeni
					// vyberem si hodnoty : Meno a telefonne cislo
					Integer index = null;
					String id_substring = null;
					String fullname = (String) view.getList_navstevy().getSelectedValue();
					if (fullname!=null && fullname.length()>0){
					index = fullname.indexOf("."); 				
					id_substring = fullname.substring(0, index);	
					}
					//Integer id = null;

					try {							
						for (Navsteva navsteva : model_navsteva.getAllNavsteva()){
							if (Integer.parseInt(id_substring) == navsteva.getId()){
								System.out.println("id_substring="+id_substring+" navsteva.getId()="+navsteva.getId());
								view.getTextFieldDiagnose().setText(navsteva.getDiagnoza());
								view.getTextAreaProblem().setText(navsteva.getProblem());
								
								//model_navsteva.setId(Integer.parseInt(id_substring));
							}
						}
			
					} catch (SQLException e1) { e1.printStackTrace(); }
					index= 0;
				}
			});
	
	}//end control


}//end class
