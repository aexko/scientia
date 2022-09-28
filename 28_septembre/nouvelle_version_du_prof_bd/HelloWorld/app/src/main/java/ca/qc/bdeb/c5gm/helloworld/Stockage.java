package ca.qc.bdeb.c5gm.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Stockage {

    public static final int VERSION = 1;
    public static final String APP_NAME = "app.db";
    private Context context;
    private static Stockage instance = null;
    public static final String

    private Stockage(@Nullable Context context) {
        super(context, APP_NAME,)

    }



    public Stockage getInstance (Context context) {

    }

    public static class Scores implements BaseColums{
        public static final String NOM_TABLE = "scores";
        public static final String NOM_JOUEUR = "nom";
        public static final String SCORE = "score";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        "CREATE TABLE" + Scores.NOM_TABLE + "(" + Scores._ID + " INTEGER PRIMARY KEY," + Score.SCORE + " NUMBER)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int version_actuelle, int nouvelle_version) {
        if (nouvelle_version > version_actuelle) {
            sqLiteDatabase.execSQL("DROP_TABLE");
            sqLiteDatabase.execSQL("CREATE_TABLE");
        }
    }

    public void ajoutScore(Joueur j) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
    }

    public ArrayList<Joueur> getJoueurs() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] colonnes = {Scores.NOM_JOUEUR, Scores.SCORE};
        Cursor cursor = db.query(Scores.NOM_TABLE, colonnes, null, null, null, null, new String[] );
        ArrayList<Joueur> joueurs = new ArrayList<>();
        cursor.moveToFirst();
        do {
            if (!cursor.isNull(0))
                joueurs.add(new Joueur(cursor.getInt(1), null, cursor.getString(0)));
        } while (cursor.moveToNext());
        cursor.close();
        return joueurs;
    }


}

