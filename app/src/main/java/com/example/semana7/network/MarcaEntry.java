package com.example.semana7.network;

import android.content.res.Resources;
import android.util.Log;

import com.example.semana7.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MarcaEntry {
    private static final String TAG = MarcaEntry.class.getSimpleName();

    public final Integer idMarca;
    public final String nombre;

    public MarcaEntry(Integer idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    public static List<MarcaEntry> initMarcaEntryList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.marca);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try{
            Reader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            int pointer;
            while((pointer = reader.read(buffer)) != -1){
                writer.write(buffer,0,pointer);
            }
        } catch (IOException e) {
            Log.e(TAG,"Error al escribir/leer el archivo JSON",e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e){
                Log.e(TAG,"Error al cerrar la conexión con el archivo",e);
            }
        }
        String jsonMarcaString = writer.toString();
        Gson gson = new Gson();
        Type marcaListType = new TypeToken<ArrayList<MarcaEntry>>(){
        }.getType();
        return gson.fromJson(jsonMarcaString,marcaListType);
    }
}
