package repository;

import connect.ConnectionFactory;
import entity.Member;

import java.sql.*;

public class MemberRepository {
    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    public Member get(Long memberId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from \"Member\" where \"memberId\" = ?");
            statement.setLong(1, memberId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return findMember(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Member findMember(ResultSet resultSet) throws SQLException {
        return new Member(
                resultSet.getLong("memberId"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("nickname"),
                resultSet.getString("telephoneNumber"),
                resultSet.getDate("birth").toLocalDate(),
                resultSet.getString("position"),
                resultSet.getLong("groupIdFk")
        );
    }

    public String update(Member member) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update \"Member\" set \"name\" = ?," +
                    "\"surname\" = ?, \"nickname\" = ?, \"telephoneNumber\" = ?, \"birth\" = ?, \"position\" = ?, \"groupIdFk\" = ? where \"memberId\" = ?");
            statement.setString(1, member.getName());
            statement.setString(2, member.getSurname());
            statement.setString(3, member.getNickname());
            statement.setString(4, member.getTelephoneNumber());
            statement.setDate(5, Date.valueOf(member.getBirth()));
            statement.setString(6, member.getPosition());
            statement.setLong(7, member.getGroupIdFk());
            statement.setLong(8, member.getMemberId());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Update success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public Long insert(Member member) {
        long memberId = 0L;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into \"Member\" (\"name\"," +
                    "\"surname\", \"nickname\", \"telephoneNumber\", \"birth\", \"position\", \"groupIdFk\") values (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, member.getName());
            statement.setString(2, member.getSurname());
            statement.setString(3, member.getNickname());
            statement.setString(4, member.getTelephoneNumber());
            statement.setDate(5, Date.valueOf(member.getBirth()));
            statement.setString(6, member.getPosition());
            statement.setLong(7, member.getGroupIdFk());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        memberId = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return memberId;
    }

    public String delete(Long memberId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from \"Member\" where \"memberId\" = ?");
            statement.setLong(1, memberId);
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
