package com.xugino.bingpicanother;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseAdapter
{
    Context mContext;
    private LayoutInflater mInflater;
    private List<Map<String,Object>> mapList;
    private DataResource data;

    public MyAdapter(Context mContext, List<Map<String,Object>> mapList,DataResource data){
        this.mContext=mContext;
        mInflater=LayoutInflater.from(mContext);
        this.mapList=mapList;
        this.data=data;
    }

    @Override
    public int getCount() {
        return mapList.size();
    }

    @Override
    public Object getItem(int i) {
        return mapList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView=mInflater.inflate(R.layout.list_item,null);
            viewHolder.pic=convertView.findViewById(R.id.item_pic);
            viewHolder.text=convertView.findViewById(R.id.item_text);
            viewHolder.time=convertView.findViewById(R.id.item_time);
            viewHolder.btn=convertView.findViewById(R.id.download_btn);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.pic.setImageResource((int)data.getData().get(position).get("pic"));
        viewHolder.text.setText((CharSequence) data.getData().get(position).get("text"));
        viewHolder.time.setText((CharSequence) data.getData().get(position).get("time"));
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return convertView;
    }

    private class ViewHolder{
        ImageView pic;
        TextView text;
        TextView time;
        Button btn;
    }
}