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

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates2.AdapterDelegatesManager;
import com.liferay.hackaday.lunchhangout.listener.OnPlaceClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Allan Melo
 */
public class PeopleAdapter extends RecyclerView.Adapter {

	public PeopleAdapter(Activity activity) {
		entries = new ArrayList<>();

		delegatesManager = new AdapterDelegatesManager<>();
		delegatesManager.addDelegate(new PeopleDelegate(activity));
	}

	public void addOnBottom(List newEntries) {
		int index = entries.size() - 1;
		entries.addAll(index, newEntries);
		notifyItemRangeInserted(index, newEntries.size());
	}

	public List getEntries() {
		return entries;
	}

	@Override
	public int getItemCount() {
		return entries.size();
	}

	@Override
	public int getItemViewType(int position) {
		return delegatesManager.getItemViewType(entries, position);
	}

	public int indexOf(Object entry) {
		return entries.indexOf(entry);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		delegatesManager.onBindViewHolder(entries, position, holder);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return delegatesManager.onCreateViewHolder(parent, viewType);
	}

	public void setEntries(List entries) {
		this.entries = entries;
		notifyDataSetChanged();
	}

	protected AdapterDelegatesManager<List> delegatesManager;
	protected List entries;

}