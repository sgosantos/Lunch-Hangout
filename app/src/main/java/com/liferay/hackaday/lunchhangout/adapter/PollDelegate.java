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

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.hannesdorfmann.adapterdelegates2.AdapterDelegate;
import com.liferay.hackaday.lunchhangout.R;
import com.liferay.hackaday.lunchhangout.model.Poll;

import java.util.List;

/**
 * @author Igor Oliveira
 */
public class PollDelegate implements AdapterDelegate<List> {

	private LayoutInflater inflater;

	public PollDelegate(Activity activity) {
		inflater = activity.getLayoutInflater();
	}

	@Override
	public boolean isForViewType(List items, int position) {
		return items.get(position) instanceof Poll;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
		View view = inflater.inflate(R.layout.poll_row, parent, false);

		return new PoolViewHolder(view);
	}

	@Override
	public void onBindViewHolder(
		List items, int position, RecyclerView.ViewHolder holder) {

		Poll poll = (Poll)items.get(position);

		PoolViewHolder viewHolder = (PoolViewHolder)holder;
		viewHolder.bind(poll);
	}

	class PoolViewHolder extends RecyclerView.ViewHolder {

		private TextView name;
		private TextView time;
		private TextView votes;

		public PoolViewHolder(View itemView) {
			super(itemView);

			name = (TextView) itemView.findViewById(R.id.name);
			time = (TextView) itemView.findViewById(R.id.time);
			votes = (TextView) itemView.findViewById(R.id.votes);
		}

		public void bind(Poll poll) {
			name.setText(poll.getRestaurantName());
			time.setText(poll.getTime());

			votes.setText(poll.getVotesCount());
		}

	}
}
