////
////package com.E_commerce.model;
////
////import jakarta.persistence.Column;
////import jakarta.persistence.Entity;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////import jakarta.persistence.Table;
////
////@Entity
////@Table(name="User_Registration")
////public class User {
////
////    @Id
////    @GeneratedValue(strategy=GenerationType.IDENTITY)
////    private int id;
////    private String fullName;
////    private String address;
////    private String pincode;
////    private String city;
////    private String gender;
////    private String contact;
////    
////    @Column(unique = true)
////    private String email;
////    private String password;
////    private boolean approved;
////
////    // Constructors, getters, and setters
////    public User() {
////        super();
////    }
////
////    public User(int id, String fullName, String address, String pincode, String city, String gender, String contact, String email, String password, boolean approved) {
////        super();
////        this.id = id;
////        this.fullName = fullName;
////        this.address = address;
////        this.pincode = pincode;
////        this.city = city;
////        this.gender = gender;
////        this.contact = contact;
////        this.email = email;
////        this.password = password;
////        this.approved = approved;
////        
////    }
////
////	public int getId() {
////		return id;
////	}
////
////	public void setId(int id) {
////		this.id = id;
////	}
////
////	public String getFullName() {
////		return fullName;
////	}
////
////	public void setFullName(String fullName) {
////		this.fullName = fullName;
////	}
////
////	public String getAddress() {
////		return address;
////	}
////
////	public void setAddress(String address) {
////		this.address = address;
////	}
////
////	public String getPincode() {
////		return pincode;
////	}
////
////	public void setPincode(String pincode) {
////		this.pincode = pincode;
////	}
////
////	public String getCity() {
////		return city;
////	}
////
////	public void setCity(String city) {
////		this.city = city;
////	}
////
////	public String getGender() {
////		return gender;
////	}
////
////	public void setGender(String gender) {
////		this.gender = gender;
////	}
////
////	public String getContact() {
////		return contact;
////	}
////
////	public void setContact(String contact) {
////		this.contact = contact;
////	}
////
////	public String getEmail() {
////		return email;
////	}
////
////	public void setEmail(String email) {
////		this.email = email;
////	}
////
////	public String getPassword() {
////		return password;
////	}
////
////	public void setPassword(String password) {
////		this.password = password;
////	}
////
////	public boolean isApproved() {
////		return approved;
////	}
////
////	public void setApproved(boolean approved) {
////		this.approved = approved;
////	}
////
////    
////}
////
//package com.E_commerce.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "User_Registration")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String fullName;
//    private String address;
//    private String pincode;
//    private String city;
//    private String gender;
//    private String contact;
//
//    @Column(unique = true)
//    private String email;
//    private String password;
//    private boolean approved;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "login_id", referencedColumnName = "id")
//    private shopLog login;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getFullName() {
//		return fullName;
//	}
//
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getPincode() {
//		return pincode;
//	}
//
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//
//	public String getContact() {
//		return contact;
//	}
//
//	public void setContact(String contact) {
//		this.contact = contact;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public boolean isApproved() {
//		return approved;
//	}
//
//	public void setApproved(boolean approved) {
//		this.approved = approved;
//	}
//
//	public shopLog getLogin() {
//		return login;
//	}
//
//	public void setLogin(shopLog login) {
//		this.login = login;
//	}
//
//	public User(int id, String fullName, String address, String pincode, String city, String gender, String contact,
//			String email, String password, boolean approved, shopLog login) {
//		super();
//		this.id = id;
//		this.fullName = fullName;
//		this.address = address;
//		this.pincode = pincode;
//		this.city = city;
//		this.gender = gender;
//		this.contact = contact;
//		this.email = email;
//		this.password = password;
//		this.approved = approved;
//		this.login = login;
//	}
//
//	public User() {
//		super();
//		
//	}
//
//    
//}
//
package com.E_commerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "User_Registration")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String address;
    private String pincode;
    private String city;
    private String gender;
    private String contact;

    @Column(unique = true)
    private String email;
    private String password;
    private boolean approved;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private shopLog login;
   
    public int getLoginid() {
        return login.getId();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public shopLog getLogin() {
		return login;
	}

	public void setLogin(shopLog login) {
		this.login = login;
	}

	public User(int id, String fullName, String address, String pincode, String city, String gender, String contact,
			String email, String password, boolean approved, shopLog login) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.pincode = pincode;
		this.city = city;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.approved = approved;
		this.login = login;
	}

	public User() {
		super();
		
	}

	
	}

    

