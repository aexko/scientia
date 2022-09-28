package ca.qc.bdeb.c5gm.helloworld;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class Joueur implements Parcelable {
    protected Joueur(Parcel in) {
        score = in.readInt();
        nom = in.readString();
    }

    public static final Creator<Joueur> CREATOR = new Creator<Joueur>() {
        @Override
        public Joueur createFromParcel(Parcel in) {
            return new Joueur(in);
        }

        @Override
        public Joueur[] newArray(int size) {
            return new Joueur[size];
        }
    };

    public int getScore() {
        return score;
    }

    private int score;
    private TextView tv;
    private String nom;


    public Joueur(int score, TextView tv, String nom) {
        this.score = score;
        this.tv = tv;
        this.setNom(nom);
    }

    public void ajoutScore(int score){
        this.score += score;
        tv.setText(Integer.toString(this.score));
    }

    public void resetScore(){
        score = 0;
        tv.setText("0");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(score);
        parcel.writeString(nom);
    }
}
