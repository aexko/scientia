package ca.qc.bdeb.c5gm.kaolabo2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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
    private String fileName = "recorded.3gp";

    //    private final RecordButton recordButton = null;
//    private final PlayButton playButton = null;
    private MediaRecorder recorder;
    private MediaPlayer player;
    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private FloatingActionButton btn_enregistrer, btn_jouer;


    // Requesting permission to RECORD_AUDIO
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictaphone);

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        fileName = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + fileName;

        btn_enregistrer = findViewById(R.id.btn_enregistrer);
        btn_jouer = findViewById(R.id.btn_jouer);

        btn_enregistrer.setOnClickListener(new View.OnClickListener() {
            private boolean enregistrementEnCours = true;
            @Override
            public void onClick(View v) {
                if (enregistrementEnCours) {
                    btn_enregistrer.setImageResource(R.drawable.ic_baseline_stop_24);
                    Log.d("Enregistrer", "enregistrementEnCours " + enregistrementEnCours);
                    startRecording();

                } else {
                    btn_enregistrer.setImageResource(R.drawable.ic_baseline_fiber_manual_record_24);

                    Log.d("Enregistrer", "enregistrementEnCours " + enregistrementEnCours);
                    stopRecording();

                }
                enregistrementEnCours = !enregistrementEnCours;
            }

        });

        btn_jouer.setOnClickListener(new View.OnClickListener() {
            private boolean jouerEnCours = true;
            @Override
            public void onClick(View v) {
                if (jouerEnCours) {
                    btn_jouer.setImageResource(R.drawable.ic_baseline_stop_24);

//                    jouerEnCours = false;
                    Log.d("Jouer", "jouer " + jouerEnCours);
                    startPlaying();

                } else {
                    btn_jouer.setImageResource(R.drawable.ic_baseline_play_arrow_24);

//                    jouerEnCours = true;
                    Log.d("Jouer", "jouer " + jouerEnCours);
                    stopPlaying();

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
        player = new MediaPlayer();
        try {
            player.setDataSource(fileName);
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
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {

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
        Log.d("ACTIONS", "stopRecording: ");

    }
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (recorder != null) {
//            recorder.release();
//            recorder = null;
//        }
//
//        if (player != null) {
//            player.release();
//            player = null;
//        }
//    }

    //    asdasd
//    class RecordButton extends Button {
//        boolean mStartRecording = true;
//
//        final OnClickListener clicker = new OnClickListener() {
//            public void onClick(View v) {
//                onRecord(mStartRecording);
//                if (mStartRecording) {
//                    setText("Stop recording");
//                } else {
//                    setText("Start recording");
//                }
//                mStartRecording = !mStartRecording;
//            }
//        };
//
//        public RecordButton(Context ctx) {
//            super(ctx);
//            setText("Start recording");
//            setOnClickListener(clicker);
//        }
//    }

    //    asdasd
//    class PlayButton extends Button {
//        boolean mStartPlaying = true;
//
//        final OnClickListener clicker = new OnClickListener() {
//            public void onClick(View v) {
//                onPlay(mStartPlaying);
//                if (mStartPlaying) {
//                    setText("Stop playing");
//                } else {
//                    setText("Start playing");
//                }
//                mStartPlaying = !mStartPlaying;
//            }
//        };
//
//
//    }
}