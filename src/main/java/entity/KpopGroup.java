package entity;

import java.sql.Date;

public class KpopGroup {
    private int groupId;
    private String groupName;
    private Date dataStartContract;
    private Date dataEndContract;
    private String managerName;
    private int agencyIdFk;

    public KpopGroup(int groupId, String groupName, Date dataStartContract, Date dataEndContract, String managerName, int agencyIdFk) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.dataStartContract = dataStartContract;
        this.dataEndContract = dataEndContract;
        this.managerName = managerName;
        this.agencyIdFk = agencyIdFk;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getDataStartContract() {
        return dataStartContract;
    }

    public void setDataStartContract(Date dataStartContract) {
        this.dataStartContract = dataStartContract;
    }

    public Date getDataEndContract() {
        return dataEndContract;
    }

    public void setDataEndContract(Date dataEndContract) {
        this.dataEndContract = dataEndContract;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getAgencyIdFk() {
        return agencyIdFk;
    }

    public void setAgencyIdFk(int agencyIdFk) {
        this.agencyIdFk = agencyIdFk;
    }

    @Override
    public String toString() {
        return "entity.KpopGroup{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", dataStartContract=" + dataStartContract +
                ", dataEndContract=" + dataEndContract +
                ", managerName='" + managerName + '\'' +
                ", agencyIdFk=" + agencyIdFk +
                '}';
    }
}
