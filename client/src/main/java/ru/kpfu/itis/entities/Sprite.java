package ru.kpfu.itis.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite {
    private Image image;
    //    private ImageView imageView;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprite() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
    }

    public void setImage(Image i) {
        this.image = i;
//        this.imageView = new ImageView();
//        imageView.setImage(image);
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename) {
        Image i = new Image(filename);
        setImage(i);
    }

//    public void resizeImage(int width, int height){
//        System.out.println(image);
//        System.out.println(imageView);
//        imageView.setFitWidth(width);
////        imageView.setFitHeight(height);
//        imageView.setPreserveRatio(true);
//        imageView.setSmooth(true);
//        imageView.setCache(true);
//        imageView.setRotate(90);
////        imageView.fitHeightProperty();
////        imageView.fitWidthProperty();
//
//        System.out.println(imageView.getFitHeight());
//        System.out.println(imageView.getFitWidth());
//
//        System.out.println(imageView.getImage().getHeight());
//        System.out.println(imageView.getImage().getWidth());
//        setImage(imageView.getImage());
//    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX, positionY);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String toString() {
        return " Position: [" + positionX + "," + positionY + "]"
                + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
}