package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class JDBC_Connection {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner input= new Scanner(System.in);
		System.out.println("enter firstname");
		String firstname= input.next();
		System.out.println("Enter lastname");
		String lastname= input.next();
		
		try {
			// step 1: load the driver class.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//step 2: create the connection object
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","admin");
			
			PreparedStatement ps= conn.prepareStatement("insert into student (firstname,lastname) values (?,?)");
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			
			int z=ps.executeUpdate();
			if(z>0) {
				System.out.print("saved");
			}
			else {
				System.out.print("not saved");
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
