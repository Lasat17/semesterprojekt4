package dk.sdu.mmmi.cbse.commonmap;


import java.util.ArrayList;
import java.util.Random;

public class Room{
    int id;
    ArrayList<Door> door = new ArrayList<>();
    ArrayList<Portal> portals = new ArrayList<>();

    public Room(){
        Random random = new Random();
        id = random.nextInt(2000);
    }





}





