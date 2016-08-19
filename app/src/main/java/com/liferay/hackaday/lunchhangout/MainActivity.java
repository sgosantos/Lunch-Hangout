package com.liferay.hackaday.lunchhangout;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
	}

	public void onCreateClick(View view) {
		Toast.makeText(
			MainActivity.this, "Click do add pool", Toast.LENGTH_SHORT).show();
	}

}
