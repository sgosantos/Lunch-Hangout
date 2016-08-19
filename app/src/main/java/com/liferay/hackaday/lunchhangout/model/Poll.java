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

package com.liferay.hackaday.lunchhangout.model;

import com.google.gson.JsonElement;

/**
 * @author Igor Oliveira
 */
public class Poll {

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public JsonElement getVotes() {
		return votes;
	}

	public void setVotes(JsonElement votes) {
		this.votes = votes;
	}

	public String getLunchTime() {
		return lunchTime;
	}

	public void setLunchTime(String lunchTime) {
		this.lunchTime = lunchTime;
	}

	private String restaurantName;
	private JsonElement votes;
	private String lunchTime;

}
