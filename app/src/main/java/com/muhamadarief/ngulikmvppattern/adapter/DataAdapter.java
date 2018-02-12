package com.muhamadarief.ngulikmvppattern.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muhamadarief.ngulikmvppattern.R;
import com.muhamadarief.ngulikmvppattern.model.Android;

import java.util.List;

/**
 * Created by riefist on 2/12/18.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Android> mAndroidList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClicked(Android android);
    }

    public DataAdapter(OnItemClickListener listener){
        this.listener = listener;
    }

    public void setListAndroid(List<Android> android){
        this.mAndroidList = android;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.android_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvName.setText(mAndroidList.get(position).getName());
        holder.mTvVersion.setText(mAndroidList.get(position).getVer());
        holder.mTvApi.setText(mAndroidList.get(position).getApi());
        holder.itemView.setOnClickListener(view -> listener.onItemClicked(mAndroidList.get(position)));
    }

    @Override
    public int getItemCount() {
        return mAndroidList != null ? mAndroidList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvName,mTvVersion,mTvApi;
        ViewHolder(View view) {
            super(view);
            mTvName = view.findViewById(R.id.tv_name);
            mTvVersion = view.findViewById(R.id.tv_version);
            mTvApi = view.findViewById(R.id.tv_api_level);
        }

    }
}
