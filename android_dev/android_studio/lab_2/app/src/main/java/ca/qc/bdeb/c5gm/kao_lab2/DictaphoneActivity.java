package ca.qc.bdeb.c5gm.kao_lab2;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;

public class DictaphoneActivity extends AppCompatActivity {

    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
//    private String fileName = "recorded.3gp";

    //    private final RecordButton recordButton = null;
//    private final PlayButton playButton = null;
    private MediaRecorder recorder;
    private MediaPlayer player;
    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private FloatingActionButton btn_enregistrer, btn_jouer;


    // Requesting permission to RECORD_AUDIO
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictaphone);

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

//        fileName = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + fileName;

        btn_enregistrer = findViewById(R.id.btn_enregistrer);
        btn_jouer = findViewById(R.id.btn_jouer);

        btn_enregistrer.setOnClickListener(new View.OnClickListener() {
            private boolean enregistrementEnCours = true;

            @Override
            public void onClick(View v) {
                if (enregistrementEnCours) {
                    btn_enregistrer.setImageResource(R.drawable.ic_baseline_stop_24);
                    // TRUE
                    Log.d("Enregistrer", "enregistrementEnCours " + enregistrementEnCours);

                    enregistrementEnCours = false;
                    stopRecording();
                } else {
                    btn_enregistrer.setImageResource(R.drawable.ic_baseline_fiber_manual_record_24);
                    // FALSE
                    Log.d("Enregistrer", "enregistrementEnCours " + enregistrementEnCours);
                    enregistrementEnCours = true;
                    startRecording();
                }
            }

        });

        btn_jouer.setOnClickListener(new View.OnClickListener() {
            private boolean jouerEnCours = true;

            @Override
            public void onClick(View v) {
                if (jouerEnCours) {
                    btn_jouer.setImageResource(R.drawable.ic_baseline_stop_24);

                    jouerEnCours = false;
                    // TRUE

                    Log.d("Jouer", "jouer " + jouerEnCours);
                    stopPlaying();
                } else {
                    btn_jouer.setImageResource(R.drawable.ic_baseline_play_arrow_24);

                    jouerEnCours = true;
                    // FALSE
                    Log.d("Jouer", "jouer " + jouerEnCours);
                    startPlaying();
                }
                jouerEnCours = !jouerEnCours;

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted) finish();

    }


    private void startPlaying() {
        try {
            player = new MediaPlayer();
            player.setDataSource(getRecordingFilePath());
            player.prepare();
            player.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
        Log.d("ACTIONS", "startPlaying: ");
    }

    private void stopPlaying() {
        player.release();
        Log.d("ACTIONS", "stopPlaying: ");

    }

    private void startRecording() {
        try {
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setOutputFile(getRecordingFilePath());
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.prepare();
            recorder.start();
            Log.d("ACTIONS", "startRecording: ");
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }


    }

    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
        Log.d("ACTIONS", "stopRecording: ");

    }

    private String getRecordingFilePath() {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(musicDirectory, "test_audio" + ".mp3");
        return file.getPath();
    }

    // SOURCE: https://stackoverflow.com/questions/4778754/how-do-i-kill-an-activity-when-the-back-button-is-pressed
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}