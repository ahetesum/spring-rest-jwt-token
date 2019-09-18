package com.login.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Product")
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private Double price;
	private String image;
	
	public Product(String prodName, String prodDesc, Double prodPrice, String prodImage) {
	    super();
	    this.name = prodName;
	    this.description = prodDesc;
	    this.price = prodPrice;
	    this.image = prodImage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
