package com.example.noname.ttnm12;

import android.content.Context;
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

public class CustomListAdapter extends BaseAdapter implements Filterable{

    private List<State> listDrone;
    private List<State> listDroneChanged;
    private LayoutInflater layoutInflater;
    private Context context;
    private int option = 0;

    public CustomListAdapter(List<State> listDrone, Context context,int option) {
        this.listDrone = listDrone;
        this.listDroneChanged = listDrone;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.option = option;
    }

    @Override
    public int getCount() {
        return listDroneChanged.size();
    }

    @Override
    public Object getItem(int position) {
        return listDroneChanged.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            if(option == 1) {
                convertView = layoutInflater.inflate(R.layout.custom_list_layout2, null);
            }
            else {
                convertView = layoutInflater.inflate(R.layout.custom_list_layout, null);
            }
            holder = new ViewHolder();
            holder.textViewId = (TextView) convertView.findViewById(R.id.drone_id);
            holder.imageViewState = (ImageView) convertView.findViewById(R.id.drone_state);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String id = this.listDroneChanged.get(position).getDrone_Id();
        holder.textViewId.setText(id);
        holder.imageViewState.setImageResource(listDroneChanged.get(position).getState());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                listDroneChanged = (List<State>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                List<State> filteredDrones = new ArrayList<State>();

                // perform your search here using the searchConstraint String.

                constraint = constraint.toString().toLowerCase();
                for (int i = 0; i < listDrone.size(); i++) {
                    String drone_id = listDrone.get(i).getDrone_Id();
                    if (drone_id.toLowerCase().startsWith(constraint.toString()))  {
                        filteredDrones.add(listDrone.get(i));
                    }
                }

                results.count = filteredDrones.size();
                results.values = filteredDrones;
                //Log.e("VALUES", results.values.toString());

                return results;
            }
        };

        return filter;
    }

    class ViewHolder {
        TextView textViewId;
        ImageView imageViewState;
    }
}
