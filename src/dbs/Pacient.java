package dbs;

import java.sql.Connection;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Pacient {  
     
     private int id;
     private String name;
     private String surname;
     private String date;
     private String address;
     private String phonenum;
     private Date datee;
     
     public Pacient() {
     }
     public Pacient(String name, String surname){
    	setName(name);
    	setSurname(surname);
     }
     public Pacient(Integer id, String name, String surname, Date datee, String address, String phonenum){
    	 setId(id);
    	setName(name);
     	setSurname(surname);
     	setDatee(datee);
    	setAddress(address);
    	setPhonenum(phonenum);
     }
     
  
	public Pacient(String name2, String surname2, Date datee2, String address2,String phonenum2) {
		setName(name2);
     	setSurname(surname2);
     	setDatee(datee2);
    	setAddress(address2);
    	setPhonenum(phonenum2);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getDatee() {
		return datee;
	}
	public void setDatee(Date datee) {
		this.datee = datee;
	}
	 

}//end class
