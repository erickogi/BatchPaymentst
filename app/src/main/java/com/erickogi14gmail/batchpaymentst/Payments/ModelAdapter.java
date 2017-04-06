package com.erickogi14gmail.batchpaymentst.Payments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.batchpaymentst.Account.Model;
import com.erickogi14gmail.batchpaymentst.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimani kogi on 2/15/2017.
 */


    public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {
        Context context;
        private List<ModelB> modelList;

    public ModelAdapter(Context context){
        this.context = context;
       // this.listData = listData;
    }
    public interface OnItemClickListener {

        void onItemClick(Model item);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView txtName;
            private TextView txtPhone;
            private TextView txtAmount;
            private TextView txtStatus;
           // private ImageView loadedImage;

            public MyViewHolder(View view) {
                super(view);
                txtName = (TextView) view.findViewById(R.id.txtname);
                txtPhone = (TextView) view.findViewById(R.id.txtphone);
              //  txtAmount=(TextView)view.findViewById(R.id.amount) ;
              //  txtStatus=(TextView)view.findViewById(R.id.status) ;

            }
        }


        public ModelAdapter(List<ModelB> modelList, Context context) {
            this.modelList = modelList;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.batchlistitem, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            ModelB model = modelList.get(position);
            holder.txtName.setText(model.getNamea());
            holder.txtPhone.setText(model.getPhone());
          //  holder.txtAmount.setText(String.valueOf(model.getAmount()));
          //  holder.txtStatus.setText(String.valueOf(model.getTransactionStatus()));

        }

        @Override
        public int getItemCount() {
            return modelList.size();
        }

    }



