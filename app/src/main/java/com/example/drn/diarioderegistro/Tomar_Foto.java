package com.example.drn.diarioderegistro;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class Tomar_Foto extends AppCompatActivity {
    static final  int REQUEST_CAPTURAR_IMAGEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar__foto);
        Button btnCalendario = (Button) findViewById(R.id.btnVerRegistros);
        Button btnFoto = (Button) findViewById(R.id.btnFoto);
        btnFoto.setOnClickListener(new btnTakeFotoClick());
        TextView tvuName = (TextView)findViewById(R.id.tvUname);
        tvuName.setText(variablesGlobales.username);

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inCalendario = new Intent(v.getContext(), VerCalendario.class);
                startActivityForResult(inCalendario, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent inFinal = new Intent(this, show_upload.class);
        if (resultCode == RESULT_OK){
            if(requestCode == REQUEST_CAPTURAR_IMAGEN){
                startActivity(inFinal);
            }
        }
    }


    class btnTakeFotoClick implements  Button.OnClickListener{

        @Override
        public void onClick(View view){
            Intent intent = new Intent((MediaStore.ACTION_IMAGE_CAPTURE));

            File picDir = Environment.getExternalStoragePublicDirectory(variablesGlobales.appFolderName);
            Fotos g = new Fotos();
            String nombreFoto = g.nombrarFoto();
            File archivoImagen = new File(picDir,nombreFoto);
            Uri uriImagen = Uri.fromFile(archivoImagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriImagen);
            startActivityForResult(intent, REQUEST_CAPTURAR_IMAGEN );
        }

    }




   /* public String crearImagenDesdeBitmap(Bitmap bitmap){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String nomArchivo = sdf.format(calendar.getTime());
        try{
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,bytes);
            FileOutputStream fo = openFileOutput(nomArchivo, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            fo.close();
        }
        catch (Exception e){
            e.printStackTrace();
            nomArchivo = null;
        }
        return nomArchivo;
    }*/

    /*   btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(abrirCamara.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(abrirCamara, capturar_imagen);
                    v.buildDrawingCache();
                    Bitmap bmap = v.getDrawingCache();
                    Guardar_foto gFoto = new Guardar_foto();
                    gFoto.GuardarImagen(context, bmap);
                }
            }
        });
    }*/


}
