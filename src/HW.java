import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

import com.google.gson.Gson;


public class HW {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {

        Pizza pizza = new Pizza();
        pizza.dough = new Dough();
        pizza.filling = "hawaii";
        pizza.dough.size = "30";
        pizza.dough.type = "classic";

        Gson gson = new Gson();

        ObjectOutputStream outputstream = new ObjectOutputStream(new FileOutputStream("pizza.serialize"));
        outputstream.writeObject(pizza);
        outputstream.close();

        File file = new File("pizza.json");

        String jsonString = gson.toJson(pizza);
        Files.write(Paths.get("pizza.json"), jsonString.getBytes());

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("pizza.serialize"));
        Pizza pizzaResulted = (Pizza) inputStream.readObject();
        inputStream.close();
        jsonString = new String(Files.readAllBytes(Paths.get("pizza.json")),StandardCharsets.UTF_8);
        Pizza pizzaResulted1 = gson.fromJson(jsonString,Pizza.class);
        System.out.println(pizzaResulted1);
    }
}
