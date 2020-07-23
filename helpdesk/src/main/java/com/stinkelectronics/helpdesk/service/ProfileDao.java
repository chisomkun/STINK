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
	
	//posts
	public boolean postProfile(Profile profile) {
		try {
			String query = "INSERT INTO Profile (UserID, FirstName, LastName, RoleID, RepairID) VALUES ('" + profile.getUserID() + "', '" +  profile.getFirstName() + "', '" + profile.getLastName() + "', '1', '0')";
			jtemp.execute(query);
			return true;
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
