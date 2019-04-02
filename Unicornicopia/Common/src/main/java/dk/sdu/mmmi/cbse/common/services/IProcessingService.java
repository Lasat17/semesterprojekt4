package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IProcessingService {

    void process(GameData gameData, World world);

    IProcessingService newInstanceOf();

}
