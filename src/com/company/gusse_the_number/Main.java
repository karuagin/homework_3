package com.company.gusse_the_number;

import java.util.*;


public class Main {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            System.out.print("Сделай выбор:\n"+
                    "1. Выбери число\n2. Выбери слово\n3. Выход\n: ");
            switch (sc.next()) {
                case "1":
                    guessTheNumber();
                    break;
                case "2":
                    guessTheWord();
                    break;
                default:
                    return;
            }
        }
    }
     //   1. Написать программу, которая загадывает случайное число от 0 до 9,
     //   и пользователю дается 3 попытки угадать это число. При каждой попытке
     //   компьютер должен сообщить больше ли указанное пользователем число чем
     //   загаданное, или меньше. После победы или проигрыша выводится запрос
     //   «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).
     static void guessTheNumber() {
         Scanner scanner = new Scanner(System.in);
         do {
             int numComp = random.nextInt(10);
             System.out.println("Угдай число с 3-х попыток от 0 до 9");
             for (int i = 3; i > 0; i--) {
                 System.out.println("Введи свой ответ:");
                 int questionNum = scanner.nextInt();
                 if (questionNum == numComp) {
                     System.out.println("Вы угадали число, молодец!");
                     break;
                 }
                 System.out.println(questionNum > numComp ? "Введенное чилсо больше " : "Введенное число меньше ");
                 System.out.println((i-1) > 0 ? " у вас осталось " + (i-1) + " попыток." : "Попытки закончились, вы проиграли.");
             }
             System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
         }
         while (scanner.nextInt() == 1);
     }


    //    2.  Создать массив из слов
     //    String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     //           "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
     //           "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
     //           "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
     //           "potato"};
     //   При запуске программы компьютер загадывает слово, запрашивает ответ
     //   у пользователя, сравнивает его с загаданным словом и сообщает
     //   правильно ли ответил пользователь. Если слово не угадано, компьютер
     //   показывает буквы которые стоят на своих местах.
     //           apple – загаданное
     //           apricot - ответ игрока
     //           ap#############
     //   (15 символов, чтобы пользователь не мог узнать длину слова)
     //   Для сравнения двух слов посимвольно, можно пользоваться:
     //   str.charAt(0) - метод вернет char, который стоит в слове str на
     //   первой позиции, играем до тех пор, пока игрок не отгадает слово,
     //   используем только маленькие буквы.

    static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int indWord = random.nextInt(words.length - 1);
        String word = words[indWord];
        int lenWord = word.length();
        System.out.println("Попробуй отгадать слово которое я загадал?");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введи свой ответ:");
            String answer = scanner.nextLine();
            if (answer.equals("")) break;
            else if (word.equals(answer)) {
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
            char[] charsAnswer = answer.toCharArray();
            for (int i = 0; i < lenWord; i++) {
                if (i >= charsAnswer.length) break;
                if (word.charAt(i) != charsAnswer[i]) charsAnswer[i] = '#';
            }
            StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
            for (int i = comment.length(); i < 15; i++) comment.append("#");
            System.out.println(comment);
        }
        while (true);
    }
}




