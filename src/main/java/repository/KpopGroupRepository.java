package repository;

import connect.ConnectionFactory;
import entity.KpopGroup;

import java.sql.*;

public class KpopGroupRepository {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    public KpopGroup get(Long groupId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from \"KpopGroup\" where \"groupId\" = ?");
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

    public String insert(KpopGroup group) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into \"KpopGroup\" (\"groupId\",\"groupName\"," +
                    "\"dataStartContract\", \"dataEndContract\", \"managerName\", \"agencyIdFk\") values (?, ?, ?, ?, ?, ?)");
            statement.setLong(1, group.getGroupId());
            statement.setString(2, group.getGroupName());
            statement.setDate(3, Date.valueOf(group.getDataStartContract()));
            statement.setDate(4, Date.valueOf(group.getDataEndContract()));
            statement.setString(5, group.getManagerName());
            statement.setLong(6, group.getAgencyIdFk());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Insert success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
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
