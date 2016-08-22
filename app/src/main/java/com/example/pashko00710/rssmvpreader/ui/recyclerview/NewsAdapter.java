package com.example.pashko00710.rssmvpreader.ui.recyclerview;import android.content.Context;import android.content.Intent;import android.support.v7.widget.CardView;import android.support.v7.widget.RecyclerView;import android.util.Log;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ImageView;import android.widget.TextView;import com.daimajia.androidanimations.library.Techniques;import com.daimajia.androidanimations.library.YoYo;import com.example.pashko00710.rssmvpreader.R;import com.example.pashko00710.rssmvpreader.core.model.ItemTalk;import com.example.pashko00710.rssmvpreader.ui.DetailsActivity;import com.squareup.picasso.Picasso;import java.util.ArrayList;public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>  {    ArrayList<ItemTalk> feedItems;    Context context;    public NewsAdapter(Context context, ArrayList<ItemTalk>feedItems){        this.feedItems=feedItems;        this.context=context;    }    @Override    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {        View view= LayoutInflater.from(context).inflate(R.layout.custom_row_news_item,parent,false);        MyViewHolder holder=new MyViewHolder(view);        return holder;    }    @Override    public void onBindViewHolder(MyViewHolder holder, int position) {        YoYo.with(Techniques.FadeIn).playOn(holder.cardView);        ItemTalk current=feedItems.get(position);        holder.title.setText(current.getTitle());        holder.description.setText(current.getDescription());        holder.date.setText(current.getPubDate());        Picasso.with(context).load(current.getThumbnailUrl()).into(holder.thumbnail);    }    @Override    public int getItemCount() {        return feedItems.size();    }    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {        private Context context;        TextView title,description,date;        ImageView thumbnail;        CardView cardView;        public MyViewHolder(View itemView) {            super(itemView);            context = itemView.getContext();            title= (TextView) itemView.findViewById(R.id.title_text);            description= (TextView) itemView.findViewById(R.id.description_text);            date= (TextView) itemView.findViewById(R.id.date_text);            thumbnail= (ImageView) itemView.findViewById(R.id.thumb_img);            cardView= (CardView) itemView.findViewById(R.id.cardview);            title.setOnClickListener(this);        }        @Override        public void onClick(View v) {            final Intent intent;            ItemTalk current=feedItems.get(getAdapterPosition());            Log.d("lala", String.valueOf(current.getGuid()));            intent = new Intent(context, DetailsActivity.class);            intent.putExtra("guid", current.getGuid());            intent.putExtra("date", current.getPubDate());            intent.putExtra("title", current.getTitle());            intent.putExtra("pic", current.getThumbnailUrl());            context.startActivity(intent);        }    }}