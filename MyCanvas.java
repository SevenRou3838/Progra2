import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JPanel;

public class MyCanvas extends JPanel implements ActionListener{
    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList<Ovni> ovnis = new ArrayList<Ovni>();
    ArrayList<Avion> avion = new ArrayList<Avion>();
    ArrayList<Barco> barco = new ArrayList<Barco>();

    public MyCanvas () {
        setPreferredSize(new Dimension(400,300));
        setBackground(Color.GRAY);
        Timer timer = new Timer(80, this);
        timer.start();
        cars.add(new Car(10, 250, 2, 0, Color.RED, 60,30));
        cars.add(new Car(10, 200, 3, 0, Color.BLUE, 50, 25));
        cars.add(new Car(10, 150, 4, 0, Color.GREEN, 40,20));
        cars.add(new Car(10, 100, 5, 0, Color.ORANGE, 30, 15) );
        ovnis.add(new Ovni(10, 50, 5, 0, Color.black, 80, 15) );
        avion.add(new Avion(100, 50, 5, 0, Color.gray, 80, 15) );
        barco.add(new Barco(100, 270, 5, 0, Color.green,80, 30) );
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Paintbrush paintBrush = new Paintbrush(g);
        paintBrush.drawSky();
        paintBrush.drawWater();
        paintBrush.drawMountains();
        for(Car c : cars){
            c.move();
            c.draw(g);
        }
        for(Ovni c : ovnis){
            c.move();
            c.draw(g);
        }
        for(Avion c : avion){
            c.move();
            c.draw(g);
        }
        for(Barco c : barco){
            c.move();
            c.draw(g);
        }
        paintBrush.drawTree();
        paintBrush.drawTree();
    }
    @Override
    public void actionPerformed(ActionEvent E) {
        repaint();
    }
    }
    
