package ca.qc.bdeb.c5gm.kaolabo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GalerieActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GalerieAdapter galerieAdapter;
    List<String> images;
    TextView numero_galerie;

    private static final int READ_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galerie);

        numero_galerie = findViewById(R.id.numero_galerie);
        recyclerView = findViewById(R.id.recyclerview_galerie);

        if (ContextCompat.checkSelfPermission(GalerieActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(GalerieActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_PERMISSION_CODE);
        }
        else {
            loadImages();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == READ_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Acces stockage autorise", Toast.LENGTH_SHORT).show();
                loadImages();
            } else {
                Toast.makeText(this, "Acces stockage refuse", Toast.LENGTH_SHORT).show();

            }
        }


    }

    private void loadImages() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        images = GalerieImages.listImages(this);
        galerieAdapter = new GalerieAdapter(images, this, new GalerieAdapter.PhotoListener(){

            @Override
            public void onPhotoClick(String path) {
                Toast.makeText(GalerieActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(galerieAdapter);
        numero_galerie.setText("Photos (" + images.size()+ ")");
    }
}