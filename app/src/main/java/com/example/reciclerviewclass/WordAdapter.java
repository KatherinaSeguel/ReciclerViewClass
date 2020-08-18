package com.example.reciclerviewclass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reciclerviewclass.databinding.WordItemLayoutBinding;

import java.util.List;
//Aquí abajo marca error y se tienen que implementar los 3 métodos, los genera
public class WordAdapter  extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<String> wordList;
    //variable que represente a la interface
    private PassEleentSelected mListener;


//Generé este constructor para que me pida el listado de palabras
    public WordAdapter(List<String> wordList, PassEleentSelected mElementSelected) {
        this.wordList = wordList;
        this.mListener=mElementSelected;

    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WordItemLayoutBinding mBinding = WordItemLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new WordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String word= wordList.get(position);
        holder.textView.setText(word);

    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }


    //Clase que vive dentro del ADAPTER

    public class WordViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {

        //SI PASARAMOS UNA IMAGEN SE TIENE QUE DECLARAR AQUI
        private TextView textView;

        public WordViewHolder(@NonNull WordItemLayoutBinding mBinding) {
            super(mBinding.getRoot());
            textView=mBinding.wordTv;
           itemView.setOnClickListener(this);
        }
//metodo implementado después del error al agregar implements
        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            String element = wordList.get(position);
            mListener.passElement(element);

        }
    }


    //Se genera una interfaz pa mostrar la palabra que presiono
    public interface  PassEleentSelected{

        void  passElement(String word);
    }

}
