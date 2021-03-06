package dk.sdu.mmmi.cbse.osgienemy;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.enemy.Enemy;
import dk.sdu.mmmi.cbse.common.services.IProcessingService;

public class EnemyPlugin implements IProcessingService {
    private String enemyID;

    public EnemyPlugin() {
    }

    public void start(GameData gameData, World world) {
        // Add entities to the world
        Entity enemy = createEnemy("Zombie");
        enemyID = world.addEntity(enemy);        
    }

    private Entity createEnemy(String enemyType) {
        Entity enemy = new Enemy();
        float deacceleration;
        float acceleration;
        float maxSpeed;
        float rotationSpeed;
        float x;
        float y;
        float radians;

        switch(enemyType){
            case "Troll": 
                deacceleration = 500;
                acceleration = 100;
                maxSpeed = 100;
                rotationSpeed = 5;
                x = 50;
                y = 50;
                radians = 3.1415f / 2;
                enemy.add(new LifePart(80));
                enemy.setRadius(4);
                enemy.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
                enemy.add(new PositionPart(x, y, radians));
                break;
            case "Wraith":
                deacceleration = 500;
                acceleration = 150;
                maxSpeed = 200;
                rotationSpeed = 5;
                x = 50;
                y = 50;
                radians = 3.1415f / 2;
                enemy.add(new LifePart(50));
                enemy.setRadius(4);
                enemy.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
                enemy.add(new PositionPart(x, y, radians));
                break;
            case "Zombie":
                deacceleration = 500;
                acceleration = 50;
                maxSpeed = 175;
                rotationSpeed = 5;
                x = 50;
                y = 50;
                radians = 3.1415f / 2;
                enemy.add(new LifePart(30));
                enemy.setRadius(4);
                enemy.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
                enemy.add(new PositionPart(x, y, radians));
                break;
            default:
                //Boss
                deacceleration = 500;
                acceleration = 150;
                maxSpeed = 200;
                rotationSpeed = 5;
                x = 50;
                y = 50;
                radians = 3.1415f / 2;
                enemy.add(new LifePart(500));
                enemy.setRadius(4);
                enemy.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
                enemy.add(new PositionPart(x, y, radians));
                break;
        }
        
        return enemy;
    }

    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemyID);
    }

    @Override
    public void process(GameData gameData, World world) {

    }
}
