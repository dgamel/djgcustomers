import com.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by djg03 on 9/18/17.git
 */
public class CustomersApplication {
    public static void main(String[] args) {

        String txtFile = "/Users/djg03/Documents/customers.csv";
        BufferedReader br = null;
        String line = "";
        String txtSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(txtFile));
            List<Customer> customerList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                Customer customer = new Customer();
                customer.setName(details[0]);
                customer.setAddress(details[1]);
                customer.setCity(details[2]);
                customer.setState(details[3]);
                customer.setZipcode(details[4]);
                customerList.add(customer);
            }

            for(Customer customer: customerList){
                System.out.println(
                        "Name [name=" + customer.getName() + " , address=" + customer.getAddress() + ", city=" + customer.getCity() + ", state=" + customer.getCity()
                                + ", zipcode=" + customer.getZipcode() +"]");
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

