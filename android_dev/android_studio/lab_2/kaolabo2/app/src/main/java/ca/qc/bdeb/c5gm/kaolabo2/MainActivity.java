package ca.qc.bdeb.c5gm.kaolabo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button btn_dictaphone, btn_galerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_dictaphone = findViewById(R.id.btn_ouvrirDictaphone);
        btn_galerie = findViewById(R.id.btn_ouvrirGalerie);

        // listener pour le bouton ouvrir dictaphone
        btn_dictaphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DictaphoneActivity.class);
                startActivity(intent);
            }
        });

        // listerner pour le bouton ouvrir galerie
        btn_galerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GalerieActivity.class);
                startActivity(intent);
            }
        });
    }
}