package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stinkelectronics.helpdesk.model.Account;

@Configuration
@Repository
public class AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Account getAccountbyUserID(String UserID) {
		try {
			String a = "SELECT * FROM account WHERE UserID =?";
				return jdbcTemplate.queryForObject(a, new Object[] {UserID}, new AccountRowMapper()); 
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Account();
		}
	}
	public Account getAccountbyEmail(String Email) {
		try {
			String b = "SELECT * FROM account WHERE Email =?";
			return jdbcTemplate.queryForObject(b, new Object[] {Email}, new AccountRowMapper());
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Account();
		}
	}	
	public Account getAccountbyPassword(String Password) {
		try {
			String c = "SELECT * FROM account WHERE Password =?";
			return jdbcTemplate.queryForObject(c, new Object[] {Password}, new AccountRowMapper());
		}catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			return new Account();
		}
	}
}
