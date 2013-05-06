package com.example.labvezba;

import com.example.labvezba.adapter.ListItemsAdapter;
import com.example.labvezba.model.LstItem;

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
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		loadData();
	}
	
	public void loadData(){
		String ime = "ime";
		String prezime = "prezime";
		for(int i = 0; i < 4; i++){
			LstItem item = new LstItem();
			item.name = ime + Integer.toString(i);
			item.lastName = prezime + Integer.toString(i);
			adapter.addItem(item);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
