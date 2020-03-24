package com.example.task.Adapter;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.task.Apiclient.Apiclient;
import com.example.task.Interface.ApiInterface;
import com.example.task.Model.Deals_details;
import com.example.task.Model.Post;
import com.example.task.R;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.MyViewHolder> {
    private Context context;
    private ApiInterface apiInterface;

    private List<Deals_details> mDeals_details;

    public DealsAdapter(Context context, List<Deals_details> mDeals_details) {
        this.context = context;
        this.mDeals_details = mDeals_details;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater minflater = LayoutInflater.from(context);
        view = minflater.inflate(R.layout.row_items_deals, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.percent.setText(mDeals_details.get(position).getPercent());
        holder.item_titile.setText(mDeals_details.get(position).getItem_name());
        holder.imageView.setImageResource(mDeals_details.get(position).getImageid());
        apiInterface = Apiclient.getApiclient().create(ApiInterface.class);

        if (position % 2 == 0 && position % 4 == 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#ffff00"));
        }
//        if(){
//            holder.cardView.setCardBackgroundColor(Color.parseColor("#9e0e55"));
//        }
        else if (position % 3 == 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#87ceeb"));

        } else if (position % 6 == 0 && position % 3 != 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#140449"));

        } else if (position % 5 == 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#ff7100"));

        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#0e5f07"));

        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                createpost(position, mDeals_details.get(position).getItem_name());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDeals_details.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView percent, item_titile;
        ImageView imageView;

        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            percent = (TextView) itemView.findViewById(R.id.percent);
            item_titile = (TextView) itemView.findViewById(R.id.homeandfur);
            imageView = (ImageView) itemView.findViewById(R.id.img_item);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }


    }


    private void createpost(int position, String item_name) {
        Post post = new Post(position, item_name, "text");

        apiInterface = Apiclient.getOkHttpClient_localAPI().create(ApiInterface.class);


        Call<Post> call = apiInterface.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post po = response.body();

                    Toast.makeText(context, po.getTitle(), Toast.LENGTH_SHORT).show();

                } else {
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                if (t instanceof SocketTimeoutException) {

                    Toast.makeText(context, "timeout Please try again", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void openDialog() {
        final Dialog dialog = new Dialog(context); // Context, this, etc.
        // dialog.setContentView(R.layout.dialog_demo);
        System.out.println("outofdsucess");
        dialog.setTitle("hgggjgjg");
        dialog.show();
    }
}
