package com.stinkelectronics.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stinkelectronics.helpdesk.model.Profile;

@Repository
@Configuration
public class ProfileDao {
	
	@Autowired
	private JdbcTemplate jtemp;
	
	//query by User ID (Unique)
	public Profile getProfileByUserID(String uid) {
		Profile profile = new Profile();
		try {
			String query = "SELECT * FROM Profile WHERE UserID=?";
			return jtemp.queryForObject(query, new Object[]{uid}, new ProfileRowMapper());
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return profile;
		}
	}
	
	//ask about returning list for nonunique attribute
	//query by Role ID (Non Unique)
	public Profile getProfileByRoleID(int roleid) {
		Profile profile = new Profile();
		try {
			String query = "SELECT * FROM Profile WHERE RoleID=?";
			return jtemp.queryForObject(query, new Object[]{roleid}, new ProfileRowMapper());
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return profile;
		}
	}
	
	//ask about returning list for nonunique attribute
	//query by Repair ID (Non Unique)
	public Profile getProfileByRepairID(int repairid) {
		Profile profile = new Profile();
		try {
			String query = "SELECT * FROM Profile WHERE RepairID=?";
			return jtemp.queryForObject(query, new Object[]{repairid}, new ProfileRowMapper());
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return profile;
		}
	}
	
	public Profile getProfileByEmail(String Email) {
		try {
			String b = "SELECT * FROM Profile WHERE Email=?";
			return jtemp.queryForObject(b, new Object[] {Email}, new ProfileRowMapper());
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Profile();
		}
	}
	
	//exists
	public boolean isUserIdExists(String UserID) {
		try {
			String query = "SELECT * FROM Profile WHERE UserID=?";
			int count = jtemp.queryForObject(query, new Object[] {UserID}, Integer.class);
			return count > 0;
		}
		catch(DataAccessException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	//posts
	
	//create customer profile with no repairs
	public boolean postProfile(Profile profile) {
		try {
			String query = "INSERT INTO Profile (UserID, FirstName, LastName, Email, Password, RoleID, RepairID) VALUES ('" 
					+ profile.getUserID() + "', '" 
					+ profile.getFirstName() + "', '" 
					+ profile.getLastName() + "', '" 
					+ profile.getEmail() + "', '"
					+ profile.getPassword()
					+ "', '1', '0')";
			jtemp.execute(query);
			return true;
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	//updates specified column of profile(by userid) with specified value
	public boolean updateProfile(String uid, String columnName, String update) {
		try {
			String sql = "UPDATE Profile " + 
					"SET " + columnName + "='"
					+ update + "' "
					+ "WHERE UserID='" + uid + "'";
			return true;
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
