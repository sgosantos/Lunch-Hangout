package com.liferay.hackaday.lunchhangout;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.liferay.hackaday.lunchhangout.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

	ActivitySignInBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
		binding.setPresenter(this);
	}

	public void loginClick(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void signUpClick(View view) {
		Toast.makeText(SignInActivity.this, "Click do cadastro", Toast.LENGTH_SHORT).show();
	}

}