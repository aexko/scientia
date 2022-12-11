package ca.qc.bdeb.c5gm.retrofit101;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompteEtudiantPOJO {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("typeCompte")
    @Expose
    private String typeCompte;
    @SerializedName("entreprises")
    @Expose
    private Object entreprises;
    private final static long serialVersionUID = 2889417296985674968L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public Object getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(Object entreprises) {
        this.entreprises = entreprises;
    }
}
