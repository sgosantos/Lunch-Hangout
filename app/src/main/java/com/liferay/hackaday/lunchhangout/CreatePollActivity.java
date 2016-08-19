package com.liferay.hackaday.lunchhangout;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.liferay.hackaday.lunchhangout.databinding.ActivityCreatePollBinding;

public class CreatePollActivity extends AppCompatActivity {


	ActivityCreatePollBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_create_poll);
		binding.setPresenter(this);

		String array[] = {"11:00", "11:30", "12", "12:30"};

		ArrayAdapter<String> adapter =
		new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, array);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		binding.timeSpinner.setAdapter(adapter);
	}

	public void placeAction(View view) {
		Intent intent = new Intent(this, SelectAPlaceActivity.class);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode != Activity.RESULT_OK) {
			return;
		}

		binding.place.setText(data.getStringExtra(SelectAPlaceActivity.PLACE_NAME));
	}
}
