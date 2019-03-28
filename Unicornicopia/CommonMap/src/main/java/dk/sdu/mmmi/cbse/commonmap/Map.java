package dk.sdu.mmmi.cbse.commonmap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import dk.sdu.mmmi.cbse.common.data.Entity;


public class Map extends Entity {
    private int level;
    private String texturePath;
    private TextureRegion backgroundTexture;
    private java.util.Map<Room,Integer> rooms;


    public Map(int level) {
        this.level = level;
        texturePath = setBackgroundTexture(level);
        backgroundTexture = new TextureRegion(new Texture(texturePath));
        constructRooms(level);
        constructPortal(level);
    }

    private void constructRooms(int mapLevel){
        switch (mapLevel){
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            default :
        }
    }

    private void constructPortal(int mapLevel){
        switch (mapLevel){
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            default :
        }
    }

/*
    Move render responsibility to world/game

    private void renderBackground(){
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(backgroundTexture,0,0);
        batch.end();
    }

    */

    private String setBackgroundTexture(int mapLevel){
        if(mapLevel == 1){
            return "levelone";
        }else if(mapLevel == 2){
            return "leveltwo";
        }else if(mapLevel == 3) {
            return "levelthree";
        }else if(mapLevel == 4) {
            return "levelfour";
        }

        return "levelone";
    }






}
