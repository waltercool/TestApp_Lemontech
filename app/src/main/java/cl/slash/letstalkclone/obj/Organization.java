package cl.slash.letstalkclone.obj;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.util.Date;

import cl.slash.letstalkclone.utilities.DateToolkit;

/**
 * Created by waltercool on 26-08-14.
 */
public class Organization implements Parcelable {
    private int id;
    private String name, domain, subdomain, logo, location;
    private Date syncTime;
    private boolean active;

    public Organization(int id, String name, String domain, String subdomain, String logo,
            String location, Date syncTime, boolean active) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.subdomain = subdomain;
        this.logo = logo;
        this.location = location != null?location:"";
        this.syncTime = syncTime;
        this.active = active;
    }

    private Organization(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.domain = in.readString();
        this.subdomain = in.readString();
        this.logo = in.readString();
        this.location = in.readString();
        try {
            this.syncTime = DateToolkit.commonDateFormat().parse(in.readString());
        } catch(ParseException e) {
            e.printStackTrace();
            this.syncTime = new Date();
        }
        this.active = in.readInt() == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(domain);
        dest.writeString(subdomain);
        dest.writeString(logo);
        dest.writeString(location);
        dest.writeString(DateToolkit.commonDateFormat().format(syncTime));
        dest.writeInt(active?1:0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getLogo() {
        return logo;
    }

    public String getLocation() {
        return location;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public int describeContents() {return 0;}

    public static Creator<Organization> CREATOR = new Creator<Organization>() {
        @Override
        public Organization createFromParcel(Parcel source) {
            return new Organization(source);
        }

        @Override
        public Organization[] newArray(int size) {
            return new Organization[size];
        }
    };
}
