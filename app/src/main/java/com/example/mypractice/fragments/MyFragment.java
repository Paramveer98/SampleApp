package com.example.mypractice.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypractice.R;

public class MyFragment extends Fragment {
    Button Btntoast;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.layout_fragment, container, false);
        Btntoast=(Button) v.findViewById(R.id.BtnToast);

        Btntoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "Fragment button clicked", Toast.LENGTH_SHORT).show();
                showDialog();
            }
        });

        return v;


    }

    public void showDialog()//or String msg param
    {
        final Dialog dialog=new Dialog(getActivity());//context of class
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);//dialog will not hide on touching outside the dialog box


        final TextView message=(TextView) dialog.findViewById(R.id.message);
        Button btnOk=(Button) dialog.findViewById(R.id.BtnOk);
        Button btnCancel=(Button) dialog.findViewById(R.id.BtnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                message.setText("Saved Ok");

                Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                message.setText("Discarded");
                Toast.makeText(getActivity(), "Discarded", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
//                dialog.hide();


            }
        });


    }
}
