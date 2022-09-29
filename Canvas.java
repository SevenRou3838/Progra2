import javax.swing.*;
class Canvas{
    public static void main(String args[]){
        JFrame window = new JFrame("Swing");
        MyCanvas canvas= new MyCanvas();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(400,300);
        window.add(canvas);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}