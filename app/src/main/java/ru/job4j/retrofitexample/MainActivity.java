package ru.job4j.retrofitexample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);

        JsonPlaceHolderApi jsonPlaceHolderApi =
                JsonPlaceHolderApi.RETROFIT.create(JsonPlaceHolderApi.class);
        final Call<List<Comment>> call = jsonPlaceHolderApi.getComments();

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    result.setText(String.format("Code: %s", response.code()));
                    return;
                }
                List<Comment> comments = response.body();

                for (Comment comment : comments) {
                    String content = String.format(
                            "postId: %s \nid: %s \nname: %s \nemail: %s \ntext: %s \n\n",
                            comment.getId(), comment.getId(), comment.getName(),
                            comment.getEmail(), comment.getText()
                    );
                    result.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }
}
