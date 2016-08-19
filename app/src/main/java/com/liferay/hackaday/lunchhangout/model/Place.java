package com.liferay.hackaday.lunchhangout.model;

import com.google.gson.JsonElement;

import org.json.JSONArray;

/**
 * @author Silvio Santos
 */
public class Place {

	private long id;
	private String name;
	private String description;
	private String[] paymentType;
	private boolean liferayDiscount;
	private String promotionDescription;
	private String price;
	private String restaurantType;

	public JsonElement getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(JsonElement geolocation) {
		this.geolocation = geolocation;
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

	public String[] getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String[] paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isLiferayDiscount() {
		return liferayDiscount;
	}

	public void setLiferayDiscount(boolean liferayDiscount) {
		this.liferayDiscount = liferayDiscount;
	}

	public String getPromotionDescription() {
		return promotionDescription;
	}

	public void setPromotionDescription(String promotionDescription) {
		this.promotionDescription = promotionDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}

	private JsonElement geolocation;

	public long getId() {
		return id;
	}
}
