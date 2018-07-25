package me.devilsen.danqing.achieve;

/**
 * desc :
 * date : 2018/7/4
 *
 * @author : dongSen
 */
public class AchieveProvider {

    private final IAchieve achieve;

    private AchieveProvider() {
        achieve = new GlideAchieve();
    }

    public static AchieveProvider getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final AchieveProvider INSTANCE = new AchieveProvider();
    }


    public IAchieve getAchiever() {
        return achieve;
    }


}
