package Eunsung.com;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private  List<NewsData>  mDataset;
    private  static View.OnClickListener onClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_title;
        public TextView TextView_content;
        public TextView TextView_originalLink;
        public TextView TextView_link;
        public TextView TextView_pubDate;
        public ImageView ImageView_title;
        public View rootView;

        public MyViewHolder(View v) {

            super(v);
            TextView_title = v.findViewById(R.id.TextView_title);
            TextView_content = v.findViewById(R.id.TextView_content);
            TextView_pubDate=v.findViewById(R.id.pubDate);

            //TextView_originalLink=v.findViewById(R.id.originalLink);
            //TextView_link=v.findViewById(R.id.link);
            //ImageView_title = (SimpleDraweeView) v.findViewById(R.id.ImageView_title);
            rootView= v;
           // v.setClickable(true);
          //  v.setEnabled(true);
          //  v.setOnClickListener(onClickListener) ;

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<NewsData> myDataset, Context context, View.OnClickListener onClick) {
        mDataset = myDataset;
        onClickListener = onClick;
        Fresco.initialize(context);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_news, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        NewsData news= mDataset.get(position);

        holder.TextView_title.setText(news.getTitle());
        holder.TextView_content.setText(news.getContent());
        holder.TextView_pubDate.setText(news.getPubDate());

        // Uri uri = Uri.parse(news.getUrlToImage());
        // holder.ImageView_title.setImageURI(uri);
        // holder.rootView.setTag(position);
        // holder.TextView_link.setText(news.getLink());
        // holder.TextView_originalLink.setText(news.getOriginallink());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    public NewsData getNews(int position){

        return mDataset != null ? mDataset.get(position) : null;

    }
}
