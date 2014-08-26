package cl.slash.letstalkclone.obj;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by waltercool on 26-08-14.
 */
public class Message implements Parcelable {

    private int id;
    private String contentType, content, who, repliedOn, mType;
    private Person person;
    public Message(int id, String contentType, String content, String who, String repliedOn,
                   String mType, Person person)
    {
        this.id = id;
        this.contentType = contentType;
        this.content = content;
        this.who = who;
        this.repliedOn = repliedOn;
        this.mType = mType;
        this.person = person;
    }

    private Message(Parcel in) {
        this.id = in.readInt();
        this.contentType = in.readString();
        this.content = in.readString();
        this.who = in.readString();
        this.repliedOn = in.readString();
        this.mType = in.readString();
        this.person = in.readParcelable(Person.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(contentType);
        dest.writeString(content);
        dest.writeString(who);
        dest.writeString(repliedOn);
        dest.writeString(mType);
        dest.writeParcelable(person, 0);
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            return new Message(source);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getContentType() {
        return contentType;
    }

    public String getContent() {
        return content;
    }

    public String getWho() {
        return who;
    }

    public String getRepliedOn() {
        return repliedOn;
    }

    public String getmType() {
        return mType;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public int describeContents() {return 0;}
}
