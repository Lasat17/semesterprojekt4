package dk.sdu.mmmi.cbse.common.Interfaces;

public interface IGameMap {

    void constructRooms(int mapLevel);

    String getBackgroundTexturePath(int mapLevel);

    int getLevel();
}
