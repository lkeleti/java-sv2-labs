package collectionsqueue;

import java.util.*;

public class ToDoList {
    private List<ToDo> todos = new ArrayList<>();

    public void addToDo(ToDo toDo) {
        todos.add(toDo);
    }

    public Deque<ToDo> getTodosInUrgencyOrder() {
        Deque<ToDo> result = new ArrayDeque<>();

        for (ToDo toDo: todos) {
            if (toDo.isUrgent()) {
                result.addFirst(toDo);
            }
            else {
                result.addLast(toDo);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.addToDo(new ToDo("Start", true));
        toDoList.addToDo(new ToDo("Urgent", true));
        toDoList.addToDo(new ToDo("Not Urgent1", false));
        toDoList.addToDo(new ToDo("End", true));
        toDoList.addToDo(new ToDo("Not Urgent2", false));

        Deque<ToDo> todos = toDoList.getTodosInUrgencyOrder();
        System.out.println(todos);
        System.out.println(todos.pop());
    }
}
