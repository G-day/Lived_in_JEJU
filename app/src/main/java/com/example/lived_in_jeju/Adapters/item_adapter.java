package com.example.lived_in_jeju.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lived_in_jeju.ProfileActivityForCompany;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lived_in_jeju.ProfileActivityForEmployee;
import com.example.lived_in_jeju.Profiles.Item;
import com.example.lived_in_jeju.R;

import java.util.List;

/**
 * Created by EsrefTurkok on 26.04.2018.
 */

public class item_adapter extends RecyclerView.Adapter<item_adapter.item_holder>{
    private List<Item> itemList;
    FirebaseDatabase fbDb;
    FirebaseAuth mAuth;

    public item_adapter(List<Item> itemList){
        this.itemList = itemList;
    }

    @Override
    public item_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        fbDb = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();

        final item_holder holder = new item_holder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String userId = holder.textViewUserId.getText().toString();
                fbDb.getReference().child("Users").child(userId).child("usersType").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final String value = dataSnapshot.getValue(String.class);
                        if(value.length() == 8){
                            Context context = view.getContext();
                            Intent intent = new Intent(context, ProfileActivityForEmployee.class);
                            intent.putExtra("userId", userId);
                            context.startActivity(intent);
                        }
                        if(value.length() == 7){
                            Context context = view.getContext();
                            Intent intent = new Intent(context, ProfileActivityForCompany.class);
                            intent.putExtra("userId", userId);
                            context.startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
        return new item_holder(itemView);
    }

    @Override
    public void onBindViewHolder(final item_holder holder, int position) {
        Item item = itemList.get(position);
        holder.textViewName.setText(item.getName());
        holder.textViewLocation.setText(item.getLocation());
        holder.textViewUserId.setText(item.getDocsRef());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class item_holder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public TextView textViewLocation;
        public TextView textViewUserId;


        public item_holder(final View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
            textViewLocation = (TextView) view.findViewById(R.id.textViewLocation);
            textViewUserId = (TextView) view.findViewById(R.id.textViewDocsRef);
        }
    }
}
