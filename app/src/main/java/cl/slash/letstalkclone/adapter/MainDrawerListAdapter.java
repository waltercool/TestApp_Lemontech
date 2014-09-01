package cl.slash.letstalkclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cl.slash.letstalkclone.obj.MainDrawerListItem;

/**
 * Created by waltercool on 01-09-14.
 */
public class MainDrawerListAdapter extends BaseAdapter {

    private Context context;
    private List<MainDrawerListItem> items;

    public MainDrawerListAdapter(Context context, List<MainDrawerListItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public MainDrawerListItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.activity_list_item, null);  //I'm lazy
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        MainDrawerListItem item = getItem(position);

        holder.getTvName().setText(item.getName());

        return convertView;
    }

    private class ViewHolder
    {
        private TextView tvName;
        public ViewHolder(View container) {
            this.tvName = (TextView)container.findViewById(android.R.id.text1);
        }

        public TextView getTvName() {
            return tvName;
        }
    }
}
