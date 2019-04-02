package services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.events.MapChangeEvent;
import dk.sdu.mmmi.cbse.common.services.IGameMap;
import dk.sdu.mmmi.cbse.common.services.IGetMapProcessingService;
import dk.sdu.mmmi.cbse.common.services.IProcessingService;
import dk.sdu.mmmi.cbse.commonmap.GameMap;

public class MapProcessingService implements IProcessingService, IGetMapProcessingService {
    GameMap gameMap;

    @Override
    public IGameMap getMap(){
        return this.gameMap;
    }

    @Override
    public void process(GameData gameData, World world) {
            if(!world.mapExists()){
                gameMap = new GameMap(1);
                MapChangeEvent event = new MapChangeEvent(gameMap);
                gameData.addEvent(event);
            }

            //if player collides with door/room etc. change room/level


    }

    @Override
    public IProcessingService newInstanceOf() {
        return this;
    }
}
