package moskvichevhomeworkthree;

import java.util.Scanner;

public class MainHomeWorkThree {

    public static void main(String[] args) {
        char a, b;// промежуточная переменная для сравнения букв
        int ii;// промежуточная переменная - граница цикла
        String word_ansver = "Nul";
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        long namber_ansver = Math.round(Math.random() * 100 / 4);
        int namber_ansver_int = (int) namber_ansver;

        //System.out.println(namber_ansver + " " + words[namber_ansver_int - 1]);
        String word_b = words[namber_ansver_int - 1];
        System.out.print("Угадай слово: ");
        while (word_ansver != word_b) {
            Scanner word = new Scanner(System.in);
            word_ansver = word.nextLine();
            //word.close();
            char[] arr = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',};
            if (word_ansver.length() >= word_b.length())
                ii = word_b.length();
            else ii = word_ansver.length();
            for (int i = 0; i < ii; i++) {
                a = word_ansver.charAt(i);
                b = word_b.charAt(i);
                if (a == b) {
                    arr[i] = word_ansver.charAt(i);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            if(word_ansver.equals(word_b)) {
                System.out.println("Угадал!");
                break;
            }
                else {
                    word_ansver = "Nul";
            }
            System.out.println("Попробуй ещё!");
        }
    }
}
