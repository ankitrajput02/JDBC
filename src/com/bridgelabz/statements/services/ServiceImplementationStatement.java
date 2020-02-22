package com.bridgelabz.statements.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.statements.connections.DatabaseConnectivity;
import com.bridgelabz.statements.model.Student;

public class ServiceImplementationStatement {
	static DatabaseConnectivity connectivity = new DatabaseConnectivity();
	static Statement statement = null;
	static Connection con = DatabaseConnectivity.connect();
	static Student student = new Student();

	public void showTable() throws SQLException {
		// TODO Auto-generated method stub
		DatabaseConnectivity.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM student");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getFloat(5) + "\t" + rs.getString(6));
		}
	}

	public void addStudent(int sID, String firstName, String lastName, String year, float percentage, String status) {
		String query="INSERT INTO student VALUES("+sID+",'"+firstName+"','"+lastName+"','"+year+"',"+percentage+",'"+status+"')";
		try {
			Statement st = con.createStatement();//Execute Query
			st.executeUpdate(query);//executes the query. It is used for create, drop, insert, update, delete etc
			System.out.println("Student Record Added");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void removeStudent(int sID) {// Remove Student
		String query = "DELETE FROM student WHERE roll_no="+sID;
		try {
			DatabaseConnectivity.connect();
			Statement st = con.createStatement();
			st.executeUpdate(query);//executes the query. It is used for create, drop, insert, update, delete etc
			System.out.println("Deleted the Student");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void updateStudent(String fName,String lName,String status) {
		String query = "UPDATE student SET status='"+status+"' WHERE FirstName='"+fName+"' AND LastName='"+lName+"' ";
		try {
			DatabaseConnectivity.connect();
			Statement st=con.createStatement();
			st.executeUpdate(query);
			System.out.println("Record Updated");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void createTable(String tableName) {
		String query="CREATE TABLE "+tableName+"(roll_no INT NOT NULL,FirstName VARCHAR(10) ,LastName VARCHAR(10),YEAR CHAR(4),Marks FLOAT,status char(4))";
	try {
		DatabaseConnectivity.connect();
		Statement st=con.createStatement();
		st.executeUpdate(query);
		System.out.println("Table Created Successfully");
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	}
	public void showPositionData(int sID) throws SQLException {
		String query="SELECT * FROM student WHERE roll_no="+sID;
		DatabaseConnectivity.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getFloat(5) + "\t" + rs.getString(6));
		
	}
}


