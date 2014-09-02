package cl.slash.letstalkclone.obj;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by waltercool on 01-09-14.
 */
public class Conversation implements Parcelable
{
    private int id;
    private String issue;
    private int unreadMessages;
    private String lastMessage;
    private List<Person> people;
    private Person lastMessagePerson;

    public Conversation(int id, String issue, int unreadMessages, String lastMessage, List<Person> people, Person lastMessagePerson){
        this.id = id;
        this.issue = issue;
        this.unreadMessages = unreadMessages;
        this.lastMessage = lastMessage;
        this.people = people;
        this.lastMessagePerson = lastMessagePerson;
    }

    private Conversation(Parcel in)
    {
        this.id = in.readInt();
        this.issue = in.readString();
        this.unreadMessages = in.readInt();
        this.lastMessage = in.readString();
        this.people = in.readArrayList(Person.class.getClassLoader());
        this.lastMessagePerson = in.readParcelable(Person.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.issue);
        dest.writeInt(this.unreadMessages);
        dest.writeString(this.lastMessage);
        dest.writeList(this.people);
        dest.writeParcelable(lastMessagePerson, 0);
    }

    public int getId() {
        return id;
    }

    public String getIssue() {
        return issue;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getUnreadMessages() {
        return unreadMessages;
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getLastMessagePerson() {
        return lastMessagePerson;
    }

    public static final Creator<Conversation> CREATOR = new Creator<Conversation>() {
        @Override
        public Conversation createFromParcel(Parcel source) {
            return new Conversation(source);
        }

        @Override
        public Conversation[] newArray(int size) {
            return new Conversation[size];
        }
    };

    @Override
    public int describeContents() {return 0;}
}
