import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CsvHelper {

    public static void save(AppData appData, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(String.join(";", appData.getHeader()));
            writer.write("\n");
            for (int i = 0; i < appData.getData().length; i++) {
                writer.write(String.join(";", toStringArray(appData.getData()[i])));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData read(String file) {
        AppData result = new AppData();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String d = reader.readLine();
            result.setHeader(d.split(";"));
            ArrayList<String[]> lines = new ArrayList();
            while ((d = reader.readLine()) != null) {
                String[] line = d.split(";");
                lines.add(line);
            }
            int[][] data = new int[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                data[i] = Arrays.stream(lines.get(i)).mapToInt(Integer::parseInt).toArray();
            }
            result.setData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int item : ints) {
                System.out.print(item + ",");
            }
            System.out.println();
        }

    }

    private static String[] toStringArray(int[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] + "";
        }
        return result;
    }

}
