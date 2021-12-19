package virtualmethod.grammar;

public class Grammar {
    public static void main(String[] args) {
        Verb verb1 =  new PhrasalVerb("figyel","meg");
        Verb verb2 = new PhrasalVerbWithSuffix("figyel", "meg", "tem");
        Preposition preposition1 = new PhrasalVerb("áll", "fel");
        Preposition preposition2 = new  PhrasalVerbWithSuffix("áll", "fel","ni");
        PhrasalVerb phrasalVerb1 = new PhrasalVerb("ül", "le");
        PhrasalVerb phrasalVerb2 = new PhrasalVerbWithSuffix("ül", "le", "tem");
        Suffix suffix1 = new PhrasalVerbWithSuffix("megy", "ki", "ek");
        PhrasalVerbWithSuffix phrasalVerbWithSuffix1= new  PhrasalVerbWithSuffix("tanul", "meg","tam");

        System.out.println(verb1.getWord());
        System.out.println(verb2.getWord());

        System.out.println(preposition1.getPreposition());
        System.out.println(preposition1.getWholeWord());

        System.out.println(preposition2.getPreposition());
        System.out.println(preposition2.getWholeWord());

        System.out.println(phrasalVerb1.getPreposition());
        System.out.println(phrasalVerb1.getWord());
        System.out.println(phrasalVerb1.getWholeWord());

        System.out.println(phrasalVerb2.getPreposition());
        System.out.println(phrasalVerb2.getWord());
        System.out.println(phrasalVerb2.getWholeWord());

        System.out.println(suffix1.getSuffix());

        System.out.println(phrasalVerbWithSuffix1.getPreposition());
        System.out.println(phrasalVerbWithSuffix1.getSuffix());
        System.out.println(phrasalVerbWithSuffix1.getWord());
        System.out.println(phrasalVerbWithSuffix1.getWholeWord());
    }
}
