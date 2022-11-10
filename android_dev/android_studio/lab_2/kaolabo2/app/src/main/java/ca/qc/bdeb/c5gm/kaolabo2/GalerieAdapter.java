package ca.qc.bdeb.c5gm.kaolabo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GalerieAdapter extends RecyclerView.Adapter<GalerieAdapter.MyViewHolder> {

    private List<String> images;
    private ImageView imageView;
    private Context context;
    protected PhotoListener photoListener;


    public GalerieAdapter(List<String> images, Context context, PhotoListener photoListener) {
        this.images = images;
        this.context = context;
        this.photoListener = photoListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.item_galerie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String image = images.get(position);
//        Glide.with(context).load(image).into(holder.image);
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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.photo);
        }
    }

    public interface PhotoListener {
        void onPhotoClick(String path);
    }
}
