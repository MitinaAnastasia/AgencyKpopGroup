package logic;

import data.KpopAgencyTestsData;
import org.junit.jupiter.api.Test;
import repository.AgencyRepository;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgencyCRUDTests {
    private final AgencyRepository agencyRepository = new AgencyRepository();

    @Test
    public void AgencyGetIdTest() {
        //given
        String expectedSelectQuery = "entity.Agency{agencyId=2, agencyName='sunny', directorName='Пак Хён Сок', telephoneNumber='+82 (630) 12 43 345', address='Каннам-гу, Сеул, Корея'}";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        //when
        String actualSelectQuery = Objects.requireNonNull(agencyRepository.get(KpopAgencyTestsData.SUNNY_ID)).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void AgencyInsertIdTest() {
        //given
        String expectedSelectQuery = "Insert success";

        //when
        String actualSelectQuery = agencyRepository.insert(KpopAgencyTestsData.SUNNY);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void AgencyUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        //when
        String actualSelectQuery = agencyRepository.update(KpopAgencyTestsData.SUNNY);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void AgencyDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        //when
        String actualSelectQuery = agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }
}
