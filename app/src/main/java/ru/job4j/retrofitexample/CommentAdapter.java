package ru.job4j.retrofitexample;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Comment> comments;

    CommentAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder(
                LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.comment, parent, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Comment comment = comments.get(position);
        final TextView result = holder.itemView.findViewById(R.id.result);
        String content = String.format(
                "postId: %s \nid: %s \nname: %s \nemail: %s \ntext: %s \n\n",
                comment.getId(), comment.getId(), comment.getName(),
                comment.getEmail(), comment.getText()
        );
        result.setText(content);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
