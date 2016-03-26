package com.example.aj.intentexample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private final Context ctx;
    ArrayList<Contact> contacts=new ArrayList<>();

    public ContactAdapter(ArrayList<Contact> contacts,Context ctx){
        this.ctx=ctx;
        this.contacts=contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view,ctx,contacts);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact=contacts.get(position);
        holder.person_image.setImageResource(contact.getImage_id());
        holder.pname.setText(contact.getName());
        holder.pemail.setText(contact.getEmail());
        holder.pmobile.setText(contact.getMobile());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView person_image;
        TextView pname,pemail,pmobile;
        ArrayList<Contact> contacts=new ArrayList<>();
        Context ctx;
        public ContactViewHolder(View itemView,Context ctx,ArrayList<Contact> contacts) {

            super(itemView);
            this.contacts=contacts;
            this.ctx=ctx;
            itemView.setOnClickListener(this);
            person_image=(ImageView)itemView.findViewById(R.id.person_image);
            pname=(TextView)itemView.findViewById(R.id.person_name);
            pemail=(TextView)itemView.findViewById(R.id.person_email);
            pmobile=(TextView)itemView.findViewById(R.id.person_mobile);

        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            Contact contact= this.contacts.get(position);
            Intent intent=new Intent(ctx,ContactDetails.class);
            intent.putExtra("img_id",contact.getImage_id());
            intent.putExtra("pname",contact.getName());
            intent.putExtra("pemail",contact.getEmail());
            intent.putExtra("pmobile",contact.getMobile());
            this.ctx.startActivity(intent);
        }
    }
}
