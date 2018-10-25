package Game.SpellCast;

import Main.Handler;
import Resources.Images;

/**
 * Created by Elemental on 2/11/2017.
 */
public class MetalSpell extends Spells {
    private Handler handler;

    public MetalSpell(Handler handler) {
        super(handler,Images.Runes[6],11);
        this.handler=handler;
    }

}
