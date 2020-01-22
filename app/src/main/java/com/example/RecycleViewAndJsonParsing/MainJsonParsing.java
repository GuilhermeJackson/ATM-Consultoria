package com.example.RecycleViewAndJsonParsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.atmempresadeconsultoria.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainJsonParsing extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likesCount";
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleIten> mExampleList;
    private RecyclerView mRecyclerView;
    private RequestQueue mRequestQueue;
    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_json_parsing);
        mRecyclerView = findViewById(R.id.recycleViewJson);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        parseJson();
    }


    public void parseJson() {
        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

        //JsonObjectRequest pega a URL e retorna no formato Json para o response
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Pega o objeto "hits" q contem um array de objetos(com suas caracteristicas user, webformatURL e likes)
                    JSONArray jsonArray = response.getJSONArray("hits");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject hit = jsonArray.getJSONObject(i);    //Objeto Json "hit" recebe os objetos da lista (um por um)

                        //Coleta as informações das caracteristicas do objeto
                        String creatorName = hit.getString("user");
                        String imageUrl = hit.getString("webformatURL");
                        int likesCount = hit.getInt("likes");

                        //Cria objeto ExampleIten com as informações coletadas e adicionar no array de ExampleIten
                        mExampleList.add(new ExampleIten(imageUrl, creatorName, likesCount));
                    }
                    mExampleAdapter = new ExampleAdapter(MainJsonParsing.this, mExampleList);
                    mRecyclerView.setAdapter(mExampleAdapter);

                    mExampleAdapter.setOnItemClickListiner(MainJsonParsing.this);

                    mExampleAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detailItent = new Intent(this, DetailActivity.class);
        ExampleIten clikedItem = mExampleList.get(position);

        detailItent.putExtra(EXTRA_URL, clikedItem.getmImageURL());
        detailItent.putExtra(EXTRA_CREATOR, clikedItem.getmCreator());
        detailItent.putExtra(EXTRA_LIKES, clikedItem.getmLikes());

        startActivity(detailItent);
    }

}
