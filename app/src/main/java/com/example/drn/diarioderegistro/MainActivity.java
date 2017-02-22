package com.example.drn.diarioderegistro;

import android.content.Intent;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testDB();
        String fn = variablesGlobales.appFolderName;
        File folder = new File(Environment.getExternalStorageDirectory() + "/"+ fn);

        boolean folderCreado = true;
        if(!folder.exists()){
            folderCreado = folder.mkdir();
            Toast.makeText(MainActivity.this, "Carpeta '"+ fn.toString()+"' creada",LENGTH_LONG).show();
        }
        if (folderCreado){}else{}

        Button btn = (Button) findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryLogin(v);
            }
        });
    }

    public void tryLogin(View v) {
        EditText txtschool = (EditText) findViewById(R.id.txtEscuela);
        EditText txtuser = (EditText) findViewById(R.id.txtUser);
        EditText txtpass = (EditText) findViewById(R.id.txtPass);
        String usuario = txtuser.getText().toString();
        String password = txtpass.getText().toString();
        String errorLogin = "Usuario o contraseña Incorrectos";

        try {
            Class.forName(variablesGlobales.driver);
            Connection con = DriverManager.getConnection(variablesGlobales.url, variablesGlobales.user, variablesGlobales.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tblusuarios where BINARY `Usuario` = '"+ usuario + "'and BINARY Password = '"+ password+"'");
            ResultSetMetaData rsmd = rs.getMetaData();
            Intent intent;
            if(rs.next()){
                variablesGlobales.username = rs.getString(2)+ " "+ rs.getString(3);
                intent = new Intent(v.getContext(), Tomar_Foto.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),errorLogin, LENGTH_LONG).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            TextView tv = (TextView)findViewById(R.id.tvTest);
            tv.setText(e.toString());
        } catch (SQLException e) {
            TextView tv = (TextView)findViewById(R.id.tvTest);
            tv.setText(e.toString());
            e.printStackTrace();
        }
    }
    public void testDB(){
        TextView tv = (TextView) findViewById(R.id.tvTest);
        try {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName(variablesGlobales.driver);
            Connection con = DriverManager.getConnection(variablesGlobales.url, variablesGlobales.user, variablesGlobales.pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tblusuarios");

            if(rs.next()){
                Toast.makeText(getApplicationContext(), variablesGlobales.txtToastconn, LENGTH_LONG).show();
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            tv.setText(e.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            tv.setText(e.toString());
        }
    }


/*
*
*
*   2295839849
*
*
*
*   */
}
