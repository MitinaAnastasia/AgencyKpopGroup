package logic;

import data.KpopAgencyTestsData;
import org.junit.jupiter.api.Test;
import repository.AgencyRepository;
import repository.KpopGroupRepository;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GroupCRUDTests {
    private final KpopGroupRepository kpopGroupRepository = new KpopGroupRepository();
    private final AgencyRepository agencyRepository = new AgencyRepository();

    @Test
    public void GroupGetIdTest() {
        //given
        String expectedSelectQuery = "entity.KpopGroup{groupId=2, groupName='txt', dataStartContract=2017-09-12, dataEndContract=2024-03-17, managerName='Хан Мен Дук', agencyIdFk=2}";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        //when
        String actualSelectQuery = Objects.requireNonNull(kpopGroupRepository.get(KpopAgencyTestsData.TXT_ID)).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void GroupInsertIdTest() {
        //given
        String expectedSelectQuery = "Insert success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        //when
        String actualSelectQuery = kpopGroupRepository.insert(KpopAgencyTestsData.TXT);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void GroupUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        //when
        String actualSelectQuery = kpopGroupRepository.update(KpopAgencyTestsData.TXT);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void GroupDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        //when
        String actualSelectQuery = kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }
}
