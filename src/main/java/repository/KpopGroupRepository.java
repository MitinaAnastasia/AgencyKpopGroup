package repository;

import connect.ConnectionFactory;
import entity.KpopGroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KpopGroupRepository {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    public KpopGroup get(Long groupId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select \"groupId\", \"groupName\", \"dataStartContract\", \"dataEndContract\", \"managerName\", \"agencyIdFk\" from \"KpopGroup\" where \"groupId\" = ?");
            statement.setLong(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return findGroup(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private KpopGroup findGroup(ResultSet resultSet) throws SQLException {
        return new KpopGroup(
                resultSet.getLong("groupId"),
                resultSet.getString("groupName"),
                resultSet.getDate("dataStartContract").toLocalDate(),
                resultSet.getDate("dataEndContract").toLocalDate(),
                resultSet.getString("managerName"),
                resultSet.getLong("agencyIdFk")
        );
    }

    public List<KpopGroup> getAllById(Long agencyIdFk) {
        List<KpopGroup> kpopGroups = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select \"groupId\", \"groupName\", \"dataStartContract\", \"dataEndContract\", \"managerName\", \"agencyIdFk\" from \"KpopGroup\" where \"agencyIdFk\" = ?");
            statement.setLong(1, agencyIdFk);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                kpopGroups.add(findGroup(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kpopGroups;
    }

    public String update(KpopGroup group) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update \"KpopGroup\" set \"groupName\" = ?," +
                    "\"dataStartContract\" = ?, \"dataEndContract\" = ?, \"managerName\" = ?, \"agencyIdFk\" = ? where \"groupId\" = ?");
            statement.setString(1, group.getGroupName());
            statement.setDate(2, Date.valueOf(group.getDataStartContract()));
            statement.setDate(3, Date.valueOf(group.getDataEndContract()));
            statement.setString(4, group.getManagerName());
            statement.setLong(5, group.getAgencyIdFk());
            statement.setLong(6, group.getGroupId());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Update success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public Long insert(KpopGroup group) {
        long groupId = 0L;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into \"KpopGroup\" (\"groupName\"," +
                    "\"dataStartContract\", \"dataEndContract\", \"managerName\", \"agencyIdFk\") values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getGroupName());
            statement.setDate(2, Date.valueOf(group.getDataStartContract()));
            statement.setDate(3, Date.valueOf(group.getDataEndContract()));
            statement.setString(4, group.getManagerName());
            statement.setLong(5, group.getAgencyIdFk());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        groupId = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groupId;
    }

    public String delete(Long groupId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from \"KpopGroup\" where \"groupId\" = ?");
            statement.setLong(1, groupId);
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Delete success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

}
