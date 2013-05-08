package com.example.tasks;

import java.util.List;

import com.example.labvezba.R;

import com.example.utils.Downloader;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import com.example.labvezba.adapter.ListItemsAdapter;
import com.example.labvezba.model.LstItem;
import com.example.utils.OnContentDownloaded;
import com.example.utils.OnToDoItemsDownloaded;

public class DownloadTask extends AsyncTask<String, Void, List<LstItem>> {

	private Exception exception = null;
	private ProgressDialog loadingDialog;
	private ListItemsAdapter adapter;
	private Context ctx;
	Handler handler;
	
	public DownloadTask(Context c, ListItemsAdapter a) {
		ctx = c;
		adapter = a;
		handler = new Handler();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected List<LstItem> doInBackground(String... params) {
		// TODO Auto-generated method stub
		if(params.length < 1){
			exception = new IllegalArgumentException(
					"At least one argument for the download url expected. ");
			return null;
		}else{
			String url = params[0];
			OnContentDownloaded<List<LstItem>> handler = new OnToDoItemsDownloaded();
			try{
				Downloader.getFromUrl(url, handler);
				publishProgress(null);
				return handler.getResult();
			}catch (Exception ex) {
				exception = ex;
				ex.printStackTrace();
				return null;
			}
		}
	}
	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		createDialog();
	}
	
	@Override
	protected void onPostExecute(List<LstItem> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		dismiss();
		if(exception != null){
			Toast.makeText(ctx, "Error: " + exception.getMessage(),
					Toast.LENGTH_LONG).show();
			return;
		}
		adapter.clear();
		adapter.addItems(result);
	}
	private void createDialog() {
		loadingDialog = new ProgressDialog(ctx);
		loadingDialog.setTitle(ctx.getResources().getString(R.string.download_title));
		loadingDialog.setMessage(ctx.getResources().getString(
				R.string.download_description));
		loadingDialog.setIndeterminate(true);
		loadingDialog.setCancelable(false);
	}

	public void dismiss() {
		if (loadingDialog != null && loadingDialog.isShowing()) {
			loadingDialog.dismiss();
		}
	}

}
