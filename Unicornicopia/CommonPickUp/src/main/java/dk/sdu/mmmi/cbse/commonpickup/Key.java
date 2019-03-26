/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.commonpickup;

/**
 *
 * @author Obel
 */
public class Key
{
    private final String name;
    private final int Lock;

    public Key(String name, int Lock)
    {
        this.name = name;
        this.Lock = Lock;
    }

    public String getName()
    {
        return name;
    }

    public int getLock()
    {
        return Lock;
    }
    
}
