package moskvichevhomeworkfour;
import java.util.Random;
import java.util.Scanner;
public class MainHomeWorkFour {
    public static int t;
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    //Ячейки поля
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    //Тест программы. Можно запускать первый тест программы.
    //Основной игровой цикл. Игровой цикл состоит из последовательного вызова ходов человек-компьютер-человек-компьютер
    // -…до тех пор, пока не заполнится игровое поле или не выиграет один из участников.t

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }


    //Проверка победы. Необходимо проверить все выигрышные комбинации. Если хотя бы одна будет найдена, вернуть true.
    // В приведённом ниже варианте производится проверка всех возможных комбинаций с помощью 8 условий, для поля 3х3
    // такой подход может быть оправдан. Если размер поля или длину выигрышной серии можно будет увеличить, лучше найти
    // другой вариант проверки победы, например, через циклы(для поля 4х4 придется написать уже не 8, а 24 условия).
    public static boolean checkWin(char symb) {

        for (int i = 0; i < 3; i++)
            if ((map[i][0] == symb && map[i][1] == symb &&
                    map[i][2] == symb) ||
                    (map[0][i] == symb && map[1][i] == symb &&
                            map[2][i] == symb))
                return true;
        if ((map[0][0] == symb && map[1][1] == symb &&
                map[2][2] == symb) ||
                (map[2][0] == symb && map[1][1] == symb &&
                        map[0][2] == symb))
            return true;
        return false;
    }



        /*if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;

         */



    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    // Ход компьютера. Для реализации хода компьютера достаточно чуть изменить метод хода игрока,
    // добавив туда генератор случайных чисел
    public static void aiTurn() {
        int x, y;

        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);

            int k = 0; // счетчик
            for(int i = 0; i < SIZE; i++) {
                if (map[0][i] == DOT_X) {
                    k++;
                }
            }
            if (k == 2) {
                for (int j=0; j<SIZE ; j++){
                    if (map[0][j] == DOT_EMPTY) {
                        x = j;
                        y = 0;
                    }
                }
            }
            int q = 0; // счетчик
            for(int i = 0; i < SIZE; i++) {
                if (map[1][i] == DOT_X)
                    q++;
            }
            if (q == 2) {
                for (int j=0; j<SIZE ; j++){
                    if (map[1][j] == DOT_EMPTY) {
                        x = j;
                        y = 1;
                    }
                }
            }
            int w = 0; // счетчик
            for(int i = 0; i < SIZE; i++) {
                if (map[2][i] == DOT_X)
                    w++;
            }
            if (w == 2) {
                for (int j=0; j<SIZE ; j++){
                    if (map[2][j] == DOT_EMPTY) {
                        x = j;
                        y = 2;
                    }
                }
            }

            int v = 0; // счетчик
            for(int i = 0; i < SIZE; i++) {
                if (map[i][0] == DOT_X)
                    v++;
            }
            if (v == 2) {
                for (int j=0; j<SIZE ; j++){
                    if (map[j][0] == DOT_EMPTY) {
                        x = 0;
                        y = j;
                    }
                }
            }
            int e = 0; // счетчик
            for(int i = 0; i < SIZE; i++) {
                if (map[i][1] == DOT_X)
                    e++;
            }
            if (e == 2) {
                for (int j=0; j<SIZE ; j++){
                    if (map[j][1] == DOT_EMPTY) {
                        x = 1;
                        y = j;
                    }
                }
            }
            int r = 0; // счетчик
            for(int i = 0; i < SIZE; i++) {
                if (map[i][2] == DOT_X)
                    r++;
            }
            if (r == 2) {
                for (int j=0; j<SIZE ; j++){
                    if (map[j][2] == DOT_EMPTY) {
                        x = 2;
                        y = j;
                    }
                }
            }
            //диагональ 1
            int f = 0; // счетчик
            for(int i = 0; i<SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (i == j) {
                        if (map[i][j] == DOT_X)
                            f++;
                    }
                }
            }
            if (f == 2) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (i == j) {
                            if (map[j][i] == DOT_EMPTY) {
                                x = j;
                                y = i;
                            }
                        }
                    }
                }
            }
            //диагональ 2
            int h = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if ( j == SIZE - 1 - i) {
                        if (map[i][j] == DOT_X)
                            h++;
                    }
                }
            }
            if (h == 2) {
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if ( j == SIZE - 1 - i) {
                            if (map[i][j] == DOT_EMPTY) {
                                x = j;
                                y = i;
                            }
                        }
                    }
                }
            }

        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;

    }

    // Ход человека. Теперь можно сделать метод, отвечающий за ход человека-игрока.
    public static void humanTurn(){

        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;

    }
    //Проверка ячеек. Метод isCellValid() проверяет возможность установки фишки в указанную ячейку.
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    //Инициализация поля. При запуске программы необходимо инициализировать поле и заполнить все его ячейки символом,
    // обозначающим пустое поле.
    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    //Вывод поля в консоль. Проинициализированное поле готово. Теперь необходимо вывести его в консоль.
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}