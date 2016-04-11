package app;

import gui_kontroler.Kontroler_MVC;
import gui_kontroler.Kontroler_edit;
import gui_kontroler.Kontroler_navsteva;
import gui_kontroler.Kontroler_pridaj;
import gui_model.Model_MVC;
import gui_model.Model_edit;
import gui_model.Model_navsteva;
import gui_model.Model_pridaj;
import gui_view.Okno_MVC;
import gui_view.Okno_edit;
import gui_view.Okno_navsteva;
import gui_view.Okno_pridaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				runApplication();
			}		
		});				
	}//end main
	
	public static void runApplication(){
		Okno_MVC okno = new Okno_MVC();	
		Model_MVC model = new Model_MVC();	
			
		Okno_pridaj okno_pridaj = new Okno_pridaj(); 
		Model_pridaj model_pridaj = new Model_pridaj();
		
		Okno_edit okno_edit = new Okno_edit();
		Model_edit model_edit = new Model_edit();
		
		Okno_navsteva okno_navsteva = new Okno_navsteva();
		Model_navsteva model_navsteva = new Model_navsteva();
			
		Kontroler_MVC kontrol = new Kontroler_MVC(model, okno, okno_pridaj, okno_edit, okno_navsteva); //kontroler
		Kontroler_pridaj kontrol_pridaj = new Kontroler_pridaj(model_pridaj,okno_pridaj);
		Kontroler_edit kontrol_edit = new Kontroler_edit(model, okno_edit, okno, model_navsteva);
		Kontroler_navsteva kontrol_navsteva = new Kontroler_navsteva(model, model_navsteva, okno_navsteva, okno);
		
		kontrol.control();
		kontrol_pridaj.control();
		kontrol_edit.control();
		kontrol_navsteva.control();
	}
}//end class
