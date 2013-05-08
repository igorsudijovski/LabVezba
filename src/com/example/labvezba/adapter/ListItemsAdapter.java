package com.example.labvezba.adapter;

import java.util.ArrayList;
import java.util.List;


import com.example.labvezba.model.LstItem;
import com.example.labvezba.MainActivity;
import com.example.labvezba.R;
import com.example.labvezba.ShowItems;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;

public class ListItemsAdapter extends BaseAdapter implements OnItemClickListener, OnItemLongClickListener {

	private List<LstItem> items;
	private Context ctx;
	private LayoutInflater inflater;
	
	public ListItemsAdapter(Context ctx) {
		items = new ArrayList<LstItem>();
		this.ctx = ctx;
		inflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// TODO Auto-generated constructor stub
	}
	
	class Holder {
		public RelativeLayout itemLayout;
		public TextView name;
		public TextView lastName;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LstItem item = items.get(position);
		Holder holder = null;
		if(convertView == null){
			holder = new Holder();
			holder.itemLayout = (RelativeLayout) inflater.inflate(R.layout.item_design, null);
			holder.name = (TextView) holder.itemLayout.findViewById(R.id.listName);
			holder.lastName = (TextView) holder.itemLayout.findViewById(R.id.listLastName);
			convertView = holder.itemLayout;
			convertView.setTag(holder);
		}
		holder = (Holder) convertView.getTag();
		holder.name.setText(item.getName());
		holder.lastName.setText(item.getLastName());
		return convertView;
	}
	
	public void addItem(LstItem i){
		items.add(i);
		notifyDataSetChanged();
	}
	
	public void deleteItem(int position){
		items.remove(position);
		notifyDataSetChanged();
	}
	
	public void clear(){
		items.clear();
		notifyDataSetInvalidated();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		LstItem item = items.get(arg2);
		//Toast.makeText(ctx, item.getName() + " " + item.getLastName() ,Toast.LENGTH_LONG).show();
		Intent i = new Intent(ctx, ShowItems.class);
		i.putExtra("ime", item.getName());
		i.putExtra("prezime", item.getLastName());
		ctx.startActivity(i);
		
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		deleteItem(arg2);
		return false;
	}
	
	public void addItems(List<LstItem> lst){
		items.addAll(lst);
	}

}
