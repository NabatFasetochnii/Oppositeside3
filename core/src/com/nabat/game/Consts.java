package com.nabat.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

import java.util.HashMap;
import java.util.Map;

public class Consts {
    //
    private static final String LEADERBOARD1 = "BOARD1";
    private static final String LEADER_BOARD = "CgkIpq7zg9UYEAIQAg";//
    private static final String PRIME = "Prime";
    private static final String FAST_START = "FastStart";
    private static final String FASTEST_FINGERS_IN_THE_WILD_WEST = "FastestFingersInTheWildWest";
    private static final String NICE = "Nice";
    private static final String NICE2 = "Nice2";
    private static final String IS_IT_YOU_AGAIN = "IsItYouAgain";
    private static final String THE_DEVIL_HIMSELF = "TheDevilHimself";
    private static final String IM_AT_HOME = "ImAtHome";
    private static final String TAKE_THOUGHT = "TakeThought";
    private static final String IMPOSSIBLE = "Impossible";
    private static final String IS_THIS_AN_RPG = "IsThisAnRPG";
    private static final String SPEED_RUN = "SpeedRun";
    private static final Map<String, String> achievements = new HashMap<>();
    private static final Map<String, String> events = new HashMap<>();
    //
    private final static String ttfPath = "fonts/Terminus.ttf";//путь к шрифту
    //private final static String SOUND = "Sound";
    //
    private final static String PATH_TO_FIRST = "levels/1/1";//пути к файлам базовых уровней
    //
    private final static String PATH_TO_SECOND = "levels/2/1";
    private final static String PATH_TO_THIRD = "levels/3/1";
    private final static String PATH_TO_FOURTH = "levels/4/1";
    //
    private final static String PATH_TO_FIRST_COMPLICATED = "levels/1/2";
    private final static String PATH_TO_SECOND_COMPLICATED = "levels/2/2";
    private final static String PATH_TO_THIRD_COMPLICATED = "levels/3/2";
    private final static String PATH_TO_FOURTH_COMPLICATED = "levels/4/2";
    //
    private final static String PATH_TO_FIRST_ROTATION = "levels/1/1_2/1";//пути к файлам крутящихся уровней
    private final static String PATH_TO_SECOND_ROTATION = "levels/2/2_2/1";
    private final static String PATH_TO_THIRD_ROTATION = "levels/3/3_2/1";
    private final static String PATH_TO_FOURTH_ROTATION = "levels/4/4_2/1";
    //
    private final static String PATH_TO_FIRST_ROTATION_COMPLICATED = "levels/1/1_2/2";//пути к файлам крутящихся уровней
    private final static String PATH_TO_SECOND_ROTATION_COMPLICATED = "levels/2/2_2/2";
    private final static String PATH_TO_THIRD_ROTATION_COMPLICATED = "levels/3/3_2/2";
    private final static String PATH_TO_FOURTH_ROTATION_COMPLICATED = "levels/4/4_2/2";
    //
    private final static String PATH_TO_MUSIC = "audio/music.mp3";
    private final static String PATH_TO_SOUND = "audio/sounds/JYKD_kick_chick.wav";
    //
    private final static String COUNT1 = "countOfPoints1";//стринги-ключи к preferences
    //
    private final static String COUNT2 = "countOfPoints2";
    private final static String COUNT3 = "countOfPoints3";
    private final static String COUNT4 = "countOfPoints4";
    //
    private final static String COUNT11 = "countOfPoints11";
    private final static String COUNT21 = "countOfPoints21";
    private final static String COUNT31 = "countOfPoints31";
    private final static String COUNT41 = "countOfPoints41";
    //
    private final static String COUNT111 = "countOfPoints111";
    private final static String COUNT211 = "countOfPoints211";
    private final static String COUNT311 = "countOfPoints311";
    private final static String COUNT411 = "countOfPoints411";
    //
    private final static String COUNT12 = "countOfPoints12";
    private final static String COUNT22 = "countOfPoints22";
    private final static String COUNT32 = "countOfPoints32";
    private final static String COUNT42 = "countOfPoints42";
    //
    private final static String COUNT121 = "countOfPoints121";
    private final static String COUNT221 = "countOfPoints221";
    private final static String COUNT321 = "countOfPoints321";
    private final static String COUNT421 = "countOfPoints421";
    //
    private final static String COUNT122 = "countOfPoints122";
    private final static String COUNT222 = "countOfPoints222";
    private final static String COUNT322 = "countOfPoints322";
    private final static String COUNT422 = "countOfPoints422";
    //
    private final static String COUNT1R = "countOfPoints1R";
    private final static String COUNT2R = "countOfPoints2R";
    private final static String COUNT3R = "countOfPoints3R";
    private final static String COUNT4R = "countOfPoints4R";
    //
    private final static String COUNT1R1 = "countOfPoints1R1";
    private final static String COUNT2R1 = "countOfPoints2R1";
    private final static String COUNT3R1 = "countOfPoints3R1";
    private final static String COUNT4R1 = "countOfPoints4R1";
    //
    private final static String COUNT1R2 = "countOfPoints1R2";
    private final static String COUNT2R2 = "countOfPoints2R2";
    private final static String COUNT3R2 = "countOfPoints3R2";
    private final static String COUNT4R2 = "countOfPoints4R2";
    //
    private final static String COUNT13 = "countOfPoints12";
    private final static String COUNT23 = "countOfPoints22";
    private final static String COUNT33 = "countOfPoints32";
    private final static String COUNT43 = "countOfPoints42";
    //
    private final static String COUNT131 = "countOfPoints121";
    private final static String COUNT231 = "countOfPoints221";
    private final static String COUNT331 = "countOfPoints321";
    private final static String COUNT431 = "countOfPoints421";
    //
    private final static String COUNT132 = "countOfPoints122";
    private final static String COUNT232 = "countOfPoints222";
    private final static String COUNT332 = "countOfPoints322";
    private final static String COUNT432 = "countOfPoints422";
    //
    private final static String COUNT0 = "countOfAllPoints";
    //
    private final static Map<String, Integer> map = new HashMap<>();
    //
    private final static String PREF_NAME = "fileForPrefs";//имя файла preferences
    //
    private final static String SOUND = "sound";
    private final static String VIBRATE = "vib";
    //
    private static final Map<String, Boolean> bool = new HashMap<>();
    private static final Map<Integer, Boolean> isWin = new HashMap<>();
    //
    private final static String isFirst = "isFirstRan";
    //    private final static String removeAds = "REM";
    //
    public static float time = 0;
    public static float timeSpeed = 0;
    //
    private static int WIDTH;//ширина и высота экрана
    private static int HEIGHT;
    //
    private static float scaleX; //масштабируем под экран
    private static float scaleY;
    private static float scaleXY;
    //    private static boolean isVibrate = true;
//    private static boolean sound = true;
    //
    //
    private static boolean isLastSessionFall = false;
    private static boolean isRead = true;
    private static boolean isRemoveAds = false;


