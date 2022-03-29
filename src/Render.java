import GameEngine.Boss;
import GameEngine.Warrior;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Render extends Application {

    //Variables
    static int width = 1000;
    static int height = 600;

    //Method
    public void addBoss(GraphicsContext gc){
            Boss boss = new Boss(width/2, height/2, 79, 100);
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
    }
    public void addWarrior(GraphicsContext gc, String J){
            String type;
            double x;
            double y = height/2;

            if(J.equals("J1")){
                    type = "joueur 1";
                    x = 0;
            }
            else if(J.equals("J2")){
                    type = "joueur 2";
                    x = width - 55;
            }
            else{
                    type = "error : invalid type of player";
                    x = 0;
                    y = 0;
            }
            Warrior warrior = new Warrior(x, y, 45, 55, type);
            Image ImWarrior = warrior.getSkinWarrior();
            gc.drawImage(ImWarrior, warrior.getX(), warrior.getY(), warrior.getHeight(), warrior.getWidth());
    }


    @Override
    public void start(Stage stage) {

            //Create group Object
            Group root = new Group();

            //Create a scene
            Scene scene = new Scene(root, width, height);
            stage.setScene(scene); //Add scene to stage
            //scene.setFill(Color.WHITE); //new RadialGradient(0, 0, 500, 300, 500, false, CycleMethod.NO_CYCLE, new Stop(0, Color.grayRgb(60)), new Stop(1, Color.GREY))


            //Create a canvas
            Canvas canvas = new Canvas(width, height);
            root.getChildren().add(canvas);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.BLACK);

            //Add fond
            Image fond = new Image ("Resources/Sprites/Fond.png");
            gc.drawImage(fond, 50, 50, width-100, height-100);


            //gc.setFill(Color.WHITE);

            //Add Boss
            Boss boss = new Boss((width/2),(height/2), 70, 60);
            Image ImBoss = boss.getHeadBoss();
            gc.drawImage(ImBoss, boss.getX(), boss.getY(), boss.getWidth(), boss.getHeight());
            addBoss(gc);

            //Add Warrior
            addWarrior(gc, "J1");
            addWarrior(gc, "J2");

            //Timeloop
/*            final long startNanoTime = System.nanoTime();
            new AnimationTimer()
            {
                    public void handle(long currentNanoTime)
                    {
                            double t = (currentNanoTime -
                                    startNanoTime) / 1000000000.0;
                            double x = 232 + 128 * Math.cos(t);
                            double y = 232 + 128 * Math.sin(t);
                            gc.drawImage( space, 0, 0 );
                            gc.drawImage( earth, x, y );
                            gc.drawImage( sun, 196, 196 );
                    }
            }.start();
            /*
 */

            //Stage
            stage.setTitle("W A R  P O N G");
            stage.show();


    }

}
