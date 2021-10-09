package com.example.cis_692_final_project.ui.newProgressPicture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.cis_692_final_project.databinding.FragmentNewProgressPictureBinding;


public class NewProgressPictureFragment extends Fragment {

    private NewProgressPictureViewModel newProgressPictureViewModel;
    private FragmentNewProgressPictureBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newProgressPictureViewModel =
                new ViewModelProvider(this).get(NewProgressPictureViewModel.class);

        binding = FragmentNewProgressPictureBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNewProgressPicture;
        newProgressPictureViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
