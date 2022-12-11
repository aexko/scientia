package com.example.connexion;

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


}
