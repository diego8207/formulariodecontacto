package co.macrosystem.formulariodecontacto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EdicionDatosActivity extends AppCompatActivity {

    private String nombre, fechaNac, telefono, mail, descripcion;
    private TextView txtNombre;
    private TextView txtFechaNac;
    private TextView txtTelefono;
    private TextView txtEmail;
    private TextView txtDescripcion;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion_datos);
        txtNombre = (TextView) findViewById(R.id.txtNombreContacto);
        txtFechaNac = (TextView) findViewById(R.id.txtFechaNac);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescripcion = (TextView) findViewById(R.id.txtDescContacto);
        btnRegresar = (Button) findViewById(R.id.btnEditar);

        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("NOMBRE");
        fechaNac = extras.getString("NACIMIENTO");
        telefono = extras.getString("TELEFONO");
        mail = extras.getString("EMAIL");
        descripcion = extras.getString("DESCRIPCION");

        txtNombre.setText(nombre);
        txtFechaNac.setText("Fecha Nacimiento: "+fechaNac);
        txtEmail.setText("Email: " + mail);
        txtTelefono.setText("Tel. " + telefono);
        txtDescripcion.setText("Descripcion: " + descripcion);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



}
