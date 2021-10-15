package primitivetypes;

public class PrimitiveTypesMain {
    public static void main(String[] args) {
        // a változó: a típusa legyen int, az értéke 2!
        int a = 2;
        // b változó: a típusa legyen Integer, az értéke 2!
        Integer b = 2;
        // c változó: a típusa legyen Integer, az értéke legyen az a változó értéke!
        Integer c = a;
        // d változó: a típusa legyen Integer, az értéke legyen a b változó értéke!
        Integer d = b;
        /* e változó: a típusa legyen Integer, az értékét úgy add meg,
        hogy az Integer osztály megfelelő metódusával hozz létre egy új Integer objektumot a 2-es számból!
         */
        Integer e = Integer.valueOf(2);
        /* f változó: a típusa legyen int, az értékét úgy add meg,
        hogy az Integer osztály megfelelő metódusával hozz létre egy új Integer objektumot a 2-es számból!
         */
        int f = Integer.valueOf(2);
        /*g változó: a típusa legyen int, az értékét úgy add meg, hogy az Integer osztály megfelelő
        metódusával hozz létre egy új Integer objektumot az a változó értékéből!
         */
        int g = Integer.valueOf(a);
        /* h változó: a típusa legyen int, az értékét úgy add meg, hogy az Integer osztály megfelelő
         metódusával hozz létre egy új Integer objektumot a c változó értékéből!
         */
        int h = Integer.valueOf(c);
        /* i változó: a típusa legyen int, az értékét úgy add meg, hogy az Integer osztály megfelelő
        metódusával hozz létre egy új int típusú értéket a "2" szövegből!
         */
        int i = Integer.parseInt("2");
        /* j változó: a típusa legyen Integer, az értékét úgy add meg, hogy az Integer osztály megfelelő
        metódusával hozz létre egy új int típusú értéket a "2" szövegből!
         */
        Integer j = Integer.valueOf("2");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);
        System.out.println(j);
    }
}
