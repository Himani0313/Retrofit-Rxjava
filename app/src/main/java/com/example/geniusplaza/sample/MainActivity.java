package com.example.geniusplaza.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.geniusplaza.sample.POJO.Posts;
import com.example.geniusplaza.sample.retrofit.ApiUtils;
import com.example.geniusplaza.sample.retrofit.ExampleApi;
import com.example.geniusplaza.sample.retrofit.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {
    private ExampleApi mExampleApi;
    private List<Posts> mPosts = new ArrayList<Posts>();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private PostsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExampleApi = ApiUtils.getExampleApi();
        mRecyclerView = (RecyclerView) findViewById(R.id.postsRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.setHasFixedSize(false);
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new PostsAdapter(this, mPosts);
        mRecyclerView.setAdapter(mAdapter);


        mExampleApi.getAllPosts().enqueue(new Callback<List<Posts>>() {


            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                Log.d("Main Activity", "inside nRespose successful ");
                mAdapter.updateData(mPosts);
                Log.d("aaaaaaaa",response.body().get(0).getId().toString());
                //put in listview
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}