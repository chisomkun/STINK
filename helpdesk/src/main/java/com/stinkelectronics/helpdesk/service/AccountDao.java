package com.stinkelectronics.helpdesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stinkelectronics.helpdesk.model.Account;
import com.stinkelectronics.helpdesk.model.Profile;

@Configuration
@Repository
public class AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProfileDao profileDao;
	
	//gets
	public Account getAccountByUserID(String UserID) {
		try {
			String a = "SELECT * FROM account WHERE UserID=?";
				return jdbcTemplate.queryForObject(a, new Object[] {UserID}, new AccountRowMapper()); 
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Account();
		}
	}
	public Account getAccountByEmail(String Email) {
		try {
			String b = "SELECT * FROM account WHERE Email=?";
			return jdbcTemplate.queryForObject(b, new Object[] {Email}, new AccountRowMapper());
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Account();
		}
	}	
	public Account getAccountByPassword(String Password) {
		try {
			String c = "SELECT * FROM account WHERE Password=?";
			return jdbcTemplate.queryForObject(c, new Object[] {Password}, new AccountRowMapper());
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Account();
		}
	}
	
	public boolean isUserIdExists(String UserID) {
		try {
			String query = "SELECT * FROM account WHERE UserID=?";
			int count = jdbcTemplate.queryForObject(query, new Object[] {UserID}, Integer.class);
			return count > 0;
		}
		catch(DataAccessException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	//posts
	public boolean postAccount(Account account, Profile profile) {
		try {
			String query = "INSERT INTO Account (Email, Password, UserID) VALUES ('" + account.getEmail() + "', '" + account.getPassword() + "', '" + account.getUserID() + "')";
			jdbcTemplate.execute(query);
			return profileDao.postProfile(profile);
		}
		catch(DataAccessException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
