package com.dwetherbee.crossrexapp.database;

import java.util.List;
import com.dwetherbee.crossrexapp.database.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table WORKOUT.
 */
public class Workout {

    private Long id;
    private String name;
    private String description;
    private Integer type;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient WorkoutDao myDao;

    private List<ExerciseWorkout> exercises;
    private List<WorkoutSchedule> schedules;
    private List<UserWorkout> userWorkouts;

    // KEEP FIELDS - put your custom fields here
    public static final int TYPE_SCHEDULED =  0;
    public static final int TYPE_CUSTOM =  1;
    // KEEP FIELDS END

    public Workout() {
    }

    public Workout(Long id) {
        this.id = id;
    }

    public Workout(Long id, String name, String description, Integer type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWorkoutDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ExerciseWorkout> getExercises() {
        if (exercises == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ExerciseWorkoutDao targetDao = daoSession.getExerciseWorkoutDao();
            List<ExerciseWorkout> exercisesNew = targetDao._queryWorkout_Exercises(id);
            synchronized (this) {
                if(exercises == null) {
                    exercises = exercisesNew;
                }
            }
        }
        return exercises;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetExercises() {
        exercises = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<WorkoutSchedule> getSchedules() {
        if (schedules == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WorkoutScheduleDao targetDao = daoSession.getWorkoutScheduleDao();
            List<WorkoutSchedule> schedulesNew = targetDao._queryWorkout_Schedules(id);
            synchronized (this) {
                if(schedules == null) {
                    schedules = schedulesNew;
                }
            }
        }
        return schedules;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetSchedules() {
        schedules = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<UserWorkout> getUserWorkouts() {
        if (userWorkouts == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserWorkoutDao targetDao = daoSession.getUserWorkoutDao();
            List<UserWorkout> userWorkoutsNew = targetDao._queryWorkout_UserWorkouts(id);
            synchronized (this) {
                if(userWorkouts == null) {
                    userWorkouts = userWorkoutsNew;
                }
            }
        }
        return userWorkouts;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetUserWorkouts() {
        userWorkouts = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
