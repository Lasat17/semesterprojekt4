package dk.sdu.mmmi.cbse.commonmap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;


public class Map {
    private String texturePath;
    private TextureRegion backgroundTexture;
    private java.util.Map<ArrayList<Room>,Integer> rooms;


    public Map(String t) {
        texturePath = t;
        constructRooms();
    }

    private void constructRooms(){

        for (int i = 0; i < 4; i++) {
            Room One = new Room();
            ArrayList<Room> Room = new ArrayList<>();
            Room.add(One);
            rooms.put(Room,i);
        }

    }

    private void renderBackground(){
        backgroundTexture = new TextureRegion(new Texture(texturePath));
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(backgroundTexture,0,0);
        batch.end();
    }






}
