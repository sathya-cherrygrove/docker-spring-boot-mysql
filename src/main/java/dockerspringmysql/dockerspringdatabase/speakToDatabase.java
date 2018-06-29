package dockerspringmysql.dockerspringdatabase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@RestController
public class speakToDatabase {
	
	@RequestMapping("/getdata")
	public static String speakToDB(@RequestParam("name") String name)
	{
		
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://mysqlhost:3306/addressdatabase","root","");
		Statement statement = (Statement) con.createStatement();
		Boolean result = statement.execute("insert into addresstable values('sathya','No10 luxor view')");
		
		con.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "Statement Executed";
	 
	}

}
