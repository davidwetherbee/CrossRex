package com.dwetherbee.crossrexapp.database;

import java.util.List;
import com.dwetherbee.crossrexapp.database.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table USER.
 */
public class User {

    private Long id;
    private String fName;
    private String lName;
    private Integer weight;
    private Integer height;
    private Integer bodyFat;
    private Integer type;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient UserDao myDao;

    private List<Goal> goals;
    private List<WorkoutSchedule> schedules;
    private List<UserWorkout> workouts;

    // KEEP FIELDS - put your custom fields here
    public static final int TYPE_STUDENT =  0;
    public static final int TYPE_INSTRUCTOR =  1;
    // KEEP FIELDS END

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String fName, String lName, Integer weight, Integer height, Integer bodyFat, Integer type) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.weight = weight;
        this.height = height;
        this.bodyFat = bodyFat;
        this.type = type;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(Integer bodyFat) {
        this.bodyFat = bodyFat;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Goal> getGoals() {
        if (goals == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            GoalDao targetDao = daoSession.getGoalDao();
            List<Goal> goalsNew = targetDao._queryUser_Goals(id);
            synchronized (this) {
                if(goals == null) {
                    goals = goalsNew;
                }
            }
        }
        return goals;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetGoals() {
        goals = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<WorkoutSchedule> getSchedules() {
        if (schedules == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WorkoutScheduleDao targetDao = daoSession.getWorkoutScheduleDao();
            List<WorkoutSchedule> schedulesNew = targetDao._queryUser_Schedules(id);
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
    public List<UserWorkout> getWorkouts() {
        if (workouts == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserWorkoutDao targetDao = daoSession.getUserWorkoutDao();
            List<UserWorkout> workoutsNew = targetDao._queryUser_Workouts(id);
            synchronized (this) {
                if(workouts == null) {
                    workouts = workoutsNew;
                }
            }
        }
        return workouts;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetWorkouts() {
        workouts = null;
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
