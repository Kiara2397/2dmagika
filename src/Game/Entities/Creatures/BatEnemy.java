package Game.Entities.Creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import Game.Entities.EntityBase;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

/**
 * Created by Elemental on 2/7/2017.
 */
public class BatEnemy extends CreatureBase  {


    private Animation animDown, animUp, animLeft, animRight;

    private Boolean attacking=false;

    private int animWalkingSpeed = 150;
    private Inventory Batinventory;
    private Rectangle BatCam;

    private int healthcounter =0;

    private Random randint;
    private int moveCount=0;
    private int direction;
    
    public Item QuestItem;

    public BatEnemy(Handler handler, float x, float y,Item questItem) {
        super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT);
        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;
        speed=1.5f;
        health=50;
        this.QuestItem = questItem;

        BatCam= new Rectangle();



        randint = new Random();
        direction = randint.nextInt(4) + 1;

        animDown = new Animation(animWalkingSpeed, Images.BatEnemy_front);
        animLeft = new Animation(animWalkingSpeed,Images.BatEnemy_left);
        animRight = new Animation(animWalkingSpeed,Images.BatEnemy_right);
        animUp = new Animation(animWalkingSpeed,Images.BatEnemy_back);

        Batinventory= new Inventory(handler);
    }

    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();

        moveCount ++;
        if(moveCount>=60){
            moveCount=0;
            direction = randint.nextInt(4) + 1;
        }
        checkIfMove();

        move();


        if(isBeinghurt()){
            healthcounter++;
            if(healthcounter>=120){
                setBeinghurt(false);
                System.out.print(isBeinghurt());
            }
        }
        if(healthcounter>=120&& !isBeinghurt()){
            healthcounter=0;
        }


        Batinventory.tick();


    }


    private void checkIfMove() {
        xMove = 0;
        yMove = 0;

        BatCam.x = (int) (x - handler.getGameCamera().getxOffset() - (64 * 3));
        BatCam.y = (int) (y - handler.getGameCamera().getyOffset() - (64 * 3));
        BatCam.width = 64 * 7;
        BatCam.height = 64 * 7;

        if (BatCam.contains(handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset(), handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset())
                || BatCam.contains(handler.getWorld().getEntityManager().getPlayer().getX() - handler.getGameCamera().getxOffset() + handler.getWorld().getEntityManager().getPlayer().getWidth(), handler.getWorld().getEntityManager().getPlayer().getY() - handler.getGameCamera().getyOffset() + handler.getWorld().getEntityManager().getPlayer().getHeight())) {

            Rectangle cb = getCollisionBounds(0, 0);
            Rectangle ar = new Rectangle();
            int arSize = 13;
            ar.width = arSize;
            ar.height = arSize;

            if (lu) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y - arSize;
            } else if (ld) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y + cb.height;
            } else if (ll) {
                ar.x = cb.x - arSize;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else if (lr) {
                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            }

            for (EntityBase e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.equals(this))
                    continue;
                if (e.getCollisionBounds(0, 0).intersects(ar) && e.equals(handler.getWorld().getEntityManager().getPlayer())) {

                    checkAttacks();
                    return;
                }
            }


            if (x >= handler.getWorld().getEntityManager().getPlayer().getX() - 8 && x <= handler.getWorld().getEntityManager().getPlayer().getX() + 8) {//nada

                xMove = 0;
            } else if (x < handler.getWorld().getEntityManager().getPlayer().getX()) {//move right

                xMove = speed;

            } else if (x > handler.getWorld().getEntityManager().getPlayer().getX()) {//move left

                xMove = -speed;
            }

            if (y >= handler.getWorld().getEntityManager().getPlayer().getY() - 8 && y <= handler.getWorld().getEntityManager().getPlayer().getY() + 8) {//nada
                yMove = 0;
            } else if (y < handler.getWorld().getEntityManager().getPlayer().getY()) {//move down
                yMove = speed;

            } else if (y > handler.getWorld().getEntityManager().getPlayer().getY()) {//move up
                yMove = -speed;
            }


        } else {


            switch (direction) {
                case 1://up
                    yMove = -speed;
                    break;
                case 2://down
                    yMove = speed;
                    break;
                case 3://left
                    xMove = -speed;
                    break;
                case 4://right
                    xMove = speed;
                    break;

            }
        }
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(animDown,animUp,animLeft,animRight,Images.BatEnemy_front,Images.BatEnemy_back,Images.BatEnemy_left,Images.BatEnemy_right), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setColor(Color.BLACK);
        g.drawRect((int)(x-handler.getGameCamera().getxOffset()-1),(int)(y-handler.getGameCamera().getyOffset()-21),56,11);
        if(this.getHealth()>=35) {
            g.setColor(Color.GREEN);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth()+5,10);
          

        }else if(this.getHealth()>10 && getHealth()<35){
            g.setColor(Color.YELLOW);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

        }else if(this.getHealth() <= 10 ){
            g.setColor(Color.RED);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

        }
        g.setColor(Color.white);
        g.drawString("Health: " + getHealth(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-10));

    }




    @Override
    public void die() {
    	handler.getWorld().getItemManager().addItem(this.QuestItem.createNew((int)x + bounds.x,(int)y + bounds.y,randint.nextInt(1) + 1));
  
        	
    }
}