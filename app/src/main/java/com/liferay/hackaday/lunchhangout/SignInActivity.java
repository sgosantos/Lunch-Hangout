package com.liferay.hackaday.lunchhangout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.liferay.hackaday.lunchhangout.databinding.ActivitySignInBinding;
import com.liferay.hackaday.lunchhangout.model.AuthToken;
import com.liferay.hackaday.lunchhangout.model.Place;
import com.liferay.hackaday.lunchhangout.model.User;
import com.liferay.hackaday.lunchhangout.service.LunchHangoutService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

	private static final String TAG = SignInActivity.class.getSimpleName();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sign_in);

		password = (EditText) findViewById(R.id.password);
		username = (EditText) findViewById(R.id.username);


		findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				loginClick(view);
			}
		});
	}

	public void loginClick(View view) {
		Call<AuthToken> call = LunchHangoutService.getInstance().signIn(
			username.getText().toString(),
			password.getText().toString(), "password");

		call.enqueue(new Callback<AuthToken>() {
			@Override
			public void onResponse(
				Call<AuthToken> call, Response<AuthToken> response) {

				if (response.isSuccessful()) {
					SettingsUtil.setToken(
						SignInActivity.this, response.body().access_token);

					getUser();
				}
				else {
					Toast.makeText(
						SignInActivity.this, "Invalid login or password",
						Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(Call<AuthToken> call, Throwable t) {
				Toast.makeText(
					SignInActivity.this, "Failed to get user token",
					Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void getUser() {
		Call<User> call = LunchHangoutService.getInstance().getUser(
			SettingsUtil.getToken(this));

		call.enqueue(new Callback<User>() {
			@Override
			public void onResponse(Call<User> call, Response<User> response) {
				Log.i(TAG, "onResponse: getUser()");

				if (response.isSuccessful()) {
					SettingsUtil.setUser(response.body());

					Intent intent = new Intent(
						SignInActivity.this, MainActivity.class);

					startActivity(intent);
					finish();
				}
			}

			@Override
			public void onFailure(Call<User> call, Throwable t) {
				Log.e(TAG, "onFailure: getUser()", t);

				Toast.makeText(
					SignInActivity.this, "Failed to get user",
					Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void signUpClick(View view) {
		Toast.makeText(SignInActivity.this, "Click do cadastro", Toast.LENGTH_SHORT).show();
	}

	private EditText username;
	private EditText password;

}