package gui_model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dbs.Pacient;

public class Model_edit extends AllTablesManager_Model{
		
	@Override
	protected Pacient processRow(ResultSet rs) throws SQLException {	
		return (new Pacient(rs.getInt("id"), rs.getString("name"),rs.getString("surname"),rs.getDate("date"),rs.getString("address"),
				rs.getString("phonenum"))); //vsetky udaje pacienta
	}
	
	public List<Pacient> getAllPacients() throws SQLException
	{
		return(selectQuery("SELECT * FROM pacient"));
	}

	
}//end class
