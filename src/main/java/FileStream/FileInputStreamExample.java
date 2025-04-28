package FileStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {

    public void read(){
        try {
            String fileName = "test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            fis.close();
            System.out.println();
        }catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    //    Посчитать количество символов в файле
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
        fos.write("Hello german it's potok data 123".getBytes());
    }
}
