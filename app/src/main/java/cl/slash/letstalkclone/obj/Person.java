package cl.slash.letstalkclone.obj;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.util.Date;

import cl.slash.letstalkclone.utilities.DateToolkit;

/**
 * Created by waltercool on 26-08-14.
 */
public class Person implements Parcelable {
    private int id;
    private String name;
    private String email;
    private Date createdAt;
    private String urlAvatar;
    private String token;

    public Person(int id, String name, String email, Date createdAt, String urlAvatar, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.urlAvatar = urlAvatar;
        this.token = token;
    }

    private Person(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
        try {
            this.createdAt = DateToolkit.commonDateFormat().parse(in.readString());
        } catch(ParseException e) {
            e.printStackTrace();
            this.createdAt = new Date();
        }
        this.urlAvatar = in.readString();
        this.token = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(DateToolkit.commonDateFormat().format(createdAt));
        dest.writeString(urlAvatar);
        dest.writeString(token);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public String getToken() {
        return token;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {return 0;}
}
