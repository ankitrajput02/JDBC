import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseInsertPreparedStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
		String user = "ankit"; // database user name
		String pass = "password"; // database password
		System.out.println("Insert Employee ID");
		int E_id = sc.nextInt();
		System.out.println("Insert Employee Name");
		String E_name = sc.next();
		String query = "INSERT INTO phase1 VALUES(?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, E_id);
		st.setString(2, E_name);
		int count = st.executeUpdate();
		System.out.println(count + "row affected");
		st.close();
		con.close();
		sc.close();
	}
}
