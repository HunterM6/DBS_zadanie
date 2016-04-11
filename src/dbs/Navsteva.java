package dbs;

import java.util.Date;

public class Navsteva {
	
	  private int id;
	  private int pacient_id;
	  private String problem;
	  private String diagnoza;
	  private Date datee;
	  
	  public Navsteva(int id, int pacient_id, Date datee, String problem, String diagnoza ){
		  this.id = id;
		  this.pacient_id = pacient_id;
		  this.problem = problem;
		  this.diagnoza = diagnoza;
		  this.datee = datee;
	  }
	  
	  public Navsteva( int pacient_id, Date datee, String problem, String diagnoza ){
		  this.pacient_id = pacient_id;
		  this.problem = problem;
		  this.diagnoza = diagnoza;
		  this.datee = datee;
	  }
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPacient_id() {
		return pacient_id;
	}
	public void setPacient_id(int pacient_id) {
		this.pacient_id = pacient_id;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getDiagnoza() {
		return diagnoza;
	}
	public void setDiagnoza(String diagnoza) {
		this.diagnoza = diagnoza;
	}
	public Date getDatee() {
		return datee;
	}
	public void setDatee(Date datee) {
		this.datee = datee;
	}

}//end class
