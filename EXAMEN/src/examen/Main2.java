package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
    String arxiu = "C:\\temp\\vehicles.csv";
    String arxiuLog = "C:\\temp\\EXAMEN.log";
    String lector2;
    String [] linea;
    
    List<Vehicle> vehicles = new ArrayList<>();
    
    LlegeixArxiu(arxiu,vehicles,arxiuLog);    
    }
    
    public static void LlegeixArxiu(String arxiu, List<Vehicle> vehicles,String arxiuLog)throws IOException, NumberFormatException, IllegalArgumentException{
        String lector2;
        String[] linea;
        int precio = 0;
        int precio2 = 0;
        
        try(BufferedReader lector = new BufferedReader(new FileReader(arxiu));
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arxiuLog))){  
            while((lector2 = lector.readLine()) != null){
                try{
                    if (!(lector2.isEmpty() || lector2.startsWith("#"))) {
                        linea = lector2.split(",");
                        if(Integer.parseInt(linea[4]) >= 15000){
                            precio++;
                        }
                        vehicles.add(new Vehicle(linea[0],linea[1],linea[2],Integer.parseInt(linea[3]),Integer.parseInt(linea[4])));
                    }
                } catch (NumberFormatException e) {
                    System.err.println("NumberExcepcion: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("IllegalArgument: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Exception" + e.getMessage());
                }
            }
            System.out.println("Vehicles amb preu major de 15000 EUR :" + precio);
            for(Vehicle v : vehicles){
                precio2 += v.getPreu();
            }
            precio2 = precio2/vehicles.size();
            
            System.out.println("Preu mitja: " + precio2);
            System.out.println("Més car: " + vehicles.stream().max((a,b) -> Double.compare(a.getPreu(),b.getPreu())));
            System.out.println("Més barat: " + vehicles.stream().min((a,b) -> Double.compare(a.getPreu(),b.getPreu())));

            
        }catch(IOException e){
            System.err.println("Exception" + e.toString());
        }
    }
}

