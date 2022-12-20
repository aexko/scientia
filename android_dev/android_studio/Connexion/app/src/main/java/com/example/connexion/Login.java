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
                String inputUsername = username.getText().toString();
                String inputMdp = password.getText().toString();


//                HashMap<String, Object> user = new HashMap<>();
//                HashMap<String, Object> test = new HashMap<>();
//
//                test.put("e                test.put("email", username.getText().toString().trim());
////                test.put("mot_de_passe", password.getText().toString().trim());mail", "prof1@test.com");
//                test.put("mot_de_passe", "secret");
//                user.put("id_compte", ConnectUtils.authID);
//                client.testerConnexion(ConnectUtils.authToken, user).enqueue(
//                        new Callback<ResponseBody>() {
//                            @Override
//                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                                if (response.code() != 200) {
//                                    connecter(test);
//                                }
//                                Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
//                            }
//                            @Override
//                            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                                connecter(test);
//                                Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                );


            }
        });





    }




}