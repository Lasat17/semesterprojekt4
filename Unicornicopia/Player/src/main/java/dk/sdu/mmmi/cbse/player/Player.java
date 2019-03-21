/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.player;

import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.ArrayList;

/**
 *
 * @author LavanSathiyaseelan
 */
public class Player extends Entity implements IGamePluginService{
    
        private boolean left;
	private boolean right;
	private boolean up;
        	
	private float maxSpeed;
	private float acceleration;
	private float deceleration;
	private float acceleratingTimer;
        private float defence;
        private int health;
        
        private ArrayList<Object> inventory;
        
        public Player() {
                
                defence = 1;
                health = 100;
            
                x = width / 2;
		y = height / 2;
		
		maxSpeed = 300;
		acceleration = 200;
		deceleration = 1250;

		radians = 3.1415f / 2;
		rotationSpeed = 5;
                
                
		
	}
        
        public void increaseDefence(Object Item){
            //defence = defence * (1 - Item.getDefenceValue());
        }
        
        public void pickUpItem(Object Item){
            inventory.add(Item);
        }
        
        public void increaseHealth(int healthBoost){
            health =+ healthBoost;
        }
        
        public void decreaseHealth(int damage){
            health = (int) (health - (damage * defence));
        }
        
        public void setLeft(boolean b) {
            left = b; 
        }
        
	public void setRight(boolean b) {
            right = b; 
        }
        
	public void setUp(boolean b) {
            up = b; 
        }
    public void update(float dt) {
		
		// turning
		if(left) {
			radians += rotationSpeed * dt;
		}
		else if(right) {
			radians -= rotationSpeed * dt;
		}
		
		// accelerating
		if(up) {
			dx += MathUtils.cos(radians) * acceleration * dt;
			dy += MathUtils.sin(radians) * acceleration * dt;
                        acceleratingTimer += dt;
                        if (acceleratingTimer > 0.1f) {
                            acceleratingTimer = 0;
                    } 
		} 
                else{
                    acceleratingTimer = 0;
                }
		
		// deceleration
		float vec = (float) Math.sqrt(dx * dx + dy * dy);
		if(vec > 0 && !up) {
			dx = 0;
			dy = 0;
		}
		if(vec > maxSpeed) {
			dx = (dx / vec) * maxSpeed;
			dy = (dy / vec) * maxSpeed;
		}
		
		// set position
		x += dx * dt;
		y += dy * dt;
    }

    @Override
    public void start(GameData gameData, World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop(GameData gameData, World world) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
