/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.hackaday.lunchhangout.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates2.AdapterDelegate;
import com.liferay.hackaday.lunchhangout.R;
import com.liferay.hackaday.lunchhangout.listener.OnPlaceClickListener;
import com.liferay.hackaday.lunchhangout.model.Place;
import com.liferay.hackaday.lunchhangout.model.User;

import java.util.List;

/**
 * @author Igor Oliveira
 */
public class PeopleDelegate implements AdapterDelegate<List> {

	private OnPlaceClickListener listener;

	public PeopleDelegate(Activity activity) {
		inflater = activity.getLayoutInflater();
	}

	@Override
	public boolean isForViewType(List items, int position) {
		return items.get(position) instanceof User;
	}

	@Override
	public void onBindViewHolder(List items, int position, ViewHolder holder) {
		User user = (User)items.get(position);

		PeopleViewHolder viewHolder = (PeopleViewHolder) holder;
		viewHolder.bind(user);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent) {
		View view = inflater.inflate(R.layout.user_row, parent, false);

		return new PeopleViewHolder(view);
	}

	class PeopleViewHolder extends ViewHolder {

		private TextView name;

		public PeopleViewHolder(View itemView) {
			super(itemView);

			name = (TextView) itemView.findViewById(R.id.name);
		}

		public void bind(final User user) {
			name.setText(user.name);
		}
	}

	protected LayoutInflater inflater;

}