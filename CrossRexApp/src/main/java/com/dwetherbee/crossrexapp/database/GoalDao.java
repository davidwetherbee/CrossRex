package com.dwetherbee.crossrexapp.database;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.dwetherbee.crossrexapp.database.Goal;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table GOAL.
*/
public class GoalDao extends AbstractDao<Goal, Long> {

    public static final String TABLENAME = "GOAL";

    /**
     * Properties of entity Goal.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StartTime = new Property(1, java.util.Date.class, "startTime", false, "START_TIME");
        public final static Property CompleteTime = new Property(2, java.util.Date.class, "completeTime", false, "COMPLETE_TIME");
        public final static Property EndTime = new Property(3, java.util.Date.class, "endTime", false, "END_TIME");
        public final static Property UserId = new Property(4, Long.class, "userId", false, "USER_ID");
        public final static Property GoalId = new Property(5, Long.class, "goalId", false, "GOAL_ID");
    };

    private DaoSession daoSession;

    private Query<Goal> user_GoalsQuery;
    private Query<Goal> exerciseWorkout_GoalsQuery;

    public GoalDao(DaoConfig config) {
        super(config);
    }
    
    public GoalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'GOAL' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'START_TIME' INTEGER," + // 1: startTime
                "'COMPLETE_TIME' INTEGER," + // 2: completeTime
                "'END_TIME' INTEGER," + // 3: endTime
                "'USER_ID' INTEGER," + // 4: userId
                "'GOAL_ID' INTEGER);"); // 5: goalId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'GOAL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Goal entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        java.util.Date startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindLong(2, startTime.getTime());
        }
 
        java.util.Date completeTime = entity.getCompleteTime();
        if (completeTime != null) {
            stmt.bindLong(3, completeTime.getTime());
        }
 
        java.util.Date endTime = entity.getEndTime();
        if (endTime != null) {
            stmt.bindLong(4, endTime.getTime());
        }
 
        Long userId = entity.getUserId();
        if (userId != null) {
            stmt.bindLong(5, userId);
        }
 
        Long goalId = entity.getGoalId();
        if (goalId != null) {
            stmt.bindLong(6, goalId);
        }
    }

    @Override
    protected void attachEntity(Goal entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Goal readEntity(Cursor cursor, int offset) {
        Goal entity = new Goal( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // startTime
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // completeTime
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)), // endTime
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // userId
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // goalId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Goal entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStartTime(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setCompleteTime(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setEndTime(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
        entity.setUserId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setGoalId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Goal entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Goal entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "goals" to-many relationship of User. */
    public List<Goal> _queryUser_Goals(Long userId) {
        synchronized (this) {
            if (user_GoalsQuery == null) {
                QueryBuilder<Goal> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UserId.eq(null));
                user_GoalsQuery = queryBuilder.build();
            }
        }
        Query<Goal> query = user_GoalsQuery.forCurrentThread();
        query.setParameter(0, userId);
        return query.list();
    }

    /** Internal query to resolve the "goals" to-many relationship of ExerciseWorkout. */
    public List<Goal> _queryExerciseWorkout_Goals(Long goalId) {
        synchronized (this) {
            if (exerciseWorkout_GoalsQuery == null) {
                QueryBuilder<Goal> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.GoalId.eq(null));
                exerciseWorkout_GoalsQuery = queryBuilder.build();
            }
        }
        Query<Goal> query = exerciseWorkout_GoalsQuery.forCurrentThread();
        query.setParameter(0, goalId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUserDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getExerciseWorkoutDao().getAllColumns());
            builder.append(" FROM GOAL T");
            builder.append(" LEFT JOIN USER T0 ON T.'USER_ID'=T0.'_id'");
            builder.append(" LEFT JOIN EXERCISE_WORKOUT T1 ON T.'GOAL_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Goal loadCurrentDeep(Cursor cursor, boolean lock) {
        Goal entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        User user = loadCurrentOther(daoSession.getUserDao(), cursor, offset);
        entity.setUser(user);
        offset += daoSession.getUserDao().getAllColumns().length;

        ExerciseWorkout exercise = loadCurrentOther(daoSession.getExerciseWorkoutDao(), cursor, offset);
        entity.setExercise(exercise);

        return entity;    
    }

    public Goal loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Goal> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Goal> list = new ArrayList<Goal>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Goal> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Goal> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
