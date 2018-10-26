package Worlds;
import Game.Entities.Creatures.BatEnemy;
import Game.Entities.Creatures.BigBossEnemy;
import Game.Entities.Creatures.SmallBossEnemy;
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
public class FinalWorld extends BaseWorld{
    private Handler handler;
    private Player player;
   

    
    public FinalWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
       
        entityManager.addEntity(new BigBossEnemy(handler, 700, 800));
        
        
        
    }


}