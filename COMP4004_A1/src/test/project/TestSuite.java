package project;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({FullChest_test.class, Game_Get_Winner_Test.class, Game_GetFortuneCard_Test.class, Game_PrintDiceRoll_test.class,
                 dice.class, GameServer_winner_Test.class, isSet_Test.class, Player_2SkullCard_Test.class, Player_2SwordSeaBattle_Test.class,
                Player_3SwordSeaBattle_Test.class, Player_4SwordSeaBattle_Test.class, Player_CaptainCard_Test.class, Player_Chest_Test.class,
                Player_CoinCard_Test.class, Player_constructor_Test.class, Player_DiamondCard_Test.class, Player_getPlayer_Test.class,
                Player_getRoundScore_Test.class, Player_getTotalScore_Test.class, Player_getUpAndLower_score_Test.class, Player_IslandSkull_Test.class,
                Player_MonkeyCard_Test.class, Player_moreRound_4Skull_Test.class, Player_OneSkullCard_Test.class, Player_RollDiceWith3Skull_InFirstRounf_Test.class,
                Player_scoresheet_getandSet_Test.class, Player_Sorceress_Test.class, Player_UserSelectionReroll_Test.class, reRoll_test.class,
                score_CoinandDiamond_Test.class, ScoreFullChest_Test.class, ScoreSet_Test.class})
public class TestSuite {
}
