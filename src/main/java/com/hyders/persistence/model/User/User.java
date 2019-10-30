package com.hyders.persistence.model.User;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity (name="User")
@Table (name="usertable")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public User() {
        super();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column (name="id")
    private Long id;

    @Column(name="userId")
    private int userId;

    @Column(name= "ip")
    private String ip;

    @Column(name="timestamp")
    private Date timestamp;

    @Column(name="userAgent")
    private String userAgent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Integer.toString(userId) == null) ? 0 : Integer.toString(userId).hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (Integer.toString(userId) == null) {
            if (Integer.toString(other.userId) != null)
                return false;
        } else if (!Integer.toString(userId).equals(Integer.toString(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Foo [name=").append(userId).append("]");
        return builder.toString();
    }

}
