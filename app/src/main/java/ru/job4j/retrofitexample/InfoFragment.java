package ru.job4j.retrofitexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comments, container, false);
        loadInfo();
        return view;
    }

    private void loadInfo() {
        JsonPlaceHolderApi jsonPlaceHolderApi =
                JsonPlaceHolderApi.RETROFIT.create(JsonPlaceHolderApi.class);
        final Call<List<Comment>> call = jsonPlaceHolderApi.getComments();
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    List<Comment> comments = response.body();
                    addCommentsInRecycler(comments);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    private void addCommentsInRecycler(List<Comment> comments) {
        RecyclerView recycler = getActivity().findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = new CommentAdapter(comments);
        recycler.setAdapter(adapter);
    }
}