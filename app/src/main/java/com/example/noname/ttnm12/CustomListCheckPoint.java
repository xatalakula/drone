package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListCheckPoint extends BaseAdapter{

    private List<CheckPoint> listCheckpoint;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListCheckPoint(List<CheckPoint> listCheckpoint, Context context) {
        this.listCheckpoint = listCheckpoint;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listCheckpoint.size();
    }

    @Override
    public Object getItem(int position) {
        return listCheckpoint.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_list_special, null);
            holder = new ViewHolder();
            holder.coordinate1 = (TextView) convertView.findViewById(R.id.tv_coordinate1);
            holder.coordinate2 = (TextView) convertView.findViewById(R.id.tv_coordinate2);
            holder.ordinal = (TextView) convertView.findViewById(R.id.tv_ordinal);
            holder.imageCheck = (ImageView) convertView.findViewById(R.id.imageview_checksuccess);
            holder.imageLevel = (ImageView) convertView.findViewById(R.id.imageview_level);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.ordinal.setText(listCheckpoint.get(position).getOrdinal());
        holder.coordinate1.setText(listCheckpoint.get(position).getCoordinate1());
        holder.coordinate2.setText(listCheckpoint.get(position).getCoordinate2());
        if(listCheckpoint.get(position).getImageCheck() != 0) {
            holder.imageCheck.setImageResource(listCheckpoint.get(position).getImageCheck());
        }
        else {
            holder.imageCheck.setImageResource(android.R.color.transparent);
        }
        if(listCheckpoint.get(position).getImageLevel() != 0) {
            holder.imageLevel.setImageResource(listCheckpoint.get(position).getImageLevel());
        }
        return convertView;
    }

    class ViewHolder {
        TextView coordinate1;
        TextView coordinate2;
        TextView ordinal;
        ImageView imageLevel;
        ImageView imageCheck;
    }
}
