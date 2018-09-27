package filtering;

import java.sql.ResultSet;
import java.sql.SQLException;
import functions.DBFunctions;
import functions.Functions_Std;

public class FilterProducts {
	private ResultSet rs = null;
	private String sqlQuery = "select * from courses";
	
	
	/**
	*
	* Objects of this type can be used to create a filtered version of a ResultSet
	*
	*@param subject the subject of the course
	*@param topic the topic of the course
	*@param pricePerHour the price of the course per hour
	*@param capacity the maximum amount of people that can be in the course
	*@param frequency defines how frequent the course is scheduled
	*@param durationPerMeeting how long a course lasts for in minutes
	*@param addressID defines the used address
	*@param seachText the string that is searched for in topic and teacher username
	*/
	public FilterProducts(String subject, String topic, int pricePerHour, int capacity, String frequency, int durationPerMeeting, String addressID, String searchText){
		StringBuilder sBuilder = new StringBuilder();
		Boolean hasAtLeastOneConditionBefore = false;
		
		sBuilder.append(" WHERE ");
		if(searchText != null){
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("(topic LIKE('%" + searchText + "%') OR userID IN(SELECT userID FROM user WHERE username LIKE('%" + searchText + "%')))");
			hasAtLeastOneConditionBefore = true;
		}
		
		if (subject != null) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("LOWER(subject) = '" + subject + "'");	
			hasAtLeastOneConditionBefore = true;
		}
		
		if (topic != null) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("LOWER(topic) = '" + topic + "'");	
			hasAtLeastOneConditionBefore = true;
		}
		
		if (pricePerHour > 0) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("pricePerHour <= " + pricePerHour);	
			hasAtLeastOneConditionBefore = true;
		}
		
		if (capacity > 0) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("capacity <= " + capacity);	
			hasAtLeastOneConditionBefore = true;
		}
		
		if (frequency != null) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("LOWER(frequency) = '" + frequency + "'");	
			hasAtLeastOneConditionBefore = true;
		}
		
		if (durationPerMeeting > 0) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("durationPerMeeting <= " + durationPerMeeting);	
			hasAtLeastOneConditionBefore = true;
		}
		
		if (addressID != null) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("addressID = " + addressID);	
			hasAtLeastOneConditionBefore = true;
		}
		
		if(hasAtLeastOneConditionBefore){
			sqlQuery += sBuilder.toString() + ";";
		} 
	}
	
	/**
	*
	* Objects of this type can be used to create a filtered version of a ResultSet
	*
	*@param sqlQuery The sql query that will be used to get the filtered courses
	*/
	public FilterProducts(String sqlQuery){
		if(!Functions_Std.isStringNullOrEmpty(sqlQuery)){
			this.sqlQuery = sqlQuery;
		}
	}

	/**
	*
	* Gets the filtered courses configured in the constructor
	*
	*@return resultset containing the filtered courses
	*/
	public ResultSet GetFilteredProducts (){
		try {
			if(rs == null){
				rs = DBFunctions.Execute(sqlQuery);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	*
	* Gives the used sql query
	*
	*@return sql query that is used for the filtering
	*/
	public String getSqlQuery(){
		return sqlQuery;
	}
}