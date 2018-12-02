package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomListNoti extends BaseAdapter{
    private List<NotificationObj> listNoti;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListNoti(List<NotificationObj> listNoti, Context context) {
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
            holder.title = (TextView) convertView.findViewById(R.id.text_title_noti);
            holder.time = (TextView) convertView.findViewById(R.id.text_time_noti);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String title = listNoti.get(position).getTitle();
        String content = listNoti.get(position).getContent();
        String time = listNoti.get(position).getTime();
        holder.title.setText(title);
        holder.expandableTextView.setText(content);
        holder.time.setText(time);
        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView time;
        ExpandableTextView expandableTextView;
    }
}
