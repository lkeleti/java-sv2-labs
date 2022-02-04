package activity;

import java.util.*;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }


    public int numberOfTrackActivities() {
        return (int)activities.stream()
                .filter(ActivityWithTrack.class::isInstance)
                .count();
    }

    public int numberOfWithoutTrackActivities() {
        return (int)activities.stream()
                .filter(ActivityWithoutTrack.class::isInstance)
                .count();
    }

    public List<Report> distancesByTypes() {
        System.out.println(activities);
        Map<ActivityType, Double> activityTypeByDistance = new LinkedHashMap<>();
        for (ActivityType activityType: ActivityType.values()) {
            activityTypeByDistance.put(activityType,0.0);
        }

        for (Activity activity: activities) {
            ActivityType key = activity.getType();
            activityTypeByDistance.put(key, activityTypeByDistance.get(key) + activity.getDistance());
        }

        System.out.println(activityTypeByDistance);

        List<Report> result = new ArrayList<>();
        for (Map.Entry<ActivityType, Double> entry : activityTypeByDistance.entrySet()){
            result.add(new Report(entry.getKey(), entry.getValue()));
        }
        return result;
    }
}
