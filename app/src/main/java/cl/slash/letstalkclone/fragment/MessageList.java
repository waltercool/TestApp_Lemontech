package cl.slash.letstalkclone.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import cl.slash.letstalkclone.adapter.ConversationAdapter;
import cl.slash.letstalkclone.utilities.Demo;
import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 01-09-14.
 */
public class MessageList extends Fragment {

    public static final String TYPE_MESSAGE = "type_message";
    public static final int TYPE_OPEN = 1, TYPE_CLOSED = 2;

    private ListView mList;
    private ConversationAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup)inflater.inflate(R.layout.fragment_messagelist, null);
        int typeMessage = getArguments().getInt(TYPE_MESSAGE, 0);
        TextView tvTitle = (TextView)container.findViewById(R.id.fragment_messagelist_title);
        mList = (ListView)container.findViewById(android.R.id.list);

        Demo demo = new Demo();
        tvTitle.setText(typeMessage==TYPE_OPEN?R.string.txt_openmessages:R.string.txt_closedmessages);
        mAdapter = new ConversationAdapter(getActivity(), demo.getDemoConversation());
        mList.setAdapter(mAdapter);
        return container;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
