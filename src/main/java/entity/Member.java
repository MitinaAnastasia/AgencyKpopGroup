package entity;

import java.sql.Date;

public class Member {
    private int memberId;
    private String name;
    private String surname;
    private String nickname;
    private String telephoneNumber;
    private Date birth;
    private String position;
    private int groupIdFk;

    public Member(int memberId, String name, String surname, String nickname, String telephoneNumber, Date birth, String position, int groupIdFk) {
        this.memberId = memberId;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.telephoneNumber = telephoneNumber;
        this.birth = birth;
        this.position = position;
        this.groupIdFk = groupIdFk;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGroupIdFk() {
        return groupIdFk;
    }

    public void setGroupIdFk(int groupIdFk) {
        this.groupIdFk = groupIdFk;
    }

    @Override
    public String toString() {
        return "entity.Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", birth=" + birth +
                ", position='" + position + '\'' +
                ", groupIdFk=" + groupIdFk +
                '}';
    }
}
