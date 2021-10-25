package algorithmstransformation.family;

import java.util.ArrayList;
import java.util.List;

public class Family {

    private List<FamilyMember> familyList;

    public Family() {
        familyList = new ArrayList<>();
    }

    public List<FamilyMember> getFamilyList() {
        return familyList;
    }

    public void addFamilyMember(FamilyMember familyMember) {
        familyList.add(familyMember);
    }

    public List<Integer> getAgesOfFamilyMembersWithNameGiven(String givenName) {
        List<Integer> ages = new ArrayList<>();
        for (FamilyMember member: familyList) {
            if (!member.getName().startsWith(givenName) && member.getName().contains(givenName)) {
                ages.add(member.getAge());
            }
        }
        return ages;
    }
}
