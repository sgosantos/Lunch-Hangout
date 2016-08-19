package com.liferay.hackaday.lunchhangout;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.liferay.hackaday.lunchhangout.adapter.PlaceAdapter;
import com.liferay.hackaday.lunchhangout.adapter.PollAdapter;
import com.liferay.hackaday.lunchhangout.databinding.ActivityMainBinding;
import com.liferay.hackaday.lunchhangout.model.Place;
import com.liferay.hackaday.lunchhangout.model.Poll;
import com.liferay.hackaday.lunchhangout.service.LunchHangoutService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
	private PollAdapter adapter;

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		binding.setPresenter(this);

		setSupportActionBar(binding.toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

		binding.recyclerView.setHasFixedSize(true);
		binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

		adapter = new PollAdapter(this);

		binding.recyclerView.setAdapter(adapter);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();

				return true;

			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		Call<List<Poll>> call = LunchHangoutService.getInstance().getPolls();

		call.enqueue(new Callback<List<Poll>>() {
			@Override
			public void onResponse(Call<List<Poll>> call, Response<List<Poll>> response) {
				if (response.isSuccessful()) {
					adapter.setEntries(response.body());
				}
				else {
					Toast.makeText(
						MainActivity.this, "Could not get poll!",
						Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onFailure(Call<List<Poll>> call, Throwable t) {
				Toast.makeText(
					MainActivity.this, "Connection error",
					Toast.LENGTH_SHORT).show();
			}
		});
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
