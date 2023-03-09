package data;

import entity.Agency;
import entity.KpopGroup;
import entity.Member;

import java.sql.Date;

public class KpopAgencyTestsData {
    public static final Agency SUNNY = new Agency(2, "sunny", "Пак Хён Сок", "+82 (630) 12 43 345", "Каннам-гу, Сеул, Корея");
    public static final int SUNNY_ID = 2;
    public static final int BIG_HIT_ID = 1;

    public static final KpopGroup TXT = new KpopGroup(2, "txt", Date.valueOf("2017-09-12"), Date.valueOf("2024-03-17"), "Хан Мен Дук", 1);
    public static final int TXT_ID = 2;
    public static final int BTS_ID = 1;

    public static final Member FELIX = new Member(2, "Пак", "Хосок", "Felix", "+82(302) 12 32 134", Date.valueOf("2001-02-18"), "рэп", 1);
    public static final int FELIX_ID = 2;
    public static final int SUGAR_ID = 1;

}
