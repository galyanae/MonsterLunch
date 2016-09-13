package galyanae.monsterlunch;

/**
 * Created by Owner on 13/09/2016.
 */
public class Food {
    private String type;
    private String name;
    private String color;

    private int image;
    private int bonus;
    private int negativeBonus;
    private int sound;

    public Food(int bonus, String color, int image, String name, int negativeBonus, int sound, String type) {
        this.bonus = bonus;
        this.color = color;
        this.image = image;
        this.name = name;
        this.negativeBonus = negativeBonus;
        this.sound = sound;
        this.type = type;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getNegativeBonus() {
        return negativeBonus;
    }

    public void setNegativeBonus(int negativeBonus) {
        this.negativeBonus = negativeBonus;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
