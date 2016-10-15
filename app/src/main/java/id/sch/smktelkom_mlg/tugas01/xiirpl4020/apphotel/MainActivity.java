package id.sch.smktelkom_mlg.tugas01.xiirpl4020.apphotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etKtp;
    Button btHasil;
    TextView tvHasil;
    CheckBox cbEB, cbS, cbL;
    RadioButton rbM, rbBM;
    Spinner spKamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etKtp = (EditText) findViewById(R.id.editTextKTP);
        btHasil = (Button) findViewById(R.id.buttonHasil);
        tvHasil = (TextView) findViewById(R.id.textView);
        cbEB = (CheckBox) findViewById(R.id.checkBoxEB);
        cbS = (CheckBox) findViewById(R.id.checkBoxS);
        cbL = (CheckBox) findViewById(R.id.checkBoxL);
        rbM = (RadioButton) findViewById(R.id.radioButtonMember);
        rbBM = (RadioButton) findViewById(R.id.radioButtonBM);
        spKamar = (Spinner) findViewById(R.id.spinnerTipeKamar);

        findViewById(R.id.buttonHasil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String ktp = etKtp.getText().toString();

        String fasilitas = "";
        int startlen = fasilitas.length();
        if (cbEB.isChecked()) fasilitas += cbEB.getText().toString() + ", ";
        if (cbS.isChecked()) fasilitas += cbS.getText().toString() + ", ";
        if (cbL.isChecked()) fasilitas += cbL.getText().toString() + " ";

        if (fasilitas.length() == startlen) fasilitas = "Tanpa fasilitas tambahan";

        String status = null;
        String ket = "";
        if (rbM.isChecked()) {
            status = rbM.getText().toString();
        } else if (rbBM.isChecked()) {
            status = rbBM.getText().toString();
        } else {
            status = "Anda belum memilih status";
        }

        tvHasil.setText("Nama : " + nama +
                "\nNomor KTP : " + ktp +
                "\nFasilitas : " + fasilitas +
                "\nStatus : " + status +
                "\nTipe Kamar : " + spKamar.getSelectedItem().toString());
    }
}
