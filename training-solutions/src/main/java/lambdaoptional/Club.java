package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Club {
    private List<Member> members;

    public Club(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return List.copyOf(members);
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        if (members == null || members.isEmpty()) {
            return Optional.empty();
        }

        for (Member member: members) {
            if (predicate.test(member)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.isEmpty()) {
            return Optional.empty();
        }

        int totalNumberOfSkills = 0;
        for (Member member: members) {
            totalNumberOfSkills += member.getSkills().size();
        }
        return Optional.of(totalNumberOfSkills/(double)members.size());
    }
}
