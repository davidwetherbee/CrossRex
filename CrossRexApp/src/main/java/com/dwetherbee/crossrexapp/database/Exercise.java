package com.dwetherbee.crossrexapp.database;

import java.util.List;
import com.dwetherbee.crossrexapp.database.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table EXERCISE.
 */
public class Exercise {

    private Long id;
    private String name;
    private Integer type;
    private String description;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ExerciseDao myDao;

    private List<ExerciseWorkout> exerciseWorkouts;

    // KEEP FIELDS - put your custom fields here
    public static final int TYPE_TIME =  0;
    public static final int TYPE_ROUNDS =  1;
    public static final int TYPE_REPS =  2;
    public static final int TYPE_WEIGHT =  3;
    // KEEP FIELDS END

    public Exercise() {
    }

    public Exercise(Long id) {
        this.id = id;
    }

    public Exercise(Long id, String name, Integer type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getExerciseDao() : null;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ExerciseWorkout> getExerciseWorkouts() {
        if (exerciseWorkouts == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ExerciseWorkoutDao targetDao = daoSession.getExerciseWorkoutDao();
            List<ExerciseWorkout> exerciseWorkoutsNew = targetDao._queryExercise_ExerciseWorkouts(id);
            synchronized (this) {
                if(exerciseWorkouts == null) {
                    exerciseWorkouts = exerciseWorkoutsNew;
                }
            }
        }
        return exerciseWorkouts;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetExerciseWorkouts() {
        exerciseWorkouts = null;
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