    Consts() {


    }

    public static String getCOUNT13() {
        return COUNT13;
    }

    public static String getCOUNT23() {
        return COUNT23;
    }

    public static String getCOUNT33() {
        return COUNT33;
    }

    public static String getCOUNT43() {
        return COUNT43;
    }

    public static String getCOUNT131() {
        return COUNT131;
    }

    public static String getCOUNT231() {
        return COUNT231;
    }

    public static String getCOUNT331() {
        return COUNT331;
    }

    public static String getCOUNT431() {
        return COUNT431;
    }

    public static String getCOUNT132() {
        return COUNT132;
    }

    public static String getCOUNT232() {
        return COUNT232;
    }

    public static String getCOUNT332() {
        return COUNT332;
    }

    public static String getCOUNT432() {
        return COUNT432;
    }

    public static void setZeroLevel(int zeroLevel) {
        WIDTH = Gdx.app.getGraphics().getWidth();//ширина и высота экрана
        HEIGHT = Gdx.app.getGraphics().getHeight();
        scaleX = WIDTH / 1080f; //масштабируем под экран
        scaleY = (HEIGHT - zeroLevel - 50) / 1920f;
        scaleXY = ((scaleX + scaleY) / 2f);
    }

    public static boolean isRemoveAds() {
        return isRemoveAds;
    }

