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
		String pass="password";
		Scanner sc=new Scanner(System.in);
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		//All Queries
		String displayQuery="SHOW TABLES";
		Statement st;
		ResultSet rs;
		//System.out.println("Display Tables In Database");
		System.out.println("Select choice \n1.Show tables in Database\n2.Insert Values In Table"
				+ "\n3.Insert data into table\n4.Display Table");
		int choice=sc.nextInt();
		String tableName = null;
		switch(choice) {
		case 1:
			
			
			st = con.createStatement();
			rs = st.executeQuery(displayQuery);
			System.out.println("Tables Present in Database....\n=====================================");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			break;
		case 2:
			st = con.createStatement();
			rs = st.executeQuery(displayQuery);
			System.out.println("Tables Present in Database....\n=====================================");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			
			}
			System.out.println("Enter Table Name...");
			tableName=sc.next();
			rs=st.executeQuery("DESCRIBE "+tableName+"");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			break;
			
		case 3:
			System.out.println("Enter Table Name...");
			tableName=sc.next();
			if(tableName.equalsIgnoreCase("student")) {
				System.out.println("Enter Student ID");
				int sId=sc.nextInt();
				System.out.println("Enter Student Name");
				String sName=sc.next();
				System.out.println("Enter Class");
				String sClass=sc.next();
				System.out.println("Enter Percentage");
				float perc=sc.nextFloat();
				System.out.println("Enter Status PASS/FAIL");
				String status=sc.next();
				String query = "INSERT INTO student VALUES(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1,sId);
				ps.setString(2, sName);
				ps.setString(3, sClass);
				ps.setFloat(4, perc);
				ps.setString(5, status);
				int count = ps.executeUpdate();
				System.out.println(count + "row affected");
				ps.close();
				con.close();
				
				}
			break;
		case 4:
			String displayTable="SELECT * FROM student";
			st = con.createStatement();
			rs = st.executeQuery(displayTable);
			System.out.println("Roll No\tName\t\tClass\tPercentage\tStatus");
			System.out.println("------------------------------------------------------------");
			while (rs.next()) {
				int id = rs.getInt("roll_no");
				String name = rs.getString("name");
				String sClass=rs.getString("class");
				float perc=rs.getFloat("percentage");
				String status=rs.getString("status");
				System.out.println(id + "\t" + name+"\t"+sClass+"\t"+perc+"\t\t"+status);
			}
			break;
		default:
			System.out.println("Please enter valid choice");
		}
		
		sc.close();
	}

}
