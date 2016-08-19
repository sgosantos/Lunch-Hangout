package com.liferay.hackaday.lunchhangout;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liferay.hackaday.lunchhangout.model.AuthToken;
import com.liferay.hackaday.lunchhangout.service.LunchHangoutService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

	ActivitySignInBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
		binding.setPresenter(this);
	}

	public void loginClick(View view) {
		Call<AuthToken> call = LunchHangoutService.getInstance().signIn(
			binding.username.getText().toString(),
			binding.password.getText().toString(), "password");

		call.enqueue(new Callback<AuthToken>() {
			@Override
			public void onResponse(
				Call<AuthToken> call, Response<AuthToken> response) {

				if (response.isSuccessful()) {
					Intent intent = new Intent(SignInActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
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
					SignInActivity.this, "Connection error",
					Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void signUpClick(View view) {
		Toast.makeText(SignInActivity.this, "Click do cadastro", Toast.LENGTH_SHORT).show();
	}

}