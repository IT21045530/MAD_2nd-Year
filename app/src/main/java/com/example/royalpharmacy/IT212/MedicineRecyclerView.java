package com.example.royalpharmacy.IT212;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.royalpharmacy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MedicineRecyclerView {

    private Context mContext;
    private ItemAdapter adapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Medicine> list, List<String> keys){
        mContext=context;
        adapter =new ItemAdapter(list,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    class ItemView extends RecyclerView.ViewHolder{
        private TextView iname;
        private TextView iquantity;
        private TextView abcd;
        private ImageButton delete;

        FirebaseDatabase firebase;
        DatabaseReference reference;

        private String key;

        public ItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.add_list_medicine,parent,false));


            iname =(TextView)itemView.findViewById(R.id.Item_Name);
            iquantity =(TextView)itemView.findViewById(R.id.quantity);
            abcd =(TextView)itemView.findViewById(R.id.fvv);
            delete =(ImageButton) itemView.findViewById(R.id.remove);

            firebase = FirebaseDatabase.getInstance();
            reference = firebase.getReference("medicine");

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String orderNum = iname.getText().toString().trim();

                    reference.child(orderNum).setValue(null);
                }
            });


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, com.example.royalpharmacy.IT212.UpdateMedicine.class);
                    intent.putExtra("key",key);
                    intent.putExtra("name", iname.getText().toString());
                    intent.putExtra("quantity", iquantity.getText().toString());
                    intent.putExtra("add", abcd.getText().toString());

                    mContext.startActivity(intent);
                }

            });
        }
        public void bind(Medicine medicine, String key){
            iname.setText(medicine.getMedName());
            iquantity.setText(medicine.getQuantity());
            abcd.setText(medicine.getMedAddDate());
            this.key=key;

        }
    }
    class ItemAdapter extends RecyclerView.Adapter<ItemView>{
        private List<Medicine> medicines;
        private List<String> list;

        public ItemAdapter(List<Medicine> medicines1, List<String> stringList) {
            this.medicines = medicines1;
            this.list = stringList;
        }

        @NonNull
        @Override
        public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemView holder, int position) {
            holder.bind(medicines.get(position), list.get(position));

        }

        @Override
        public int getItemCount() {
            return medicines.size();
        }
    }
}
