package ca.qc.bdeb.revision_from_codelabs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private TextView username;
    private EditText inputUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("test", "Hello World");
        mShowCount = (TextView) findViewById(R.id.show_count);
        inputUser = (EditText) findViewById(R.id.editTxt_username);
        username = (TextView) findViewById(R.id.username1);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
        Log.d("checkingToast", "The toast showed up");
    }

    public void increaseCount(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            Log.d("checkingCount", "The count has increased.");
        } else {
            Log.d("checkingCount", "mShowCount is null");
        }
    }

    public void changeName(View view) {
        username.setText(inputUser.getText());
        Log.d("checkingChangingName", "The user entered: " + inputUser.getText().toString());
    }


}