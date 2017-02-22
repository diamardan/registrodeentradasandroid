package com.example.drn.diarioderegistro;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dany on 18/02/2017.
 */

public class Fotos {
    public static String nombrarFoto(){
        SimpleDateFormat fecha = new SimpleDateFormat("HH:mm:ss");
        String timestamp = fecha.format(new Date());

        return timestamp + ".jpg";
    }
}
