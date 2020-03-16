package mc.assignment1;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class FreefallTable {

    private ArrayList<String> dataList;
    
    // constructor
    public FreefallTable() {
    
        // create the dataList object
        this.dataList = new ArrayList<String>();
        
    }
    
    
    public int loadCSV() {
        String fileName;
        
        System.out.println("please enter filename of CSV file: ");
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
    
    public void calculateFreefall() {
    
        String rowString;
        String[] valueStrings;
        String row;
        
        //variables
        double mass_kg;
        double drag_k;
        double[] m = {0,0,0,0,0,0,0,0,0,0};
        double[] k = {0,0,0,0,0,0,0,0,0,0};
        double dt = 2;
        double tot_t = 20;
        double t0 = 0;
        double v0 = 0;
       	double[] v_a = {0,0,0,0,0,0,0,0,0,0,0};
       	double[] t_a = {0,0,0,0,0,0,0,0,0,0,0};
  
        int i;
        int numRows = this.dataList.size();
        
        for(i=0; i<numRows; i++){
            rowString = dataList.get(i);
            valueStrings = rowString.split(",");
            if(valueStrings.length>1){
                mass_kg = Double.parseDouble(valueStrings[0]);
                drag_k = Double.parseDouble(valueStrings[1]);
                m[i] = mass_kg;
                k[i] = drag_k;
                }else{
                System.out.println("There is not enough data...");
             }
          }
         
         int a;
         int c = 0; 
         while(c<numRows){
            int b = 0;
            System.out.println("The table for:"+ m[c]+"kg");
            for(a=0; a<tot_t/dt;a++){
                v_a[b+1] = v_a[b]+((9.81-(k[c]*v_a[b])/m[c])*dt);
                t_a[b+1] = t_a[b]+dt;
                System.out.print(t_a[b]+"\t");
                System.out.println(v_a[b]);
                b++;
             }
             c++;
         }
  	      
    }
 
    public void clearTable() {
        this.dataList.clear();    
    }
    
    public void insertTableRow(String row) {
        this.dataList.add(row);
    }
}
