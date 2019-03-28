/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStarAlgorithm;

import java.util.List;

/**
 *
 * @author Tobias Ahrenschneider Sztuk
 */
public abstract class AStarNode implements Comparable{

    protected AStarNode pathParent;
    protected float costFromStart;
    protected float estimatedCostToGoal;
    
    public float getCost(){
        return costFromStart + estimatedCostToGoal;
    }
    
    @Override
    public int compareTo(Object o) {
        float thisCost = this.getCost();
        float newStarCost = ((AStarNode)o).getCost();
        
        float totalCost = thisCost - newStarCost;
        return (totalCost > 0) ? 1 : (totalCost < 0) ? -1 : 0; //integrated if statements
    }
    
    public abstract float getCost(AStarNode node);
    
    public abstract float getEstimatedCost(AStarNode node);
    
    public abstract List getNeighbors();
   
}
