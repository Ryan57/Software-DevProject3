import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryan on 10/26/2014.
 */
public class TeamManager {

    ArrayList<Olympian> olympians;
    ArrayList<Team> teams = new ArrayList<Team>(); //Allows for the number of olympians in the array-list to vary in size
    Olympian males[] = new Olympian[50],
             females[] = new Olympian[50];
    int numOlympians, numTeams;

    TeamManager(ArrayList<Olympian> olympians) {
        this.olympians = olympians;

        numOlympians = olympians.size();
        numTeams = (int)(numOlympians*.5); //Creates a number of teams equal to half the number of olympians, this creates the perfect number of teams to hold 2 olympians each




    }//..

}// end Class TeamManager
