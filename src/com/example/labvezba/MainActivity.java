package com.example.labvezba;

import com.example.labvezba.adapter.ListItemsAdapter;
import com.example.labvezba.model.LstItem;
import com.example.tasks.DownloadTask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView lstView;
	private ListItemsAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lstView = (ListView) findViewById(R.id.listView1);
		adapter = new ListItemsAdapter(this);
		lstView.setAdapter(adapter);
		lstView.setOnItemClickListener(adapter);
		lstView.setOnItemLongClickListener(adapter);
		//loadData();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		loadData();
		
	}
	
	public void loadData(){
		DownloadTask task = new DownloadTask(this, adapter);
		task.execute(getString(R.string.service));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
