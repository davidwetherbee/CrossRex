package com.dwetherbee.crossrex.daogen;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class Main {

        private static Schema schema;


    // Entities
    private static Entity user;
    private static Entity goal;
    private static Entity exercise;
    private static Entity exerciseWorkout;
    private static Entity workout;
    private static Entity userWorkout;
    private static Entity exerciseResult;
    private static Entity workoutSchedule;


    public static void main(String[] args) throws Exception {
        schema = new Schema(1, "com.dwetherbee.crossrexapp.database");
        schema.enableKeepSectionsByDefault();

        user = schema.addEntity("User");
        user.addIdProperty();
        goal = schema.addEntity("Goal");
        goal.addIdProperty();
        exercise = schema.addEntity("Exercise");
        exercise.addIdProperty();
        exerciseWorkout = schema.addEntity("ExerciseWorkout");
        exerciseWorkout.addIdProperty();
        workout = schema.addEntity("Workout");
        workout.addIdProperty();
        userWorkout = schema.addEntity("UserWorkout");
        userWorkout.addIdProperty();
        exerciseResult = schema.addEntity("ExerciseResult");
        exerciseResult.addIdProperty();
        workoutSchedule = schema.addEntity("WorkoutSchedule");
        workoutSchedule.addIdProperty();

        addUser();
        addExercise();
        addExerciseWorkout();
        addExerciseResult();
        addGoal();
        addWorkout();
        addWorkoutSchedule();
        addUserWorkout();

        new DaoGenerator().generateAll(schema, "C:\\Users\\Flavadave\\IdeaProjects\\CrossRex\\CrossRexApp\\src\\main\\java");
    }

    private static void addUser() {

        user.addStringProperty("fName");
        user.addStringProperty("lName");
        user.addIntProperty("weight");
        user.addIntProperty("height");
        user.addIntProperty("bodyFat");
        user.addIntProperty("type");


    }
    private static void addGoal(){

        goal.addDateProperty("startTime");
        goal.addDateProperty("completeTime");
        goal.addDateProperty("endTime");

        // User to Goal Relationship
        Property userId = goal.addLongProperty("userId").getProperty();
        user.addToMany(goal, userId).setName("goals");
        goal.addToOne(user, userId).setName("user");

        // exerciseWorkout to goal relationship
        Property goalId = goal.addLongProperty("goalId").getProperty();
        exerciseWorkout.addToMany(goal, goalId).setName("goals");
        goal.addToOne(exerciseWorkout, goalId).setName("exercise");
    }

    private static void addExercise(){

        exercise.addStringProperty("name");
        exercise.addIntProperty("type");
        exercise.addStringProperty("description");


    }
    private static void addExerciseWorkout(){

        exerciseWorkout.addIntProperty("amount");
        exerciseWorkout.addIntProperty("duration");
        exerciseWorkout.addIntProperty("weight");
        exerciseWorkout.addIntProperty("sets");
        exerciseWorkout.addIntProperty("difficulty");

        // exerciseWorkout to exercise relationship
        Property exerciseId = exerciseWorkout.addLongProperty("exerciseExerciseWorkoutId").getProperty();
        exerciseWorkout.addToOne(exercise, exerciseId).setName("exercise");
        exercise.addToMany(exerciseWorkout, exerciseId).setName("exerciseWorkouts");

        // exerciseWorkout to workout relationship
        Property workoutId = exerciseWorkout.addLongProperty("workoutExerciseWorkoutId").getProperty();
        exerciseWorkout.addToOne(workout, workoutId).setName("workout");
        workout.addToMany(exerciseWorkout, workoutId).setName("exercises");

    }
    private static void addWorkout(){

        workout.addStringProperty("name");
        workout.addStringProperty("description");
        workout.addIntProperty("type");





    }
    private static void addUserWorkout(){

        userWorkout.addDateProperty("date");
        userWorkout.addStringProperty("notes");
        userWorkout.addIntProperty("intensity");
        userWorkout.addIntProperty("caloriesBurned");
        userWorkout.addIntProperty("percentComplete");

        // workout to userWorkout relationship
        Property workoutId = userWorkout.addLongProperty("workoutId").getProperty();
        workout.addToMany(userWorkout, workoutId).setName("userWorkouts");
        userWorkout.addToOne(workout, workoutId).setName("workout");

        // User to userWorkout
        Property userId = userWorkout.addLongProperty("userId").getProperty();
        user.addToMany(userWorkout, userId).setName("workouts");
        userWorkout.addToOne(user, userId).setName("user");

        // workoutSchedule to userWorkout
        Property userWorkoutId = userWorkout.addLongProperty("userWorkoutId").getProperty();
        workoutSchedule.addToMany(userWorkout, userWorkoutId).setName("userWorkouts");
        userWorkout.addToOne(workoutSchedule, userWorkoutId).setName("scheduledWorkout");


    }
    private static void addExerciseResult(){

        exerciseResult.addIntProperty("amount");
        // exerciseResult to userWorkout
        Property exerciseWorkoutUserId = exerciseResult.addLongProperty("exerciseResultId").getProperty();
        exerciseResult.addToOne(userWorkout, exerciseWorkoutUserId).setName("userWorkout");
        userWorkout.addToMany(exerciseResult, exerciseWorkoutUserId).setName("exerciseResults");



        // exerciseWorkout to exerciseResult
        Property exerciseWorkoutId = exerciseResult.addLongProperty("exerciseWorkoutId").getProperty();
        exerciseWorkout.addToMany(exerciseResult, exerciseWorkoutId).setName("exerciseResult");
        exerciseResult.addToOne(exerciseWorkout, exerciseWorkoutId).setName("exercise");
    }
    private static void addWorkoutSchedule(){

        workoutSchedule.addStringProperty("location");
        workoutSchedule.addDateProperty("date");

        // User to workoutSchedule
        Property workoutScheduleId = workoutSchedule.addLongProperty("userId").getProperty();
        user.addToMany(workoutSchedule, workoutScheduleId).setName("schedules");
        workoutSchedule.addToOne(user, workoutScheduleId).setName("user");



        // workoutSchedule to workout
        Property workoutId = workoutSchedule.addLongProperty("workoutId").getProperty();
        workout.addToMany(workoutSchedule, workoutId).setName("schedules");
        workoutSchedule.addToOne(workout, workoutId).setName("workout");

    }
    }

