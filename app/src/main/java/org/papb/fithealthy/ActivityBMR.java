package org.papb.fithealthy;

/*
Ini adalah halaman BMR
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityBMR extends AppCompatActivity implements InterfaceParents {

    private FragmentManager fm;
    private FragmentInput fragmentInput;
    private FragmentOutput fragmentOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmr_view);

        this.fm = this.getSupportFragmentManager();
        this.fragmentInput = new FragmentInput();
        this.fragmentInput.setParent(this);
        this.fragmentOutput = new FragmentOutput();
        this.fm.beginTransaction()
                .add(R.id.inputBMR, this.fragmentInput, "fInput")
                .add(R.id.outputBMR, this.fragmentOutput, "fOutput")
                .commit();
    }


    @Override
    public void kirimData(String time, int indeks, int tinggi, int berat, String gender, int umur) {
        Fragment frag = this.fm.findFragmentById(R.id.outputBMR);
        if (frag instanceof FragmentOutput) {
            ((FragmentOutput) frag).terimaData(time, indeks, tinggi, berat, gender, umur);
        }
    }
}
