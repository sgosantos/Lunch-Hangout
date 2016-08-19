package com.liferay.hackaday.lunchhangout;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.liferay.hackaday.lunchhangout.model.User;

/**
 * @author Silvio Santos
 */
public class SettingsUtil {

	public static User user;

	public static String getToken(Activity activity) {
		SharedPreferences preference = activity.getPreferences(
			Context.MODE_PRIVATE);

		return "Bearer " + preference.getString("token", "");
	}

	public static void setToken(Activity activity, String token) {
		SharedPreferences preference = activity.getPreferences(
			Context.MODE_PRIVATE);

		SharedPreferences.Editor editor = preference.edit();
		editor.putString("token", token);
		editor.commit();
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		SettingsUtil.user = user;
	}
}
