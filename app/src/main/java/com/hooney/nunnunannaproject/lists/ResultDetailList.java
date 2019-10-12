package com.hooney.nunnunannaproject.lists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hooney.nunnunannaproject.R;

import java.util.ArrayList;

public class ResultDetailList extends RecyclerView.Adapter<ResultDetailList.ResultDetailHolder> {
    private ArrayList<String> titles;
    private onClickViewListener listener;

    public ResultDetailList(ArrayList<String> t){
        this.titles = t;
    }

    public interface onClickViewListener{
        void onClicked(View view, String title);
    }

    public void setOnClickViewListener(onClickViewListener lis){
        this.listener = lis;
    }

    @NonNull
    @Override
    public ResultDetailList.ResultDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_view, parent, false);
        return new ResultDetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultDetailList.ResultDetailHolder holder, int position) {
        String item = this.titles.get(position);

        String year = item.substring(0, 4);
        String month = item.substring(4, 6);
        String day = item.substring(6,8);
        holder.title.setText(year+"."+month+"."+day+" 검사결과");
    }

    @Override
    public int getItemCount() {
        return this.titles.size();
    }

    public class ResultDetailHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public LinearLayout touchView;

        public ResultDetailHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_detail_title);
            touchView = itemView.findViewById(R.id.item_view);
            touchView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onClicked(touchView, titles.get(position));
                    }
                }
            });
        }
    }
}
