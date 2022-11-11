package ca.qc.bdeb.c5gm.first_fragment_class;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private BlankViewModel viewModel;

    private Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new BlankViewModel();
        viewModel.getSelectedItem().observe(this, item -> {
            // Perform an action with the latest item data
        });
    }
}
//
//public class ListFragment extends Fragment {
//    private BlankViewModel viewModel;
//
//    @Override
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        viewModel = new ViewModelProvider(requireActivity()).get(BlankViewModel.class);
//
//
//        items.setOnClickListener(item -> {
//            // Set a new item
//            viewModel.select(item);
//        });
//    }
