package ca.qc.bdeb.c5gm.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ModifierNom extends AppCompatActivity {

    private EditText etNomJ1;
    private EditText etNomJ2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_nom);

        TextView tvJ1 = findViewById(R.id.textView);
        tvJ1.setText(getString(R.string.Joueur) + 1);
        TextView tvJ2 = findViewById(R.id.textView2);
        tvJ2.setText(getString(R.string.Joueur) + 2);

        etNomJ1 = findViewById(R.id.editTextTextPersonName);
        etNomJ2 = findViewById(R.id.editTextTextPersonName2);

        Intent message = getIntent();


        if (message != null){
            etNomJ1.setText(message.getStringExtra(MainActivity.NOM_J_1));
            etNomJ2.setText(message.getStringExtra(MainActivity.NOM_J_2));
        }

    }

    public void onClickOK(View view) {
        Intent resultat = new Intent();
        resultat.putExtra(MainActivity.NOM_J_1, etNomJ1.getText().toString());
        resultat.putExtra(MainActivity.NOM_J_2, etNomJ2.getText().toString());
        setResult(RESULT_OK, resultat);
        finish();
    }
}