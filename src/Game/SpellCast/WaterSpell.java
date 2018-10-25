package Game.SpellCast;

import Main.Handler;
import Resources.Images;

/**
 * Created by Elemental on 2/11/2017.
 */
public class WaterSpell extends Spells {
    private Handler handler;

    public WaterSpell(Handler handler) {
        super(handler,Images.Runes[4],9);
        this.handler=handler;
    }

}
