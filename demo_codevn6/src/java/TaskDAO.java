
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author codevn
 */
public class TaskDAO {

    ArrayList<Task> taskList = new ArrayList<>();

    public TaskDAO() {
        if (taskList.isEmpty()) {
            taskList.add(new Task(1, "button", "Tuan ngu", "10/4/2024"));
            taskList.add(new Task(2, "space", "Tuan ngu", "17/4/2024"));
            taskList.add(new Task(3, "button", "Tuan ngu", "20/4/2024"));
        }
    }

    public ArrayList<Task> getAll() {

        return taskList;
    }

    public Task getTaskById(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void updateTask(int id, Task task) {
        int index = 0;
        for (Task task1 : taskList) {
            if (task1.getId() == id) {
                taskList.set(index, task);
                return;
            }
            index++;
        }

    }

    public void deleteTask(int id) {
        int index = 0;
        for (Task task : taskList) {
            if (task.getId() == id) {
                taskList.remove(task);
                return;
            }
            index++;
        }

    }

}
