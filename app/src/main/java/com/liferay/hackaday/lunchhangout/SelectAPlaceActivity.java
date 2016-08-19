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

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liferay.hackaday.lunchhangout.adapter.PlacesAdapter;
import com.liferay.hackaday.lunchhangout.databinding.ActivitySelectAPlaceBinding;

/**
 * @author Igor Oliveira
 */
public class SelectAPlaceActivity extends AppCompatActivity {

	private ActivitySelectAPlaceBinding binding;
	private PlacesAdapter adapter;

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);

		binding = DataBindingUtil.setContentView(
			this, R.layout.activity_select_a_place);

		setSupportActionBar(binding.toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

		adapter = new PlacesAdapter(this);
	}

}
