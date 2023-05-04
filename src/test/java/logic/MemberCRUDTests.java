package logic;

import data.KpopAgencyTestsData;
import entity.Agency;
import entity.KpopGroup;
import entity.Member;
import org.junit.jupiter.api.Test;
import repository.AgencyRepository;
import repository.KpopGroupRepository;
import repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberCRUDTests {
    private final MemberRepository memberRepository = new MemberRepository();
    private final KpopGroupRepository kpopGroupRepository = new KpopGroupRepository();
    private final AgencyRepository agencyRepository = new AgencyRepository();

    @Test
    public void MemberGetIdTest() {
        //given
        Long agencyId = agencyRepository.insert(KpopAgencyTestsData.SUNNY);
        KpopAgencyTestsData.TXT.setAgencyIdFk(agencyId);
        Long groupId = kpopGroupRepository.insert(KpopAgencyTestsData.TXT);
        KpopAgencyTestsData.FELIX.setGroupIdFk(groupId);
        Long memberId = memberRepository.insert(KpopAgencyTestsData.FELIX);
        KpopAgencyTestsData.FELIX.setMemberId(memberId);
        String expectedSelectQuery = KpopAgencyTestsData.FELIX.toString();
        //when
        String actualSelectQuery = memberRepository.get(memberId).toString();

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(memberId);
        kpopGroupRepository.delete(groupId);
        agencyRepository.delete(agencyId);
    }

    @Test
    public void MemberInsertIdTest() {
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.get(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        KpopAgencyTestsData.FELIX.setGroupIdFk(kpopGroup.getGroupId());
        //when
        Long actualSelectQuery = memberRepository.insert(KpopAgencyTestsData.FELIX);
        Member member = memberRepository.get(actualSelectQuery);
        Long id = member.getMemberId();
        //given
        Long expectedSelectQuery = id;

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(id);
        kpopGroupRepository.delete(kpopGroup.getGroupId());
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void MemberUpdateIdTest() {
        //given
        String expectedSelectQuery = "Update success";
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.get(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        KpopAgencyTestsData.FELIX.setGroupIdFk(kpopGroup.getGroupId());
        Member member = memberRepository.get(memberRepository.insert(KpopAgencyTestsData.FELIX));

        //when
        String actualSelectQuery = memberRepository.update(member);

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        memberRepository.delete(member.getMemberId());
        kpopGroupRepository.delete(kpopGroup.getGroupId());
        agencyRepository.delete(agency.getAgencyId());
    }

    @Test
    public void MemberDeleteIdTest() {
        //given
        String expectedSelectQuery = "Delete success";
        Agency agency = agencyRepository.get(agencyRepository.insert(KpopAgencyTestsData.SUNNY));
        KpopAgencyTestsData.TXT.setAgencyIdFk(agency.getAgencyId());
        KpopGroup kpopGroup = kpopGroupRepository.get(kpopGroupRepository.insert(KpopAgencyTestsData.TXT));
        KpopAgencyTestsData.FELIX.setGroupIdFk(kpopGroup.getGroupId());
        Member member = memberRepository.get(memberRepository.insert(KpopAgencyTestsData.FELIX));

        //when
        String actualSelectQuery = memberRepository.delete(member.getMemberId());

        //then
        assertEquals(expectedSelectQuery, actualSelectQuery);
        kpopGroupRepository.delete(kpopGroup.getGroupId());
        agencyRepository.delete(agency.getAgencyId());
    }
}
