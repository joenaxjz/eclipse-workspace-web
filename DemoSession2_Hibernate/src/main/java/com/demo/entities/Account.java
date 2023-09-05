package com.demo.entities;
// Generated Sep 5, 2023, 2:07:17 PM by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", catalog = "demo_hinbernate")
public class Account implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private int fullName;
	private boolean status;
	private String email;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Invoice> invoices = new HashSet<Invoice>(0);

	public Account() {
	}

	public Account(String username, String password, int fullName, boolean status, String email) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.email = email;
	}

	public Account(String username, String password, int fullName, boolean status, String email, Set<Role> roles,
			Set<Invoice> invoices) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.email = email;
		this.roles = roles;
		this.invoices = invoices;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 250)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 250)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name", nullable = false)
	public int getFullName() {
		return this.fullName;
	}

	public void setFullName(int fullName) {
		this.fullName = fullName;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "email", nullable = false, length = 250)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "account_role", catalog = "demo_hinbernate", joinColumns = {
			@JoinColumn(name = "account_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

}
