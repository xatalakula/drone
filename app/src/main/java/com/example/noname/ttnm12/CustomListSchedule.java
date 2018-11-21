package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListSchedule extends BaseAdapter {
    private List<Schedule> listSchedule;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListSchedule(List<Schedule> listSchedule, Context context) {
        this.listSchedule = listSchedule;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listSchedule.size();
    }

    @Override
    public Object getItem(int position) {
        return listSchedule.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomListSchedule.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.schedule_list_layout, null);
            holder = new CustomListSchedule.ViewHolder();
            holder.ngay = (TextView) convertView.findViewById(R.id.ngay);
            holder.khuvuc = (TextView) convertView.findViewById(R.id.khuvuc);
            convertView.setTag(holder);
        } else {
            holder = (CustomListSchedule.ViewHolder) convertView.getTag();
        }

        String ngay = this.listSchedule.get(position).getNgay();
        String khuvuc = this.listSchedule.get(position).getKhuvuc();
        holder.ngay.setText(ngay);
        holder.khuvuc.setText(khuvuc);
        return convertView;
    }

    class ViewHolder {
        TextView ngay;
        TextView khuvuc;
    }
}
