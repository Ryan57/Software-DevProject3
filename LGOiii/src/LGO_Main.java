import java.io.*;
import java.util.ArrayList;

/**
 * Created by Ryan on 10/22/2014.
 */
public class LGO_Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader file;
    static String fileLocation;
    static String command;
    static EventManager em;
    static OlympianManager om;
    static TeamManager tm;
    static ArrayList<Olympian> olympians;

    public static void showHelp(){

        System.out.println("******** LGO HELP ******\n*");
        System.out.println("* Arguments  -- argument details");
        System.out.println("* events e --list day\'s events.");
        System.out.println("* olympians o --list day\'s olympians.");
        System.out.println("* help h --display this help message");
        System.out.println("* teams t --List the days teams as well as their record");
        System.out.println("* quit q --exit the program");
        System.out.println("*\n*************************************");

    }//..

    public static void processCommand() throws IOException{
        command = in.readLine();
        command.toLowerCase();

        if(command.equals("help") || command.equals("h")){
            showHelp();
        }else if(command.equals("quit") || command.equals("q")){
            System.exit(0);
        }else if(command.equals("olympians") || command.equals("o")){
            showOlympians();
        }else if(command.equals("events") || command.equals("e")){
            showEvents();
        }else if(command.equals("teams") || command.equals("t")){
            //showTeams();
        }else{
            showHelp();
        }

    }//..

    public static void showEvents() {

        Event event[] = em.getEvent();

        System.out.println("******* Events *******");
        for(int i =0; i < event.length; i++){
            System.out.println(event[i].name+"\n");
        }
    }//..

    public static void showOlympians(){

        System.out.println("******* Olympians ********\n");
       for(Olympian o : olympians){
           System.out.println(o.name+", "+o.sex+", "+o.age);
       }
    }//...

    public static void main(String[] args) {
        if (args.length < 1) {// handle non-existant argument
            System.out.println("You must supply of .lgoo file location");
            System.exit(1);
        }else {
            try{


                fileLocation = args[0];
                file = new BufferedReader(new FileReader(new File(fileLocation)));
                em = new EventManager();
                om = new OlympianManager(file);
                olympians = om.getOlympians();
                tm = new TeamManager(olympians);


                System.out.println("******* LGO ********\n");

                while(true) {
                    System.out.print("Enter Command: ");
                    processCommand();
                }

            }catch (FileNotFoundException fnfe){// handle invalid argument
                fnfe.printStackTrace();
                System.out.println("Cannot locate file at location "+fileLocation);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Error: internal error");
            }
        }
    }//..


}// end Class LGO_Main
