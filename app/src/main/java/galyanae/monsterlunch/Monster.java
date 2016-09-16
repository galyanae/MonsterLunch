package galyanae.monsterlunch;

import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Owner on 13/09/2016.
 */
public class Monster {


    private String story;

    private String name;
    private Food.FoodType foodType;
    private String foodColor;

    private int imageStand;
    private int imageWink;
    private int imageMounhClose;
    private int dead;
    private int imageHappy;

    private int animation;
    private int eatSound;
    private int dislikeSound;

    public Monster(int animation, int dead, int dislikeSound,
                   int eatSound, String foodColor, Food.FoodType foodType,
                   int imageHappy, int imageMounhClose, int imageStand,
                   int imageWink, String name, String story) {
        this.animation = animation;
        this.dead = dead;
        this.dislikeSound = dislikeSound;
        this.eatSound = eatSound;
        this.foodColor = foodColor;
        this.foodType = foodType;
        this.imageHappy = imageHappy;
        this.imageMounhClose = imageMounhClose;
        this.imageStand = imageStand;
        this.imageWink = imageWink;
        this.name = name;
        this.story = story;
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

    public int getDislikeSound() {
        return dislikeSound;
    }

    public void setDislikeSound(int dislikeSound) {
        this.dislikeSound = dislikeSound;
    }

    public int getEatSound() {
        return eatSound;
    }

    public void setEatSound(int eatSound) {
        this.eatSound = eatSound;
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

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
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
