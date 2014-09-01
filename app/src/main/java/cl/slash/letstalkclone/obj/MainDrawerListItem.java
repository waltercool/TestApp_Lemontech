package cl.slash.letstalkclone.obj;

/**
 * Created by waltercool on 01-09-14.
 */
public class MainDrawerListItem {
    private int id;
    private String name;
    private int image;

    public MainDrawerListItem(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
