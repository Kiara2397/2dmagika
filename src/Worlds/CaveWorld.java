package Worlds;
import Game.Entities.Creatures.BatEnemy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Stalagmite;
import Game.Entities.Statics.TreasureChest;
import Game.Items.Item;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private Player player;
   private BaseWorld world2;

    
    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        world2 = new World2(handler,"res/Maps/map2.map",player);

        
        entityManager.addEntity(new BatEnemy(handler,100,600,Item.friendItem));
        entityManager.addEntity(new Stalagmite(handler,200,100));
        entityManager.addEntity(new Stalagmite(handler,1100,550));
        entityManager.addEntity(new Stalagmite(handler,300,700));
        entityManager.addEntity(new Rock(handler, 1000, 1000));
        entityManager.addEntity(new Rock(handler, 200, 1000));
      //  entityManager.addEntity(new Door(handler, 100, 0,world2));
        entityManager.addEntity(new SkelyEnemy(handler, 1300, 1500,Item.earthRuneItem));
        entityManager.addEntity(new SkelyEnemy(handler, 300, 1300,Item.airRuneItem));
        entityManager.addEntity(new TreasureChest(handler,250, 1400,Item.waterRuneItem));
        entityManager.addEntity(new TreasureChest(handler,1300, 600,Item.plantRuneItem));
        entityManager.addEntity(new BatEnemy(handler,1000,600,Item.metalRuneItem));
        
        
    }


}