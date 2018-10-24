package Worlds;
import Game.Entities.Creatures.BatEnemy;
import Game.Entities.Creatures.Player;
import Game.Entities.Statics.Stalagmite;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private Player player;

    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        
        entityManager.addEntity(new BatEnemy(handler,200,200));
        entityManager.addEntity(new Stalagmite(handler,100,300));

    }


}