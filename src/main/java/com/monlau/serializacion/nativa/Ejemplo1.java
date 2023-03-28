package com.monlau.serializacion.nativa;

import com.monlau.serializacion.modelo.Producto;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejemplo1 {

    public static void main(String[] args) {
//        Producto prod = new Producto(1, "iPhon X", 300.75);
//        System.out.println(prod.toString());
//        System.out.println("Vamos a serializar el producto");
//        serializar(prod);

        Producto newProduct = null;
        newProduct = deserializar();
        System.out.println(newProduct.toString());
    }

    static void serializar(Producto p) {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(".\\Producto.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            System.out.println("El producto ha sido serializado en Producto.ser");
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra la ruta del fichero." + ex.getMessage());

        } catch (IOException ex) {
            System.out.println("Ha surgido un error serializando." + ex.getMessage());
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                System.out.println("Ha surgido un error cerrando el fichero." + ex.getMessage());
            }
        }
    }

    static Producto deserializar() {
        FileInputStream fileIn = null;
        Producto p = null; 
        try {
            fileIn = new FileInputStream(".\\Producto.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Producto) in.readObject();
            System.out.println("El producto ha sido serializado en Producto.ser");
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra la ruta del fichero." + ex.getMessage());

        } catch (IOException ex) {
            System.out.println("Ha surgido un error serializando." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Ha surgido un error deserializando" + ex.getMessage());
        } finally {
            try {
                fileIn.close();
            } catch (IOException ex) {
                System.out.println("Ha surgido un error cerrando el fichero." + ex.getMessage());
            }
            return p;
        }
        
    }
}
