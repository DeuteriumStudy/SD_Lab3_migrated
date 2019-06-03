package com.example.sd_lab3.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.sd_lab3.database.DateConverter;

import java.util.Date;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String fullName;

    public String lastname;

    public String patronymic;

    @TypeConverters({DateConverter.class})
    public Date date;
}
