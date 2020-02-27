package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListViewAct extends AppCompatActivity {

    ListView listViewPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listViewPaises = findViewById(R.id.listView);

        JSONObject json = null;
        JSONArray paisesJsonArray = null;
        final ArrayList<Pais> listaPaises = new ArrayList<Pais>();
        ArrayList<String> listaNombrePaises = new ArrayList<String>();
        Pais p = null;

        try{
            json = new JSONObject(loadJSONFromAsset());
            paisesJsonArray = json.getJSONArray("paises");

            for(int i=0; i<paisesJsonArray.length(); i++)
            {
                p = new Pais();
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                p.setNombre(jsonObject.getString("nombre_pais"));
                p.setNombre_int(jsonObject.getString("nombre_pais_int"));
                p.setCapital(jsonObject.getString("capital"));
                p.setSigla(jsonObject.getString("sigla"));
                listaNombrePaises.add(p.getNombre());
                listaPaises.add(p);
            }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombrePaises);
        listViewPaises.setAdapter(adapter);

        listViewPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListViewAct.this, PaisActivity.class);
                Pais p = listaPaises.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("nombre", p.getNombre());
                bundle.putString("nombre_int", p.getNombre_int());
                bundle.putString("capital", p.getCapital());
                bundle.putString("sigla", p.getSigla());

                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });
    }

    public String loadJSONFromAsset(){
        String json = null;
        try{
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
