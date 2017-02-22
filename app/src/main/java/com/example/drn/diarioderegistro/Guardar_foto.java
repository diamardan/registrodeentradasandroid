package com.example.drn.diarioderegistro;

import android.content.Context;
import android.graphics.Bitmap;
//import android.icu.util.Calendar;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Dany on 12/02/2017.
 */

//@RequiresApi(api = Build.VERSION_CODES.N)
public class Guardar_foto {

   /* public String crearImagenDesdeBitmap(Bitmap bitmap){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String nomArchivo = sdf.format(calendar.getTime());
        try{
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,bytes);
            FileOutputStream fo =   openFileOutput(nomArchivo, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            fo.close();
        }
        catch (Exception e){
            e.printStackTrace();
            nomArchivo = null;
        }
        return nomArchivo;
    }
*/
}
