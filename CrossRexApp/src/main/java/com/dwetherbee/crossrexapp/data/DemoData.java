package com.dwetherbee.crossrexapp.data;

import com.dwetherbee.crossrexapp.CrossRexApplication;
import com.dwetherbee.crossrexapp.database.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Flavadave
 * Date: 8/17/13
 * Time: 10:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class DemoData {

    public static void create(){

        boolean isCreated = Preferences.getBoolean(Preferences.KEY_DEMO_DATA, false);

        if (isCreated){
            return;
        }

        Preferences.saveBoolean(Preferences.KEY_DEMO_DATA, true);

        ExerciseDao exerciseDao = CrossRexApplication.getDaoSession().getExerciseDao();
        WorkoutDao workoutDao = CrossRexApplication.getDaoSession().getWorkoutDao();
        ExerciseWorkoutDao exerciseWorkoutDao = CrossRexApplication.getDaoSession().getExerciseWorkoutDao();
        UserDao userDao = CrossRexApplication.getDaoSession().getUserDao();
        WorkoutScheduleDao workoutScheduleDao = CrossRexApplication.getDaoSession().getWorkoutScheduleDao();

        User userAdmin = new User();
        userAdmin.setFName("Lance");
        userAdmin.setLName("Einerson");
        userAdmin.setHeight(66);
        userAdmin.setWeight(175);
        userAdmin.setBodyFat(15);
        userAdmin.setType(User.TYPE_INSTRUCTOR);
        userDao.insert(userAdmin);




        Workout workout1 = new Workout();
        workout1.setName("The Big Cheese");
        workout1.setDescription("Do these 3 exercises");
        workout1.setType( Workout.TYPE_CUSTOM);
        workoutDao.insert(workout1);


        Workout workout2 = new Workout();
        workout2.setName("The Big Kahuna");
        workout2.setDescription("Do these 3 exercises");
        workout2.setType( Workout.TYPE_CUSTOM);
        workoutDao.insert(workout2);

        Workout workout3 = new Workout();
        workout3.setName("The Big Noggin");
        workout3.setDescription("Do these 3 exercises");
        workout3.setType( Workout.TYPE_CUSTOM);
        workoutDao.insert(workout3);

        Exercise exercise1 = new Exercise();
        exercise1.setName("Bench Press");
        exercise1.setType(Exercise.TYPE_WEIGHT);
        exercise1.setDescription("Get on your back and push the bar away from your chest hairs.");
        exerciseDao.insert(exercise1);

        ExerciseWorkout exerciseWorkout1 = new ExerciseWorkout();
        exerciseWorkout1.setExercise(exercise1);
        exerciseWorkout1.setAmount(10);
        exerciseWorkout1.setSets(1);
        exerciseWorkout1.setWeight(1000);
        exerciseWorkout1.setDifficulty(ExerciseWorkout.DIFFICULTY_INSANE);
        exerciseWorkout1.setWorkout(workout1);
        exerciseWorkoutDao.insert(exerciseWorkout1);


        Exercise exercise2 = new Exercise();
        exercise2.setName("Snatch");
        exercise2.setType(Exercise.TYPE_WEIGHT);
        exercise2.setDescription("Snatch that!");
        exerciseDao.insert(exercise2);

        ExerciseWorkout exerciseWorkout2 = new ExerciseWorkout();
        exerciseWorkout2.setExercise(exercise2);
        exerciseWorkout2.setAmount(5);
        exerciseWorkout2.setSets(1);
        exerciseWorkout2.setWeight(500);
        exerciseWorkout2.setDifficulty(ExerciseWorkout.DIFFICULTY_INSANE);
        exerciseWorkout2.setWorkout(workout1);
        exerciseWorkoutDao.insert(exerciseWorkout2);

        Exercise exercise3 = new Exercise();
        exercise3.setName("Clean and Jerk");
        exercise3.setType(Exercise.TYPE_WEIGHT);
        exercise3.setDescription("First clean, then Jerk");
        exerciseDao.insert(exercise3);

        ExerciseWorkout exerciseWorkout3 = new ExerciseWorkout();
        exerciseWorkout3.setExercise(exercise3);
        exerciseWorkout3.setAmount(5);
        exerciseWorkout3.setSets(1);
        exerciseWorkout3.setWeight(250);
        exerciseWorkout3.setDifficulty(ExerciseWorkout.DIFFICULTY_INSANE);
        exerciseWorkout3.setWorkout(workout1);
        exerciseWorkoutDao.insert(exerciseWorkout3);

        Exercise exercise4 = new Exercise();
        exercise4.setName("Back Squat");
        exercise4.setType(Exercise.TYPE_WEIGHT);
        exercise4.setDescription("Use your back to squat");
        exerciseDao.insert(exercise4);

        ExerciseWorkout exerciseWorkout4 = new ExerciseWorkout();
        exerciseWorkout4.setExercise(exercise4);
        exerciseWorkout4.setAmount(5);
        exerciseWorkout4.setSets(1);
        exerciseWorkout4.setWeight(300);
        exerciseWorkout4.setDifficulty(ExerciseWorkout.DIFFICULTY_HARD);
        exerciseWorkout4.setWorkout(workout2);
        exerciseWorkoutDao.insert(exerciseWorkout4);

        Exercise exercise5 = new Exercise();
        exercise5.setName("Front Squat");
        exercise5.setType(Exercise.TYPE_WEIGHT);
        exercise5.setDescription("Use your front to squat");
        exerciseDao.insert(exercise5);

        ExerciseWorkout exerciseWorkout5 = new ExerciseWorkout();
        exerciseWorkout5.setExercise(exercise5);
        exerciseWorkout5.setAmount(5);
        exerciseWorkout5.setSets(1);
        exerciseWorkout5.setWeight(300);
        exerciseWorkout5.setDifficulty(ExerciseWorkout.DIFFICULTY_HARD);
        exerciseWorkout5.setWorkout(workout2);
        exerciseWorkoutDao.insert(exerciseWorkout5);

        Exercise exercise6 = new Exercise();
        exercise6.setName("Dead Lift");
        exercise6.setType(Exercise.TYPE_WEIGHT);
        exercise6.setDescription("The dead are rising!!");
        exerciseDao.insert(exercise6);

        ExerciseWorkout exerciseWorkout6 = new ExerciseWorkout();
        exerciseWorkout6.setExercise(exercise6);
        exerciseWorkout6.setAmount(5);
        exerciseWorkout6.setSets(1);
        exerciseWorkout6.setWeight(50);
        exerciseWorkout6.setDifficulty(ExerciseWorkout.DIFFICULTY_EASY);
        exerciseWorkout6.setWorkout(workout2);
        exerciseWorkoutDao.insert(exerciseWorkout6);

        Exercise exercise7 = new Exercise();
        exercise7.setName("10K");
        exercise7.setType(Exercise.TYPE_TIME);
        exercise7.setDescription("Run, Forest, Run!");
        exerciseDao.insert(exercise7);

        ExerciseWorkout exerciseWorkout7 = new ExerciseWorkout();
        exerciseWorkout7.setExercise(exercise7);
        exerciseWorkout7.setAmount(1);
        exerciseWorkout7.setDifficulty(ExerciseWorkout.DIFFICULTY_MEDIUM);
        exerciseWorkout7.setWorkout(workout3);
        exerciseWorkoutDao.insert(exerciseWorkout7);

        Exercise exercise8 = new Exercise();
        exercise8.setName("5k");
        exercise8.setType(Exercise.TYPE_TIME);
        exercise8.setDescription("Approximately 5 - 1k runs in succession.");
        exerciseDao.insert(exercise8);

        ExerciseWorkout exerciseWorkout8 = new ExerciseWorkout();
        exerciseWorkout8.setExercise(exercise8);
        exerciseWorkout8.setAmount(1);
        exerciseWorkout8.setDifficulty(ExerciseWorkout.DIFFICULTY_MEDIUM);
        exerciseWorkout8.setWorkout(workout3);
        exerciseWorkoutDao.insert(exerciseWorkout8);

        Exercise exercise9 = new Exercise();
        exercise9.setName("Pull Up");
        exercise9.setType(Exercise.TYPE_WEIGHT);
        exercise9.setDescription("Pull yourself up");
        exerciseDao.insert(exercise9);

        ExerciseWorkout exerciseWorkout9 = new ExerciseWorkout();
        exerciseWorkout9.setExercise(exercise9);
        exerciseWorkout9.setAmount(10);
        exerciseWorkout9.setSets(2);
        exerciseWorkout9.setDifficulty(ExerciseWorkout.DIFFICULTY_EASY);
        exerciseWorkout9.setWorkout(workout3);
        exerciseWorkoutDao.insert(exerciseWorkout9);

        WorkoutSchedule workoutSchedule = new WorkoutSchedule();
        Date date1 = new Date();
        Calendar calendar = Calendar.getInstance();

        for (int i= 0; i < 5; i++){
            WorkoutSchedule schedule1 = new WorkoutSchedule();
            calendar.add(Calendar.DAY_OF_YEAR, i * 2);
            schedule1.setDate(calendar.getTime());
            schedule1.setUser(userAdmin);
            schedule1.setWorkout(workout1);
            schedule1.setLocation("CrossRex Gym ");
            workoutScheduleDao.insert(schedule1);
        }
       calendar = Calendar.getInstance();
        for (int i= 0; i < 5; i++){
            WorkoutSchedule schedule2 = new WorkoutSchedule();
            calendar.add(Calendar.DAY_OF_YEAR, i * 3);
            schedule2.setDate(calendar.getTime());
            schedule2.setUser(userAdmin);
            schedule2.setWorkout(workout2);
            schedule2.setLocation("CrossRex Gym ");
            workoutScheduleDao.insert(schedule2);
        }
        calendar = Calendar.getInstance();
        for (int i= 0; i < 5; i++){
            WorkoutSchedule schedule3 = new WorkoutSchedule();
            calendar.add(Calendar.DAY_OF_YEAR, i * 3);
            schedule3.setDate(calendar.getTime());
            schedule3.setUser(userAdmin);
            schedule3.setWorkout(workout3);
            schedule3.setLocation("CrossRex Gym ");
            workoutScheduleDao.insert(schedule3);

        }
    }
}
