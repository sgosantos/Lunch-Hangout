package com.liferay.hackaday.lunchhangout.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Silvio Santos
 */
public class LunchHangoutService {

	public static LunchHangout getInstance() {
		Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://192.168.109.253/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();

		return retrofit.create(LunchHangout.class);
	}
}
