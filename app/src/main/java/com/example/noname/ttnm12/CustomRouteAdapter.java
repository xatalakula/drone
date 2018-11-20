package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class CustomRouteAdapter extends BaseAdapter {

    private List<Integer> listRoute;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomRouteAdapter(List<Integer> listRoute, Context context) {
        this.listRoute = listRoute;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listRoute.size();
    }

    @Override
    public Object getItem(int position) {
        return listRoute.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_list_route_layout, null);
            holder = new ViewHolder();
            holder.imageViewRoute = (ImageView) convertView.findViewById(R.id.imgv_route);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageViewRoute.setImageResource(listRoute.get(position));
        return convertView;
    }

    class ViewHolder {
        ImageView imageViewRoute;
    }
}
