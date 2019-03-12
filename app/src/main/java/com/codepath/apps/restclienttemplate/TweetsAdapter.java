package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {

    private Context context;
    private List<Tweet> tweets;

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        holder.tv_body.setText(tweet.body);
        holder.tv_screenName.setText(tweet.user.screenName);
        holder.tv_createdAt.setText(tweet.getFormattedTimeStamp());
        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.iv_profileImage);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Clear all tweets
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of tweets
    public void addTweets(List<Tweet> tweetList) {
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    //Pass in context and list of tweets

    //for each row, inflate the layout

    //bind values based on the position of the element

    //Define the ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv_profileImage;
        public TextView tv_screenName;
        public TextView tv_body;
        public TextView tv_createdAt;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_profileImage = itemView.findViewById(R.id.iv_profileImage);
            tv_screenName = itemView.findViewById(R.id.tv_screenName);
            tv_body = itemView.findViewById(R.id.tv_body);
            tv_createdAt = itemView.findViewById(R.id.tv_date);
        }
    }
}
