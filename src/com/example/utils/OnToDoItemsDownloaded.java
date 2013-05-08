package com.example.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.labvezba.model.LstItem;

import org.json.JSONArray;
import org.json.JSONObject;

public class OnToDoItemsDownloaded implements
		OnContentDownloaded<List<LstItem>> {

	private List<LstItem> items = new ArrayList<LstItem>();

	@Override
	public void onContentDownloaded(String content, int httpStatus)
			throws Exception {
		JSONArray jsonItems = new JSONArray(content);

		for (int i = 0; i < jsonItems.length(); i++) {
			JSONObject jObj = (JSONObject) jsonItems.get(i);
			LstItem item = new LstItem();
			item.setId(jObj.getString("id"));
			item.setLastName(jObj.getString("prezime"));
			item.setName(jObj.getString("ime"));
			item.setSex(jObj.getString("gender"));
			items.add(item);
			/*TodoItem item = new TodoItem();
			item.setName(jObj.getString("name"));
			item.setId(jObj.getLong("id"));
			item.setDone(jObj.getBoolean("done"));
			items.add(item);*/
		}

	}

	@Override
	public List<LstItem> getResult() {
		return items;
	}

}
