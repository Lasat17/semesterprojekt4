/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.commonweapon;

/**
 *
 * @author Obel
 */
public class CommonWeapon
{

    private final String name;
    private final int tier;

    public CommonWeapon(String name, int Lock)
    {
        this.name = name;
        this.tier = Lock;
    }

    public String getName()
    {
        return name;
    }

    public int getTier()
    {
        return tier;
    }
}
