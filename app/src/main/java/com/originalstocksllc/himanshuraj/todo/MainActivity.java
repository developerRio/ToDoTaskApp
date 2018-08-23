package com.originalstocksllc.himanshuraj.todo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.originalstocksllc.himanshuraj.todo.db.ToDoHelper;
import com.originalstocksllc.himanshuraj.todo.db.ToDoTable;
import com.originalstocksllc.himanshuraj.todo.model.ToDo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ToDo> toDos;
    private ToDoHelper dbHelper;
    private SQLiteDatabase todoDb;
    private TodoAdapter todoAdapter;
    private EditText etTask;
    private Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.etTask);
        addTaskButton = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recycler);

        dbHelper = new ToDoHelper(this);
        todoDb = dbHelper.getWritableDatabase();

        toDos = ToDoTable.getAllToDos(todoDb);
        todoAdapter = new TodoAdapter(toDos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(todoAdapter);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDo toDo = new ToDo(etTask.getText().toString(), false);
                ToDoTable.addTodo(todoDb, toDo);
                toDos = ToDoTable.getAllToDos(todoDb);
                todoAdapter.updateTodos(toDos);
            }
        });

    }
}





