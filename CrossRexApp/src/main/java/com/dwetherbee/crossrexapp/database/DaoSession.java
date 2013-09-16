package com.dwetherbee.crossrexapp.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.dwetherbee.crossrexapp.database.User;
import com.dwetherbee.crossrexapp.database.Goal;
import com.dwetherbee.crossrexapp.database.Exercise;
import com.dwetherbee.crossrexapp.database.ExerciseWorkout;
import com.dwetherbee.crossrexapp.database.Workout;
import com.dwetherbee.crossrexapp.database.UserWorkout;
import com.dwetherbee.crossrexapp.database.ExerciseResult;
import com.dwetherbee.crossrexapp.database.WorkoutSchedule;

import com.dwetherbee.crossrexapp.database.UserDao;
import com.dwetherbee.crossrexapp.database.GoalDao;
import com.dwetherbee.crossrexapp.database.ExerciseDao;
import com.dwetherbee.crossrexapp.database.ExerciseWorkoutDao;
import com.dwetherbee.crossrexapp.database.WorkoutDao;
import com.dwetherbee.crossrexapp.database.UserWorkoutDao;
import com.dwetherbee.crossrexapp.database.ExerciseResultDao;
import com.dwetherbee.crossrexapp.database.WorkoutScheduleDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig goalDaoConfig;
    private final DaoConfig exerciseDaoConfig;
    private final DaoConfig exerciseWorkoutDaoConfig;
    private final DaoConfig workoutDaoConfig;
    private final DaoConfig userWorkoutDaoConfig;
    private final DaoConfig exerciseResultDaoConfig;
    private final DaoConfig workoutScheduleDaoConfig;

    private final UserDao userDao;
    private final GoalDao goalDao;
    private final ExerciseDao exerciseDao;
    private final ExerciseWorkoutDao exerciseWorkoutDao;
    private final WorkoutDao workoutDao;
    private final UserWorkoutDao userWorkoutDao;
    private final ExerciseResultDao exerciseResultDao;
    private final WorkoutScheduleDao workoutScheduleDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        goalDaoConfig = daoConfigMap.get(GoalDao.class).clone();
        goalDaoConfig.initIdentityScope(type);

        exerciseDaoConfig = daoConfigMap.get(ExerciseDao.class).clone();
        exerciseDaoConfig.initIdentityScope(type);

        exerciseWorkoutDaoConfig = daoConfigMap.get(ExerciseWorkoutDao.class).clone();
        exerciseWorkoutDaoConfig.initIdentityScope(type);

        workoutDaoConfig = daoConfigMap.get(WorkoutDao.class).clone();
        workoutDaoConfig.initIdentityScope(type);

        userWorkoutDaoConfig = daoConfigMap.get(UserWorkoutDao.class).clone();
        userWorkoutDaoConfig.initIdentityScope(type);

        exerciseResultDaoConfig = daoConfigMap.get(ExerciseResultDao.class).clone();
        exerciseResultDaoConfig.initIdentityScope(type);

        workoutScheduleDaoConfig = daoConfigMap.get(WorkoutScheduleDao.class).clone();
        workoutScheduleDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        goalDao = new GoalDao(goalDaoConfig, this);
        exerciseDao = new ExerciseDao(exerciseDaoConfig, this);
        exerciseWorkoutDao = new ExerciseWorkoutDao(exerciseWorkoutDaoConfig, this);
        workoutDao = new WorkoutDao(workoutDaoConfig, this);
        userWorkoutDao = new UserWorkoutDao(userWorkoutDaoConfig, this);
        exerciseResultDao = new ExerciseResultDao(exerciseResultDaoConfig, this);
        workoutScheduleDao = new WorkoutScheduleDao(workoutScheduleDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(Goal.class, goalDao);
        registerDao(Exercise.class, exerciseDao);
        registerDao(ExerciseWorkout.class, exerciseWorkoutDao);
        registerDao(Workout.class, workoutDao);
        registerDao(UserWorkout.class, userWorkoutDao);
        registerDao(ExerciseResult.class, exerciseResultDao);
        registerDao(WorkoutSchedule.class, workoutScheduleDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        goalDaoConfig.getIdentityScope().clear();
        exerciseDaoConfig.getIdentityScope().clear();
        exerciseWorkoutDaoConfig.getIdentityScope().clear();
        workoutDaoConfig.getIdentityScope().clear();
        userWorkoutDaoConfig.getIdentityScope().clear();
        exerciseResultDaoConfig.getIdentityScope().clear();
        workoutScheduleDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public GoalDao getGoalDao() {
        return goalDao;
    }

    public ExerciseDao getExerciseDao() {
        return exerciseDao;
    }

    public ExerciseWorkoutDao getExerciseWorkoutDao() {
        return exerciseWorkoutDao;
    }

    public WorkoutDao getWorkoutDao() {
        return workoutDao;
    }

    public UserWorkoutDao getUserWorkoutDao() {
        return userWorkoutDao;
    }

    public ExerciseResultDao getExerciseResultDao() {
        return exerciseResultDao;
    }

    public WorkoutScheduleDao getWorkoutScheduleDao() {
        return workoutScheduleDao;
    }

}