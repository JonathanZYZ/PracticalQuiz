package com.myapplicationdev.android.practicalquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TasksAdapter extends ArrayAdapter<Tasks> {
    private ArrayList<Tasks> tasks;
    private Context context;
    private TextView tvDesc;
    private TextView tvDate;
    private TextView tvItem;
    private Button btnShare;

    public TasksAdapter(@NonNull Context context, int resource, ArrayList<Tasks> objects) {
        super(context, resource, objects);

        tasks = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row,parent, false);

        tvDesc = rowView.findViewById(R.id.tvDesc);
        tvDate = rowView.findViewById(R.id.tvDate);
        tvItem = rowView.findViewById(R.id.tvItem);
        btnShare = rowView.findViewById(R.id.btnShare);

        tvDesc.setText(tasks.get(position).getDesc());
        tvDate.setText(tasks.get(position).getDate());
        tvItem.setText(tasks.get(position).getItem());

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"andy_tao@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "A task is shared with you from 19021227");
                String desc = "";
                String date = "";
                desc = tasks.get(position).getDesc();
                date = tasks.get(position).getDate();
                String textSend = "Task "+ desc + "\nTask "+ date;
                email.putExtra(Intent.EXTRA_TEXT, textSend);
                email.setType("message/rfc822");
                context.startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });


        return rowView;

    }
}
