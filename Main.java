import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static void Ex3(int num1, int num2){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(num1+num2);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(num1-num2);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(num1*num2);
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(num1/num2);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }

    public static boolean Ex2(int[][] tenByTen, int[][] fourtyByFourty){
        for(int i=0; i<31; i++){
            for(int j=0; j<31; j++){
                if(matCheck(tenByTen, fourtyByFourty, i, j))
                    return true;
            }
        }
        return false;
    }

    //Ex1
    public static boolean matCheck(int[][] small, int[][] big, int startRowIndex, int startColumnIndex){
        if(startRowIndex > 30 || startColumnIndex > 30){
            return false;
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(small[i][j] != big[startRowIndex+i][startColumnIndex+j])
                    return false;
            }
        }
        return true;
    }

    public static void newId(){
        Scanner scanner = new Scanner(System.in);
        String nameAndId = scanner.nextLine();

        String Id = "";
        String name = "";

        for(int i=0; i<nameAndId.length(); i++){
            if(Character.isDigit(nameAndId.charAt(i))){
                Id += nameAndId.charAt(i);
            }
            else {
                name += nameAndId.charAt(i);
            }
        }

        String newId = Id.substring(0,Character.getNumericValue(Id.charAt(7)+1))
                + Id.charAt(Id.length()-1)
                + Id.substring(Character.getNumericValue(Id.charAt(7)+2));

        System.out.println("name: " + name + ", ID: " + newId);

    }
}
