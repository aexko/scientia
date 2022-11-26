package ca.qc.bdeb.c5gm.retrofit101;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {
    // because posts is the part after the base URL
    // https://jsonplaceholder.typicode.com/ + posts
    @GET("posts")
    Call<List<Post>> getPosts();
}
