package ca.qc.bdeb.c5gm.helloworld;

import android.widget.TextView;

public class Joueur {
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
}
