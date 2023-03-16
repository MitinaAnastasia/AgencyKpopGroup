package data;

import entity.Agency;
import entity.KpopGroup;
import entity.Member;

import java.sql.Date;

public class KpopAgencyTestsData {
    public static final Agency SUNNY = new Agency(2L, "sunny", "Пак Хён Сок", "+82 (630) 12 43 345", "Каннам-гу, Сеул, Корея");
    public static final Long SUNNY_ID = 2L;

    public static final KpopGroup TXT = new KpopGroup(2L, "txt", Date.valueOf("2017-09-12").toLocalDate(), Date.valueOf("2024-03-17").toLocalDate(), "Хан Мен Дук", 2L);
    public static final Long TXT_ID = 2L;

    public static final Member FELIX = new Member(2L, "Пак", "Хосок", "Felix", "+82(302) 12 32 134", Date.valueOf("2001-02-18").toLocalDate(), "рэп", 2L);
    public static final Long FELIX_ID = 2L;
}
