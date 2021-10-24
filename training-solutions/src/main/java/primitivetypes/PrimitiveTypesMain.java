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

        //Logikai értékek
        //k változó: a típusa legyen boolean, az értéke true
        boolean k = true;
        //l változó: a típusa legyen Boolean, az értéke true
        Boolean l = true;
        /* m változó: a típusa legyen boolean, az értékét úgy add meg, hogy a Boolean osztály megfelelő
        metódusával hozz létre egy új Boolean objektumot a true logikai literálból!
         */
        boolean m = Boolean.valueOf(true);
        /* n változó: a típusa legyen Boolean, az értékét úgy add meg, hogy a Boolean osztály megfelelő
        metódusával hozz létre egy új Boolean objektumot a true logikai literálból!
         */
        Boolean n = new Boolean(true);
        /* o változó: a típusa legyen boolean, az értékét úgy add meg, hogy a Boolean osztály megfelelő
        metódusával hozz létre egy új boolean típusú értéket a "TrUe" szövegből!
         */
        boolean o = Boolean.valueOf("TrUe");
        /* p változó: a típusa legyen Boolean, az értékét úgy add meg, hogy a Boolean osztály megfelelő
        metódusával hozz létre egy új boolean típusú értéket a "TrUe" szövegből!
         */
        Boolean p = Boolean.valueOf("TrUe");
        /* q változó: a típusa legyen boolean, az értékét úgy add meg, hogy a Boolean osztály megfelelő
        metódusával hozz létre egy új boolean típusú értéket a "TreU" szövegből!
         */
        boolean q = Boolean.valueOf("TreU");
        /* r változó: a típusa legyen Boolean, az értékét úgy add meg, hogy a Boolean osztály megfelelő
        metódusával hozz létre egy új boolean típusú értéket a "TreU" szövegből!
         */
        Boolean r = Boolean.valueOf("TreU");

        System.out.println(k);
        System.out.println(l);
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
        System.out.println(p);
        System.out.println(q);
        System.out.println(r);
    }
}
