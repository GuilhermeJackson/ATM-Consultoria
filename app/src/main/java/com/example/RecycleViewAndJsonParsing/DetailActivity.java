package com.example.RecycleViewAndJsonParsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.atmempresadeconsultoria.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Pegando as informações das chaves passado pela putExtra na class "MainJsonParsing"
        Intent intent = getIntent();
        String imageURL = intent.getStringExtra("imageUrl");
        String creatorName = intent.getStringExtra("creatorName");
        int likesCount = intent.getIntExtra("likesCount",0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreatorName = findViewById(R.id.txtCreatorNameDetail);
        TextView textViewLikes = findViewById(R.id.txtLikesDetail);

        //imprimindo conteudo na tela
        Picasso.with(this).load(imageURL).fit().centerInside().into(imageView);
        textViewCreatorName.setText(creatorName);
        textViewLikes.setText("Likes: "+likesCount);
    }
}
