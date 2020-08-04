package com.chalookoba.lyrikapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.DialogFragment;

public class FeedbackDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.feedback_fragment_dialog, container, false);
        getDialog().setTitle("Lyrics Feedback");
        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton); // butterknife cannot be used in fragments
        Button submitButton = (Button) rootView.findViewById(R.id.submitButton);

        RadioGroup feedbackRadioGroup = (RadioGroup) rootView.findViewById(R.id.feedbackRadioGroup);
        int selectedId = feedbackRadioGroup.getCheckedRadioButtonId();
        final RadioButton selectedRadioButton = (RadioButton) rootView.findViewById(selectedId);


        cancelButton.setOnClickListener(new View.OnClickListener() { //cancel button logic
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() { //submit button logic
            @Override
            public void onClick(View v) {
                Log.d("testing", selectedRadioButton.getText().toString());
                dismiss();
            }
        });
    return rootView;
    }
}
