package Worlds;
import Game.Entities.Creatures.BatEnemy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Creatures.SmallBossEnemy;
import Game.Entities.Statics.Door;
import Game.Items.Item;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class World2 extends BaseWorld{
    private Handler handler;
    private Player player;
    private BaseWorld finalWorld;
   

    
    public World2(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        finalWorld = new FinalWorld(handler,"res/Maps/Finalmap.map",player);
       
        entityManager.addEntity(new SmallBossEnemy(handler, 1300, 1500));
        entityManager.addEntity(new SkelyEnemy(handler, 1400, 500,Item.AttackPotion));
        entityManager.addEntity(new SkelyEnemy(handler, 300, 700,Item.AttackPotion));
        entityManager.addEntity(new BatEnemy(handler,500,500,Item.AttackPotion));
        entityManager.addEntity(new BatEnemy(handler,400,1500,Item.AttackPotion));
        entityManager.addEntity(new Door(handler,300,0,finalWorld));
        

        entityManager.getPlayer().setX(130);
        entityManager.getPlayer().setY(90);
        
    }


}