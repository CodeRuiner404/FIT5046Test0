package com.example.fit5046test0.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity(tableName = "pain_record")
public class PainRecord {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="record_id")
    private int recordID;
    //pde
    @ColumnInfo(name="pain_level")
    @NotNull
    private int painIntensityLevel;
    @ColumnInfo(name="pain_location")
    @NotNull
    private String painLocation;
    @ColumnInfo(name="mood_level")
    @NotNull
    private int moodLevel;
    @NotNull
    private int steps;
    @NotNull
    private Date date;

    //weather
    private double temperature;
    private double humidity;
    private double pressure;

    //user
    @ColumnInfo(name="user_email")
    private String userEmail;

    public PainRecord( @NotNull int painIntensityLevel, @NotNull String painLocation, @NotNull int moodLevel, @NotNull int steps, @NotNull Date date,  @NotNull String userEmail) {
        this.painIntensityLevel = painIntensityLevel;
        this.painLocation = painLocation;
        this.moodLevel = moodLevel;
        this.steps = steps;
        this.date = date;
        this.userEmail = userEmail;
    }
}
