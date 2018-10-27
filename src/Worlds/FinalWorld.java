package Worlds;
import Game.Entities.Creatures.BigBossEnemy;
import Game.Entities.Creatures.Player;
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
        
        entityManager.getPlayer().setX(130);
        entityManager.getPlayer().setY(90);
    }


}