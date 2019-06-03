package com.example.sd_lab3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sd_lab3.database.AppDatabase;
import com.example.sd_lab3.database.StudentDao;
import com.example.sd_lab3.models.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ItemHolder> {

    private List<Student> students;

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.line, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {

        itemHolder.id.setText(Long.toString(students.get(position).id));
        itemHolder.name.setText(students.get(position).fullName);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String string = dateFormat.format(students.get(position).date);
        itemHolder.date.setText(string);

    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView name;
        private final TextView date;

        ItemHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.student_id);
            name = itemView.findViewById(R.id.fullname);
            date = itemView.findViewById(R.id.added);
        }
    }
}
