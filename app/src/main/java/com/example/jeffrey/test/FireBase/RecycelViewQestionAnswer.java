package com.example.jeffrey.test.FireBase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeffrey.test.R;

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
    }

    @Override
    public int getItemCount() {
        return answerQestionClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


         TextView answer,qestion;



        public ViewHolder(View itemView) {
            super(itemView);
            answer=itemView.findViewById(R.id.answer_to_show_recycelview);
            qestion=itemView.findViewById(R.id.qestion_to_show_recycelview);





        }
    }


}
