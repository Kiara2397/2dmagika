package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Elemental on 12/19/2016.
 */
public class Images {

    private static final int width = 32, height = 32;
    private static final int Bwidth = 64, Bheight = 64;
    private static final int Rwidth = 56, Rheight = 93;
    private static final int Fwidth = 512, Fheight = 197;
    private static final int Batwidth = 50, Batheight = 40;
    private static final int Catwidth = 45, Catheight = 50;
    private static final int Bosswidth = 30, Bossheight = 44;
    
    public static BufferedImage[] blocks;
    public static BufferedImage[] player_right;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_front;
    public static BufferedImage[] player_back;
    public static BufferedImage[] SkelyEnemy_right;
    public static BufferedImage[] SkelyEnemy_left;
    public static BufferedImage[] SkelyEnemy_front;
    public static BufferedImage[] SkelyEnemy_back;
    public static BufferedImage[] BatEnemy_right;
    public static BufferedImage[] BatEnemy_left;
    public static BufferedImage[] BatEnemy_front;
    public static BufferedImage[] BatEnemy_back;
    public static BufferedImage[] SkelyFriend_right;
    public static BufferedImage[] SkelyFriend_left;
    public static BufferedImage[] SkelyFriend_front;
    public static BufferedImage[] SkelyFriend_back;
    public static BufferedImage[] SmallBoss_right;
    public static BufferedImage[] SmallBoss_left;
    public static BufferedImage[] SmallBoss_front;
    public static BufferedImage[] SmallBoss_back;
    public static BufferedImage[] butstart;
    public static BufferedImage[] particleSmoke;
    public static BufferedImage[] items;
    public static BufferedImage[] numbers;
    public static BufferedImage inventory;
    public static BufferedImage title;
    public static BufferedImage gameOver;
    public static BufferedImage door;
    public static BufferedImage CoinItem;
    public static BufferedImage HealthPotion;
    public static BufferedImage KeyItem;
    public static BufferedImage Humanoid;
    public static BufferedImage E;
    public static BufferedImage EP;
    public static BufferedImage Pause;
    public static BufferedImage[] Resume;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] Options;
	public static BufferedImage[] Retry;
	public static BufferedImage[] Quit;
    public static BufferedImage[] Runes;
    public static ImageIcon icon;
    public static BufferedImage[] FireBallLeft;
    public static BufferedImage[] FireBallRight;
    public static BufferedImage[] FireBallUp;
    public static BufferedImage[] FireBallDown;
    public static BufferedImage loading;
    public static BufferedImage spellGUI;
    public static BufferedImage[] chest;


    public Images() {

        SpriteSheet newsheet = new SpriteSheet(Images.loadImage("/Sheets/SpriteSheet.png"));
        SpriteSheet numsheet = new SpriteSheet(Images.loadImage("/Sheets/numsheet.png"));
        SpriteSheet runesheet = new SpriteSheet(Images.loadImage("/Sheets/runes.png"));
        SpriteSheet FireBallsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBall.png"));
        SpriteSheet FireBallRightsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallRight.png"));
        SpriteSheet FireBallUpsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallUp.png"));
        SpriteSheet FireBallDownsheet = new SpriteSheet(Images.loadImage("/Sheets/FireBallDown.png"));
        SpriteSheet treasureChest = new SpriteSheet(Images.loadImage("/Sheets/chest2.png"));
        SpriteSheet Cavesheet = new SpriteSheet(Images.loadImage("/Sheets/CaveSheet.png"));
        SpriteSheet World2 = new SpriteSheet(Images.loadImage("/Sheets/World2.png"));


        chest = new BufferedImage[2];
        
        blocks = new BufferedImage[22];

        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_front = new BufferedImage[4];
        player_back = new BufferedImage[4];

        SkelyEnemy_left = new BufferedImage[4];
        SkelyEnemy_right = new BufferedImage[4];
        SkelyEnemy_front = new BufferedImage[4];
        SkelyEnemy_back = new BufferedImage[4];
        
        BatEnemy_left = new BufferedImage[4];
        BatEnemy_right = new BufferedImage[4];
        BatEnemy_front = new BufferedImage[4];
        BatEnemy_back = new BufferedImage[4];
        
        SkelyFriend_left = new BufferedImage[4];
        SkelyFriend_right = new BufferedImage[4];
        SkelyFriend_front = new BufferedImage[4];
        SkelyFriend_back = new BufferedImage[4];
        
        SmallBoss_left = new BufferedImage[4];
        SmallBoss_right = new BufferedImage[4];
        SmallBoss_front = new BufferedImage[4];
        SmallBoss_back = new BufferedImage[4];
        
        butstart = new BufferedImage[3];
        particleSmoke = new BufferedImage[3];
        items = new BufferedImage[3];
        numbers = new BufferedImage[21];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[2];
        Retry = new BufferedImage[2];
		Quit = new BufferedImage[2];
        Runes = new BufferedImage[36];

        FireBallLeft = new BufferedImage[6];
        FireBallRight = new BufferedImage[6];
        FireBallUp = new BufferedImage[6];
        FireBallDown = new BufferedImage[6];




        try {

            loading = ImageIO.read(getClass().getResourceAsStream("/Sheets/loading.png"));
            spellGUI = ImageIO.read(getClass().getResourceAsStream("/Sheets/SpellGUI.png"));

            inventory = ImageIO.read(getClass().getResourceAsStream("/Sheets/guit.png"));
            title = ImageIO.read(getClass().getResourceAsStream("/Sheets/Title.png"));
            gameOver =  ImageIO.read(getClass().getResourceAsStream("/Sheets/GameOver.png"));
            door = ImageIO.read(getClass().getResourceAsStream("/Sheets/Door.png"));
            E = ImageIO.read(getClass().getResourceAsStream("/Buttons/E.png"));
            EP = ImageIO.read(getClass().getResourceAsStream("/Buttons/EP.png"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Buttons/Pause.png"));
            Resume[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
            Resume[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
            BTitle[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitle.png"));
            BTitle[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/BTitleP.png"));
            Options[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Options.png"));
            Options[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/OptionsP.png"));
            
            CoinItem = ImageIO.read(getClass().getResourceAsStream("/Sheets/Coin.png"));
            HealthPotion = ImageIO.read(getClass().getResourceAsStream("/Sheets/HealthPotion.png"));
            Humanoid = ImageIO.read(getClass().getResourceAsStream("/Sheets/Humanoid.png"));
            KeyItem = ImageIO.read(getClass().getResourceAsStream("/Sheets/KeyItem.png"));
            
            //chest
            chest[0]= treasureChest.crop(0, 0, width, height);
            chest[1]= treasureChest.crop(width, 0, width, height);

            //icon
            icon = new ImageIcon(runesheet.crop(Rwidth*1,Rheight*0,Rwidth,Rheight));

            //fireball left
            FireBallLeft[0]= FireBallsheet.crop(Fwidth*0,Fheight*0,Fwidth,Fheight);
            FireBallLeft[1]= FireBallsheet.crop(Fwidth*1,Fheight*0,Fwidth,Fheight);
            FireBallLeft[2]= FireBallsheet.crop(Fwidth*2,Fheight*0,Fwidth,Fheight);
            FireBallLeft[3]= FireBallsheet.crop(Fwidth*0,Fheight*1,Fwidth,Fheight);
            FireBallLeft[4]= FireBallsheet.crop(Fwidth*1,Fheight*1,Fwidth,Fheight);
            FireBallLeft[5]= FireBallsheet.crop(Fwidth*2,Fheight*1,Fwidth,Fheight);

            //fireball right
            FireBallRight[0]= FireBallRightsheet.crop(Fwidth*0,Fheight*0,Fwidth,Fheight);
            FireBallRight[1]= FireBallRightsheet.crop(Fwidth*1,Fheight*0,Fwidth,Fheight);
            FireBallRight[2]= FireBallRightsheet.crop(Fwidth*2,Fheight*0,Fwidth,Fheight);
            FireBallRight[3]= FireBallRightsheet.crop(Fwidth*0,Fheight*1,Fwidth,Fheight);
            FireBallRight[4]= FireBallRightsheet.crop(Fwidth*1,Fheight*1,Fwidth,Fheight);
            FireBallRight[5]= FireBallRightsheet.crop(Fwidth*2,Fheight*1,Fwidth,Fheight);

            //fireball up
            FireBallUp[0]= FireBallUpsheet.crop(Fheight*1,Fwidth*0,Fheight,Fwidth);
            FireBallUp[1]= FireBallUpsheet.crop(Fheight*1,Fwidth*1,Fheight,Fwidth);
            FireBallUp[2]= FireBallUpsheet.crop(Fheight*1,Fwidth*2,Fheight,Fwidth);
            FireBallUp[3]= FireBallUpsheet.crop(Fheight*0,Fwidth*0,Fheight,Fwidth);
            FireBallUp[4]= FireBallUpsheet.crop(Fheight*0,Fwidth*1,Fheight,Fwidth);
            FireBallUp[5]= FireBallUpsheet.crop(Fheight*0,Fwidth*2,Fheight,Fwidth);

            //fireball down
            FireBallDown[0]= FireBallDownsheet.crop(Fheight*1,Fwidth*0,Fheight,Fwidth);
            FireBallDown[1]= FireBallDownsheet.crop(Fheight*1,Fwidth*1,Fheight,Fwidth);
            FireBallDown[2]= FireBallDownsheet.crop(Fheight*1,Fwidth*2,Fheight,Fwidth);
            FireBallDown[3]= FireBallDownsheet.crop(Fheight*0,Fwidth*0,Fheight,Fwidth);
            FireBallDown[4]= FireBallDownsheet.crop(Fheight*0,Fwidth*1,Fheight,Fwidth);
            FireBallDown[5]= FireBallDownsheet.crop(Fheight*0,Fwidth*2,Fheight,Fwidth);

            Runes[0]= runesheet.crop(Rwidth*0,Rheight*0,Rwidth,Rheight);//Runes
            Runes[1]= runesheet.crop(Rwidth*1,Rheight*0,Rwidth,Rheight);
            Runes[2]= runesheet.crop(Rwidth*2,Rheight*0,Rwidth,Rheight);
            Runes[3]= runesheet.crop(Rwidth*3,Rheight*0,Rwidth,Rheight);
            Runes[4]= runesheet.crop(Rwidth*4,Rheight*0,Rwidth,Rheight);
            Runes[5]= runesheet.crop(Rwidth*5,Rheight*0,Rwidth,Rheight);
            Runes[6]= runesheet.crop(Rwidth*6,Rheight*0,Rwidth,Rheight);
            Runes[7]= runesheet.crop(Rwidth*7,Rheight*0,Rwidth,Rheight);


            blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Slime.png"));

            butstart[0]= newsheet.crop(11,422,93,34);//normbut
            butstart[1]= newsheet.crop(11,456,93,33);//hoverbut
            butstart[2]= newsheet.crop(11,489,93,32);//clickbut
            
        	Retry[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Retry.png"));
			Retry[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/RetryP.png"));
			
			Quit[0] = ImageIO.read(getClass().getResourceAsStream("/Buttons/Quit.png"));
			Quit[1] = ImageIO.read(getClass().getResourceAsStream("/Buttons/QuitP.png"));

            particleSmoke[0]= newsheet.crop(111,397,18,38);
            particleSmoke[1]= newsheet.crop(129,399,20,35);
            particleSmoke[2]= newsheet.crop(154,400,20,35);

            items[0]= newsheet.crop(114,448,30,24);//log

           
            items[2] = World2.crop(15, 16, 68, 98);//attackpotion!

            items[1]=Cavesheet.crop(442,352,25,25);//friendItem


            numbers[1]= numsheet.crop(17,15,17,22);
            numbers[2]= numsheet.crop(64,16,14,19);
            numbers[3]= numsheet.crop(110,16,14,19);
            numbers[4]= numsheet.crop(154,17,15,19);
            numbers[5]= numsheet.crop(19,61,13,20);
            numbers[6]= numsheet.crop(64,61,14,20);
            numbers[7]= numsheet.crop(110,62,14,19);
            numbers[8]= numsheet.crop(156,61,13,20);
            numbers[9]= numsheet.crop(19,107,13,20);
            numbers[10]= numsheet.crop(60,107,24,20);
            numbers[11]= numsheet.crop(107,107,20,19);
            numbers[12]= numsheet.crop(151,107,23,19);
            numbers[13]= numsheet.crop(14,152,23,20);
            numbers[14]= numsheet.crop(60,152,23,20);
            numbers[15]= numsheet.crop(105,153,24,20);
            numbers[16]= numsheet.crop(151,153,23,20);
            numbers[17]= numsheet.crop(14,198,24,20);
            numbers[18]= numsheet.crop(60,198,23,20);
            numbers[19]= numsheet.crop(106,198,23,21);
            numbers[20]= numsheet.crop(149,198,28,20);


            //block images,array index is equal to block id
            blocks[1] = newsheet.crop(0,324,Bwidth,Bheight);//grass
            blocks[2] = newsheet.crop(67,260,Bwidth,Bheight);//dirt
            blocks[3] = newsheet.crop(67,324,Bwidth,Bheight);//dirtrock
            blocks[4] = newsheet.crop(0,0,Bwidth,Bheight);//uppperleft
            blocks[5] = newsheet.crop(67,0,Bwidth,Bheight);//upperright
            blocks[6] = newsheet.crop(67,65,Bwidth,Bheight);//lowerleft
            blocks[7] = newsheet.crop(0,65,Bwidth,Bheight);//lowerright
            blocks[8] = newsheet.crop(0,195,Bwidth,Bheight);//leftwall
            blocks[9] = newsheet.crop(67,195,Bwidth,Bheight);//rightwall
            blocks[10] = newsheet.crop(0,130,Bwidth,Bheight);//topwall
            blocks[11] = newsheet.crop(67,130,Bwidth,Bheight);//lowerwall
            blocks[12] = newsheet.crop(0,260,Bwidth,Bheight);//mossyrock
            blocks[13] = newsheet.crop(176,0,Bwidth,Bheight*2);//tree
            blocks[14] = newsheet.crop(174,410,78,74);//rock
            blocks[15] = Cavesheet.crop(296,70,30,60);//stalagmite
            blocks[16] = Cavesheet.crop(32,415,32,32);//black
            blocks[17] = Cavesheet.crop(413, 153, 30, 30);//cavefloor
            blocks[18] = Cavesheet.crop(471, 285, 54, 54);//cavehallway
            blocks[19] = Cavesheet.crop(328, 222, 56, 56);//caverocks
            blocks[20] = World2.crop(80, 248, 90, 90);
            blocks[21] = World2.crop(80, 129, 128, 91);
            


            //player anim
            player_front[0]=newsheet.crop(132,131,width,height);
            player_front[1]=newsheet.crop(164,131,width,height);
            player_front[2]=newsheet.crop(196,131,width,height);
            player_front[3]=newsheet.crop(228,131,28,height);

            player_left[0]=newsheet.crop(132,163,width,height);
            player_left[1]=newsheet.crop(164,163,width,height);
            player_left[2]=newsheet.crop(196,163,width,height);
            player_left[3]=newsheet.crop(228,163,28,height);

            player_right[0]=newsheet.crop(132,195,width,height);
            player_right[1]=newsheet.crop(164,195,width,height);
            player_right[2]=newsheet.crop(196,195,width,height);
            player_right[3]=newsheet.crop(228,195,28,height);

            player_back[0]=newsheet.crop(132,227,width,height);
            player_back[1]=newsheet.crop(164,227,width,height);
            player_back[2]=newsheet.crop(196,227,width,height);
            player_back[3]=newsheet.crop(228,227,28,height);

            //Skely enemy anim
            SkelyEnemy_front[0]=newsheet.crop(132,131+130,width,height);
            SkelyEnemy_front[1]=newsheet.crop(164,131+130,width,height);
            SkelyEnemy_front[2]=newsheet.crop(196,131+130,width,height);
            SkelyEnemy_front[3]=newsheet.crop(228,131+130,28,height);

            SkelyEnemy_left[0]=newsheet.crop(132,163+130,width,height);
            SkelyEnemy_left[1]=newsheet.crop(164,163+130,width,height);
            SkelyEnemy_left[2]=newsheet.crop(196,163+130,width,height);
            SkelyEnemy_left[3]=newsheet.crop(228,163+130,28,height);

            SkelyEnemy_right[0]=newsheet.crop(132,195+130,width,height);
            SkelyEnemy_right[1]=newsheet.crop(164,195+130,width,height);
            SkelyEnemy_right[2]=newsheet.crop(196,195+130,width,height);
            SkelyEnemy_right[3]=newsheet.crop(228,195+130,28,height);

            SkelyEnemy_back[0]=newsheet.crop(132,227+130,width,height);
            SkelyEnemy_back[1]=newsheet.crop(164,227+130,width,height);
            SkelyEnemy_back[2]=newsheet.crop(196,227+130,width,height);
            SkelyEnemy_back[3]=newsheet.crop(228,227+130,28,height);
            
            //Bat enemy anim
            BatEnemy_front[0]=Cavesheet.crop(25,40,Batwidth,Batheight);
            BatEnemy_front[1]=Cavesheet.crop(73,0,Batwidth,Batheight);
            BatEnemy_front[2]=Cavesheet.crop(127,0,Batwidth,Batheight);
            BatEnemy_front[3]=Cavesheet.crop(178,0,Batwidth,Batheight);

            BatEnemy_right[0]=Cavesheet.crop(30,80,Batwidth,Batheight);
            BatEnemy_right[1]=Cavesheet.crop(73,58,Batwidth,Batheight);
            BatEnemy_right[2]=Cavesheet.crop(127,58,Batwidth,Batheight);
            BatEnemy_right[3]=Cavesheet.crop(178,58,Batwidth,Batheight);

            BatEnemy_back[0]=Cavesheet.crop(25,130,Batwidth,Batheight);
            BatEnemy_back[1]=Cavesheet.crop(73,103,Batwidth,Batheight);
            BatEnemy_back[2]=Cavesheet.crop(127,103,Batwidth,Batheight);
            BatEnemy_back[3]=Cavesheet.crop(178,103,Batwidth,Batheight);

            BatEnemy_left[0]=Cavesheet.crop(30,172,Batwidth,Batheight);
            BatEnemy_left[1]=Cavesheet.crop(73,149,Batwidth,Batheight);
            BatEnemy_left[2]=Cavesheet.crop(127,149,Batwidth,Batheight);
            BatEnemy_left[3]=Cavesheet.crop(178,149,Batwidth,Batheight);

            //Skely friend anim
            SkelyFriend_front[0]=Cavesheet.crop(38,210,Catwidth,Catheight);
            SkelyFriend_front[1]=Cavesheet.crop(88,210,Catwidth,Catheight);
            SkelyFriend_front[2]=Cavesheet.crop(135,210,Catwidth,Catheight);
            SkelyFriend_front[3]=Cavesheet.crop(183,210,Catwidth,Catheight);

            SkelyFriend_left[0]=Cavesheet.crop(30,271,Catwidth,Catheight);
            SkelyFriend_left[1]=Cavesheet.crop(75,271,Catwidth,Catheight);
            SkelyFriend_left[2]=Cavesheet.crop(125,271,Catwidth,Catheight);
            SkelyFriend_left[3]=Cavesheet.crop(175,271,Catwidth,Catheight);

            SkelyFriend_right[0]=Cavesheet.crop(30,318,Catwidth,Catheight);
            SkelyFriend_right[1]=Cavesheet.crop(75,318,Catwidth,Catheight);
            SkelyFriend_right[2]=Cavesheet.crop(125,318,Catwidth,Catheight);
            SkelyFriend_right[3]=Cavesheet.crop(175,318,Catwidth,Catheight);

            SkelyFriend_back[0]=Cavesheet.crop(38,364,Catwidth,Catheight);
            SkelyFriend_back[1]=Cavesheet.crop(88,364,Catwidth,Catheight);
            SkelyFriend_back[2]=Cavesheet.crop(135,364,Catwidth,Catheight);
            SkelyFriend_back[3]=Cavesheet.crop(183,364,Catwidth,Catheight);
            
            //Small Boss anim
            SmallBoss_front[0]=World2.crop(135,339,Bosswidth,Bossheight);
            SmallBoss_front[1]=World2.crop(165,339,Bosswidth,Bossheight);
            SmallBoss_front[2]=World2.crop(194,339,Bosswidth,Bossheight);
            SmallBoss_front[3]=World2.crop(225,339,Bosswidth,Bossheight);

            SmallBoss_left[0]=World2.crop(135,384,Bosswidth,Bossheight);
            SmallBoss_left[1]=World2.crop(165,384,Bosswidth,Bossheight);
            SmallBoss_left[2]=World2.crop(194,384,Bosswidth,Bossheight);
            SmallBoss_left[3]=World2.crop(225,384,Bosswidth,Bossheight);

            SmallBoss_right[0]=World2.crop(135,431,Bosswidth,Bossheight);
            SmallBoss_right[1]=World2.crop(165,431,Bosswidth,Bossheight);
            SmallBoss_right[2]=World2.crop(194,431,Bosswidth,Bossheight);
            SmallBoss_right[3]=World2.crop(225,431,Bosswidth,Bossheight);

            SmallBoss_back[0]=World2.crop(135,476,Bosswidth,Bossheight);
            SmallBoss_back[1]=World2.crop(165,476,Bosswidth,Bossheight);
            SmallBoss_back[2]=World2.crop(194,476,Bosswidth,Bossheight);
            SmallBoss_back[3]=World2.crop(225,476,Bosswidth,Bossheight);
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }


}