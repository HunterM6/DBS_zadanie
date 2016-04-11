package gui_model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dbs.Pacient;

public class Model_MVC extends AllTablesManager_Model{
	
	private String string;
	private Integer id;
	
	@Override
	protected Pacient processRow(ResultSet rs) throws SQLException {	
		return (new Pacient(rs.getInt("id"), rs.getString("name"),rs.getString("surname"),rs.getDate("date"),rs.getString("address"),
				rs.getString("phonenum"))); //vsetky udaje pacienta
	}
	
	public List<Pacient> getAllPacients() throws SQLException
	{
		return(selectQuery("SELECT * FROM pacient"));
	}

	public String getString(){
		return string;
	}
	public void setString(String s) {
		this.string = s;
	}

	public void updatePacient(Integer id, String name, String surname, Date datee,String address, String phonenum) throws SQLException {
		String queryString = "UPDATE pacient set name ='"+name+"', surname='"+surname +"', date='"+datee
												+"',address='"+address+"' ,phonenum='"+phonenum+"' WHERE id = "+id;
		super.theQuery(queryString);
		System.out.println("queryString = "+queryString);
	}

	public void setId(Integer id) {
		this.id = id;	
	}
	public int getId(){
		return id;
	}

	public void deletePacient(int id_delete) throws SQLException {
		String queryString = "DELETE from pacient WHERE id = "+id_delete+";";
		super.theQuery(queryString);
		System.out.println("queryString = "+queryString);
	}
	


}//end class
