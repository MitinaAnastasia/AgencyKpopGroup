package repository;

import connect.ConnectionFactory;
import entity.Agency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgencyRepository {

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    public Agency get(Long agencyId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from \"Agency\" where \"agencyId\" = ?");
            statement.setLong(1, agencyId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return findAgency(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Agency findAgency(ResultSet resultSet) throws SQLException {
        return new Agency(
                resultSet.getLong("agencyId"),
                resultSet.getString("agencyName"),
                resultSet.getString("directorName"),
                resultSet.getString("telephoneNumber"),
                resultSet.getString("address")
        );
    }

    public List<Agency> getAll() {
        List<Agency> agencies = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from \"Agency\"");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                agencies.add(findAgency(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agencies;
    }

    public String update(Agency agency) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update \"Agency\" set \"agencyName\" = ?," +
                    "\"directorName\" = ?, \"address\" = ?, \"telephoneNumber\" = ? where \"agencyId\" = ?");
            statement.setString(1, agency.getAgencyName());
            statement.setString(2, agency.getDirectorName());
            statement.setString(3, agency.getAddress());
            statement.setString(4, agency.getTelephoneNumber());
            statement.setLong(5, agency.getAgencyId());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                return "Update success";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public Long insert(Agency agency) {
        long agencyId = 0L;
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into \"Agency\" (\"agencyName\"," +
                    "\"directorName\", \"address\", \"telephoneNumber\") values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, agency.getAgencyName());
            statement.setString(2, agency.getDirectorName());
            statement.setString(3, agency.getAddress());
            statement.setString(4, agency.getTelephoneNumber());
            int countRows = statement.executeUpdate();
            if (countRows > 0) {
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        agencyId = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agencyId;
    }

    public String delete(Long agencyId) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from \"Agency\" where \"agencyId\" = ?");
            statement.setLong(1, agencyId);
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
