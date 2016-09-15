package galyanae.monsterlunch;

import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Owner on 13/09/2016.
 */
public class Monster {




    private String name;
    private Food.FoodType foodType;
    private String foodColor;

    private int imageStand;
    private int imageWink;
    private int imageMounhClose;
    private int dead;
    private int imageHappy;

    private int animation;
    private int sound;

    public Monster(int animation, int dead, String foodColor,
                   Food.FoodType foodType, int imageHappy, int imageMounhClose,
                   int imageStand, int imageWink, String name, int sound) {
        this.animation = animation;
        this.dead = dead;
        this.foodColor = foodColor;
        this.foodType = foodType;
        this.imageHappy = imageHappy;
        this.imageMounhClose = imageMounhClose;
        this.imageStand = imageStand;
        this.imageWink = imageWink;
        this.name = name;
        this.sound = sound;
    }

    public int getAnimation() {
        return animation;
    }

    public void setAnimation(int animation) {
        this.animation = animation;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public String getFoodColor() {
        return foodColor;
    }

    public void setFoodColor(String foodColor) {
        this.foodColor = foodColor;
    }

    public Food.FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(Food.FoodType foodType) {
        this.foodType = foodType;
    }

    public int getImageHappy() {
        return imageHappy;
    }

    public void setImageHappy(int imageHappy) {
        this.imageHappy = imageHappy;
    }

    public int getImageMounhClose() {
        return imageMounhClose;
    }

    public void setImageMounhClose(int imageMounhClose) {
        this.imageMounhClose = imageMounhClose;
    }

    public int getImageStand() {
        return imageStand;
    }

    public void setImageStand(int imageStand) {
        this.imageStand = imageStand;
    }

    public int getImageWink() {
        return imageWink;
    }

    public void setImageWink(int imageWink) {
        this.imageWink = imageWink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int eat (Food food){
        int foodBonus=0;
        if (this.getFoodType()==food.getType()){
           foodBonus += food.getBonus();
        }
        else {
            foodBonus-=food.getNegativeBonus();
        }
        return foodBonus;


    }


}
