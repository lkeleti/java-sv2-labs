package collectionsiterator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeSchooling {
    private List<OnlineLesson> lessons = new ArrayList<>();

    public void addNewLesson(OnlineLesson lesson)
    {
        int numberOfLessons = lessons.size();
        if (lessons.size() == 0) {
            lessons.add(lesson);
        }
        else if(numberOfLessons == 1) {
            if (lessons.get(0).getStartTime().isBefore(lesson.getStartTime())) {
                lessons.add(lesson);
            }
            else {
                lessons.add(0, lesson);
            }
        }
        else {
            if (lessons.get(0).getStartTime().isBefore(lesson.getStartTime())) {
                lessons.add(0,lesson);
                return;
            }
            for (int i= 0; i < numberOfLessons-1; i++) {
                if (lessons.get(i).getStartTime().isBefore(lesson.getStartTime()) &&
                        lessons.get(i + 1).getStartTime().isAfter(lesson.getStartTime())) {
                    lessons.add(i, lesson);
                    return;
                }
            }
            lessons.add(lesson);
        }
    }

    public  List<OnlineLesson> getLessonsByTitle(String title) {
        //ezzel le lehet kérni az összes ugyanolyan típusú tanórát, pl. az összes matekórát.
        List<OnlineLesson> result = new ArrayList<>();
        for (Iterator<OnlineLesson> i = lessons.iterator();i.hasNext();) {
            OnlineLesson nextEntry = i.next();
            if (nextEntry.getLessonTitle().equals(title)){
                result.add(nextEntry);
            }
        }
        return result;
    }

    public void removeLesson(LocalDateTime startTime) {
        for (Iterator<OnlineLesson> i = lessons.iterator(); i.hasNext();){
            if (i.next().getStartTime().equals(startTime)) {
                i.remove();
            }
        }
    }

    public List<OnlineLesson> getLessons() {
        return lessons;
    }
}
