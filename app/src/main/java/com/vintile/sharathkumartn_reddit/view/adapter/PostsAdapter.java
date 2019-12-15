package com.vintile.sharathkumartn_reddit.view.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.vintile.sharathkumartn_reddit.R;
import com.vintile.sharathkumartn_reddit.databinding.ItemFeedBinding;
import com.vintile.sharathkumartn_reddit.model.postmodel.Data_;
import com.vintile.sharathkumartn_reddit.utils.PostClickInterface;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Data_> hitList;
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private boolean isLoadingAdded = false;

    private PostClickInterface clickInterface;
    public PostsAdapter(PostClickInterface clickInterface) {
        this.hitList = new ArrayList<>();
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemFeedBinding itemFeedBinding =  DataBindingUtil.inflate(inflater,
                R.layout.item_feed, parent, false);

        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case ITEM:
                viewHolder = new PostViewHolder(itemFeedBinding);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Data_ data = hitList.get(position);
        switch (getItemViewType(position)) {
            case ITEM:
                final PostViewHolder newsVH = (PostViewHolder) holder;
                newsVH.itemFeedBinding.setDataModel(data);
//                newsVH.itemFeedBinding.ivPost.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        clickInterface.clickImage(data.getPermalink());
//                    }
//                });
                break;

            case LOADING:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return hitList == null ? 0 : hitList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == hitList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    private class PostViewHolder extends RecyclerView.ViewHolder {

        private ItemFeedBinding itemFeedBinding;

        private PostViewHolder(ItemFeedBinding itemView) {
            super(itemView.getRoot());
            itemFeedBinding = itemView;
        }
    }

    private class LoadingVH extends RecyclerView.ViewHolder {

        private LoadingVH(View itemView) {
            super(itemView);
        }
    }

    private void add(Data_ r) {
        hitList.add(r);
        notifyItemInserted(hitList.size() - 1);
    }

    public void addAll(List<Data_> moveResults) {
        hitList.addAll(moveResults);
        notifyDataSetChanged();
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Data_());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = hitList.size() - 1;
        Data_ result = getItem(position);

        if (result != null) {
            hitList.remove(position);
            notifyItemRemoved(position);
        }
    }

    private Data_ getItem(int position) {
        return hitList.get(position);
    }

}