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

package com.liferay.hackaday.lunchhangout.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Igor Oliveira
 */
public class FloatingActionButtonScrollBehavior
	extends FloatingActionButton.Behavior {

	public FloatingActionButtonScrollBehavior(
		Context context, AttributeSet attributes) {

		super();

	}

	@Override
	public void onNestedScroll(
		CoordinatorLayout coordinatorLayout, FloatingActionButton child,
		View target, int dxConsumed, int dyConsumed, int dxUnconsumed,
		int dyUnconsumed) {

		if ((dyConsumed > 0) && (child.getVisibility() == View.VISIBLE)) {
			child.hide();
		}
		else if ((dyConsumed < 0) && (child.getVisibility() != View.VISIBLE)) {
			child.show();
		}
	}

	@Override
	public boolean onStartNestedScroll(
		CoordinatorLayout coordinatorLayout, FloatingActionButton child,
		View directTargetChild, View target, int nestedScrollAxes) {

		return (nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL);
	}

}