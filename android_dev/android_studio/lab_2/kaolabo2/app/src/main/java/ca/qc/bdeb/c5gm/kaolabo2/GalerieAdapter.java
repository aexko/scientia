package ca.qc.bdeb.c5gm.kaolabo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalerieAdapter extends RecyclerView.Adapter<GalerieAdapter.ViewHolder>{

    private List<String> images;
    private Context context;
    protected PhotoListener photoListener;

    public GalerieAdapter(List<String> images, Context context, PhotoListener photoListener) {
        this.images = images;
        this.context = context;
        this.photoListener = photoListener;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_galerie, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String image = images.get(position);
        Glide.with(context).load(image).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoListener.onPhotoClick(image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.photo);
        }
    }

    public interface PhotoListener {
        void onPhotoClick(String path);
    }
}
