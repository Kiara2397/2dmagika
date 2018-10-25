package Game.SpellCast;

import Main.Handler;
import Resources.Images;

/**
 * Created by Elemental on 2/11/2017.
 */
public class EarthSpell extends Spells {
    private Handler handler;

    public EarthSpell(Handler handler) {
        super(handler,Images.Runes[5],10);
        this.handler=handler;
    }

}
