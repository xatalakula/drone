package com.example.noname.ttnm12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListVideo extends BaseAdapter {
    private List<Video> listVideo;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListVideo(List<Video> listVideo, Context context) {
        this.listVideo = listVideo;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listVideo.size();
    }

    @Override
    public Object getItem(int position) {
        return listVideo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomListVideo.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.video_list_layout, null);
            holder = new CustomListVideo.ViewHolder();
            holder.video_id = (TextView) convertView.findViewById(R.id.video_id);
            holder.state = (TextView) convertView.findViewById(R.id.state);
            convertView.setTag(holder);
        } else {
            holder = (CustomListVideo.ViewHolder) convertView.getTag();
        }

        String video_id = this.listVideo.get(position).getVideo_id();
        String state = this.listVideo.get(position).getState();
        holder.video_id.setText(video_id);
        holder.state.setText(state);
        return convertView;
    }

    class ViewHolder {
        TextView video_id;
        TextView state;
    }
}
