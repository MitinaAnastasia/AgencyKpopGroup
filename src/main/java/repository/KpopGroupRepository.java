package repository;

import connect.ConnectionFactory;
import entity.KpopGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KpopGroupRepository {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    public static KpopGroup get(int groupId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from \"KpopGroup\" where \"groupId\" = ?");
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getGroup(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static KpopGroup getGroup(ResultSet resultSet) throws SQLException {
        return new KpopGroup(
                resultSet.getInt("groupId"),
                resultSet.getString("groupName"),
                resultSet.getDate("dataStartContract"),
                resultSet.getDate("dataEndContract"),
                resultSet.getString("managerName"),
                resultSet.getInt("agencyIdFk")
        );
    }

    public static String update(KpopGroup group) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update \"KpopGroup\" set \"groupName\" = ?," +
                    "\"dataStartContract\" = ?, \"dataEndContract\" = ?, \"managerName\" = ?, \"agencyIdFk\" = ? where \"groupId\" = ?");
            statement.setString(1, group.getGroupName());
            statement.setDate(2, group.getDataStartContract());
            statement.setDate(3, group.getDataEndContract());
            statement.setString(4, group.getManagerName());
            statement.setInt(5, group.getAgencyIdFk());
            statement.setInt(6, group.getGroupId());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Update success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public static String insert(KpopGroup group) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into \"KpopGroup\" (\"groupId\",\"groupName\"," +
                    "\"dataStartContract\", \"dataEndContract\", \"managerName\", \"agencyIdFk\") values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, group.getGroupId());
            statement.setString(2, group.getGroupName());
            statement.setDate(3, group.getDataStartContract());
            statement.setDate(4, group.getDataEndContract());
            statement.setString(5, group.getManagerName());
            statement.setInt(6, group.getAgencyIdFk());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Insert success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public static String delete(int groupId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from \"KpopGroup\" where \"groupId\" = ?");
            statement.setInt(1, groupId);
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
