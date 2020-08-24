package com.nabat.game;

public class GpgsMappers {

    public static String mapToGpgsLeaderboard(String leaderboardId) {
        String gpgsId = null;

        if (leaderboardId != null) {
            if (leaderboardId.equals(Consts.LEADERBOARD1))
                gpgsId = "CgkIpq7zg9UYEAIQAg";
        }

        return gpgsId;
    }

    public static String mapToGpgsAchievement(String achievementId) {
        String gpgsId = null;

        if (achievementId != null) {
            if (achievementId.equals(Consts.ACHIEVEMENT1))
                gpgsId = "CgkIpq7zg9UYEAIQAQ";
        }

        return gpgsId;
    }

   /* public static String mapToGpgsEvent(String eventId) {
        String gpgsId = null;

        if (eventId != null) {
            if (eventId.equals(MyGame.EVENT1))
                gpgsId = "CgkIu46Sr-8fEAIQAQ";
        }

        return gpgsId;
    }*/
}
