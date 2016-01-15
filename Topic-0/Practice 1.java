public class conradDatabase {

	public static Connection connection1 = null;

	private conradDatabase () {
	}

	public static Connection getInstance (){
		if (connection1 == null) {
			Connection connection1 = DriverManager.getConnection ("fake URL","Conrado","");
		}
		return connection1;
	}
}