    public static void setRemoveAds(boolean isRemoveAds) {
        Consts.isRemoveAds = isRemoveAds;
    }

    public static Map<Integer, Boolean> getIsWin() {
        return isWin;
    }

    public static String getIsFirst() {
        return isFirst;
    }


    public static String getLeaderBoard() {
        return LEADER_BOARD;
    }

    public static String getLEADERBOARD1() {
        return LEADERBOARD1;
    }

    public static String getPRIME() {
        return PRIME;
    }

    public static String getFastStart() {
        return FAST_START;
    }

    public static String getFastestFingersInTheWildWest() {
        return FASTEST_FINGERS_IN_THE_WILD_WEST;
    }

    public static String getNICE() {
        return NICE;
    }

    public static String getNICE2() {
        return NICE2;
    }

    public static String getIsItYouAgain() {
        return IS_IT_YOU_AGAIN;
    }

    public static String getTheDevilHimself() {
        return THE_DEVIL_HIMSELF;
    }

    public static String getImAtHome() {
        return IM_AT_HOME;
    }

    public static String getTakeThought() {
        return TAKE_THOUGHT;
    }

    public static String getIMPOSSIBLE() {
        return IMPOSSIBLE;
    }

    public static String getIsThisAnRpg() {
        return IS_THIS_AN_RPG;
    }

    public static String getSpeedRun() {
        return SPEED_RUN;
    }

    public static Map<String, String> getAchievements() {
        return achievements;
    }

    public static Map<String, String> getEvents() {
        return events;
    }

    private static void loadAch() {

        achievements.put(PRIME, "CgkIpq7zg9UYEAIQAQ");
        achievements.put(FAST_START, "CgkIpq7zg9UYEAIQCw");
        achievements.put(FASTEST_FINGERS_IN_THE_WILD_WEST, "CgkIpq7zg9UYEAIQDA");
        achievements.put(NICE, "CgkIpq7zg9UYEAIQDQ");
        achievements.put(NICE2, "CgkIpq7zg9UYEAIQDg");
        achievements.put(IS_IT_YOU_AGAIN, "CgkIpq7zg9UYEAIQDw");
        achievements.put(THE_DEVIL_HIMSELF, "CgkIpq7zg9UYEAIQEA");
        achievements.put(IM_AT_HOME, "CgkIpq7zg9UYEAIQEQ");
        achievements.put(TAKE_THOUGHT, "CgkIpq7zg9UYEAIQEg");
        achievements.put(IMPOSSIBLE, "CgkIpq7zg9UYEAIQEw");
        achievements.put(IS_THIS_AN_RPG, "CgkIpq7zg9UYEAIQFA");
        achievements.put(SPEED_RUN, "CgkIpq7zg9UYEAIQFQ");
    }

