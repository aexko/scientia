package com.example.connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private TextView tv2;
    private MonAPI client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        tv2 = findViewById(R.id.textView2);
        client = MonApiClient.getRetrofit().create(MonAPI.class);

        HashMap<String, Object> user = new HashMap<>();
        HashMap<String, Object> test = new HashMap<>();
        test.put("email", "prof1@test.com");
        test.put("mot_de_passe", "secret");
        user.put("id_compte", ConnectUtils.authID);
        client.testerConnexion(ConnectUtils.authToken, user).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() != 200) {
                            connecter(test);
                        }
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        connecter(test);
                        Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void connecter(HashMap<String, Object> test) {

        client.connecter(test).enqueue(new Callback<Compte>() {
            @Override
            public void onResponse(Call<Compte> call, Response<Compte> response) {

                tvResult.setText("Not a failure \uD83D\uDCAF");

                Compte json = response.body();

                String str = "Nom : " + json.nom + "\nEmail : " + json.email;

                tv2.setText(str);
            }

            @Override
            public void onFailure(Call<Compte> call, Throwable t) {
                tvResult.setText("Failure");
            }
        });
    }

}