package moskvichevhomewortwo;

public class MainHomeWorkTwo {
    //метод к заданию №6, вызов метода в main
    public static boolean number_six(){
        int[] a = {10, 15, 25, 50};
        int sum_L = a[0];
        int sum_R = a[a.length - 1];
        int i = 1;
        int L=0, R=0;
        while ((sum_L != sum_R) || (i !=(a.length-1))) {
            if (sum_L < sum_R) {
                sum_L += a[i];
                L++;
            } else {
                sum_R += a[a.length - i];
                R++;
            }
            i++;
        }
        if(sum_L == sum_R) {
            for (int j = 0; j < (L+1); j++) {
                System.out.print(a[j] + "\t");
            }
            System.out.print("||" + "\t");
            for (int j = (a.length-1-R); j < a.length; j++) {
                System.out.print(a[j] + "\t");
            }
            return true;
        } else return false;
    }
    //метод к заданию №7, вызов метода в main
    public static void number_seven(int n){
        int[] arr = {10, 20, 30, 40, 50};
        int m;//временная переменная затирающегося элемента
        for (int j = 0; j < arr.length; j++)
            System.out.print(arr[j] + "\t");//печать массива до преобразования
        for (int j = 1; j < (n + 1); j++) {
            m = arr[arr.length - 1];
            for (int i = 1; i < arr.length; i++) {
                arr[arr.length - i] = arr[arr.length - (i + 1)];
            }
            arr[0] = m;
        }
        System.out.println("");
        for (int j = 0; j < arr.length; j++)
            System.out.print(arr[j] + "\t");//печать массива после преобразования
    }
    public static void main(String[] args) {
        //1
        System.out.println("Задание 1: ");
        int[] arr_one = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr_one.length; i++){
            if(arr_one[i]==0){
                arr_one[i]=1;
            } else {
                arr_one[i]=0;
            }
        }
        for (int i = 0; i < arr_one.length; i++){
            System.out.print(arr_one[i]+"\t"); // массив после корректировки
        }
        System.out.println();
        //2
        System.out.println("Задание 2: ");
        int arr_two[] = new int[8];
        arr_two[0]=0;
        for (int i = 1; i < arr_two.length; i++){
            arr_two[i] = arr_two[i-1]+3;
        }
        for (int i = 0; i < arr_two.length; i++){
            System.out.print(arr_two[i]+"\t"); // массив после корректировки
        }
        System.out.println();
        //3
        System.out.println("Задание 3: ");
        int[] arr_fhree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr_fhree.length; i++){
            if(arr_fhree[i]<6){
                arr_fhree[i]*= 2;
            }
        }
        for (int i = 0; i < arr_fhree.length; i++){
            System.out.print(arr_fhree[i]+"\t"); // массив после корректировки

        }
        System.out.println();
        //4
        System.out.println("Задание 4: ");
        int arr_four[][] = new int[5][5];
        for (int i = 0; i < arr_four.length; i++){
            for (int j = 0; j < arr_four[i].length; j++){
                if(i == j || j ==arr_four.length -1 -i){
                    arr_four[i][j] = 1;
                }
             System.out.print(arr_four[i][j] + " ");
            }
            System.out.println();
        }

        //5
        System.out.println("Задание 5: ");
        int[] arr_five = {100, 30, 200, 40, 500};
        int min = arr_five[0];
        int max = arr_five[0];
        for(int i=1; i<arr_five.length; i++) {
            if (arr_five[i] < min) {
                min = arr_five[i];
            }
            if (arr_five[i] > max) {
                max = arr_five[i];
            }
        }
        System.out.println("Значение min = "+min);
        System.out.println("Значение max = "+max);

        //6
        System.out.println("Задание 6: ");
        System.out.println(number_six());
        //7. ****
        System.out.println("Задание 7: ");
        number_seven(2);// - смещение на n=2 позиций
    }
}