    private static void loadEvents() {

        events.put("1", "CgkIpq7zg9UYEAIQBA");
        events.put("-1", "CgkIpq7zg9UYEAIQAw");
        events.put("2", "CgkIpq7zg9UYEAIQBg");
        events.put("-2", "CgkIpq7zg9UYEAIQBQ");
        events.put("3", "CgkIpq7zg9UYEAIQCA");
        events.put("-3", "CgkIpq7zg9UYEAIQBw");
        events.put("4", "CgkIpq7zg9UYEAIQCg");
        events.put("-4", "CgkIpq7zg9UYEAIQCQ");

        events.put("11", "CgkIpq7zg9UYEAIQFw");
        events.put("-11", "CgkIpq7zg9UYEAIQFg");
        events.put("21", "CgkIpq7zg9UYEAIQGQ");
        events.put("-21", "CgkIpq7zg9UYEAIQGA");
        events.put("31", "CgkIpq7zg9UYEAIQGw");
        events.put("-31", "CgkIpq7zg9UYEAIQGg");
        events.put("41", "CgkIpq7zg9UYEAIQHQ");
        events.put("-41", "CgkIpq7zg9UYEAIQHA");

        events.put("111", "CgkIpq7zg9UYEAIQHg");
        events.put("-111", "CgkIpq7zg9UYEAIQHw");
        events.put("211", "CgkIpq7zg9UYEAIQIA");
        events.put("-211", "CgkIpq7zg9UYEAIQIQ");
        events.put("311", "CgkIpq7zg9UYEAIQIg");
        events.put("-311", "CgkIpq7zg9UYEAIQIw");
        events.put("411", "CgkIpq7zg9UYEAIQJA");
        events.put("-411", "CgkIpq7zg9UYEAIQJQ");

        events.put("12", "CgkIpq7zg9UYEAIQJg");
        events.put("-12", "CgkIpq7zg9UYEAIQJw");
        events.put("22", "CgkIpq7zg9UYEAIQKA");
        events.put("-22", "CgkIpq7zg9UYEAIQKQ");
        events.put("32", "CgkIpq7zg9UYEAIQKg");
        events.put("-32", "CgkIpq7zg9UYEAIQKw");
        events.put("42", "CgkIpq7zg9UYEAIQLA");
        events.put("-42", "CgkIpq7zg9UYEAIQLQ");

        events.put("121", "CgkIpq7zg9UYEAIQLg");
        events.put("-121", "CgkIpq7zg9UYEAIQLw");
        events.put("221", "CgkIpq7zg9UYEAIQMA");
        events.put("-221", "CgkIpq7zg9UYEAIQMQ");
        events.put("321", "CgkIpq7zg9UYEAIQMg");
        events.put("-321", "CgkIpq7zg9UYEAIQMw");
        events.put("421", "CgkIpq7zg9UYEAIQNA");
        events.put("-421", "CgkIpq7zg9UYEAIQNQ");

        events.put("122", "CgkIpq7zg9UYEAIQNg");
        events.put("-122", "CgkIpq7zg9UYEAIQNw");
        events.put("222", "CgkIpq7zg9UYEAIQOA");
        events.put("-222", "CgkIpq7zg9UYEAIQOQ");
        events.put("322", "CgkIpq7zg9UYEAIQOg");
        events.put("-322", "CgkIpq7zg9UYEAIQOw");
        events.put("422", "CgkIpq7zg9UYEAIQPA");
        events.put("-422", "CgkIpq7zg9UYEAIQPQ");

        events.put("10", "CgkIpq7zg9UYEAIQPg");
        events.put("-10", "CgkIpq7zg9UYEAIQPw");
        events.put("20", "CgkIpq7zg9UYEAIQQA");
        events.put("-20", "CgkIpq7zg9UYEAIQQQ");
        events.put("30", "CgkIpq7zg9UYEAIQQg");
        events.put("-30", "CgkIpq7zg9UYEAIQQw");
        events.put("40", "CgkIpq7zg9UYEAIQRA");
        events.put("-40", "CgkIpq7zg9UYEAIQRQ");
//////////////////////
        events.put("101", "CgkIpq7zg9UYEAIQRg");
        events.put("-101", "CgkIpq7zg9UYEAIQRw");
        events.put("201", "CgkIpq7zg9UYEAIQSA");
        events.put("-201", "CgkIpq7zg9UYEAIQSQ");
        events.put("301", "CgkIpq7zg9UYEAIQSg");
        events.put("-301", "CgkIpq7zg9UYEAIQSw");
        events.put("401", "CgkIpq7zg9UYEAIQTA");
        events.put("-401", "CgkIpq7zg9UYEAIQTQ");

        events.put("102", "CgkIpq7zg9UYEAIQTg");
        events.put("-102", "CgkIpq7zg9UYEAIQTw");
        events.put("202", "CgkIpq7zg9UYEAIQUA");
        events.put("-202", "CgkIpq7zg9UYEAIQUQ");
        events.put("302", "CgkIpq7zg9UYEAIQUg");
        events.put("-302", "CgkIpq7zg9UYEAIQUw");
        events.put("402", "CgkIpq7zg9UYEAIQVA");
        events.put("-402", "CgkIpq7zg9UYEAIQVQ");
/////

        events.put("13", "CgkIpq7zg9UYEAIQWg");
        events.put("-13", "CgkIpq7zg9UYEAIQWw");
        events.put("23", "CgkIpq7zg9UYEAIQXA");
        events.put("-23", "CgkIpq7zg9UYEAIQXQ");
        events.put("33", "CgkIpq7zg9UYEAIQXg");
        events.put("-33", "CgkIpq7zg9UYEAIQXw");
        events.put("43", "CgkIpq7zg9UYEAIQYA");
        events.put("-43", "CgkIpq7zg9UYEAIQYQ");

        events.put("131", "CgkIpq7zg9UYEAIQYg");
        events.put("-131", "CgkIpq7zg9UYEAIQYw");
        events.put("231", "CgkIpq7zg9UYEAIQZA");
        events.put("-231", "CgkIpq7zg9UYEAIQZQ");
        events.put("331", "CgkIpq7zg9UYEAIQZg");
        events.put("-331", "CgkIpq7zg9UYEAIQZw");
        events.put("431", "CgkIpq7zg9UYEAIQaA");
        events.put("-431", "CgkIpq7zg9UYEAIQaQ");

        events.put("132", "CgkIpq7zg9UYEAIQag");
        events.put("-132", "CgkIpq7zg9UYEAIQaw");
        events.put("232", "CgkIpq7zg9UYEAIQbA");
        events.put("-232", "CgkIpq7zg9UYEAIQbQ");
        events.put("332", "CgkIpq7zg9UYEAIQbg");
        events.put("-332", "CgkIpq7zg9UYEAIQbw");
        events.put("432", "CgkIpq7zg9UYEAIQcA");
        events.put("-432", "CgkIpq7zg9UYEAIQcQ");
    }

