import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[]  header = {"header1",  "header2", "header3", "header4"};
        int[][] data = {{11,22,33,44},{55,66,77,88},{99,11,22,33}};
        AppData appData = new AppData(header,data);
        System.out.println("Создали AppData");
        System.out.println(Arrays.toString(appData.getHeader()));
        Arrays.stream(appData.getData()).forEach(ints -> System.out.println(Arrays.toString(ints)));
        System.out.println("Сохраняем AppData");
        CsvHelper.save(appData, "D:/app/demo.txt");
        System.out.println("Сохранили AppData");
        AppData readData = CsvHelper.read("D:/app/demo.txt");
        System.out.println(Arrays.toString(readData.getHeader()));
        Arrays.stream(readData.getData()).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
