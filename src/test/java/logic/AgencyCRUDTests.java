package logic;

import data.KpopAgencyTestsData;
import org.junit.jupiter.api.Test;
import repository.AgencyRepository;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgencyCRUDTests {
    @Test
    public void AgencyGetIdTest() {
        //given
        String expectedSelectQuery = "entity.Agency{agencyId=1, agencyName='big hit', directorName='Сук Пак Рен', telephoneNumber='+82 (630) 23 23 345', address='Торговый центр Йонсан, Сеул, Корея'}";

        //when
        String actualSelectQuery = Objects.requireNonNull(AgencyRepository.get(KpopAgencyTestsData.BIG_HIT_ID)).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void AgencyInsertIdTest() {
        //given
        String expectedSelectQuery = "Insert success";

        //when
        String actualSelectQuery = AgencyRepository.insert(KpopAgencyTestsData.SUNNY);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void AgencyUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";

        //when
        String actualSelectQuery = AgencyRepository.update(KpopAgencyTestsData.SUNNY);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void AgencyDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";

        //when
        String actualSelectQuery = AgencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }
}
