package logic;

import data.KpopAgencyTestsData;
import entity.Agency;
import entity.KpopGroup;
import org.junit.jupiter.api.Test;
import repository.AgencyRepository;
import repository.KpopGroupRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GroupCRUDTests {
    private final KpopGroupRepository kpopGroupRepository = new KpopGroupRepository();
    private final AgencyRepository agencyRepository = new AgencyRepository();

    @Test
    public void GroupGetIdTest() {
        //given
        Long agencyId = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        KpopAgencyTestsData.TXT.setAgencyIdFk(agencyId);
        Long groupId = kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        KpopAgencyTestsData.TXT.setGroupId(groupId);
        String expectedSelectQuery = KpopAgencyTestsData.TXT.toString();
        //when
        String actualSelectQuery = kpopGroupRepository.get(groupId).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(groupId);
        agencyRepository.delete(agencyId);
    }

    @Test
    public void GroupInsertIdTest() {
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        //when
        Long actualSelectQuery = kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        KpopGroup kpopGroup = kpopGroupRepository.get(actualSelectQuery);
        Long id = kpopGroup.getGroupId();
        //given
        Long expectedSelectQuery = id;

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(id);
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void GroupUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.get(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        //when
        String actualSelectQuery = kpopGroupRepository.update(kpopGroup);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(kpopGroup.getGroupId());
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void GroupDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.get(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        //when
        String actualSelectQuery = kpopGroupRepository.delete(kpopGroup.getGroupId());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        agencyRepository.delete(agency.getAgencyId());
    }
}
