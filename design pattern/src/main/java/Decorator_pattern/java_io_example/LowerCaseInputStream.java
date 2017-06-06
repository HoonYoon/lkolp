package Decorator_pattern.java_io_example;

import java.io.*;

/**
 * Created by guillermo on 04/06/17.
 * change! Decorator_pattern.java_io_example
 */
public class LowerCaseInputStream extends FilterInputStream {


    protected LowerCaseInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int read() throws IOException {
        int c = super.read();
        return (c == -1? c : Character.toLowerCase(c));
    }

    public int read(byte[] b, int offset, int len) throws IOException {
        int result = super.read(b, offset, len);
        for (int i = offset; i <offset+result ; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }

        return result;
    }


    public static void main(String[] args) throws IOException {

        int c;
        try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("text.txt")))){
            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
