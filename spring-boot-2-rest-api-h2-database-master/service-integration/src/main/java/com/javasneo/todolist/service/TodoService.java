package com.javasneo.todolist.service;

import com.javasneo.todolist.model.Todo;

import java.util.List;

public interface TodoService {
  List<Todo> getAll();
  Todo saveOrUpdate(Todo todo);
  void delete(int id);
}
