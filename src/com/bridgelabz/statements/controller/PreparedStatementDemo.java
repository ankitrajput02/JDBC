package com.bridgelabz.statements.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.statements.connections.DatabaseConnectivity;
import com.bridgelabz.statements.services.ServiceImplementationPrepare;

public class PreparedStatementDemo {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DatabaseConnectivity connectivity = new DatabaseConnectivity();
		ServiceImplementationPrepare preparedImplementation = new ServiceImplementationPrepare();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Select Choice \n1.Insert Record\n2.Show Record\n"
					+ "3.Delete Record\n4.Update Record\n5.Get data by using Roll No\n6.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// Insert record
				preparedImplementation.showTable();
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
				preparedImplementation.addStudent(sId, firstName, lastName, sClass, perc, status);

				break;
			case 2:
				// Show Record
				preparedImplementation.showTable();
				break;
			case 3:
				// Delete Record
				System.out.println("Enter Student Roll No to Delete The Record");
				sId = sc.nextInt();
				preparedImplementation.removeStudent(sId);
				break;
			case 4:
				// Update Record
				System.out.println("Enter First Name");
				firstName = sc.next();
				System.out.println("Enter Last Name");
				lastName = sc.next();
				System.out.println("Enter Status PASS/FAIL");
				status = sc.next();
				preparedImplementation.updateStudent(firstName, lastName, status);
				break;
//			case 5:
//				// Create Table
//				try {
//					System.out.println("Enter Table Name");
//					String tableName = sc.next();
//					preparedImplementation.createTable(tableName);
//					// System.out.println("Table Created");
//
//				} catch (Exception e) {
//
//					e.printStackTrace();
//				}
//				break;
			case 5:
				// Index Of Data
				try {
				System.out.println("Enter Roll no to get data");
				int roll_no=sc.nextInt();
				preparedImplementation.showPositionData(roll_no);
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				break;
			}
		} while (choice != 6);

	}

}
