package ca.qc.bdeb.c5gm.helloworld;

public class Personne {
    private String nom;
    private int photoId;

    public Personne(String nom, int photoId) {
        this.nom = nom;
        this.photoId = photoId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
