package Clases;

import Interfaz.Game;

//Hola
public class FlappyMovement extends Thread {

    private int deltaTime;
    private boolean jump;
    private boolean stopJump1 = false;
    private boolean stopJump2 = true;
    private boolean jumping = false;
    private final Game parent;
    public static boolean stopThread;
    private double timeInit;
    private int yInit= 0;
    private static final int v0 = -30;
    private static final int ACCELERATION = 9;
    private static final int TIME_FLAPPING = 5;

    public FlappyMovement(Game parent) {
        this.deltaTime = 10;
        this.parent = parent;
    }

    @Override
    public void run() {
        stopThread = false;
        int x = Game.jFlappy.getLocation().x;
        yInit = Game.jFlappy.getLocation().y;
        timeInit = System.currentTimeMillis();

        while (true) {
            if (stopThread) {
                break;
            }
            if(jump){
                jump = false;
                jump();
            }
            double time =(double) ((System.currentTimeMillis() - timeInit)/100f);
            int y = (int)(yInit + v0  + 0.5 * ACCELERATION * time * time);
            
            Game.jFlappy.setLocation(x, y);
            parent.validarChoqueTubos();
            parent.detectColision();
            System.out.println(y);
        }
    }

    private void jump() {
       timeInit  = System.currentTimeMillis();
       yInit = Game.jFlappy.getLocation().y;
       
    }

  

    public boolean isStopJump1() {
        return stopJump1;
    }

    public void setStopJump1(boolean stopJump1) {
        this.stopJump1 = stopJump1;
    }

    public boolean isStopJump2() {
        return stopJump2;
    }

    public void setStopJump2(boolean stopJump2) {
        this.stopJump2 = stopJump2;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    public boolean isStopThread() {
        return stopThread;
    }

}
