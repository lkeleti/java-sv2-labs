package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {
    public Trainer getTrainerWithMaxAge(List<Trainer> trainers) {
        Trainer maxAgedTrainer = null;
        for (Trainer trainer: trainers) {
            if (maxAgedTrainer == null || trainer.getAge() > maxAgedTrainer.getAge()) {
                maxAgedTrainer = trainer;
            }
        }
        return maxAgedTrainer;
    }
}
