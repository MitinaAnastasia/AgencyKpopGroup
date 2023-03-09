package repository;

import connect.ConnectionFactory;
import entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    public static Member get(int memberId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from \"Member\" where \"memberId\" = ?");
            statement.setInt(1, memberId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return getMember(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static Member getMember(ResultSet resultSet) throws SQLException {
        return new Member(
                resultSet.getInt("memberId"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("nickname"),
                resultSet.getString("telephoneNumber"),
                resultSet.getDate("birth"),
                resultSet.getString("position"),
                resultSet.getInt("groupIdFk")
        );
    }

    public static String update(Member member) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update \"Member\" set \"name\" = ?," +
                    "\"surname\" = ?, \"nickname\" = ?, \"telephoneNumber\" = ?, \"birth\" = ?, \"position\" = ?, \"groupIdFk\" = ? where \"memberId\" = ?");
            statement.setString(1, member.getName());
            statement.setString(2, member.getSurname());
            statement.setString(3, member.getNickname());
            statement.setString(4, member.getTelephoneNumber());
            statement.setDate(5, member.getBirth());
            statement.setString(6, member.getPosition());
            statement.setInt(7, member.getGroupIdFk());
            statement.setInt(8, member.getMemberId());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Update success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public static String insert(Member member) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into \"Member\" (\"memberId\",\"name\"," +
                    "\"surname\", \"nickname\", \"telephoneNumber\", \"birth\", \"position\", \"groupIdFk\") values (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, member.getMemberId());
            statement.setString(2, member.getName());
            statement.setString(3, member.getSurname());
            statement.setString(4, member.getNickname());
            statement.setString(5, member.getTelephoneNumber());
            statement.setDate(6, member.getBirth());
            statement.setString(7, member.getPosition());
            statement.setInt(8, member.getGroupIdFk());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Insert success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public static String delete(int memberId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from \"Member\" where \"memberId\" = ?");
            statement.setInt(1, memberId);
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
