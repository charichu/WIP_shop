package functions;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import courseFunctions.Course;

public class DBFunctions {
	//our connection to access the database
	public static Connection dbCon = null;
	
	//columns of tables - saved as string array
	//TODO add other tables(when you use the tables)
	public static String[] tableUser = {"userID","username","password","email","userType","firstName","lastName","class","dateOfBirth","studentType","qualificationProfile","addressID","enabled"}; 	
	public static String[] tableUser_AddUser= {"email","username","password","userType","firstName","lastName","dateOfBirth","class","studentType", "addressID"}; 	
	
	/**
	*
	* Creates the database connection if it does not exist yet
	*
	*/
	public static void initConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		//create database connection only once
		if(dbCon == null){	
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/wip?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		}
	}
	
	/**
	*
	* Executes the given sql query. Cannot manipulate data
	*
	* @param query sql query to be used
	* @return the ResultSet generated be the query
	*/
	public static ResultSet Execute(String query) throws SQLException{
		try {
			initConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
		Statement state = dbCon.createStatement();
		return state.executeQuery(query);			
	}

	/**
	*
	* Executes the given insert/update/delete query
	*
	* @param query sql query to be used
	*/
	public static void Update(String query) throws SQLException{
		try {
			initConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbCon.createStatement().executeUpdate(query);			
	}

	/**
	*
	* Creates Insert query based on parameters. The order of column names and values is relevant.
	*
	* @param tablename name of the table the data will be inserted into
	* @param columnNames array of Strings that contains the names of the relevant columns
	* @param columnValues array of String that contains the values that will be inserted 
	* @return the insert query
	*/
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
	
	/**
	*
	* Creates update query based on parameters. The order of column names and values is relevant.
	*
	* @param tablename name of the table the data will be inserted into
	* @param columnNames array of Strings that contains the names of the relevant columns
	* @param columnValues array of String that contains the values that will be inserted 
	* @param whereCondition contains the condition which rows should be updated
	* @return the update query
	*/
	public static String CreateUpdateQuery(String tableName, String[] columnNames, String[] columnValues, String whereCondition){
		StringBuilder rvString = new StringBuilder(); // rvString stands for return value string
		//only allow insert to be created when the amount of values/columns is the same
		if (columnNames.length == columnValues.length) {
			//build the actual string
			rvString.append("UPDATE " + tableName + " SET ");
			for(int i = 0; i < columnValues.length ; i++) {
				if(i != 0){
					rvString.append(", ");
				}
				rvString.append(columnNames[i] + " = " + columnValues[i]);
			}
			if(!Functions_Std.isStringNullOrEmpty(whereCondition)){
				rvString.append(" WHERE " + whereCondition);
			}
		}
		
		return rvString.toString();
	}

	/**
	*
	* Creates select query based on parameters. The order of column names and values is relevant.
	*
	* @param tablename name of the table the data will be inserted into
	* @param columnNames array of Strings that contains the names of the columns
	* @param whereCondition contains the condition which rows should be selected
	* @return the select query
	*/
	public static String CreateSelectQuery(String tableName, String[] columnNames, String whereCondition){
		String rvString = String.format("SELECT %s FROM %s", SeperateStrings(", ", columnNames), tableName);
		if(whereCondition != "" && whereCondition != null)
		{
			rvString += String.format(" WHERE %s",whereCondition);
		}
		return rvString;
	}

	/**
	*
	* Creates a String of Strings in an Array separated by the separator
	*
	* @param seperator separator used inbetween the strings
	* @param string array of the String to be separated
	* @return strings separated by the separator
	*/
	public static String SeperateStrings(String separator, String[] strings){
		String rvString = "";
		for (int i = 0; i < strings.length; i++) {
			//add seperator when the amount of strings is more than 1
			if (i != 0) {
				rvString += separator;
			}
			rvString += strings[i];
		}
		return rvString;
	}
	
	/**
	*
	* Checks if the parameter only contains chars allowed in our sql querys
	*
	* @param toCheck String that will be checked
	* @return  true if the String does not contain forbidden characters
	*/
	public static Boolean ContainsOnlyAllowedChars(String toCheck){
		return !toCheck.contains(";");
	}
	
	/**
	*
	* Returns a ResultSet containing the courses with the given courseIDs
	*
	* @param courseIDs IDs of the courses to look for
	* @return ResultSet containing the courses
	*/
	public static ResultSet getCoursesbyCouseID(int[] courseIDs){
		String sqlStatement = "Select * From courses Where courseID in (";
		ResultSet rs;
		if(courseIDs != null){
			for (Integer integer : courseIDs) {
				sqlStatement += integer+", ";
			}
			sqlStatement=sqlStatement.substring(0, sqlStatement.length()-1)+");";
			try {
				rs=dbCon.createStatement().executeQuery(sqlStatement);
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		else {
			return null;
		}
	}
}
