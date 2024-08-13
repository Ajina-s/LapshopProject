package com.E_commerce.model;

import java.util.Base64;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private String model;
    private String processor;
    private String ram;
    private String storage;
    @Column(length = 1000) // Adjust this length as needed
    private String description;
    private String price;
   

    @OneToMany(mappedBy = "product")
    private Set<cart> carts; // Add this line to establish the relationship with Cart


	public Set<cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<cart> carts) {
		this.carts = carts;
	}

	private Integer quantity;
   

	public Products(int id, String name, String brand, String model, String processor, String ram, String storage,
			String description, String price, Set<cart> carts, Integer quantity, byte[] image, Category category,
			Integer loginid, String role) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.processor = processor;
		this.ram = ram;
		this.storage = storage;
		this.description = description;
		this.price = price;
		this.carts = carts;
		this.quantity = quantity;
		this.image = image;
		this.category = category;
		this.loginid = loginid;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getLoginid() {
		return loginid;
	}

	public void setLoginid(Integer loginid) {
		this.loginid = loginid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
     
   private Integer loginid;
  
  
	private String role;


	public String getImageBase64() {
	    return Base64.getEncoder().encodeToString(this.image);
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
   
	
}
