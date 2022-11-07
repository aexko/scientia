package ca.qc.bdeb.c5gm.kaolabo2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

public class DictaphoneActivity extends AppCompatActivity {

    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static final String fileName = null;

    //    private final RecordButton recordButton = null;
//    private final PlayButton playButton = null;
    private MediaRecorder recorder = null;
    private MediaPlayer player = null;
    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private FloatingActionButton btn_enregistrer, btn_jouer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictaphone);

        btn_enregistrer = findViewById(R.id.btn_enregistrer);
        btn_jouer = findViewById(R.id.btn_jouer);

        btn_enregistrer.setOnClickListener(new View.OnClickListener() {
            private boolean enregistrementEnCours = true;


            @Override
            public void onClick(View v) {

                if (enregistrementEnCours) {
                    btn_enregistrer.setImageResource(R.drawable.ic_baseline_fiber_manual_record_24);
                    enregistrementEnCours = false;
                    Log.d("Enregistrer", "enregistrementEnCours " + enregistrementEnCours);

                    onRecord(enregistrementEnCours);

                } else {
                    btn_enregistrer.setImageResource(R.drawable.ic_baseline_stop_24);
                    enregistrementEnCours = true;
                    Log.d("Enregistrer", "enregistrementEnCours " + enregistrementEnCours);

                }
                enregistrementEnCours = !enregistrementEnCours;
            }
        });

        btn_jouer.setOnClickListener(new View.OnClickListener() {
            private boolean jouerEnCours = true;
            @Override
            public void onClick(View v) {
                onPlay(jouerEnCours);
                if (jouerEnCours) {
                    btn_jouer.setImageResource(R.drawable.ic_baseline_play_arrow_24);
//                    jouerEnCours = false;
                    Log.d("Jouer", "jouer " + jouerEnCours);

                } else {
                    btn_jouer.setImageResource(R.drawable.ic_baseline_stop_24);
//                    jouerEnCours = true;
                    Log.d("Jouer", "jouer " + jouerEnCours);
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

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
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
    }

    private void stopPlaying() {
        player.release();
        player = null;
    }

    private void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        recorder.start();
    }

    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
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