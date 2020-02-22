package com.bridgelabz.statements.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.statements.connections.DatabaseConnectivity;
import com.bridgelabz.statements.model.Student;
import com.bridgelabz.statements.services.ServiceImplementationStatement;

public class SimpleStatementDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		DatabaseConnectivity connectivity = new DatabaseConnectivity();
		ServiceImplementationStatement serviceImplementation = new ServiceImplementationStatement();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println(
					"Select Choice \n1.Insert Record\n2.Show Record\n3.Delete Record\n4.Update Record\n5.Create Table\n6.Position of data\n7.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// Insert record
				serviceImplementation.showTable();
				System.out.println("Enter Student ID");
				int sId = sc.nextInt();
				System.out.println("Enter Student First Name");
				String firstName = sc.next();
				System.out.println("Enter Student Last Name");
				String lastName = sc.next();
				System.out.println("Enter Class");
				String sClass = sc.next();
				System.out.println("Enter Percentage");
				float perc = sc.nextFloat();
				System.out.println("Enter Status PASS/FAIL");
				String status = sc.next();
				serviceImplementation.addStudent(sId, firstName, lastName, sClass, perc, status);
				break;
			case 2:
				// Show Record
				serviceImplementation.showTable();
				break;
			case 3:
				// Delete Record
				// serviceImplementation.showTable();
				System.out.println("Enter Student Roll No to Delete The Record");
				sId = sc.nextInt();
				serviceImplementation.removeStudent(sId);
				break;
			case 4:
				// Update Record
				// serviceImplementation.showTable();
				System.out.println("Enter First Name");
				firstName = sc.next();
				System.out.println("Enter Last Name");
				lastName = sc.next();
				System.out.println("Enter Status PASS/FAIL");
				status = sc.next();
				serviceImplementation.updateStudent(firstName, lastName, status);
				// System.out.println("Record Updated");
				break;
			case 5:
				// Create Table
				try {
					System.out.println("Enter Table Name");
					String tableName = sc.next();
					serviceImplementation.createTable(tableName);
					// System.out.println("Table Created");

				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			case 6:
				// Get data from Id
				System.out.println("Enter Roll No");
				int id = sc.nextInt();
				serviceImplementation.showPositionData(id);
				break;
			case 7:
				break;
			default:
				System.out.println("Please Select Correct Choice");
			}
		} while (choice != 7);
	}

}
