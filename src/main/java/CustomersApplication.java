import com.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.codehaus.jackson.map.ObjectMapper;


/**
 * Created by djg03 on 9/18/17.git
 */
public class CustomersApplication {
    public static void main(String[] args) {

        String txtFile = "/Users/djg03/Documents/customers.csv";
        BufferedReader br = null;
        String line;
        String txtSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(txtFile));
            List<Customer> customerList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] details = line.split(txtSplitBy);
                Customer customer = new Customer();
                customer.setName(details[0]);
                customer.setAddress(details[1]);
                customer.setCity(details[2]);
                customer.setState(details[3]);
                customer.setZipcode(details[4]);
                customerList.add(customer);
            }
            ObjectMapper mapper = new ObjectMapper();

            List<JSONObject>list= new ArrayList<>();

            for(Customer customer: customerList) {
                System.out.println(
                        "Name [name=" + customer.getName() + " , address=" + customer.getAddress() + ", city=" + customer.getCity() + ", state=" + customer.getState()
                                + ", zipcode=" + customer.getZipcode() + "]");

                // POJO to Json string

                //String jsonString = mapper.writeValueAsString(customerList);
                //System.out.println(jsonString);

                // output string to file

                JSONObject obj = new JSONObject();
                obj.put("name", customer.getName());
                obj.put("address", customer.getAddress());
                obj.put("city", customer.getCity());
                obj.put("state", customer.getState());
                obj.put("zipcode", customer.getZipcode());


                list.add(obj);



            }
            try (FileWriter file = new FileWriter("test.json")) {

                file.write(list.toString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
             catch (FileSystemNotFoundException|IOException e) {
                e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();


                }

            }

        }

    }
}

