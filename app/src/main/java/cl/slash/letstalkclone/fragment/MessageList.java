package cl.slash.letstalkclone.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import letstalkclone.lemontechapp.slash.cl.testapp_lemontech.R;

/**
 * Created by waltercool on 01-09-14.
 */
public class MessageList extends Fragment {

    public static final String TYPE_MESSAGE = "type_message";
    public static final int TYPE_OPEN = 1, TYPE_CLOSED = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int typeMessage = getArguments().getInt(TYPE_MESSAGE, 0);
        container = (ViewGroup)inflater.inflate(R.layout.fragment_messagelist, null);
        TextView tvTitle = (TextView)container.findViewById(R.id.fragment_messagelist_title);
        tvTitle.setText(typeMessage==TYPE_OPEN?R.string.txt_openmessages:R.string.txt_closedmessages);
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
