package com.example.fit5046test0.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

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
    @TypeConverters({DateConverters.class})
    private Date date;

    //weather
    private double temperature;
    private double humidity;
    private double pressure;

    //user
    @ColumnInfo(name="user_email")
    private String userEmail;

    public PainRecord(@NotNull int painIntensityLevel,@NotNull String painLocation,@NotNull int moodLevel,@NotNull int steps, Date date,String userEmail) {
        this.painIntensityLevel = painIntensityLevel;
        this.painLocation = painLocation;
        this.moodLevel = moodLevel;
        this.steps = steps;
        this.date = date;
        this.userEmail = userEmail;
    }

    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getPainIntensityLevel() {
        return painIntensityLevel;
    }

    public void setPainIntensityLevel(int painIntensityLevel) {
        this.painIntensityLevel = painIntensityLevel;
    }

    @NotNull
    public String getPainLocation() {
        return painLocation;
    }

    public void setPainLocation(@NotNull String painLocation) {
        this.painLocation = painLocation;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
