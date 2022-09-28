package ca.qc.bdeb.c5gm.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

    private ArrayList<Personne> itemList;
    private RecyclerView recyclerView;
    private ObjectListAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);

        itemList = new ArrayList<>();

        itemList.add(new Personne("toto", R.drawable.dice1));
        itemList.add(new Personne("titi", R.drawable.dice2));
        itemList.add(new Personne("tata", R.drawable.dice3));

        recyclerView = findViewById(R.id.recyclerview);
        rvAdapter = new ObjectListAdapter(this, itemList);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        rvAdapter.setOnClickListener(new ObjectListAdapter.OnItemClickListener() {
            @Override
            public void onItemSelected(int position) {
                Log.i("TAG", "élément "+ position + "cliqué");
                itemList.remove(position);
                rvAdapter.notifyItemRemoved(position);
            }
        });

    }
}