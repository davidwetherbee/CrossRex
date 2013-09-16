package com.dwetherbee.crossrexapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.dwetherbee.crossrexapp.CrossRexApplication;
import com.dwetherbee.crossrexapp.R;
import com.dwetherbee.crossrexapp.database.*;

import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WorkoutDao workoutDao = CrossRexApplication.getDaoSession().getWorkoutDao();


        List<Workout> workouts = workoutDao.loadAll();
        for (Workout workout : workouts){
            Log.i("MyActivity", "name = " + workout.getName());
            for (ExerciseWorkout exerciseWorkout : workout.getExercises()){
                Log.i("MyActivity", "Exercise: " + exerciseWorkout.getExercise().getName());
            }
            for (WorkoutSchedule workoutSchedule : workout.getSchedules()){
                Log.i("MyActivity", "Workout Location: " + workoutSchedule.getLocation());
                Log.i("MyActivity", "Workout Date: " + workoutSchedule.getDate());

            }
        }





    }
}
