package ca.qc.bdeb.c5gm.helloworld;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ObjectListAdapter extends RecyclerView.Adapter<ObjectListAdapter.ObjectViewHolder> {

    private final ArrayList<Personne> itemList;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemSelected(int position);
    }

    public ObjectListAdapter(Context context, ArrayList<Personne> itemList) {
        inflater = LayoutInflater.from(context);
        this.itemList = itemList;
    }

    public void setOnClickListener (OnItemClickListener listener){
        this.listener = listener;
    }


    @NonNull
    @Override
    public ObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.rv_item, parent, false);
        return new ObjectViewHolder(itemView, this, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectViewHolder holder, int position) {
        holder.tv.setText(itemList.get(position).getNom());
        holder.iv.setImageResource(itemList.get(position).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ObjectViewHolder extends RecyclerView.ViewHolder{
        private View.OnClickListener imageClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getLayoutPosition();

                Personne personne = itemList.get(position);
                personne.setNom( personne.getNom() + " cliqué");
                adapter.notifyItemChanged(position);
                if (listener!=null) {
                    listener.onItemSelected(position);
                }
            }
        };
        private TextView tv;
        private ImageView iv;
        private final ObjectListAdapter adapter;
        private OnItemClickListener listener;
        public ObjectViewHolder(@NonNull View itemView, ObjectListAdapter adapter, final OnItemClickListener listener) {
            super(itemView);
            tv= itemView.findViewById(R.id.txtNom);
            iv= itemView.findViewById(R.id.imageView);
            iv.setOnClickListener(imageClick);
            this.adapter = adapter;
            this.listener=listener;
        }
    }
}
