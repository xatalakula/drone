package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter{

    private List<State> listDrone;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(List<State> listDrone, Context context) {
        this.listDrone = listDrone;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listDrone.size();
    }

    @Override
    public Object getItem(int position) {
        return listDrone.get(position);
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
            holder.imageViewState = (ImageView) convertView.findViewById(R.id.drone_state);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String id = this.listDrone.get(position).getDrone_Id();
        holder.textViewId.setText(id);
        holder.imageViewState.setImageResource(listDrone.get(position).getState());
            return convertView;
    }

    class ViewHolder {
        TextView textViewId;
        ImageView imageViewState;
    }
}
