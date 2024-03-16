package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracleconnection {
   public static void main(String[] args) throws SQLException {
	   Connection conn=null;
	   Statement state=null;
	   String DB_URL="jdbc:oracle:thin:@localhost:1521:xe";
	   String User= "system";
	   String Pass="admin";
	   try {
	   conn=DriverManager.getConnection(DB_URL,User,Pass);
	   if(conn!=null)
	   {
		   System.out.println("Database connected successfully");
	   }
	   else {
		   System.out.println("Database not connected");
	   }
   }
	   catch(SQLException e) {
		   System.err.format("SQL state: %s \n %s",e.getSQLState(),e.getMessage());
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   
//	 creating a table:
	   state= conn.createStatement();
	   String sql="CREATE TABLE EMPLOYEE" + "(EMPID INTEGER not NULL," 
	   		+  " FIRSNAME VARCHAR(255)," 
	   		+  " LASTNAME VARCHAR(255)," 
	   		+ " PRIMARY KEY ( EMPID ))";
	   
	state.executeUpdate(sql);
	System.out.println("Table created successfully");
	
	System.out.println("Inserting records into the table...");
	                String data = "INSERT INTO EMPLOYEE VALUES (100, 'John', 'Doe')";
	                state.executeUpdate(data);
	                data = "INSERT INTO EMPLOYEE VALUES (101, 'jane', 'Smith')";
	                state.executeUpdate(data);
	                data = "INSERT INTO EMPLOYEE VALUES (102, 'Alice', 'Johnson')";
	                state.executeUpdate(data);
	                System.out.println("Inserted records into the table...");
	}
}
