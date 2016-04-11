package gui_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

public abstract class AllTablesManager_Model {

	protected List selectQuery(String queryString) throws SQLException{
		List result = new LinkedList();
		Connection con = null;
		Statement stmt = null;
		Properties connectionProps = new Properties();
	    connectionProps.put("user", "postgres");
	    connectionProps.put("password", "marekmarcin");
	    String connectionString = "jdbc:postgresql://localhost:5432/DBS_projekt";
	    try {
			con = DriverManager.getConnection(connectionString, connectionProps);
			System.out.println("Opened database successfully");
			con.setAutoCommit(false);
	        
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			while(rs.next()){
				result.add(processRow(rs));
			}
			con.commit();
		} catch ( Exception e ) {
	    	   if (con != null){
	    		   try {
	    		   System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	    		   System.err.print("Transaction is being rolled back");
	    		   con.rollback();
	    		   System.exit(0);
	    		   } catch (SQLException excep) { }
	    	   }
	    	} finally {
	    	   if(stmt != null){
					stmt.close();
					System.out.println("stmt close!");
				}
	       }
		return result;
	}//end
	
	public void theQuery(String query) throws SQLException{
		Connection con = null;
	      Statement stmt = null;
	      try{
	          con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBS_projekt","postgres","marekmarcin");
	          con.setAutoCommit(false);
	          
	          stmt = con.createStatement();          
	          stmt.executeUpdate(query);
	          con.commit();
	          
	      } catch ( Exception e ) {
	    	   if (con != null){
	    		   try {
	    		   System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	    		   System.err.print("Transaction is being rolled back");
	    		   con.rollback();
	    		   System.exit(0);
	    		   } catch (SQLException excep) { }
	    	   }
	    	} finally {
	    	   if(stmt != null){
					stmt.close();
					System.out.println("stmt close!");
				}
	       }
	}//end


	protected abstract Object processRow(ResultSet rs) throws SQLException;


	
}//end class
