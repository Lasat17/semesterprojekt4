package dk.sdu.mmmi.cbse.commonmap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import dk.sdu.mmmi.cbse.common.Interfaces.IGameMap;


public class GameMap implements IGameMap {
    private int level;
    private String texturePath;
    private TextureRegion backgroundTexture;
    private java.util.Map<Room,Integer> rooms;


    public GameMap(int level) {
        this.level = level;
        texturePath = getBackgroundTexturePath(level);
        backgroundTexture = new TextureRegion(new Texture(texturePath));
        constructRooms(level);
        constructPortal(level);
    }

    @Override
    public void constructRooms(int mapLevel){
        switch (mapLevel){
            case 1 :
                Room room1 = new Room();
                rooms.putIfAbsent(room1,1);
            case 2 :
                Room room2 = new Room();
                rooms.put(room2,1);
            case 3 :
            case 4 :
            default :
        }
    }

    public void constructPortal(int mapLevel){
        switch (mapLevel){
            case 1 :
                Portal portalOne = new Portal(2);
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

    @Override
    public String getBackgroundTexturePath(int mapLevel){
        if(mapLevel == 1){
            return "Unicornicopia\\assets\\level_1.png";
        }else if(mapLevel == 2){
            return "Unicornicopia\\assets\\level_2.png";
        }else if(mapLevel == 3) {
            return "levelthree";
        }else if(mapLevel == 4) {
            return "levelfour";
        }

        return "levelone";
    }

    @Override
    public int getLevel() {
        return this.level;
    }


}
