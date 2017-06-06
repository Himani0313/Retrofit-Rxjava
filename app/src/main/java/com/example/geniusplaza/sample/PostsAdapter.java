package com.example.geniusplaza.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.geniusplaza.sample.POJO.Posts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geniusplaza on 6/6/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Posts> mPosts;
    private Context mContext;

    public static final String TAG = PostsAdapter.class.getSimpleName();

    public PostsAdapter(Context context, List<Posts> posts) {
        mContext = context;
        mPosts = posts;

    }
    public Context getContext(){
        return mContext;
    }

    public void updateData(List<Posts> posts) {
        mPosts = posts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_contents_row, parent, false);
        //ViewHolder vh = new ViewHolder(v);
        return new ViewHolder(v);
    }
    //Replace contents of a view(invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Posts posts = mPosts.get(position);
        Log.d("PostAdapter",posts.getId().toString() );
        holder.rowId.setText(posts.getId().toString());
        Log.d("PostAdapter", "Bind success!");
        //holder.rowSong.setText(song.getSongName());
        //Glide.with(mContext).load(song.getArtistUrl()).into(holder.rowImage);
    }
    // Replace the contents of a view (invoked by the layout manager)


    // Return the size of your dataset (invoked by the layout manager)
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //LinearLayout rowLayout;
        public TextView rowId;

        public ViewHolder(View v) {
            super(v);
            //rowLayout = (LinearLayout) v.findViewById(R.id.row_layout);
            rowId = (TextView) v.findViewById(R.id.row_id);
        }
    }
}
