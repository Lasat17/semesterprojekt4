package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;

public interface IMapProcessingService extends IGamePluginService {

    void process(GameData gameData);
}
