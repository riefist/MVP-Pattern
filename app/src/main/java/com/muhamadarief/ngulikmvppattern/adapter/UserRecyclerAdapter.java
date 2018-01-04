package com.muhamadarief.ngulikmvppattern.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muhamadarief.ngulikmvppattern.R;
import com.muhamadarief.ngulikmvppattern.model.EmployeeModel;
import com.muhamadarief.ngulikmvppattern.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riefist on 1/4/18.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {

    private OnItemClickListener listener;
    private List<EmployeeModel.Data> users = new ArrayList<>();

    public interface OnItemClickListener{
        void onItemClick(EmployeeModel.Data user);
    }

    public UserRecyclerAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public UserRecyclerAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserRecyclerAdapter.UserViewHolder holder, int position) {
        holder.bindItems(users.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void replaceData(List<EmployeeModel.Data> user){
        this.users = user;
        notifyDataSetChanged();

    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView txtEmail, txtPassword;

        public UserViewHolder(View itemView) {
            super(itemView);
            txtEmail = itemView.findViewById(R.id.txt_email);
            txtPassword = itemView.findViewById(R.id.txt_password);
        }

        public void bindItems(final EmployeeModel.Data user, final OnItemClickListener listener){

            txtEmail.setText(""+user.getId());
            txtPassword.setText(user.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(user);
                }
            });

        }
    }


}