    /*

     * */

    public static Map<String, Boolean> getBool() {
        return bool;
    }

    public static void loadMaps() {

        loadMap();
        loadBool();
        loadAch();
        loadEvents();
        loadWins();
    }

    private static void loadWins() {

        for (int i = 1; i < 5; i++) {

            isWin.put(i, false);
            isWin.put(i * 10, false);
            isWin.put(i * 10 + 1, false);
            isWin.put(i * 10 + 2, false);
            isWin.put(i * 10 + 3, false);
            isWin.put(i * 100 + 1, false);
            isWin.put(i * 100 + 2, false);
            isWin.put(i * 100 + 11, false);
            isWin.put(i * 100 + 21, false);
            isWin.put(i * 100 + 22, false);
            isWin.put(i * 100 + 31, false);
            isWin.put(i * 100 + 32, false);
        }


    }

    private static void loadBool() {

        bool.put(SOUND, true);
        bool.put(VIBRATE, true);
        bool.put(isFirst, true);
//        bool.put(removeAds, false);
    }

    public static String getPathToSound() {
        return PATH_TO_SOUND;
    }

    public static boolean isRead() {
        return isRead;
    }

    public static void setRead(boolean isRead) {
        Consts.isRead = isRead;
    }

    public static String getVIBRATE() {
        return VIBRATE;
    }

//    public static boolean isVibrate() {
//        return isVibrate;
    //    }
//
//    public static void setVibrate(boolean isVibrate) {
//        Consts.isVibrate = isVibrate;
//    }

