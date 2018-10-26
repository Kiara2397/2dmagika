package Game.GameStates;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class GameWonState extends State {

    private UIManager uiManager;

    public GameWonState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        //Retry Button
        uiManager.addObjects(new UIImageButton(115,450, 210, 90, Images.Replay, () -> {
            State.setState(handler.getGame().menuState);
        }));
        
        //Quit Button
        uiManager.addObjects(new UIImageButton(500, 455, 200, 80, Images.Quit, () -> {
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
        g.drawImage(Images.gameWon,0,0,800,600,null);
        uiManager.Render(g);

    }
}
