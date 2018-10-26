package Game.GameStates;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class GameOverState extends State {

    private UIManager uiManager;

    public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        //Retry Button
        uiManager.addObjects(new UIImageButton(125,450, 200, 80, Images.Retry, () -> {
            handler.getMouseManager().setUimanager(null);
            handler.getGame().reStart();
            State.setState(handler.getGame().gameState);
        }));
        
        //Quit Button
        uiManager.addObjects(new UIImageButton(500, 455, 200, 80, Images.Quit, () -> {
        	handler.getMouseManager().setUimanager(null);
            System.exit(0);
        }));
        
        
    }

    @Override
    public void tick() {
	  handler.getMouseManager().setUimanager(uiManager);
      uiManager.tick();


    }


    @Override
    public void render(Graphics g) {
        g.drawImage(Images.gameOver,0,0,800,600,null);
        uiManager.Render(g);

    }
}
