package com.dwetherbee.crossrexapp.database;

import java.util.List;
import com.dwetherbee.crossrexapp.database.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table USER_WORKOUT.
 */
public class UserWorkout {

    private Long id;
    private java.util.Date date;
    private String notes;
    private Integer intensity;
    private Integer caloriesBurned;
    private Integer percentComplete;
    private Long workoutId;
    private Long userId;
    private Long userWorkoutId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient UserWorkoutDao myDao;

    private Workout workout;
    private Long workout__resolvedKey;

    private User user;
    private Long user__resolvedKey;

    private WorkoutSchedule scheduledWorkout;
    private Long scheduledWorkout__resolvedKey;

    private List<ExerciseResult> exerciseResults;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public UserWorkout() {
    }

    public UserWorkout(Long id) {
        this.id = id;
    }

    public UserWorkout(Long id, java.util.Date date, String notes, Integer intensity, Integer caloriesBurned, Integer percentComplete, Long workoutId, Long userId, Long userWorkoutId) {
        this.id = id;
        this.date = date;
        this.notes = notes;
        this.intensity = intensity;
        this.caloriesBurned = caloriesBurned;
        this.percentComplete = percentComplete;
        this.workoutId = workoutId;
        this.userId = userId;
        this.userWorkoutId = userWorkoutId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserWorkoutDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public Integer getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Integer caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Integer getPercentComplete() {
        return percentComplete;
    }

    public void setPercentComplete(Integer percentComplete) {
        this.percentComplete = percentComplete;
    }

    public Long getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Long workoutId) {
        this.workoutId = workoutId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserWorkoutId() {
        return userWorkoutId;
    }

    public void setUserWorkoutId(Long userWorkoutId) {
        this.userWorkoutId = userWorkoutId;
    }

    /** To-one relationship, resolved on first access. */
    public Workout getWorkout() {
        Long __key = this.workoutId;
        if (workout__resolvedKey == null || !workout__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WorkoutDao targetDao = daoSession.getWorkoutDao();
            Workout workoutNew = targetDao.load(__key);
            synchronized (this) {
                workout = workoutNew;
            	workout__resolvedKey = __key;
            }
        }
        return workout;
    }

    public void setWorkout(Workout workout) {
        synchronized (this) {
            this.workout = workout;
            workoutId = workout == null ? null : workout.getId();
            workout__resolvedKey = workoutId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public User getUser() {
        Long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
            	user__resolvedKey = __key;
            }
        }
        return user;
    }

    public void setUser(User user) {
        synchronized (this) {
            this.user = user;
            userId = user == null ? null : user.getId();
            user__resolvedKey = userId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public WorkoutSchedule getScheduledWorkout() {
        Long __key = this.userWorkoutId;
        if (scheduledWorkout__resolvedKey == null || !scheduledWorkout__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WorkoutScheduleDao targetDao = daoSession.getWorkoutScheduleDao();
            WorkoutSchedule scheduledWorkoutNew = targetDao.load(__key);
            synchronized (this) {
                scheduledWorkout = scheduledWorkoutNew;
            	scheduledWorkout__resolvedKey = __key;
            }
        }
        return scheduledWorkout;
    }

    public void setScheduledWorkout(WorkoutSchedule scheduledWorkout) {
        synchronized (this) {
            this.scheduledWorkout = scheduledWorkout;
            userWorkoutId = scheduledWorkout == null ? null : scheduledWorkout.getId();
            scheduledWorkout__resolvedKey = userWorkoutId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ExerciseResult> getExerciseResults() {
        if (exerciseResults == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ExerciseResultDao targetDao = daoSession.getExerciseResultDao();
            List<ExerciseResult> exerciseResultsNew = targetDao._queryUserWorkout_ExerciseResults(id);
            synchronized (this) {
                if(exerciseResults == null) {
                    exerciseResults = exerciseResultsNew;
                }
            }
        }
        return exerciseResults;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetExerciseResults() {
        exerciseResults = null;
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
