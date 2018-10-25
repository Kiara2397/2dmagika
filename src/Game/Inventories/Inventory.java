package Game.Inventories;

import Game.Items.Item;
import Game.SpellCast.AirSpell;
import Game.SpellCast.EarthSpell;
import Game.SpellCast.FireBallSpell;
import Game.SpellCast.MetalSpell;
import Game.SpellCast.PlantSpell;
import Game.SpellCast.WaterSpell;
import Resources.Images;
import UI.UIInventory;
import UI.UIManager;
import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Elemental on 1/3/2017.
 */
public class Inventory {

    private Handler handler;
    private boolean active = false;
    private UIManager uiManager;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler){

        this.handler=handler;
        inventoryItems = new ArrayList<>();

        uiManager = new UIManager(handler);

        uiManager.addObjects(new UIInventory(0,0, 329, 265, Images.inventory,() -> {
        }));
    }

    public void tick() {

        for(Item i : inventoryItems){
            if(i.getCount()==0){
                inventoryItems.remove(inventoryItems.indexOf(i));
                return;
            }
        }

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_Q)){
            active=!active;
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().setActive(false);

        }

        if(!active){
            return;
        }

        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();



    }

    public void render(Graphics g) {

        if(!active){
            uiManager.isActive(uiManager.getObjects(),false);
            return;
        }



        uiManager.isActive(uiManager.getObjects(),true);
        uiManager.Render(g);
        g.setColor(Color.white);
        renderItems(g);


    }

    //Inventory Methods
    private void renderItems(Graphics g) {
    	for(int i=0; i<inventoryItems.size();i++) {
    		int x=0;
    		int y=0;
    		if(i<5) {
    			x = 25+(61*i);
    			y = 24;
    		}
    		else if(i<10) {
    			x = 25+(61*(i-5));
    			y = 86;
    		}
    		else if(i<15) {
    			x = 25+(61*(i-10));
    			y = 143;
    		}
    		else if(i<20) {
    			x = 25+(61*(i-15));
    			y = 204;
    		}
    		g.drawImage(inventoryItems.get(i).getTexture(), x, y, inventoryItems.get(i).getWidth(), inventoryItems.get(i).getHeight(), null);
    		g.drawString(String.valueOf(inventoryItems.get(i).getCount()), x+33,y+35);
    	}

    }

    public void addItem(Item item){
        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount()+item.getCount());
                return;
            }
        }
        if(item.getId()==2){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new FireBallSpell(handler));
        }
        if(item.getId()==8){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new AirSpell(handler));
        }
        if(item.getId()==9){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new WaterSpell(handler));
        }
        if(item.getId()==10){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new EarthSpell(handler));
        }
        if(item.getId()==11){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new MetalSpell(handler));
        }
        if(item.getId()==12){
            handler.getWorld().getEntityManager().getPlayer().getSpellGUI().addSpell(new PlantSpell(handler));
        }
        inventoryItems.add(item);

    }
    public void addOneItem(Item item){
        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount()+1);
                return;
            }
        }
        inventoryItems.add(item);

    }

    //GET SET
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Item> getInventoryItems(){
        return inventoryItems;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
