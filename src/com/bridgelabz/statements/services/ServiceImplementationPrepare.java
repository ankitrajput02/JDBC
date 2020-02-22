package com.bridgelabz.statements.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.statements.connections.DatabaseConnectivity;
import com.bridgelabz.statements.model.Student;

public class ServiceImplementationPrepare {
	static DatabaseConnectivity connectivity = new DatabaseConnectivity();
	static Statement statement = null;
	static Connection con = DatabaseConnectivity.connect();
	static Student student = new Student();

	public void showTable() throws SQLException {
		String query = "SELECT * FROM student";
		DatabaseConnectivity.connect();
		PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getFloat(5) + "\t" + rs.getString(6));
		}

	}

	public void addStudent(int sID, String firstName, String lastName, String year, float percentage, String status)
			throws SQLException {
		DatabaseConnectivity.connect();
		String query = "INSERT INTO student VALUES(?,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, sID);
		preparedStatement.setString(2, firstName);
		preparedStatement.setString(3, lastName);
		preparedStatement.setString(4, year);
		preparedStatement.setFloat(5, percentage);
		preparedStatement.setString(6, status);
		int count = preparedStatement.executeUpdate();
		System.out.println(count + "Row Affected");

	}

	public void removeStudent(int sID) {// Remove Student
		String query = "DELETE FROM student WHERE roll_no=?";
		try {
			DatabaseConnectivity.connect();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, sID);
			ps.executeUpdate();// executes the query. It is used for create, drop, insert, update, delete etc
			System.out.println("Deleted the Student");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateStudent(String firstName, String lastName, String status) {
		// TODO Auto-generated method stub
		String query = "UPDATE student SET status=? WHERE FirstName=? AND LastName=?";
		try {
			DatabaseConnectivity.connect();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, status);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.executeUpdate();
			System.out.println("Record Updated");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

//	public void createTable(String tableName) {
//		// TODO Auto-generated method stub
//		String query = "CREATE TABLE '?' (roll_no INT NOT NULL,FirstName VARCHAR(10) ,LastName VARCHAR(10),YEAR CHAR(4),Marks FLOAT,status char(4))";
//		try {
//			DatabaseConnectivity.connect();
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(0, tableName);
//			ps.executeUpdate();
//			System.out.println("Table Created Successfully");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}

	public void showPositionData(int sID) throws SQLException {
		String query = "SELECT * FROM student WHERE roll_no=?";
		DatabaseConnectivity.connect();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, sID);
		ResultSet rs = ps.executeQuery();
		rs.next();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
				+ "\t" + rs.getFloat(5) + "\t" + rs.getString(6));

	}

}
