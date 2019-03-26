/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.player;

import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.commonpickup.Elixir;
import java.util.ArrayList;

/**
 *
 * @author LavanSathiyaseelan
 */
public class Player extends Entity implements IGamePluginService
{

    private boolean left;
    private boolean right;
    private boolean up;

    private final int MAX_BULLETS = 4;
    private ArrayList<Bullet> bullets;

    private float maxSpeed;
    private float acceleration;
    private float deceleration;
    private float acceleratingTimer;
    private float defence;
    private int health;

    private ArrayList<Object> inventory;

    public Player(ArrayList<Bullet> bullets)
    {
        this.bullets = bullets;
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

    public void useElixir(Elixir elixir)
    {
        switch (elixir.getType())
        {
            case "health":
                        health =+ (int)elixir.getValue();
                break;

            case "defence":
                defence = defence * (1 - elixir.getValue());
                break;

            case "movement":
                maxSpeed = maxSpeed * elixir.getValue();
                acceleration = acceleration * elixir.getValue();
                break;
        }
    }


    public void pickUpItem(Object Item)
    {
        inventory.add(Item);
    }


    public void decreaseHealth(int damage)
    {
        health = (int) (health - (damage * defence));
    }

    public void setLeft(boolean b)
    {
        left = b;
    }

    public void setRight(boolean b)
    {
        right = b;
    }

    public void setUp(boolean b)
    {
        up = b;
    }

    public void shoot()
    {
        //Checks for active number of bullets, if the number is equal to MAX_BULLETS, nothing will happen.
        //Otherwise a bullet will be added to the bullets arrayList
        if (bullets.size() == MAX_BULLETS)
        {
            return;
        }
        bullets.add(new Bullet(x, y, radians));
    }

    public void update(float dt)
    {

        // turning
        if (left)
        {
            radians += rotationSpeed * dt;
        }
        else if (right)
        {
            radians -= rotationSpeed * dt;
        }

        // accelerating
        if (up)
        {
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;
            acceleratingTimer += dt;
            if (acceleratingTimer > 0.1f)
            {
                acceleratingTimer = 0;
            }
        }
        else
        {
            acceleratingTimer = 0;
        }

        // deceleration
        float vec = (float) Math.sqrt(dx * dx + dy * dy);
        if (vec > 0 && !up)
        {
            dx -= (dx / vec) * deceleration * dt;
            dy -= (dy / vec) * deceleration * dt;
        }
        if (vec > maxSpeed)
        {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        // set position
        x += dx * dt;
        y += dy * dt;
    }

    @Override
    public void start(GameData gameData, World world)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop(GameData gameData, World world)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
