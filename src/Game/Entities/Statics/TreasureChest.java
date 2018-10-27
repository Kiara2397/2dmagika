package Game.Entities.Statics;


import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Game.Items.Item;
import Game.Tiles.Tile;
import Main.Handler;
import Resources.Images;

/**
 * Created by Elemental on 1/1/2017.
 */
public class TreasureChest extends StaticEntity {
    private File audioFile;
    private AudioInputStream audioStream;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip audioClip;
    private Random rand;
    public Boolean OpenChest = false;
    public Item QuestItem;

    public TreasureChest(Handler handler, float x, float y, Item questItem) {
        super(handler, x, y, Tile.TILEHEIGHT, Tile.TILEWIDTH);
        bounds.x=0;
        bounds.y=0;
        bounds.width = 64;
        bounds.height = 64;
        health=10000000;
        this.QuestItem = questItem;
        

        try {
            audioFile = new File("res/music/OpeningChest.wav");
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            format = audioStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.setMicrosecondPosition(2000);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void tick() {
        if(isBeinghurt()){
            audioClip.start();
            
        }
        if(!isBeinghurt() && !handler.getKeyManager().attbut){
            audioClip.stop();

        }
        if(!isActive()){
            audioClip.stop();

        }

    }

    @Override
    public void render(Graphics g) {
        renderLife(g);
        g.drawImage(Images.chest[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
        if(OpenChest) {
        	g.drawImage(Images.chest[1],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
        }
        
        
    }
    @Override
    public void hurt(int amt){
    	if(!beinghurt) {
    	rand =new Random();
    	int pickedNumber = 1; 
    	if(QuestItem.equals(Item.CoinItem)) {
    		pickedNumber = rand.nextInt(3)+1;
    	}
    	handler.getWorld().getItemManager().addItem(this.QuestItem.createNew((int)x + bounds.x + this.width,(int)y + bounds.y,pickedNumber));
    	OpenChest=true;
    	beinghurt=true;
    	}
    }
    	
    @Override
    public void renderLife(Graphics g) {

    }
    

    @Override
    public void die() {

    }
}