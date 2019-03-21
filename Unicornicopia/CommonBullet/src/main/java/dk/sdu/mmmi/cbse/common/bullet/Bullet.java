package dk.sdu.mmmi.cbse.common.bullet;

import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.common.data.Entity;

/**
 *
 * @author corfixen
 */
public class Bullet extends Entity {
        
    private float lifeTime;
    private float lifeTimer;
    
    private boolean remove;
    
    public Bullet(float x, float y, float radians) {
        this.x = x;
        this.y = y;
        this.radians = radians;
        
        float speed = 350; 
        dx = MathUtils.sin(radians) * speed;
        dy = MathUtils.cos(radians) * speed;
        
        width = height = 2;
        lifeTimer = 0;
        lifeTime = 1;
             
             
    }
    
    public boolean shouldRemove() { 
        return remove;
    } 
    
    public void update(float dt){
        y += dx * dt;
        x += dy * dt;
        

        lifeTimer += dt;
        if (lifeTimer > lifeTime) {
            remove = true;
        }
    }
}
