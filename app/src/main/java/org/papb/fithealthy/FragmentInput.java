package org.papb.fithealthy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kvnch on 12-Dec-17.
 */

public class FragmentInput extends Fragment implements View.OnClickListener {
    private View view;
    private EditText etTinggi;
    private EditText etBerat;
    private RadioGroup rgGender;
    private Button btHitung;
    int indeks = 0;
    int tinggi,berat,umur;
    String time, gender;
    private RadioButton selectedRadio;
    private EditText etUmur;
    private ArrayList<BMR> bmr;
    private InterfaceParents parent;

    public void setParent(InterfaceParents parent) {
        this.parent = parent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = (View)inflater.inflate(R.layout.fragment_input, container, false);
        this.etTinggi = (EditText)this.view.findViewById(R.id.etTinggi);
        this.etBerat = (EditText)this.view.findViewById(R.id.etBerat);
        this.etUmur = (EditText)this.view.findViewById(R.id.etUmur);
        this.rgGender = (RadioGroup)this.view.findViewById(R.id.rgGender);
        this.btHitung = (Button)this.view.findViewById(R.id.btHitung);
        btHitung.setOnClickListener(this);
        return this.view;
    }

    public void resetEditText(){
        this.etTinggi.setText(null);
        this.etBerat.setText(null);
        this.etUmur.setText(null);
    }

    @Override
    public void onClick(View v) {
        if(etTinggi.getText().toString().equals(null)
                ||etBerat.getText().equals(null)
                ||etUmur.getText().equals(null)
                || rgGender.getCheckedRadioButtonId()==-1){
            Toast.makeText(getContext(), "Please input Tinggi, Badan, Umur, Jens Kelamin", Toast.LENGTH_SHORT).show();
        } else {
            tinggi = Integer.parseInt(etTinggi.getText().toString());
            berat = Integer.parseInt(etBerat.getText().toString());
            umur = Integer.parseInt(etUmur.getText().toString());
            int selectId = rgGender.getCheckedRadioButtonId();
            selectedRadio = (RadioButton)this.view.findViewById(selectId);
            gender = selectedRadio.getText().toString();
            time = DateFormat.getDateTimeInstance().format(new Date());
            this.parent.kirimData(time, indeks, tinggi, berat, gender, umur);
            indeks++;
            resetEditText();
        }
    }



}
