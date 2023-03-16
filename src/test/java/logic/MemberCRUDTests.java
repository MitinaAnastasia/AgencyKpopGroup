package logic;

import data.KpopAgencyTestsData;
import org.junit.jupiter.api.Test;
import repository.AgencyRepository;
import repository.KpopGroupRepository;
import repository.MemberRepository;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberCRUDTests {
    private final MemberRepository memberRepository = new MemberRepository();
    private final KpopGroupRepository kpopGroupRepository = new KpopGroupRepository();
    private final AgencyRepository agencyRepository = new AgencyRepository();

    @Test
    public void MemberGetIdTest() {
        //given
        String expectedSelectQuery = "entity.Member{memberId=2, name='Пак', surname='Хосок', nickname='Felix', telephoneNumber='+82(302) 12 32 134', birth=2001-02-18, position='рэп', groupIdFk=2}";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        memberRepository.insert(KpopAgencyTestsData.FELIX);
        //when
        String actualSelectQuery = Objects.requireNonNull(memberRepository.get(KpopAgencyTestsData.FELIX_ID)).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(KpopAgencyTestsData.FELIX_ID);
        kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void MemberInsertIdTest() {
        //given
        String expectedSelectQuery = "Insert success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        //when
        String actualSelectQuery = memberRepository.insert(KpopAgencyTestsData.FELIX);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(KpopAgencyTestsData.FELIX_ID);
        kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void MemberUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        memberRepository.insert(KpopAgencyTestsData.FELIX);

        //when
        String actualSelectQuery = memberRepository.update(KpopAgencyTestsData.FELIX);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(KpopAgencyTestsData.FELIX_ID);
        kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }

    @Test
    public void MemberDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";
        agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        memberRepository.insert(KpopAgencyTestsData.FELIX);

        //when
        String actualSelectQuery = memberRepository.delete(KpopAgencyTestsData.FELIX_ID);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(KpopAgencyTestsData.TXT_ID);
        agencyRepository.delete(KpopAgencyTestsData.SUNNY_ID);
    }
}
