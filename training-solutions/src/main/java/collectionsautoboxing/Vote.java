package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Vote {
    public Map<VoteResult, Integer> getResult(Map<String, VoteResult> votes){
        Map<VoteResult, Integer> result = new HashMap<>();
        for (VoteResult vr: votes.values()){
            if (result.containsKey(vr)) {
                result.put(vr, result.get(vr) + 1);
            }
            else {
                result.put(vr, 1);
            }
        }
        return result;
    }
}
