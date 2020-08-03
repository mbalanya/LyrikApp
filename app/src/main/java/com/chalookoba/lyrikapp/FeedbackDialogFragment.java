package com.chalookoba.lyrikapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

public class FeedbackDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.feedback_fragment_dialog, container, false);
        getDialog().setTitle("Lyrics Feedback");
        return rootView;
    }
}
