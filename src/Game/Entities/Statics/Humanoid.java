package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Game.Items.Item;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

import java.awt.*;

/**
 * Created by Elemental on 2/2/2017.
 */


public class Humanoid extends StaticEntity {

    private Rectangle ir = new Rectangle();
    public Boolean EP = false;
    public static boolean TradeComplete = false;
    int CoinCounter=3;
    int KeyCounter=1;
    int message=0;

    private BaseWorld world;

    public Humanoid(Handler handler, float x, float y,BaseWorld world) {
        super(handler, x, y, 64, 100);
        this.world=world;
        health=10000000;
        bounds.x=0;
        bounds.y=0;
        bounds.width = 100;
        bounds.height = 64;

        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+913);
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
            g.setColor(Color.BLACK);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset()+80),(int)(y-handler.getGameCamera().getyOffset()+30),250,100);
            g.setColor(Color.white);
            g.drawString("If you want to proceed you need to bring me: " ,(int)(x-handler.getGameCamera().getxOffset()+85),(int)(y-handler.getGameCamera().getyOffset()+45));
            g.drawImage(Images.CoinItem ,(int)(x-handler.getGameCamera().getxOffset()+95),(int)(y-handler.getGameCamera().getyOffset()+60),32,32,null);
            g.drawString(""+CoinCounter ,(int)(x-handler.getGameCamera().getxOffset()+105),(int)(y-handler.getGameCamera().getyOffset()+110));
            g.drawImage(Images.KeyItem ,(int)(x-handler.getGameCamera().getxOffset()+150),(int)(y-handler.getGameCamera().getyOffset()+60),32,32,null);
            g.drawString(""+KeyCounter ,(int)(x-handler.getGameCamera().getxOffset()+160),(int)(y-handler.getGameCamera().getyOffset()+110));
            for(Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
    			if(i.getId()==3) {
    				CoinCounter-=i.getCount();
    				i.setCount(0);
    				if(CoinCounter<0) {
    					i.setCount(Math.abs(CoinCounter));
    					CoinCounter=0;
    					
    				}
    			}
    			if(i.getId()==6) {
    				KeyCounter-=i.getCount();
    				i.setCount(0);
    				if(KeyCounter<0) {
    					i.setCount(Math.abs(KeyCounter));
    					KeyCounter=0;
    				}
    			}
            }
            if(CoinCounter==0&&KeyCounter==0) {
            	 TradeComplete=true;
            	g.setColor(Color.BLACK);
                g.fillRect((int)(x-handler.getGameCamera().getxOffset()+80),(int)(y-handler.getGameCamera().getyOffset()+30),250,100);
                g.setColor(Color.white);
                g.drawString("Thanks! The door is at top left." ,(int)(x-handler.getGameCamera().getxOffset()+85),(int)(y-handler.getGameCamera().getyOffset()+45));
               
    		
            }
  
        }else
        	message=0;
    }
              
        	
    public static boolean getTrade() {
        return TradeComplete;
    }
        
    


    

    @Override
    public void die() {
    	

    }
}
