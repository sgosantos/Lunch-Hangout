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

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author Igor Oliveira
 */
public class Poll implements Parcelable {

	protected Poll(Parcel in) {
		restaurantName = in.readString();
		time = in.readString();

		String votesString = in.readString();
		if (votesString != null) {
			votes = new JsonParser().parse(votesString);
		}
	}

	public static final Creator<Poll> CREATOR = new Creator<Poll>() {
		@Override
		public Poll createFromParcel(Parcel in) {
			return new Poll(in);
		}

		@Override
		public Poll[] newArray(int size) {
			return new Poll[size];
		}
	};

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

	public String getTime() {
		return time;
	}

	public String getVotesCount() {
		int votesCount = 0;

		JsonElement votes = getVotes();

		if  (votes != null) {
			if (votes.isJsonPrimitive()) {
				votesCount = 1;
			}
			else {
				votesCount = votes.getAsJsonArray().size();
			}
		}

		return String.valueOf(votesCount);
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String restaurantName;
	private JsonElement votes;
	private String time;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(restaurantName);
		parcel.writeString(time);

		if (votes != null) {
			parcel.writeString(votes.toString());
		}
	}
}
