package gui_model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.JTextArea;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dbs.Navsteva;
import dbs.Pacient;

public class Model_navsteva extends AllTablesManager_Model{
	
	private String string;
	private Integer id;
	private Integer pacient_id;
	private Integer number;
	
	@Override
	protected Navsteva processRow(ResultSet rs) throws SQLException {	
		return (new Navsteva( rs.getInt("id"), rs.getInt("pacient_id"),rs.getDate("datum"),rs.getString("problem"),
				rs.getString("diagnoza")) ); //vsetky udaje pacienta
	}
	
	public List<Navsteva> getAllNavsteva() throws SQLException
	{
		return(selectQuery("SELECT * FROM navsteva"));
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void addVisit(Integer id2, Date datee, String problem, String diagnose) throws SQLException {
		Navsteva navsteva = new Navsteva(id2, datee, problem, diagnose);
		String queryString = "INSERT INTO navsteva (pacient_id, datum, problem, diagnoza) VALUES "
				+ "("+"'"+id2+"', '"+datee+"', '"+problem+"', '"+diagnose+"');";
		super.theQuery(queryString);
		System.out.println("queryString = "+queryString);
		
	}

	public Integer getPacient_id() {
		return pacient_id;
	}

	public void setPacient_id(Integer pacient_id) {
		this.pacient_id = pacient_id;
	}

	public void deleteVisit(int id_delete) throws SQLException {
		String queryString = "DELETE from navsteva WHERE pacient_id = "+id_delete+";";
		super.theQuery(queryString);
		System.out.println("queryString = "+queryString);
		
	}


}//end class
