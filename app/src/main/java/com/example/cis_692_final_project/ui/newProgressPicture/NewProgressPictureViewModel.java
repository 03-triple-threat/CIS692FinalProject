package com.example.cis_692_final_project.ui.newProgressPicture;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewProgressPictureViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewProgressPictureViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is new progress picture fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
