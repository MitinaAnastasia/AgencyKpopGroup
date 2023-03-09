package logic;

import data.KpopAgencyTestsData;
import org.junit.jupiter.api.Test;
import repository.MemberRepository;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberCRUDTests {
    @Test
    public void MemberGetIdTest() {
        //given
        String expectedSelectQuery = "entity.Member{memberId=1, name='Мин', surname='Юнги', nickname='Sugar', telephoneNumber='+82(302) 12 32 134', birth=1991-02-18, position='танцы', groupIdFk=1}";

        //when
        String actualSelectQuery = Objects.requireNonNull(MemberRepository.get(KpopAgencyTestsData.SUGAR_ID)).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void MemberInsertIdTest() {
        //given
        String expectedSelectQuery = "Insert success";

        //when
        String actualSelectQuery = MemberRepository.insert(KpopAgencyTestsData.FELIX);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void MemberUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";

        //when
        String actualSelectQuery = MemberRepository.update(KpopAgencyTestsData.FELIX);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }

    @Test
    public void MemberDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";

        //when
        String actualSelectQuery = MemberRepository.delete(KpopAgencyTestsData.FELIX_ID);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
    }
}
