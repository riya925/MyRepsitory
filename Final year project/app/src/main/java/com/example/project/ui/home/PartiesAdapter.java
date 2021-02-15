package com.example.project.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

public class PartiesAdapter extends RecyclerView.Adapter<PartiesAdapter.ViewHolder>
{
    PartiesBeanClass[] parties_bean;
    Context context;
    

    public PartiesAdapter(PartiesBeanClass[] parties_bean, Context activity)
    {
        this.parties_bean=parties_bean;
        this.context=activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.parties,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

//        final parties_beanclass parties_beans=parties_bean[position];
        holder.company_name.setText(parties_bean[position].getCompany_name());
        holder.company_ceo.setText(parties_bean[position].getCompany_ceo());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,parties_bean[position].getCompany_name(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {

        return parties_bean.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView company_name,company_ceo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            company_name=itemView.findViewById(R.id.company_name);
            company_ceo=itemView.findViewById(R.id.company_ceo);

        }
    }
}
