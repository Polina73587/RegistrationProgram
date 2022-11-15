import java.io.*;

public class WriteObject implements Serializable {
    public static void main(String[] args) {


        FileOutputStream fileOutputStream;

        {
            try {
                fileOutputStream = new FileOutputStream("people.bin");

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        ObjectOutputStream objectOutputStream;

        {
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

}
