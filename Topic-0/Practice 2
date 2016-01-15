public class databaseAF {

	public databaseFactory createDatabaseFactory (String type){
		if ("MySQL".equalsIgnoreCase(type)){
			return new mySQLFactory();
		} else {
			return new mongoDBFactory();
		}
	}
}
