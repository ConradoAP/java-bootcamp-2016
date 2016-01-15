public class ProxyDatabase {

	Connection connection;

	public Connection connect() {
		if (connection == null) {
			connection = DriverManager.getConnection ("fake URL","Conrado","");
		}
		return connection;
	}
}
