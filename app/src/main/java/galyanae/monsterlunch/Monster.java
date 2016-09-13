package galyanae.monsterlunch;

import android.view.animation.Animation;

/**
 * Created by Owner on 13/09/2016.
 */
public class Monster {
    private String name;
    private String foodType;
    private String foodColor;

    private int image;
    private Animation animation;
    private int sound;

    public Monster(Animation animation, String foodColor, String foodType, int image, String name, int sound) {
        this.animation = animation;
        this.foodColor = foodColor;
        this.foodType = foodType;
        this.image = image;
        this.name = name;
        this.sound = sound;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public String getFoodColor() {
        return foodColor;
    }

    public void setFoodColor(String foodColor) {
        this.foodColor = foodColor;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
