package methodpass;

public class One {
    public static void main(String[] args) {
        int number = 0;
        One one = new One();

        System.out.println(number);//0
        number++;
        System.out.println(number);//1
        System.out.println(one.addOne(number));//2
        System.out.println(number);//1
    }

    public int addOne(int number) {
        return number+1;
    }
}
