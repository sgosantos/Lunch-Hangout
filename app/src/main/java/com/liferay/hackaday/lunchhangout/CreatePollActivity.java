package com.liferay.hackaday.lunchhangout;

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

		String array[] = {"11", "11:30", "12", "12:30"};

		ArrayAdapter<String> adapter =
		new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, array);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		binding.timeSpinner.setAdapter(adapter);
	}

	public void placeAction(View view) {
//activityforResult
	}



}
