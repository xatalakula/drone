package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter{

    private List<String> listId;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(List<String> listId, Context context) {
        this.listId = listId;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listId.size();
    }

    @Override
    public Object getItem(int position) {
        return listId.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null);
            holder = new ViewHolder();
            holder.textViewId = (TextView) convertView.findViewById(R.id.drone_id);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String id = this.listId.get(position);
        holder.textViewId.setText(id);

        return convertView;
    }

    class ViewHolder {
        TextView textViewId;
    }
}
