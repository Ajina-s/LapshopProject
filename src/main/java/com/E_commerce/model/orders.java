//package com.E_commerce.model;
//
//import java.util.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//
//@Entity
//@Table(name = "orders")
//public class orders 
//{
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id",nullable=false)
//    private Products product;
//
//    public orders() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public orders(Long id, Products product, Integer quantity, Double amount, Date date, String status, String loginId,
//			shop_owner shopOwner) {
//		super();
//		this.id = id;
//		this.product = product;
//		this.quantity = quantity;
//		this.amount = amount;
//		this.date = date;
//		this.status = status;
//		this.loginId = loginId;
//		this.shopOwner = shopOwner;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Products getProduct() {
//		return product;
//	}
//
//	public void setProduct(Products product) {
//		this.product = product;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public Double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(Double amount) {
//		this.amount = amount;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public String getLoginId() {
//		return loginId;
//	}
//
//	public void setLoginId(String loginId) {
//		this.loginId = loginId;
//	}
//
//	public shop_owner getShopOwner() {
//		return shopOwner;
//	}
//
//	public void setShopOwner(shop_owner shopOwner) {
//		this.shopOwner = shopOwner;
//	}
//
//	@Column(nullable = false)
//    private Integer quantity;
//
//    @Column(nullable = false)
//    private Double amount;
//
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date date;
//
//    @Column(nullable = false)
//    private String status;
//
//    @Column(name = "login_id", nullable = false)
//    private String loginId; // To store the loginId of the user
//
//    @ManyToOne
//    @JoinColumn(name = "shop_owner_id",nullable=false)
//    private shop_owner shopOwner; // If you want to keep track of the shop owner
//}
package com.E_commerce.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = false)
    private String status;

    @Column(name = "login_id", nullable = false)
    private Integer loginId; // To store the loginId of the user

    @ManyToOne
    @JoinColumn(name = "shop_owner_id", nullable = false)
    private shop_owner shopOwner; // If you want to keep track of the shop owner

    // Default constructor
    public orders() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public shop_owner getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(shop_owner shopOwner) {
		this.shopOwner = shopOwner;
	}

	public orders(Long id, Products product, Integer quantity, Double amount, Date date, String status, Integer loginId,
			shop_owner shopOwner) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.amount = amount;
		this.date = date;
		this.status = status;
		this.loginId = loginId;
		this.shopOwner = shopOwner;
	}

}