    private static void loadMap() {

        putMap(COUNT0);

        putMap(COUNT1);
        putMap(COUNT2);
        putMap(COUNT3);
        putMap(COUNT4);

        putMap(COUNT11);
        putMap(COUNT21);
        putMap(COUNT31);
        putMap(COUNT41);

        putMap(COUNT111);
        putMap(COUNT211);
        putMap(COUNT311);
        putMap(COUNT411);

        putMap(COUNT12);
        putMap(COUNT22);
        putMap(COUNT32);
        putMap(COUNT42);

        putMap(COUNT121);
        putMap(COUNT221);
        putMap(COUNT321);
        putMap(COUNT421);

        putMap(COUNT122);
        putMap(COUNT222);
        putMap(COUNT322);
        putMap(COUNT422);

        putMap(COUNT1R);
        putMap(COUNT2R);
        putMap(COUNT3R);
        putMap(COUNT4R);

        putMap(COUNT1R1);
        putMap(COUNT2R1);
        putMap(COUNT3R1);
        putMap(COUNT4R1);

        putMap(COUNT1R2);
        putMap(COUNT2R2);
        putMap(COUNT3R2);
        putMap(COUNT4R2);

        putMap(COUNT13);
        putMap(COUNT23);
        putMap(COUNT33);
        putMap(COUNT43);

        putMap(COUNT131);
        putMap(COUNT231);
        putMap(COUNT331);
        putMap(COUNT431);

        putMap(COUNT132);
        putMap(COUNT232);
        putMap(COUNT332);
        putMap(COUNT432);

        putMap(IM_AT_HOME);

    }

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static boolean isTouch(float x, float y, float w, float h, int X, int Y) {

        return ((x <= X) && (X <= x + w) && (y <= Y) && (Y <= y + h));
    }

