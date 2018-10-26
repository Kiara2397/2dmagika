package Worlds;
import Game.Entities.Creatures.BatEnemy;
import Game.Entities.Creatures.BossEnemy;
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
public class World2 extends BaseWorld{
    private Handler handler;
    private Player player;
   

    
    public World2(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
       

        
       
        entityManager.addEntity(new BossEnemy(handler, 1300, 1500,Item.fireRuneItem));
        entityManager.addEntity(new SkelyEnemy(handler, 1400, 500,Item.fireRuneItem));
        entityManager.addEntity(new SkelyEnemy(handler, 300, 1300,Item.HealthPotion));
        
        
    }


}