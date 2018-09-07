package filtering;

import java.sql.ResultSet;
import java.sql.SQLException;

import functions.DBFunctions;

public class FilterProducts {
	private ResultSet rs = null;
	
	public FilterProducts(String subject, String topic, int pricePerHour, String capacity, String frequency, String durationPerMeeting, String addressID){
		StringBuilder sBuilder = new StringBuilder();
		try {
			Boolean hasAtLeastOneConditionBefore = false;
			sBuilder.append("select * from courses WHERE ");
			if (subject != null) {
				if (hasAtLeastOneConditionBefore) {
					sBuilder.append(" AND ");						
				}
				sBuilder.append("subject = '" + subject + "'");	
				hasAtLeastOneConditionBefore = true;
			}

			if (topic != null) {
				if (hasAtLeastOneConditionBefore) {
					sBuilder.append(" AND ");						
				}
				sBuilder.append("topic = '" + topic + "'");	
				hasAtLeastOneConditionBefore = true;
			}
			
			if (pricePerHour > 0) {
				if (hasAtLeastOneConditionBefore) {
					sBuilder.append(" AND ");						
				}
				sBuilder.append("pricePerHour = " + pricePerHour);	
				hasAtLeastOneConditionBefore = true;
			}
			
			if (capacity != null) {
				if (hasAtLeastOneConditionBefore) {
					sBuilder.append(" AND ");						
				}
				sBuilder.append("capacity = '" + capacity + "'");	
				hasAtLeastOneConditionBefore = true;
			}
			
			if (frequency != null) {
				if (hasAtLeastOneConditionBefore) {
					sBuilder.append(" AND ");						
				}
				sBuilder.append("frequency = '" + frequency + "'");	
				hasAtLeastOneConditionBefore = true;
			}
			
			if (durationPerMeeting != null) {
				if (hasAtLeastOneConditionBefore) {
					sBuilder.append(" AND ");						
				}
				sBuilder.append("durationPerMeeting = '" + durationPerMeeting + "'");	
				hasAtLeastOneConditionBefore = true;
			}
			
			if (addressID != null) {
				if (hasAtLeastOneConditionBefore) {
					sBuilder.append(" AND ");						
				}
				sBuilder.append("addressID = '" + addressID + "'");	
				hasAtLeastOneConditionBefore = true;
			}
			
			if(hasAtLeastOneConditionBefore){
				rs = DBFunctions.Execute(sBuilder.toString());				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet GetFilteredProducts (){
		return rs;
	}
}