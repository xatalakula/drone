package com.example.noname.ttnm12;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListDrone extends BaseAdapter implements Filterable {
    private List<Drone> listDrone;
    private List<Drone> listDroneChanged;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListDrone(List<Drone> listDrone, Context context) {
        this.listDrone = listDrone;
        this.listDroneChanged = listDrone;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listDroneChanged.size();
    }

    @Override
    public Drone getItem(int position) {
        return listDroneChanged.get(position);
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

        String id = this.listDroneChanged.get(position).getDrone_Id();
        String status = this.listDroneChanged.get(position).getState();
        holder.textViewId.setText(id);
        holder.statusId.setText(status);
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                listDroneChanged = (List<Drone>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                List<Drone> FilteredDrones = new ArrayList<Drone>();

                // perform your search here using the searchConstraint String.

                constraint = constraint.toString().toLowerCase();
                for (int i = 0; i < listDrone.size(); i++) {
                    String drone_id = listDrone.get(i).getDrone_Id();
                    if (drone_id.toLowerCase().startsWith(constraint.toString()))  {
                        FilteredDrones.add(listDrone.get(i));
                    }
                }

                results.count = FilteredDrones.size();
                results.values = FilteredDrones;
                //Log.e("VALUES", results.values.toString());

                return results;
            }
        };

        return filter;
    }

    class ViewHolder {
        TextView textViewId;
        TextView statusId;
        ImageView imageViewState;
    }
}
