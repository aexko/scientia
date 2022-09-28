package ca.qc.bdeb.c5gm.helloworld;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Jeu";
    public static final String SCORE_TOUR = "SCORE_TOUR";
    public static final String SCORE_DE = "SCORE_DE";
    public static final String JOUEUR_COURANT = "JOUEUR_COURANT";
    public static final String SCORE_J = "SCORE_J";
    public static final String NOM_J_1 = "ca.qc.bdeb.5gm.helloworld.NOM_J1";
    public static final String NOM_J_2 = "ca.qc.bdeb.5gm.helloworld.NOM_J2";
    private TextView tvScoreJ1;
    private TextView tvScoreJ2;
    private TextView tvScoreTour;
    private ImageView ivScoreDe;
    private TextView tvJoueurCourant;

    private Joueur[] joueurs;
    private int scoreTour = 0;
    private int joueurCourant = -1;

    private View.OnClickListener imageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onClickRouler(view);
        }
    };
    private int scoreDe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvScoreJ1 = findViewById(R.id.score_j1);
        tvScoreJ2 = findViewById(R.id.score_j2);
        tvScoreTour = findViewById(R.id.score_tour);
        ivScoreDe = findViewById(R.id.score_de);
        ivScoreDe.setImageResource(R.drawable.dice1);
        ivScoreDe.setOnClickListener(imageClickListener);
        tvJoueurCourant = findViewById(R.id.joueur_courant);
        joueurs = new Joueur[2];
        joueurs[0] = new Joueur(0, tvScoreJ1, getString(R.string.Joueur) +" " + 1);
        joueurs[1] = new Joueur(0, tvScoreJ2, getString(R.string.Joueur) +" " + 2);

        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        changerJoueur();
    }

    /**
     * Sauvegarde des paramètres UI
     * @param outState sauvegarde
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        int index = 1;
        for (Joueur j : joueurs){
            outState.putInt(SCORE_J + index, j.getScore() );
            index++;
        }
        outState.putInt(SCORE_TOUR, scoreTour);
        outState.putInt(SCORE_DE, scoreDe);
        outState.putInt(JOUEUR_COURANT, joueurCourant);

    }

    /**
     *  Restauration de l'UI
     * @param savedInstanceState état sauvegardé
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(savedInstanceState != null){
            for (int i = 0; i < joueurs.length; i++) {
                joueurs[i].ajoutScore(savedInstanceState.getInt(SCORE_J + (i+1)));
            }
            scoreTour = savedInstanceState.getInt(SCORE_TOUR);
            scoreDe = savedInstanceState.getInt(SCORE_DE);
            joueurCourant = savedInstanceState.getInt(JOUEUR_COURANT);

            tvScoreTour.setText(""+scoreTour);
            String str = "dice" + scoreDe;
            ivScoreDe.setImageResource(getResources().getIdentifier(str, "drawable", getPackageName()));
            tvJoueurCourant.setText(joueurs[joueurCourant%2].getNom());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_item_rouler:
                Toast.makeText(this, "Rouler a été sélectionné", Toast.LENGTH_SHORT).show();
                onClickRouler(ivScoreDe);
                break;
            case R.id.menu_item_garder:
                Toast.makeText(this, "Garder a été sélectionné", Toast.LENGTH_SHORT).show();
                onClickGarder();
                break;
            case R.id.menu_item_nouveau:
                Toast.makeText(this, "Nouveau a été sélectionné", Toast.LENGTH_SHORT).show();
                onClickNouveau();
                break;
            case R.id.menu_item_param:
                lancerModifierNom();
                break;
            case R.id.menu_item_afficher:
                lancerListe();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;

    }

    private void lancerListe() {
        Intent afficher = new Intent(this, RVActivity.class);
        startActivity(afficher);
    }

    ActivityResultLauncher<Intent> modifierNomResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK){
                        Intent resultat = result.getData();
                        if (resultat != null){
                            // traitement du résultat
                            joueurs[0].setNom(resultat.getStringExtra(NOM_J_1));
                            joueurs[1].setNom(resultat.getStringExtra(NOM_J_2));
                            tvJoueurCourant.setText(joueurs[joueurCourant%2].getNom());
                        }
                    }
                }
            });

    public void lancerModifierNom(){
        Intent message = new Intent(this, ModifierNom.class);
        message.putExtra(NOM_J_1, joueurs[0].getNom());
        message.putExtra(NOM_J_2, joueurs[1].getNom());

        message.putExtra("JOUEUR1", joueurs[0]);
        modifierNomResult.launch(message);
    }

    public void onClickNouveau() {
        joueurCourant = -1;
        joueurs[0].resetScore();
        joueurs[1].resetScore();
        changerJoueur();
        Log.d(TAG, " Nouvelle partie");
    }

    public void onClickRouler(View view) {
        Random r = new Random();
        scoreDe = r.nextInt(6) + 1;

        String str = "dice" + scoreDe;

        Log.d(TAG, " on vient de rouler un " + scoreDe);
        //tvScoreDe.setText(Integer.toString(de));
        ivScoreDe.setImageResource(getResources().getIdentifier(str, "drawable", getPackageName()));

        if (scoreDe == 1) {
            scoreTour = 0;
            tvScoreTour.setText(Integer.toString(scoreTour));
            changerJoueur();
        } else {
            scoreTour += scoreDe;
            tvScoreTour.setText(Integer.toString(scoreTour));
        }

    }

    public void onClickGarder() {
        joueurs[joueurCourant % 2].ajoutScore(scoreTour);
        Log.d(TAG, " Le joueur vient de gagner " + scoreTour + " points");
        if (joueurs[joueurCourant % 2].getScore() >= 100) {
            Log.i(TAG, "Joueur " + (joueurCourant % 2 + 1) + " a gagné");
            Toast.makeText(this, "Joueur " + (joueurCourant % 2 + 1) + " a gagné", Toast.LENGTH_LONG).show();
        }else {
            changerJoueur();
        }
    }

    public void changerJoueur() {
        scoreTour = 0;
        tvScoreTour.setText("" + scoreTour);
        joueurCourant++;
        tvJoueurCourant.setText(joueurs[joueurCourant%2].getNom());
        Toast.makeText(this, "C'est le tour du joueur " + (joueurCourant % 2 + 1), Toast.LENGTH_SHORT).show();
    }
}