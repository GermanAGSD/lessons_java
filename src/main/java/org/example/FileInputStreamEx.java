package org.example;

import javax.crypto.spec.PSource;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileInputStreamEx {

    public void read() {
        try {
            String fileName = "test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            fis.close();
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    //    Посчитать количество цифр в файле
    public void qtyCount() throws IOException {
        FileInputStream fin = new FileInputStream("test.txt");
        int c;
        int count = 0;

        while ((c = fin.read()) != -1) {
            if (c >= '0' && c <= '9') { // если символ — цифра
                count++;
            }
        }

        fin.close();
        System.out.println(count);
    }

    public void write() throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");
        fos.write("Hello german it's potok data 123".getBytes("UTF-8"));
    }

    public void copyFileUsingStream() throws IOException {

        FileInputStream fis = new FileInputStream("test.txt");
        FileOutputStream fos = new FileOutputStream("testcopy.txt");
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }

    //    Перекодирование
    public void encoding(String source, String sourceEnc, String dest, String destEnc) throws IOException {
        Charset sEnc = Charset.forName(sourceEnc);
        Charset dEnc = Charset.forName(destEnc);

        try (Reader reader = new InputStreamReader(new FileInputStream(source), sEnc);
             Writer writer = new OutputStreamWriter(new FileOutputStream(dest), dEnc)) {

            char[] buffer = new char[1024];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }
        }
    }

    public String getReceipt() throws IOException {
        double total = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int quantity = Integer.parseInt(parts[1]);
                    double price = Double.parseDouble(parts[2]);
                    total += quantity * price;
                }
            }
        }
        System.out.println(total);
        return String.format("%.2f", total);
    }

    public void readAllLines() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("test.txt"), UTF_8);
            Scanner in = new Scanner(System.in);
            System.out.println("Введите номер строки в диапазоне 1.." + lines.size());
            int n = in.nextInt();
            System.out.println("Вот предсказание для вас:\n" + lines.get(n - 1));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
