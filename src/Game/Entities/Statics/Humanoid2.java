package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Game.Items.Item;
import Game.SpellCast.Spells;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

import java.awt.*;

/**
 * Created by Elemental on 2/2/2017.
 */


public class Humanoid2 extends StaticEntity {

    private Rectangle ir = new Rectangle();
    public Boolean EP = false;
    public static boolean TradeComplete = false;
    int AirCounter=1;
    int EarthCounter=1;
    int FireCounter =1;
    int PlantCounter=1;
    int WaterCounter=1;
    int MetalCounter=1;
    int RunesCounter=0;
    int message=0;

    private BaseWorld world;

    public Humanoid2(Handler handler, float x, float y,BaseWorld world) {
        super(handler, x, y, 64, 100);
        this.world=world;
        health=10000000;
        bounds.x=0;
        bounds.y=0;
        bounds.width = 100;
        bounds.height = 64;

        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+300);
        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
        ir.y=iry;
        ir.x=irx;
    }

    @Override
    public void tick() {

        if(isBeinghurt()){
            setHealth(10000000);
        }

        if(handler.getKeyManager().attbut){
            EP=true;
            message++;

        }else if(!handler.getKeyManager().attbut){
            EP=false;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.Humanoid,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);

       
        checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
    }

    private void checkForPlayer(Graphics g, Player p) {
        Rectangle pr = p.getCollisionBounds(0,0);
       
        	if(ir.contains(pr) && message>0){
        		RunesCounter=AirCounter+EarthCounter+MetalCounter+PlantCounter+FireCounter+WaterCounter;
        		message++;
        		g.setColor(Color.WHITE);
        		g.fillRect((int)(x-handler.getGameCamera().getxOffset()+80),(int)(y-handler.getGameCamera().getyOffset()+30),250,100);
        		g.setColor(Color.black);
        		g.drawString("If you want to proceed you need to bring me" ,(int)(x-handler.getGameCamera().getxOffset()+85),(int)(y-handler.getGameCamera().getyOffset()+45));
        		g.drawString("the "+RunesCounter +" runes" ,(int)(x-handler.getGameCamera().getxOffset()+85),(int)(y-handler.getGameCamera().getyOffset()+65));
        		
        		for(Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
        	
        			if(i.getId()==2) {
        				if(FireCounter==1) {
        		     FireCounter--;
        		    i.setCount(i.getCount()-1);	    
        		     }
        			}
        			
            		if(i.getId()==10) {
            			  if(EarthCounter==1){
            				  EarthCounter--;
            				  i.setCount(i.getCount()-1);
            			  }	   
            		}
            		if(i.getId()==8) {
            			 if(AirCounter==1) {
            				 AirCounter--;
            				 i.setCount(i.getCount()-1);
            			 }
            		}
            		if(i.getId()==11) {
            			if(MetalCounter==1) {
            			MetalCounter--;
            			i.setCount(i.getCount()-1);
             		    
            		}
            		}
            		if(i.getId()==12) {
            			if(PlantCounter==1) {
            			  PlantCounter--;
             		     i.setCount(i.getCount()-1);
            			}
            		}
            		if(i.getId()==9) {
            			if(WaterCounter==1) {
            			  WaterCounter--;
             		     i.setCount(i.getCount()-1);
            			}
            		}
            	}
        		 if(RunesCounter==0) {
                	 TradeComplete=true;
                	g.setColor(Color.WHITE);
                    g.fillRect((int)(x-handler.getGameCamera().getxOffset()+80),(int)(y-handler.getGameCamera().getyOffset()+30),250,100);
                    g.setColor(Color.black);
                    g.drawString("Thanks! Now you can now go to the next" ,(int)(x-handler.getGameCamera().getxOffset()+85),(int)(y-handler.getGameCamera().getyOffset()+45));
                    g.drawString("world.Good luck!" ,(int)(x-handler.getGameCamera().getxOffset()+85),(int)(y-handler.getGameCamera().getyOffset()+65));
                    
        		
                }

            } else
            	message=0;
    }

              

    public static boolean getTrade() {
    	return TradeComplete;
    }
    public static void setTradeComplete(boolean tradeComplete) {
		TradeComplete = tradeComplete;
	}
   
        
    


    

    @Override
    public void die() {
    	

    }

	
}
