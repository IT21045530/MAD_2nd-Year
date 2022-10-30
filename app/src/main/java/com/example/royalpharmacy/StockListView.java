package com.example.royalpharmacy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StockListView {
    private Context mContext;
    private StockAdapter adapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Stock> stocks, List<String> keys){
        mContext=context;
        adapter =new StockAdapter(stocks,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    class StockView extends RecyclerView.ViewHolder{

        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;
        private TextView name ,quantity ,price;
        private ImageButton delete;


        private String key;

        public StockView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.add_list_stock,parent,false));


            name =(TextView)itemView.findViewById(R.id.stockName1);
            quantity =(TextView)itemView.findViewById(R.id.squan);
            price =(TextView)itemView.findViewById(R.id.sprice);
            delete =(ImageButton) itemView.findViewById(R.id.deletestock);

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("stocks");

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String orderNum = name.getText().toString().trim();

                    databaseReference.child(orderNum).setValue(null);
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, com.example.royalpharmacy.UpdateStock.class);
                    intent.putExtra("key",key);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("quantity", quantity.getText().toString());
                    intent.putExtra("prize", price.getText().toString());

                    mContext.startActivity(intent);


                }

            });
        }
        public void bind(Stock stock, String key){
            name.setText(stock.getType());
            quantity.setText(stock.getQuantity());
            price.setText(stock.getPrice());
            this.key=key;

        }
    }
    class StockAdapter extends RecyclerView.Adapter<StockView>{
        private List<Stock> stockList;
        private List<String> list;

        public StockAdapter(List<Stock> stockList, List<String> stringList) {
            this.stockList = stockList;
            this.list = stringList;
        }

        @NonNull
        @Override
        public StockView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new StockView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull StockView holder, int position) {
            holder.bind(stockList.get(position), list.get(position));

        }

        @Override
        public int getItemCount() {
            return stockList.size();
        }
    }
}
