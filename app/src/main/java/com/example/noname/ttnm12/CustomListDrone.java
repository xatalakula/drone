package com.example.noname.ttnm12;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListDrone extends BaseAdapter {
    private List<Drone> listDrone;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListDrone(List<Drone> listDrone, Context context) {
        this.listDrone = listDrone;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        Log.e("dkm ", "bug đây");
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
        CustomListDrone.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.drone_list_layout, null);
            holder = new CustomListDrone.ViewHolder();
            holder.textViewId = (TextView) convertView.findViewById(R.id.drone_id);
            holder.statusId = (TextView) convertView.findViewById(R.id.status);
            convertView.setTag(holder);
        } else {
            holder = (CustomListDrone.ViewHolder) convertView.getTag();
        }

        String id = this.listDrone.get(position).getDrone_Id();
        String status = this.listDrone.get(position).getState();
        holder.textViewId.setText(id);
        holder.statusId.setText(status);
        return convertView;
    }

    class ViewHolder {
        TextView textViewId;
        TextView statusId;
        ImageView imageViewState;
    }
}
