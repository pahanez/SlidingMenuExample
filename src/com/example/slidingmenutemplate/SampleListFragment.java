package com.example.slidingmenutemplate;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SampleListFragment extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		for (int i = 0; i < 20; i++) {
			SampleItem item = new SampleItem("Sample List", android.R.drawable.ic_menu_search);
			if(i%5 == 0) item.cat = 1;
			
			adapter.add(item);
		}
		setListAdapter(adapter);
		
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.e("p37td8",""+position);
			}
		});
	}

	private class SampleItem {
		public String tag;
//		public int iconRes;
		public int cat;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
//			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}
		@Override
		public int getViewTypeCount() {
			
			return super.getViewTypeCount();
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
//			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
//			icon.setImageResource(getItem(position).iconRes);
			((TextView) convertView.findViewById(R.id.row_header)).setVisibility(getItem(position).cat == 0 ? View.GONE : View.VISIBLE );
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}
}
