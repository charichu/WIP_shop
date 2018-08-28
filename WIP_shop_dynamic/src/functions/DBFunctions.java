package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFunctions {
	//our connection to access the database
	public static Connection dbCon = null;
	
	public static String[] tableUser = {"userID","username","password","email","userType","firstName","lastName","class","dateOfBirth","studentType","qualificationProfile"}; 	
	
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		//create database connection only once
		Class.forName("con.mysql.jdbc.driver").newInstance();
		dbCon = DriverManager.getConnection("","root","");
	}
	
	public static ResultSet Execute(String query) throws SQLException{
		Statement state = dbCon.createStatement();
		return state.executeQuery(query);
	}
	
	public static String CreateInsertQuery(String tableName, String[] columnNames, String[] columnValues){
		String rvString = ""; // rvString stands for return value string
		//only allow insert to be created when the amount of values/columns is the same
		if (columnNames.length == columnValues.length) {
			String colNamesString = SeperateStrings(", ", columnNames);
			String colValuesString = SeperateStrings(", ", columnValues);
			
			//build the actual string
			rvString = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, colNamesString, colValuesString); 
		}
		
		return rvString;
	}

	public static String CreateSelectQuery(String tableName, String[] columnNames, String whereCondition){
		String rvString = String.format("SELECT %s FROM %s", SeperateStrings(", ", columnNames), tableName);
		if(whereCondition != "" && whereCondition != null)
		{
			rvString += " WHERE " + whereCondition;
		}
		return rvString;
	}
		
	public static String SeperateStrings(String seperator, String[] strings){
		String rvString = "";
		for (int i = 0; i < strings.length; i++) {
			//add seperator when the amount of strings is more than 1
			if (i != 0) {
				rvString += seperator;
			}
			rvString += strings[i];
		}
		return rvString;
	}
	
	public static Boolean ContainsOnlyAllowedChars(String toCheck){
		return !toCheck.contains(";\"");
	}
}
