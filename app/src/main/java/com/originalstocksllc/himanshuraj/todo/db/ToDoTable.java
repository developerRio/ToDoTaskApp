package com.originalstocksllc.himanshuraj.todo.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.originalstocksllc.himanshuraj.todo.model.ToDo;

import java.util.ArrayList;

import static com.originalstocksllc.himanshuraj.todo.db.Constants.CMD_CREATE_TABLE_INE;
import static com.originalstocksllc.himanshuraj.todo.db.Constants.COMA;
import static com.originalstocksllc.himanshuraj.todo.db.Constants.LBR;
import static com.originalstocksllc.himanshuraj.todo.db.Constants.RBR;
import static com.originalstocksllc.himanshuraj.todo.db.Constants.SEMICOL;
import static com.originalstocksllc.himanshuraj.todo.db.Constants.TYPE_BOOL;
import static com.originalstocksllc.himanshuraj.todo.db.Constants.TYPE_PK_AI;
import static com.originalstocksllc.himanshuraj.todo.db.Constants.TYPE_TEXT;

public class ToDoTable {
    public static final String TABLE_NAME = "todos";
    public interface Columns {
        String ID = "id";
        String TASK = "task";
        String DONE = "done";
    }

    public static final String CMD_CREATE =
            CMD_CREATE_TABLE_INE + TABLE_NAME +
                    LBR +
                    Columns.ID + TYPE_PK_AI +
                    COMA +
                    Columns.TASK + TYPE_TEXT +
                    COMA +
                    Columns.DONE + TYPE_BOOL +
                    RBR +
                    SEMICOL;

    public static long addTodo(SQLiteDatabase db, ToDo toDo) {
        ContentValues todoRow = new ContentValues();
        todoRow.put(Columns.TASK, toDo.getTask());
        todoRow.put(Columns.DONE, toDo.isDone());
        return db.insert(TABLE_NAME, null, todoRow);
    }

    public static ArrayList<ToDo> getAllToDos(SQLiteDatabase db) {
        ArrayList<ToDo> toDos = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{Columns.ID, Columns.TASK, Columns.DONE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            toDos.add(new ToDo(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2) == 1 // either 0 or 1
            ));
        }
        return toDos;
    }


}