    public static void clear() {

        Color color = parseColor("#F3DB74");//
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public static Color parseColor(String hex) {
        if (hex.length() == 7) {
            hex = hex.substring(1, 7);
        }
        String s1 = hex.substring(0, 2);//#ec58f2
        int v1 = Integer.parseInt(s1, 16);
        float f1 = 1f * v1 / 255f;
        String s2 = hex.substring(2, 4);
        int v2 = Integer.parseInt(s2, 16);
        float f2 = 1f * v2 / 255f;
        String s3 = hex.substring(4, 6);
        int v3 = Integer.parseInt(s3, 16);
        float f3 = 1f * v3 / 255f;
        return new Color(f1, f2, f3, 1f);
    }

    public static void dispose() {

    }

    public static String getSOUND() {
        return SOUND;
    }

    public static String getPathToMusic() {
        return PATH_TO_MUSIC;
    }

    public static String getCOUNT1R1() {
        return COUNT1R1;
    }

    public static String getCOUNT2R1() {
        return COUNT2R1;
    }

    public static String getCOUNT3R1() {
        return COUNT3R1;
    }

    public static String getCOUNT4R1() {
        return COUNT4R1;
    }

    public static String getCOUNT1R2() {
        return COUNT1R2;
    }

    public static String getCOUNT2R2() {
        return COUNT2R2;
    }

    public static String getCOUNT3R2() {
        return COUNT3R2;
    }

    public static String getCOUNT4R2() {
        return COUNT4R2;
    }

    public static String getPathToFirstComplicated() {
        return PATH_TO_FIRST_COMPLICATED;
    }

    public static String getPathToSecondComplicated() {
        return PATH_TO_SECOND_COMPLICATED;
    }

    public static String getPathToThirdComplicated() {
        return PATH_TO_THIRD_COMPLICATED;
    }

    public static String getPathToFourthComplicated() {
        return PATH_TO_FOURTH_COMPLICATED;
    }

    public static String getPathToFirstRotationComplicated() {
        return PATH_TO_FIRST_ROTATION_COMPLICATED;
    }

    public static String getPathToSecondRotationComplicated() {
        return PATH_TO_SECOND_ROTATION_COMPLICATED;
    }

    public static String getPathToThirdRotationComplicated() {
        return PATH_TO_THIRD_ROTATION_COMPLICATED;
    }

    public static String getPathToFourthRotationComplicated() {
        return PATH_TO_FOURTH_ROTATION_COMPLICATED;
    }

    public static String getCOUNT111() {
        return COUNT111;
    }

    public static String getCOUNT211() {
        return COUNT211;
    }

    public static String getCOUNT311() {
        return COUNT311;
    }

    public static String getCOUNT411() {
        return COUNT411;
    }

    public static String getCOUNT121() {
        return COUNT121;
    }

    public static String getCOUNT221() {
        return COUNT221;
    }

    public static String getCOUNT321() {
        return COUNT321;
    }

    public static String getCOUNT421() {
        return COUNT421;
    }

    public static String getCOUNT122() {
        return COUNT122;
    }

    public static String getCOUNT222() {
        return COUNT222;
    }

    public static String getCOUNT322() {
        return COUNT322;
    }

    public static String getCOUNT422() {
        return COUNT422;
    }

    public static String getCOUNT12() {
        return COUNT12;
    }

    public static String getCOUNT22() {
        return COUNT22;
    }

    public static String getCOUNT32() {
        return COUNT32;
    }

    public static String getCOUNT42() {
        return COUNT42;
    }

    public static String getCOUNT11() {
        return COUNT11;
    }

    public static String getCOUNT21() {
        return COUNT21;
    }

    public static String getCOUNT31() {
        return COUNT31;
    }

    public static String getCOUNT41() {
        return COUNT41;
    }

    public static String getCOUNT1R() {
        return COUNT1R;
    }

    public static String getCOUNT2R() {
        return COUNT2R;
    }

    public static String getCOUNT3R() {
        return COUNT3R;
    }

    public static String getCOUNT4R() {
        return COUNT4R;
    }

    public static String getPathToSecondRotation() {
        return PATH_TO_SECOND_ROTATION;
    }

    public static String getPathToThirdRotation() {
        return PATH_TO_THIRD_ROTATION;
    }

    public static String getPathToFourthRotation() {
        return PATH_TO_FOURTH_ROTATION;
    }

    public static String getPathToFirstRotation() {
        return PATH_TO_FIRST_ROTATION;
    }

    public static String getCOUNT1() {
        return COUNT1;
    }

    public static String getCOUNT2() {
        return COUNT2;
    }

    public static String getCOUNT3() {
        return COUNT3;
    }

    public static String getCOUNT4() {
        return COUNT4;
    }

    public static String getCOUNT0() {
        return COUNT0;
    }

    public static String getPrefName() {
        return PREF_NAME;
    }

    public static String getPathToFourth() {
        return PATH_TO_FOURTH;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static String getPathToThird() {
        return PATH_TO_THIRD;
    }

    public static String getPathToSecond() {
        return PATH_TO_SECOND;
    }

    public static String getPathToFirst() {
        return PATH_TO_FIRST;
    }

    public static float getScaleXY() {
        return scaleXY;
    }

    public static String getTtfPath() {
        return ttfPath;
    }

    public static float getScaleX() {
        return scaleX;
    }

    public static float getScaleY() {
        return scaleY;
    }

    private static void putMap(String s) {
        map.put(s, 0);
    }

    public static boolean isLastSessionFall() {
        return isLastSessionFall;
    }

    public static void setLastSessionFall(boolean lastSessionFall) {
        isLastSessionFall = lastSessionFall;
    }

}
