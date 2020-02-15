import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseInsertSimpleStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/employee?useSSL=false";
		String  user="ankit";
		String pass="password";
		int E_id=6;
		String E_name="Aakash";
		String query="INSERT INTO phase1 VALUES("+E_id+",'"+E_name+"')";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, user, pass);
		Statement st=con.createStatement();
		int count=st.executeUpdate(query);
		System.out.println(count+"row affected");
		st.close();
		con.close();


	}

}
