public class ProxyDatabase {

	Connection connection;

	public Connection connect() {
		if (conection == null) {
			connection = DriverManager.getConnection ("fake URL","Conrado","");
		}
		return connection;
	}
}
