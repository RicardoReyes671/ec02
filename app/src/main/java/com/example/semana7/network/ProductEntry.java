package com.example.semana7.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.example.semana7.R;

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

public class ProductEntry {
    private static final String TAG = ProductEntry.class.getSimpleName();

    public final Integer idProducto;
    public final String descripcion;
    public final Double precio;
    public final Integer stock;
    public final Integer idCategoria;
    public final Integer idMarca;
    public final Uri dynamicUrl;
    public final String url;

    public ProductEntry(Integer idProducto, String descripcion, Double precio, Integer stock, Integer idCategoria, Integer idMarca, String dynamicUrl, String url) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
    }

    public static List<ProductEntry> initProductEntryList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.producto);
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
        String jsonProductString = writer.toString();
        Gson gson = new Gson();
        Type productListType = new TypeToken< ArrayList<ProductEntry> >(){
        }.getType();
        return gson.fromJson(jsonProductString,productListType);
    }
}
