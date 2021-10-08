package localvariables;

public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b;
        // System.out.println(b); NEM FOG működni, mert b-nek még nincs értéke

        b= false;
        System.out.println(b);

        int a = 2;
        System.out.println(a);

        int i =3;
        int j = 4;
        int k = i;

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        String s;
        s = "Hello World";
        System.out.println(s);
        String t = s;
        System.out.println(t);
        {
            int x = 0;
            System.out.println(x);
            System.out.println(a);
        }
        //System.out.println(x); csak a blokkon belül lehet kiírni
        System.out.println(a);
    }
}
