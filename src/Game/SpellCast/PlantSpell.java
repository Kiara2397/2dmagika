package Game.SpellCast;

import Main.Handler;
import Resources.Images;

/**
 * Created by Elemental on 2/11/2017.
 */
public class PlantSpell extends Spells {
    private Handler handler;

    public PlantSpell(Handler handler) {
        super(handler,Images.Runes[1],12);
        this.handler=handler;
    }

}
