package co.macrosystem.formulariodecontacto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mDateDisplay;
    private int mYear;
    private int mMonth;
    private int mDay;
    static final int DATE_DIALOG_ID = 0;
    private Button btnSiguiente;
    private Intent intent;
    private String nombre, fechaNac, telefono, mail, descripcion;
    TextView txtNombre, txtFechaNac, txtTelefono, txtEmail, txtDescripcion;

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        txtNombre = (TextView) findViewById(R.id.txtNombreContacto);
        txtFechaNac = (TextView) findViewById(R.id.dateDisplay);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescripcion = (TextView) findViewById(R.id.txtDescContacto);

        intent = new Intent(this, EdicionDatosActivity.class);

        mDateDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });


        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        // display the current date (this method is below)
        updateDisplay();

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = txtNombre.getText().toString();
                fechaNac = txtFechaNac.getText().toString();
                telefono = txtTelefono.getText().toString();
                mail = txtEmail.getText().toString();
                descripcion = txtDescripcion.getText().toString();
                intent.putExtra("NOMBRE", nombre);
                intent.putExtra("NACIMIENTO", fechaNac);
                intent.putExtra("TELEFONO", telefono);
                intent.putExtra("EMAIL", mail);
                intent.putExtra("DESCRIPCION", descripcion);
                startActivity(intent);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        mYear, mMonth, mDay);
        }
        return null;
    }


    private void updateDisplay() {
        mDateDisplay.setText(
                new StringBuilder()
                        .append(mDay).append("/")
                        .append(mMonth + 1).append("/")
                        .append(mYear).append(" "));
    }

}
