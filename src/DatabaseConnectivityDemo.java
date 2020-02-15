import java.sql.*;
public class DatabaseConnectivityDemo {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/employee?useSSL=false";
		String user = "ankit";
		String password = "password";
		String query = "SELECT * FROM phase1";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			int id = rs.getInt("E_id");
			String name = rs.getString("E_name");
			System.out.println(id + " " + name);
		}
		st.close();
		con.close();
	}
}
