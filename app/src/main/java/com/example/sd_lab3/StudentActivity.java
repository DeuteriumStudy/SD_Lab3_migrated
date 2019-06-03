package com.example.sd_lab3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sd_lab3.database.AppDatabase;
import com.example.sd_lab3.database.StudentDao;
import com.example.sd_lab3.models.Student;

import java.util.List;

public class StudentActivity extends AppCompatActivity {

    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        AppDatabase db = App.getInstance().getDatabase();
        StudentDao studentDao = db.studentDao();

        students = studentDao.getAll();

        StudentAdapter studentAdapter = new StudentAdapter(students);
        recyclerView.setAdapter(studentAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
