package dk.sdu.mmmi.cbse;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.events.MapChangeEvent;
import dk.sdu.mmmi.cbse.common.services.IGetMapProcessingService;
import dk.sdu.mmmi.cbse.common.services.IProcessingService;
import dk.sdu.mmmi.cbse.core.managers.GameInputProcessor;
import services.MapProcessingService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game implements ApplicationListener {

    private static OrthographicCamera cam;
    private ShapeRenderer sr;
    private final GameData gameData = new GameData();
    private static World world = new World();

    private List<IProcessingService> processingServiceList = new CopyOnWriteArrayList<>();
    private List<IGetMapProcessingService> getMapProcessingServices = new CopyOnWriteArrayList();

    public Game(){
        init();
        System.out.println(world.getGameMap()+ "game map");
    }





    private void init() {

        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Asteroids";
        cfg.width = 800;
        cfg.height = 600;
        cfg.useGL30 = false;
        cfg.resizable = false;

        new LwjglApplication(this, cfg);

        //add all necessary processors to the list of processors

        processingServiceList.add(new MapProcessingService());



    }

    @Override
    public void create() {
        gameData.setDisplayWidth(Gdx.graphics.getWidth());
        gameData.setDisplayHeight(Gdx.graphics.getHeight());

        cam = new OrthographicCamera(gameData.getDisplayWidth(), gameData.getDisplayHeight());
        cam.translate(gameData.getDisplayWidth() / 2, gameData.getDisplayHeight() / 2);
        cam.update();

        sr = new ShapeRenderer();

        Gdx.input.setInputProcessor(new GameInputProcessor(gameData));

    }



    
    @Override
    public void render() {

//        String filename = world.getGameMap().getBackgroundTexturePath(world.getGameMap().getLevel());
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("Unicornicopia\\Unicornicopia\\assets\\test.jpg"));     
        }catch(IOException e){
            System.out.println("background image not found" + e );
        }


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameData.setDelta(Gdx.graphics.getDeltaTime());
        gameData.getKeys().update();

        update();
        draw();
    }

    public void setGameMap(){
        for (IProcessingService mapProcessor : processingServiceList) {
            mapProcessor.process(gameData,world);
            for (IGetMapProcessingService mapProcessor2 : getMapProcessingServices) {
                world.setGameMap(mapProcessor2.getMap());
            }
        }
    }

    private void updateMap(){
        MapChangeEvent mapChange;
        for (Event event : gameData.getEvents()) {
            if(event.equals(MapChangeEvent.class)){
                mapChange = (MapChangeEvent) event;
                setGameMap();
                gameData.removeEvent(mapChange);
            }

        }
    }

    private void update() {
        // Update
        updateMap();
    }

    private void draw() {
        for (Entity entity : world.getEntities()) {
            sr.setColor(1, 1, 1, 1);

            sr.begin(ShapeRenderer.ShapeType.Line);
            /*
            float[] shapex = entity.getShapeX();
            float[] shapey = entity.getShapeY();
            
            for (int i = 0, j = shapex.length - 1;
                    i < shapex.length;
                    j = i++) {

                sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
            }
            */
            sr.end();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

    public void addProcessingService(IProcessingService processingService){
        processingServiceList.add(processingService);
    }

    public void removeProcessingService(IProcessingService processingService){
        processingServiceList.remove(processingService);
    }


}
