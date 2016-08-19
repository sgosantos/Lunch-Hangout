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

package com.liferay.hackaday.lunchhangout;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.liferay.hackaday.lunchhangout.adapter.PlacesAdapter;
import com.liferay.hackaday.lunchhangout.databinding.ActivitySelectAPlaceBinding;
import com.liferay.hackaday.lunchhangout.listener.OnPlaceClickListener;
import com.liferay.hackaday.lunchhangout.model.Place;
import com.liferay.hackaday.lunchhangout.service.LunchHangoutService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Igor Oliveira
 */
public class SelectAPlaceActivity extends AppCompatActivity
	implements OnPlaceClickListener {

	private ActivitySelectAPlaceBinding binding;
	private PlacesAdapter adapter;

	public static final String PLACE_NAME = "name";

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);

		binding = DataBindingUtil.setContentView(
			this, R.layout.activity_select_a_place);

		setSupportActionBar(binding.toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		binding.recyclerView.setHasFixedSize(true);
		binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

		adapter = new PlacesAdapter(this, this);

		binding.recyclerView.setAdapter(adapter);

		Call<List<Place>> call = LunchHangoutService.getInstance().getRestaurants();

		call.enqueue(new Callback<List<Place>>() {
			@Override
			public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
				if (response.isSuccessful()) {
					adapter.setEntries(response.body());
				}
				else {
					Toast.makeText(
						SelectAPlaceActivity.this, "Could not get places!",
						Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(Call<List<Place>> call, Throwable t) {
				Toast.makeText(
					SelectAPlaceActivity.this, "Connection error",
					Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void onPlaceClick(Place place) {
		String name = place.getName();

		Intent intent = new Intent();
		intent.putExtra(PLACE_NAME, name);

		setResult(RESULT_OK, intent);

		finish();
	}
}
