package Game.GameStates;

import java.awt.Graphics;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

/**
 * Created by Elemental on 2/3/2017.
 */
public class PauseState extends State {

    private int count = 0;
    private UIManager uiManager;

    public PauseState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        uiManager.addObjects(new UIImageButton(250, 125+10, 300, 60, Images.Resume, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().gameState);
        }));
        
        uiManager.addObjects(new UIImageButton(250, 225+10, 300, 60, Images.BTitle, () -> {
            handler.getMouseManager().setUimanager(null);
            State.setState(handler.getGame().menuState);
        }));

     
        uiManager.addObjects(new UIImageButton(250,325, 300, 60, Images.Restart, () -> {
        	   handler.getMouseManager().setUimanager(null);
               handler.getGame().reStart();
               State.setState(handler.getGame().gameState);
        }));






    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        count++;
        if( count>=30){
            count=30;
        }
        if(handler.getKeyManager().pbutt && count>=30){
            count=0;

            State.setState(handler.getGame().gameState);
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.Pause,0,0,800,600,null);
        uiManager.Render(g);

    }
}
