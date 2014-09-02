package cl.slash.letstalkclone.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cl.slash.letstalkclone.obj.Conversation;
import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 01-09-14.
 */
public class ConversationAdapter extends BaseAdapter {

    private Context mContext;
    private List<Conversation> mItems;

    public ConversationAdapter(Context context, List<Conversation> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Conversation getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_conversation_list, parent);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Conversation item = getItem(position);
        holder.getImage().setImageDrawable(Drawable.createFromPath( item.getLastMessagePerson().getAvatar().getAbsolutePath() ));
        holder.getTitle().setText(item.getIssue());
        holder.getLastMsg().setText(item.getLastMessage());

        return convertView;
    }

    private class ViewHolder {

        private ImageView mImage;
        private TextView mTitle, mLastMsg;

        public ViewHolder(View container) {
            this.mImage = (ImageView)container.findViewById(R.id.item_conversation_list_contact_image);
            this.mTitle = (TextView)container.findViewById(R.id.item_conversation_list_title);
            this.mLastMsg = (TextView)container.findViewById(R.id.item_conversation_list_lastmessage);
        }

        public ImageView getImage() {
            return mImage;
        }

        public TextView getTitle() {
            return mTitle;
        }

        public TextView getLastMsg() {
            return mLastMsg;
        }
    }
}
