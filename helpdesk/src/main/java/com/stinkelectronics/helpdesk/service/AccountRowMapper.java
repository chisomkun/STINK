package com.stinkelectronics.helpdesk.service;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;

import com.stinkelectronics.helpdesk.model.Account;

public class AccountRowMapper implements RowMapper<Account> {
	
	@Override
	public Account mapRow(ResultSet a, int rowA) throws SQLException {
		Account acct = new Account();
		acct.setEmail(a.getString("Email"));
		acct.setPassword(a.getString("Password"));
		acct.setUserID(a.getString("UserID"));
		return acct;
	}
}
