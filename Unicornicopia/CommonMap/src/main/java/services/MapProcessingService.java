package services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IMapProcessingService;
import dk.sdu.mmmi.cbse.commonmap.Map;

public class MapProcessingService implements IMapProcessingService {


    @Override
    public void process(GameData gameData) {
        //things to do while map is running, check for player collisions with doors/portals etc.
    }

    @Override
    public void start(GameData gameData, World world) {
        if(world.getEntities().contains(Map.class)){
            //do nothing, world already contains a map
        }else{
            world.addEntity(new Map(1));
        }

    }

    @Override
    public void stop(GameData gameData, World world) {
        if(world.getEntities().contains(Map.class)){
            Map mapToRemove = (Map) world.getEntities();
            world.removeMap(mapToRemove);
        }

    }
}
