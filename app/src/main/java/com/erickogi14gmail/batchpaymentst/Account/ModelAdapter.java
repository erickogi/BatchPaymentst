package com.erickogi14gmail.batchpaymentst.Account;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import com.erickogi14gmail.batchpaymentst.R;
import java.util.ArrayList;

/**
 * Created by kimani kogi on 2/15/2017.
 */


    public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {
        Context context;
        private ArrayList<Model> modelList;

    public ModelAdapter(Context context){
        this.context = context;
       // this.listData = listData;
    }
    public interface OnItemClickListener {

        void onItemClick(Model item);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView txtdate;
            private TextView txtTo;
            private TextView txtAmount;
            private TextView txtStatus;
           // private ImageView loadedImage;

            public MyViewHolder(View view) {
                super(view);
                txtdate = (TextView) view.findViewById(R.id.date);
                txtTo = (TextView) view.findViewById(R.id.to);
                txtAmount=(TextView)view.findViewById(R.id.amount) ;
                txtStatus=(TextView)view.findViewById(R.id.status) ;

            }
        }


        public ModelAdapter(ArrayList<Model> modelList, Context context) {
            this.modelList = modelList;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.transactionlistviewitem, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Model model = modelList.get(position);
            holder.txtdate.setText(model.getModificationDate());
            holder.txtTo.setText(model.getCreditor());
            holder.txtAmount.setText(String.valueOf(model.getAmount()));
            holder.txtStatus.setText(String.valueOf(model.getTransactionStatus()));

        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

    }



