import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

/**
 * Created by djg03 on 9/18/17.git
 */
public class Customers {
    public static void main(String[] args) {

        String txtFile = "/Users/djg03/Documents/Customers.txt";
        BufferedReader br = null;
        String line = "";
        String txtSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(txtFile));
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                /*String[] name = line.split(txtSplitBy);
                String[] address = line.split(txtSplitBy);
                String[] city = line.split(txtSplitBy);
                String[] state = line.split(txtSplitBy);
                String[] zipcode = line.split(txtSplitBy);*/

                System.out.println(
                        "Name [name=" + details[0] + " , address=" + details[1] + ", city=" + details[2] + ", state=" + details[3]
                                + ", zipcode=" + details [4] +"]");
            }
        } catch (FileSystemNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();


                }

            }

        }

    }
}

