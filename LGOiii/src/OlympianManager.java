import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class OlympianManager {

    BufferedReader file;
    ArrayList<Olympian> olympian = new ArrayList<Olympian>();


    OlympianManager(BufferedReader file){
        this.file = file;
        loadOlympians();
    }//..

    public void loadOlympians(){
        String line;
        try {
            while ( (line = file.readLine()) != null){
                if(!line.equals("LGOO")) {

                    String[] parse = line.split(","); //Splits up information when , is found so olympians can display multiple attributes of personal data
                    String name = parse[0];
                    Sex sex;
                    int age = Integer.parseInt(parse[2]);

                    if(parse[1].equals("M")) {
                        sex = Sex.MALE;
                    }else{
                        sex = Sex.FEMALE;
                    }
                    //System.out.println("Adding Olympian "+name+", "+sex+", "+age);
                    olympian.add(new Olympian(name,sex,age));
                }
            }
        } catch (IOException e) { //IOException e is a universal exception catcher
            e.printStackTrace(); //Prints out errors as well as the lines number on which the error occurred
        }

    }//..

    public ArrayList<Olympian> getOlympians(){
        return  olympian;
    }//..

}// end OlympianManager