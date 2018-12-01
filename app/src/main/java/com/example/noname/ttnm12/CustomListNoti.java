package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomListNoti extends BaseAdapter{
    private List<String> listNoti;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListNoti(List<String> listNoti, Context context) {
        this.listNoti = listNoti;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listNoti.size();
    }

    @Override
    public Object getItem(int position) {
        return listNoti.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_list_noti, null);
            holder = new ViewHolder();
            holder.expandableTextView = (ExpandableTextView) convertView.findViewById(R.id.expand_textview1);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String content = listNoti.get(position);
        holder.expandableTextView.setText(content);
        return convertView;
    }

    class ViewHolder {
        ExpandableTextView expandableTextView;
    }
}
