package com.originalstocksllc.himanshuraj.todo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.originalstocksllc.himanshuraj.todo.model.ToDo;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<ToDo> toDos = new ArrayList<>();

    public TodoAdapter(ArrayList<ToDo> toDos) {
        this.toDos = toDos;
    }

    public void updateTodos(ArrayList<ToDo> newTodoList){
        toDos.clear();
        toDos.addAll(newTodoList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return new TodoViewHolder(layoutInflater.inflate(R.layout.list_items, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder todoViewHolder, int i) {
        ToDo toDo = toDos.get(i);
        todoViewHolder.taskTextView.setText(toDo.getTask());
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }


    public class TodoViewHolder extends RecyclerView.ViewHolder{

        TextView taskTextView;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTextView = itemView.findViewById(R.id.taskText);
        }
    }


}
