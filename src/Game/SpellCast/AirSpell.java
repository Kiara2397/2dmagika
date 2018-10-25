package Game.SpellCast;

import Main.Handler;
import Resources.Images;

/**
 * Created by Elemental on 2/11/2017.
 */
public class AirSpell extends Spells {
    private Handler handler;

    public AirSpell(Handler handler) {
        super(handler,Images.Runes[3],8);
        this.handler=handler;
    }

}
