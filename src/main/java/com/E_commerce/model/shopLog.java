

package com.E_commerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_login")
public class shopLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String role;

    @OneToOne(mappedBy = "login")
    private User user;

    public shopLog(int id, String email, String password, String role, User user, shop_owner shopOwner) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.user = user;
        this.shopOwner = shopOwner;
    }

    public shopLog() {
       
    }

	@OneToOne(mappedBy = "login")
    private shop_owner shopOwner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public shop_owner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(shop_owner shopOwner) {
		this.shopOwner = shopOwner;
	}

    
}
