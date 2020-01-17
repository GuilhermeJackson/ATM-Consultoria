package com.example.RecycleViewAndJsonParsing;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atmempresadeconsultoria.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//1 - Criar class ExampleViewHolder extends RecyclerView.ViewHolder e declarar o RecycleViewAdapter como <ExampleAdapter.ExampleViewHolder>

//6 - Criar os metodos  onCreateViewHolder / onBindViewHolder / getItemCount
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    //4 - Instancia o que vai ser usado no RecycleView.Adapter. Context e ArrayList do tipo do cardView
    private Context mContext;
    private ArrayList<ExampleIten> mExampleItem;

    //5 - Criando o construtor
    public ExampleAdapter(Context context, ArrayList<ExampleIten> ExampleItem) {
        mContext = context;
        mExampleItem = ExampleItem;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //7 - Definindo onde vai ser inflado a lista com cardView
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(view);     //retorna a class onde está sendo encontrado elementos do layout (findViewById)
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        //8 - Instancia o arrayList<ExampleItem> na posicao e passa as informações do objeito ExampleItem para as varivaies
        ExampleIten currentItem = mExampleItem.get(position);
        //passa as informações do objeito ExampleItem para as varivaies
        String imageURL = currentItem.getmImageURL();
        String creatorName = currentItem.getmCreator();
        int likesCount = currentItem.getmLikes();

        //9 - Passa as informações para os elementos da activity
        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: " + likesCount);
        Picasso.with(mContext).load(imageURL).fit().centerInside().into(holder.mImageView);
    }

    @Override   //Retorna o tamanho do arrayList (só pra saber tamanho mesmo, mais nada)
    public int getItemCount() {
        return mExampleItem.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        //2 - Aqui é intanciado as informações do layout do cardView
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            //3 - Aqui é usando o findViewById para encontrar no layout
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);

        }
    }
}
