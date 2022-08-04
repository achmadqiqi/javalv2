package Utilities;

import entities.Product;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import static com.sun.org.apache.xml.internal.security.Init.getResource;

public class FileServices {

    public static List<Product> readFileTxt(String filename){

        try {
            List<Product> data = new ArrayList<>();
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String lineData = scanner.nextLine();
                String [] splitter = lineData.split("/");
                Product product = new Product(splitter[0],splitter[1],
                        splitter[2],Double.parseDouble(splitter[3]));
                data.add(product);
            }
            return data;
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }



    public static void saveObjectToFile(Object object, String filename){
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public static Object readObjectFromFile(String filename){
        try {
            File file = new File(filename);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            return obj;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
