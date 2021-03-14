package com.example.mydrinkingpal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.widget.Toast;

public class GuestFragment extends AppCompatDialogFragment {

    private EditText editAge;
    private EditText editWeight;
    private EditText editHeight;

    private DialogListener dialogListener;
    RadioGroup genderButtons;
    Boolean gender;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.guest_fragment, null);

        // Reference to EditText Course title and Course code
        editWeight = view.findViewById(R.id.editWeightId);
        editHeight = view.findViewById(R.id.editHeightId);
        editAge = view.findViewById(R.id.editAgeId);
        genderButtons = view.findViewById(R.id.genderId);

        builder.setView(view)
                .setTitle("Create Guest Profile")
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Save info to database
                        int age = Integer.parseInt(editAge.getText().toString());
                        int height = Integer.parseInt(editHeight.getText().toString());
                        int weight = Integer.parseInt(editWeight.getText().toString());

                        int checkedGender = genderButtons.getCheckedRadioButtonId();

                        // Checking if user inputs are valid

                        if (checkedGender == -1){

                        }
                        else {
                            findGenderPicked(checkedGender);
                        }
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //  Cancel
                    }
                });
        return builder.create();
    }

    private void findGenderPicked(int checkedGender) {
        switch (checkedGender){
            case (R.id.maleId):
                gender = true;
                break;
            case (R.id.femaleId):
                gender = false;
                break;
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            dialogListener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Must implement ExampleDialogListener");
        }
    }
    public interface DialogListener {
        // create guest profile
    }


}
