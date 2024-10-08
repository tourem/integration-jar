package com.javasneo.todolist.controller;

import com.javasneo.todolist.model.Todo;
import com.javasneo.todolist.model.TodoListResponse;
import com.javasneo.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abderrahmen on 31/01/2018.
 */
@RestController
@RequestMapping("/todos")
@CrossOrigin()
public class TodoController {

  @Autowired
  TodoService todoService;

  @RequestMapping(method = RequestMethod.GET)
  public TodoListResponse todos (){
    List<Todo> todoList = todoService.getAll();
    TodoListResponse todoListResponse = new TodoListResponse();
    todoListResponse.setTodos(todoList);
    return todoListResponse;
  }

  @RequestMapping(method = RequestMethod.POST)
  public Todo addtodo (@RequestBody Todo todo){
    return todoService.saveOrUpdate(todo);
  }


  @RequestMapping(method = RequestMethod.PUT)
  public Todo updateTodo (@RequestBody Todo todo){
    return todoService.saveOrUpdate(todo);
  }

  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
  public void deleteTodo (@PathVariable("id") int id){
    todoService.delete(id);
  }

}
