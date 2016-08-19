/*
 *  Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 *  This library is free software; you can redistribute it and/or modify it under
 *  the terms of the GNU Lesser General Public License as published by the Free
 *  Software Foundation; either version 2.1 of the License, or (at your option)
 *  any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 *  FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 *  details.
 */

package com.liferay.hackaday.lunchhangout.adapter;

import org.json.JSONArray;

/**
 * @author Igor Oliveira
 */
public class Place {

//	{
//		"name": "casa de taipa",
//		"description": "casa de taipa",
//		"paymentType": "visa",
//		"liferayDiscount": true,
//		"promotionDescription": "promocao",
//		"geolocation": [0, 0],
//		"price": "5",
//		"restaurantType": "fast-food"
//	}

	private String name;
	private String description;
	private String[] paymentType;
	private boolean liferayDiscount;
	private String promotionDescription;
	private String price;
	private String restaurantType;

	public JSONArray getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(JSONArray geolocation) {
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

	private JSONArray geolocation;


}
