package com.example.ayush.niki;

import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class ChatAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Message> mDataset;

    private final int ME = 0, NotME = 1;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder1 extends RecyclerView.ViewHolder {  // ME
        // each data item is just a string in this case
        public TextView txtMessage;
        public TextView userImg;

        public ViewHolder1(View v) {
            super(v);
            txtMessage = (TextView) v.findViewById(R.id.textView);

        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {  // NOT ME
        // each data item is just a string in this case
        public TextView txtMessage;
        public TextView userImg;

        public ViewHolder2(View v) {
            super(v);
            txtMessage = (TextView) v.findViewById(R.id.textView1);

        }
    }

    public void add(int position, Message item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChatAdapter(ArrayList<Message> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v;
        if(viewType == ME) {
            v = inflater.inflate(R.layout.right, viewGroup, false);
            viewHolder = new ViewHolder1(v);
        }
        else

        {
            v = inflater.inflate(R.layout.left, viewGroup, false);
            viewHolder = new ViewHolder2(v);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType() == ME) {
            ViewHolder1 vh1 = (ViewHolder1) holder;
            vh1.txtMessage.setText(mDataset.get(position).getMessage());
        }
        else
        {
            ViewHolder2 vh2 = (ViewHolder2) holder;
            vh2.txtMessage.setText(mDataset.get(position).getMessage());
        }
    }




    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataset.get(position).IsMe()) {
            return ME;
        } else  {
            return NotME;
        }
    }
}