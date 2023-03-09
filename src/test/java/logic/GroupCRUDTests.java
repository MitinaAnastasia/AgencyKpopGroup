package logic;

import data.KpopAgencyTestsData;
import org.junit.jupiter.api.Test;
import repository.KpopGroupRepository;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GroupCRUDTests {
    @Test
    public void GroupGetIdTest() {
        //given
        String expectedSelectQuery = "entity.KpopGroup{groupId=1, groupName='bts', dataStartContract=2007-09-12, dataEndContract=2015-03-17, managerName='Хан Гон Дор', agencyIdFk=1}";

        //when
        String actualSelectQuery = Objects.requireNonNull(KpopGroupRepository.get(KpopAgencyTestsData.BTS_ID)).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void GroupInsertIdTest() {
        //given
        String expectedSelectQuery = "Insert success";

        //when
        String actualSelectQuery = KpopGroupRepository.insert(KpopAgencyTestsData.TXT);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void GroupUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";

        //when
        String actualSelectQuery = KpopGroupRepository.update(KpopAgencyTestsData.TXT);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void GroupDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";

        //when
        String actualSelectQuery = KpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }
}
