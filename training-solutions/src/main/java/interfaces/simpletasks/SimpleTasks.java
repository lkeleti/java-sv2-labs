package interfaces.simpletasks;

import java.util.ArrayList;
import java.util.List;

public class SimpleTasks implements Runnable{
    private List<String> tasks;

    public SimpleTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    @Override
    public void run() {
        boolean result;
        do {
            result = nextStep();
        } while (result);
    }

    private boolean nextStep(){
        if (tasks.size() == 0){
            return false;
        }
        tasks.remove(tasks.size()-1);
        return tasks.size() > 0;
    }
}
