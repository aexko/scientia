package ca.qc.bdeb.c5gm.rest_api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

public class ComptePOJO implements Serializable {
    @SerializedName("id")
    private UUID uuid;
     @SerializedName("nom")
    private String nom;
     @SerializedName("prenom")
    private String prenom;
     @SerializedName("email")
    private String email;

//    private String authToken;

}