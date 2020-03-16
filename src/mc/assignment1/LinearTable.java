package mc.assignment1;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class LinearTable {

    private ArrayList<String> dataList;
    
    // constructor
    public LinearTable() {
    
        // create the dataList object
        this.dataList = new ArrayList<String>();
        
    }
    
    
    public int loadCSV() {
        String fileName;
        
        System.out.println("please enter filename of CSV file containing mass(g) and extension(mm): ");
        Scanner scan = new Scanner(System.in);
        fileName = scan.nextLine();
        
        this.clearTable();
        
        File file = new File(fileName);
        
        try{ 
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String data = inputStream.next();
                this.dataList.add(data);
            }
            inputStream.close();
        } catch(FileNotFoundException e){
            System.out.println("I am sorry that I could not find the file");
        }
        
        return this.dataList.size();
    }
    
    public int getNumRows() {
        return 0;
    }
    
    public void showTable(){
        int numRows = this.dataList.size();
        int i;
        for(i=0; i<numRows; i++){
            System.out.println(this.dataList.get(i));
        }
    }
    
    public double[] calculateLinear() {
    
        String rowString;
        String[] valueStrings;
        String row;
        double mass_g;
        double extension_mm;
        double x = 0;
        double y = 0;
        double sumx = 0;
        double sumy = 0;
        double sumx2 = 0;
        double sumy2 = 0;
        double sumxy = 0;
        double a0 = 0;
        double a1 = 0;
        double r2 = 0;
        double x_bar = 0;
        double y_bar = 0;
        int i;
        int numRows = this.dataList.size();
        int nx = this.dataList.size();
        int ny = this.dataList.size();
        
        
         for(i=0; i<numRows; i++){
            rowString = this.dataList.get(i);
            valueStrings = rowString.split(",");
            if(valueStrings.length>1){
                mass_g = Double.parseDouble(valueStrings[0]);
                extension_mm = Double.parseDouble(valueStrings[1]);
                y = (mass_g/1000)*9.81;
                x = extension_mm/1000;
                }else{
                System.out.println("There is not enough data...");
                }
                sumx = sumx + x;
                sumy = sumy + y;
                sumx2 = sumx2 + Math.pow(x,2);
                sumy2 = sumy2 + Math.pow(y,2);
                sumxy = sumxy + x*y;
            }
        x_bar = sumx/nx;
        y_bar = sumy/ny;
        a1 = ((nx*sumxy)-(sumx*sumy))/((nx*sumx2)-Math.pow(sumx,2));
        a0 = y_bar - (a1*x_bar);
        r2 = Math.pow((nx*sumxy - sumx*sumy),2)/((nx*sumx2-Math.pow(sumx,2))*(ny*sumy2-Math.pow(sumy,2)));
        
       
        double[] answers = new double[5];
        answers[0] = a0;
        answers[1] = a1;
        answers[2] = r2;
        answers[3] = sumx;
        answers[4] = sumy;
        return answers;
        
    }
    public void printResults(){
        double [] x=calculateLinear();
        System.out.print("a0 = ");
        System.out.println(x[0]);
        System.out.print("a1 =");
        System.out.println(x[1]);
        System.out.print("r2 =");
        System.out.println(x[2]);
        System.out.print("sumx =");
        System.out.println(x[3]);
        System.out.print("sumy =");
        System.out.println(x[4]);
       
    }
    public void clearTable() {
        this.dataList.clear();    
    }
    
    public void insertTableRow(String row) {
        this.dataList.add(row);
    }
}
