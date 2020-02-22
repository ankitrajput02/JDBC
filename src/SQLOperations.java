import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/college?useSSL=false";
		String user = "ankit"; // database user name
		String pass = "password";
		Scanner sc = new Scanner(System.in);

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		// All Queries
		String displayQuery = "SHOW TABLES";
		String insertQuery = "INSERT INTO ? VALUES(?,?,?,?,?,?)";
		String removeQuery = "";
		String displayTable = "SELECT * FROM student";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		Statement st;
		ResultSet rs;
		int choice;
		// System.out.println("Display Tables In Database");
		do {
			System.out.println("Select choice \n1.Show tables in Database\n2.Describe Table(Column Names)"
					+ "\n3.Insert data into table\n4.Display Table\n5.Delete Record By Using Index\n6.Exit");
			choice = sc.nextInt();
			String tableName = null;
			switch (choice) {
			case 1:
				st = con.createStatement();
				rs = st.executeQuery(displayQuery);
				System.out.println("Tables Present in Database....\n=====================================");
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				break;
			case 2:
				st = con.createStatement();
				rs = st.executeQuery(displayQuery);
				System.out.println("Tables Present in Database....\n=====================================");
				while (rs.next()) {
					System.out.println(rs.getString(1));

				}
				System.out.println("Enter Table Name...");
				tableName = sc.next();
				//Query to Display Table
				rs = st.executeQuery("DESCRIBE " + tableName + "");
				while (rs.next()) {
					System.out.print(rs.getString(1)+" ");
				}
				break;

			case 3:
				System.out.println("Enter Table Name...");
				tableName = sc.next();
				if (tableName.equalsIgnoreCase("student")) {
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
					ps.setString(1,tableName);
					ps.setInt(2, sId);
					ps.setString(3, firstName);
					ps.setString(4, lastName);
					ps.setString(5, sClass);
					ps.setFloat(6, perc);
					ps.setString(7, status);
					int count = ps.executeUpdate();
					System.out.println(count + "row affected");
					
				}
				break;
			case 4:
				
				st = con.createStatement();
				rs = st.executeQuery(displayTable);
				System.out.println("Roll No\tFisrt Name Last Name\t\tClass\tPercentage\tStatus");
				System.out.println("------------------------------------------------------------");
				while (rs.next()) {
					int id = rs.getInt("roll_no");
					String firstName = rs.getString("firstName");
					String lastName = rs.getString("lastName");
					String sClass = rs.getString("class");
					float perc = rs.getFloat("percentage");
					String status = rs.getString("status");
					System.out.println(id + "\t" + firstName +"\t"+ lastName + "\t" + sClass + "\t" + perc + "\t\t" + status);
				}
				break;
			case 5:
				

			default:
				System.out.println("Please enter valid choice");
			}
	
		}while(choice!=6);
		
		sc.close();
		ps.close();
		con.close();

	}

}
