package com.liferay.hackaday.lunchhangout.service;

import com.google.gson.JsonElement;
import com.liferay.hackaday.lunchhangout.model.AuthToken;
import com.liferay.hackaday.lunchhangout.model.Place;
import com.liferay.hackaday.lunchhangout.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

/**
 * @author Silvio Santos
 */
public interface LunchHangout {

	@Headers("Host: auth.lunchhangout.wedeploy.me")
	@GET("user")
	Call<User> getUser(@Header("Authorization") String token);

	@Headers("Host: data.lunchhangout.wedeploy.me")
	@GET("restaurants")
	Call<List<Place>> getRestaurants();

	@Headers("Host: auth.lunchhangout.wedeploy.me")
	@FormUrlEncoded
	@POST("users")
	Call<JsonElement> signUp(
		@Field("username") String username,
		@Field("password") String password);

	@Headers("Host: auth.lunchhangout.wedeploy.me")
	@FormUrlEncoded
	@POST("oauth/token")
	Call<AuthToken> signIn(
		@Field("username") String username,
		@Field("password") String password,
		@Field("grant_type") String grantType);

}
