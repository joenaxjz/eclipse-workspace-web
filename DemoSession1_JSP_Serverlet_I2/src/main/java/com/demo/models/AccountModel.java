package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.demo.entities.Account;

public class AccountModel {
	private List<Account> accounts;
	public AccountModel() {
		accounts = new ArrayList<Account>();
		accounts.add(new Account("acc 1", "$2a$10$4IpxU5l5v9dKlHmB3E9D8ezTpy.NMK5xuy3UriL4KN9gBAEqRxkAG","Name 1"));
		accounts.add(new Account("acc 2", "$2a$10$kAS6HZLd.hxpjhZtQl4HTeqsg8FzYND3Qy.SgdKDs3uD7LTxVWwS.","Name 2"));
		accounts.add(new Account("acc 3", "$2a$10$/5OT4wtycZ5NrPX4BxwuHeMkcaiHFQG0rHv77piIDhwTuP55/bSfC","Name 3"));
	}
	
	public boolean login(String username, String password) {
		Account account = findByUsername(username);
		if(account != null) {
			return BCrypt.checkpw(password, account.getPassword());
		}
		return false;
	}
	
	private Account findByUsername(String username) {
		for (Account acc: accounts) {
			if(acc.getUsername().equals(username)) {
				return acc;
			}
		}
		return null;
	}
}
