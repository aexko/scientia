package com.example.connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private TextView tv2;
    private MonAPI client;

    private EditText username, password;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);



        client = MonApiClient.getRetrofit().create(MonAPI.class);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUsername = username.getText().toString();
                String inputMdp = password.getText().toString();
                connecter(inputUsername, inputMdp);
            }
        });


    }

    private void connecter(String inputUsername, String inputMdp) {

        LoginData loginData =new LoginData(inputUsername, inputMdp);
        client.connecter(loginData).enqueue(
                new Callback<Compte>() {
                    @Override
                    public void onResponse(Call<Compte> call, Response<Compte> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "OK!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Compte> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "NONOK", Toast.LENGTH_SHORT).show();
                    }
                }
        );

//        client.connecter(test).enqueue(new Callback<Compte>() {
//            @Override
//            public void onResponse(Call<Compte> call, Response<Compte> response) {
//
//
//                Compte json = response.body();
//
//                String str = "Nom : " + json.nom + "\nEmail : " + json.email;
//                Toast.makeText(Login.this, "OK: " + str, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Compte> call, Throwable t) {
//                Toast.makeText(Login.this, "OK: " + "FAIL", Toast.LENGTH_SHORT).show();
//            }
//        });
    }


}