package com.liferay.hackaday.lunchhangout;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.liferay.hackaday.lunchhangout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		binding.setPresenter(this);

		setSupportActionBar(binding.toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(true);
	}

	public void onCreateClick(View view) {
		Intent intent = new Intent(this, CreatePollActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);

		return true;
	}

}
