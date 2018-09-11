package filtering;

import java.sql.ResultSet;
import java.sql.SQLException;
import functions.DBFunctions;
import functions.Functions_Std;

public class FilterProducts {
	private ResultSet rs = null;
	private String sqlQuery = "select * from courses";
	
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
			sBuilder.append("pricePerHour = " + pricePerHour);	
			hasAtLeastOneConditionBefore = true;
		}
		
		if (capacity > 0) {
			if (hasAtLeastOneConditionBefore) {
				sBuilder.append(" AND ");						
			}
			sBuilder.append("capacity = " + capacity);	
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
			sBuilder.append("durationPerMeeting = " + durationPerMeeting);	
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
	
	public FilterProducts(String sqlQuery){
		if(!Functions_Std.isStringNullOrEmpty(sqlQuery)){
			this.sqlQuery = sqlQuery;
		}
	}
	
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
	
	public String getSqlQuery(){
		return sqlQuery;
	}
}