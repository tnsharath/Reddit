package com.vintile.sharathkumartn_reddit.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.vintile.sharathkumartn_reddit.MyApplication;
import com.vintile.sharathkumartn_reddit.R;
import com.vintile.sharathkumartn_reddit.databinding.ActivityMainBinding;
import com.vintile.sharathkumartn_reddit.model.postmodel.Data_;
import com.vintile.sharathkumartn_reddit.utils.PostClickInterface;
import com.vintile.sharathkumartn_reddit.view.adapter.PostsAdapter;
import com.vintile.sharathkumartn_reddit.viewmodel.HomeViewModel;
import com.vintile.sharathkumartn_reddit.viewmodel.HomeViewModelFactory;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements PostClickInterface {


    private static final int PAGE_START = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private final int TOTAL_PAGES = 50;
    private int currentPage = PAGE_START;

    private PostsAdapter adapter;
    private final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApplication.getContext(), RecyclerView.VERTICAL, false);
    private ItemOffsetDecoration itemDecoration;

    private ActivityMainBinding activityMainBinding;

    private static final String TAG = "HomeActivity";
    private HomeViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new PostsAdapter(this);
        itemDecoration = new ItemOffsetDecoration(getApplicationContext());
        model = model = ViewModelProviders.of(this, new HomeViewModelFactory()).get(HomeViewModel.class);
        initRecyView();
        loadFirstPage("popular", 10);
    }

    private void loadFirstPage(String topic, int count) {
        model.requestData(topic, count).observe(this, new Observer<List<Data_>>() {
            @Override
            public void onChanged(@Nullable List<Data_> data_list) {
                if (data_list != null) {
                    activityMainBinding.progressBar.setVisibility(View.GONE);
                    adapter.addAll(data_list);
                }
                if (currentPage <= TOTAL_PAGES) adapter.addLoadingFooter();
                else isLastPage = true;
            }
        });
    }

    /**
     * Initializing RecyclerView.
     */
    private void initRecyView() {
        activityMainBinding.recyclerView.setHasFixedSize(true);
        activityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);
        activityMainBinding.recyclerView.addItemDecoration(itemDecoration);
        activityMainBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        activityMainBinding.recyclerView.addOnScrollListener(paginationScrollListener);
        activityMainBinding.setPostAdapter(adapter);
    }

    /**
     * Scroll listener
     */
    private final PaginationScrollListener paginationScrollListener = new PaginationScrollListener(linearLayoutManager) {
        @Override
        protected void loadMoreItems() {
            isLoading = true;
            currentPage += 1;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //TODO uncomment
                    //loadNextPage();
                }
            }, 1000);
        }

        @Override
        public boolean isLastPage() {
            return isLastPage;
        }

        @Override
        public boolean isLoading() {
            return isLoading;
        }
    };

    @Override
    public void clickImage(String url) {
        Log.d(TAG, "clickImage: " + url);
    }

    @Override
    public void clickShare() {

    }

    @Override
    public void clickComment() {

    }

    @Override
    public void clickSave() {

    }

    /**
     * Recyclerview item decoration
     */
    class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

        private final int mItemOffset;
        private ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }
        private ItemOffsetDecoration(@NonNull Context context) {
            this(context.getResources().getDimensionPixelSize(R.dimen.item_margin));
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                                   @NonNull RecyclerView parent,
                                   @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }

}
