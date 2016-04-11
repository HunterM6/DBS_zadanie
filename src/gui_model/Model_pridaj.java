package gui_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import dbs.Pacient;

public class Model_pridaj extends AllTablesManager_Model{

	@Override
	protected Object processRow(ResultSet rs) throws SQLException {
		return (new Pacient(rs.getString("name"),rs.getString("surname"),rs.getDate("date"),rs.getString("address"),
				rs.getString("phonenum"))); //vsetky udaje pacienta
	}
	
	public void pridajPacienta(String name, String surname, Date datee, String address, String phonenum) throws SQLException{
		Pacient pacient = new Pacient(name, surname, datee, address, phonenum);
		String queryString = "INSERT INTO pacient (Name, Surname, date, address, phonenum) VALUES "
				+ "("+"'"+name+"', '"+surname+"', '"+datee+"', '"+address+"', "+"'"+phonenum+"'"+");";
		super.theQuery(queryString);
		System.out.println("queryString = "+queryString);
	}

	


	

}//end class
