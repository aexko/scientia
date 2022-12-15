package ca.qc.bdeb.c5gm.rest_api_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MonAPI client = MonAPIClient.getRetrofit().create(MonAPI.class);
        HashMap<String, Object> user = new HashMap<>();
        ConnectUtilis connectUtils = new ConnectUtilis("10.144.22.87:8888",  );
        user.put("id_compte", connectUtils.getAuthId()); client.testerConnexion(connectUtils.getAuthToken(), user).enqueue(
                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.code() != 200) { client.connecter();
                        } }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) { connectUtils.connecter();
                    } }
        );

        client.getComptesEleves(connectUtils.getAuthToken()).enqueue(new Callback<List<ComptePOJO>>() {

            @Override
            public void onResponse(Call<List<ComptePOJO>> call, Response<List<ComptePOJO>> response) {

            }

            @Override
            public void onFailure(Call<List<ComptePOJO>> call, Throwable t) {

            }
        });

    }


    public void onResponse(Call<List<ComptePOJO>> call, Response<List<ComptePOJO>> response) {
        if (response.code() == 200) { List<ComptePOJO> eleves = response.body(); String display = "Réponse OK\n";
            for (int i = 0; i < eleves.size(); i++) {
                display += eleves.get(i).toString() + "\n"; }
            tvResult.setText(display); }
    }
    @Override
    public void onFailure(Call<List<ComptePOJO>> call, Throwable t) {

    }
}