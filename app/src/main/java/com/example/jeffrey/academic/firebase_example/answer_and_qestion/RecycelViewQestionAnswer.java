package com.example.jeffrey.academic.firebase_example.answer_and_qestion;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class RecycelViewQestionAnswer extends RecyclerView.Adapter<RecycelViewQestionAnswer.ViewHolder> {

    private ArrayList<AnswerQestionClass>answerQestionClasses;



    public RecycelViewQestionAnswer(ArrayList<AnswerQestionClass>answerQestionClasses){
      this.answerQestionClasses=answerQestionClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycelview_answer_qestion,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.answer.setText(answerQestionClasses.get(position).getAnswer());
        holder.qestion.setText(answerQestionClasses.get(position).getQestion());
        if(!answerQestionClasses.get(position).isAnswered())
        holder.cardView.setCardBackgroundColor(Color.GRAY);
    }

    @Override
    public int getItemCount() {
        return answerQestionClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        CardView cardView;
         TextView answer,qestion;



        public ViewHolder(View itemView) {
            super(itemView);
                cardView=itemView.findViewById(R.id.recycel_view_card_view);
                answer=itemView.findViewById(R.id.answer_to_show_recycelview);
                qestion=itemView.findViewById(R.id.qestion_to_show_recycelview);





        }
    }


}
