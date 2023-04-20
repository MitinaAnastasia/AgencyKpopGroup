package logic;

import data.KpopAgencyTestsData;
import entity.Agency;
import org.junit.jupiter.api.Test;
import repository.AgencyRepository;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgencyCRUDTests {
    private final AgencyRepository agencyRepository = new AgencyRepository();

    @Test
    public void AgencyGetIdTest() {
        Long id = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        KpopAgencyTestsData.SUNNY.setAgencyId(id);
        //given
        String expectedSelectQuery = KpopAgencyTestsData.SUNNY.toString();
        //when
        String actualSelectQuery = Objects.requireNonNull(agencyRepository.get(id).toString());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(id);
    }

    @Test
    public void AgencyInsertIdTest() {
        //when
        Long actualSelectQuery = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        Agency agency = agencyRepository.get(actualSelectQuery);
        Long id = agency.getAgencyId();
        //given
        Long expectedSelectQuery = id;

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(id);
    }

    @Test
    public void AgencyUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        //when
        String actualSelectQuery = agencyRepository.update(agency);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void AgencyDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        //when
        String actualSelectQuery = agencyRepository.delete(agency.getAgencyId());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }
}
