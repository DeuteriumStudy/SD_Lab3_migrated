package com.example.sd_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sd_lab3.database.AppDatabase;
import com.example.sd_lab3.database.StudentDao;
import com.example.sd_lab3.models.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button showStudents;
    Button newPost;
    Button makeIvanov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = App.getInstance().getDatabase();
        final StudentDao studentDao = db.studentDao();

        studentDao.deleteAll();
        fillStudents(studentDao);

        showStudents = findViewById(R.id.button);
        showStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });


        newPost = findViewById(R.id.button2);
        newPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAnotherStudent(studentDao);
            }
        });

        makeIvanov = findViewById(R.id.button3);
        makeIvanov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = studentDao.selectLast();
                student.fullName = "Ivanov Ivan Ivanovich";
                studentDao.update(student);

            }
        });
    }

    void fillStudents(StudentDao studentDao) {

        for(int i = 0; i < 5; i++){
            Student student = new Student();
            student.fullName = i + 1 + "Name";
            student.date = new Date();
            studentDao.insert(student);
        }

    }

    void addAnotherStudent(StudentDao studentDao) {
        Student student = new Student();
        student.date = new Date();
        student.fullName = "Petrov Petr Petrovich";
        studentDao.insert(student);
    }
}
