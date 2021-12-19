package polymorphism.architect;

import org.w3c.dom.ls.LSOutput;

public class Architect {
    public static void main(String[] args) {
        Plan plan1 = new SketchPlan(1, "SketchPlan");
        Plan plan2 = new PermitPlan(2, "permitPlan", "John Doe", "New York");
        Plan plan3 = new ConstructionPlan(3, "ConstrtuctionPlan", "Jane Doe", "Washington", 1);
        SketchPlan sketchPlan1 = new SketchPlan(4, "SketchPlan");
        SketchPlan sketchPlan2 = new PermitPlan(5, "PermitPlan", "Jack Doe", "Ohio");
        SketchPlan sketchPlan3 = new ConstructionPlan(6,"ConstructionPlan","Jackie", "Florida",2);
        Header header1 = new PermitPlan(7,"HeaderOfPermitPlan", "Susan","Michigan");
        Header header2 = new ConstructionPlan(8,"HeaderOfConstructionPlan","Jenner","Pensilvania",3);
        PermitPlan permitPlan1 = new PermitPlan(9,"PermitPlan", "Tom", "Ontario");
        PermitPlan permitPlan2 = new ConstructionPlan(10,"PC","Daniel","Texas",4);
        ConstructionPlan constructionPlan = new ConstructionPlan(11,"CC","Camilla","Mobile",5);

        System.out.println(plan1.getPagesOfDocumentation());
        System.out.println(plan2.getPagesOfDocumentation());
        System.out.println(plan3.getPagesOfDocumentation());

        System.out.println(sketchPlan1.getPagesOfDocumentation());
        System.out.println(sketchPlan1.getTitle());
        System.out.println(sketchPlan2.getPagesOfDocumentation());
        System.out.println(sketchPlan2.getTitle());
        System.out.println(sketchPlan3.getPagesOfDocumentation());
        System.out.println(sketchPlan3.getTitle());

        System.out.println(header1.getNameOfClient());
        System.out.println(header1.getAddressOfBuilding());

        System.out.println(header2.getNameOfClient());
        System.out.println(header2.getAddressOfBuilding());

        System.out.println(permitPlan1.getPagesOfDocumentation());
        System.out.println(permitPlan1.getTitle());
        System.out.println(permitPlan1.getNameOfClient());
        System.out.println(permitPlan1.getAddressOfBuilding());
        System.out.println(permitPlan1.getHeader());

        System.out.println(permitPlan2.getPagesOfDocumentation());
        System.out.println(permitPlan2.getTitle());
        System.out.println(permitPlan2.getNameOfClient());
        System.out.println(permitPlan2.getAddressOfBuilding());
        System.out.println(permitPlan2.getHeader());

        System.out.println(constructionPlan.getPagesOfDocumentation());
        System.out.println(constructionPlan.getTitle());
        System.out.println(constructionPlan.getNameOfClient());
        System.out.println(constructionPlan.getAddressOfBuilding());
        System.out.println(constructionPlan.getHeader());
        System.out.println(constructionPlan.getSheetsOfConstructionDrawings());
    }
}
