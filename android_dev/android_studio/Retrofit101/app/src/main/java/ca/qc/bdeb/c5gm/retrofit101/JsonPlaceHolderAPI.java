package ca.qc.bdeb.c5gm.retrofit101;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderAPI {
    // because posts is the part after the base URL
    // https://jsonplaceholder.typicode.com/ + posts
    @GET("posts")
    Call<List<Post>> getPosts(@Query("id") int postID);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id")int postID);

}
