package functions;

import java.sql.ResultSet;

/**
 * the address of the wip_shop used in course and user
 * @author werner
 */
public class Address {
	private Integer addressID;
	private Integer plz;
	private String city;
	private String street;
	private Integer houseNumber;
	private boolean isEmpty = true;
	
	/**
	 * placeholder constructor
	 */
	public Address(){
		
	}
	/**
	 * get the addess out of the database with the addressID as parameter
	 * @param addressID
	 */
	public Address(Integer addressID){
		String sqlStatement;
		sqlStatement=DBFunctions.CreateSelectQuery("addresses", new String[]{"*"}, "addressID ="+addressID);
		try {
			ResultSet rs = DBFunctions.Execute(sqlStatement);
			if(rs.next()){
				this.addressID   = rs.getInt("addressID");
				this.plz	     = rs.getInt("plz");
				this.city        = rs.getString("city");
				this.street      = rs.getString("street");
				this.houseNumber = rs.getInt("housenumber");
				this.isEmpty     = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public Integer getPlz() {
		return plz;
	}

	public void setPlz(Integer plz) {
		this.plz = plz;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
}
