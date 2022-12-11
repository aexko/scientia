package com.example.connexion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private Button login;
    private MonAPI client;
    private EditText username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        client = MonApiClient.getRetrofit().create(MonAPI.class);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);


        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> user = new HashMap<>();
                HashMap<String, Object> test = new HashMap<>();
                test.put("email", username.getText().toString().trim());
                test.put("mot_de_passe", password.getText().toString().trim());
//                test.put("email", "prof1@test.com");
//                test.put("mot_de_passe", "secret");
                user.put("id_compte", ConnectUtils.authID);
                client.testerConnexion(ConnectUtils.authToken, user).enqueue(
                        new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if (response.code() != 200) {
                                    connecter(test);
                                }
                                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                connecter(test);
                                Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        });





    }


    private void connecter(HashMap<String, Object> test) {

        client.connecter(test).enqueue(new Callback<Compte>() {
            @Override
            public void onResponse(Call<Compte> call, Response<Compte> response) {


                Compte json = response.body();

                String str = "Nom : " + json.nom + "\nEmail : " + json.email;
                Toast.makeText(Login.this, "OK: " + str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Compte> call, Throwable t) {
                Toast.makeText(Login.this, "OK: " + "FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }


}