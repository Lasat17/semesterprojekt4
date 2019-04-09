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
public class Elixir
{

    private String type;
    private float value;

    public Elixir(String type, float value)
    {
        this.type = type;
        this.value = value;
    }

    public String getType()
    {
        return type;
    }

    public float getValue()
    {
        return value;
    }

}
