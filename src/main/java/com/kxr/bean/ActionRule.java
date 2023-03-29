package com.kxr.bean;

/**
 * @Author: kongxr
 * @Date: 2023-03-27 13:34
 * @Description:
 */
public class ActionRule {

    // 用户名
    private String userName;

    // 最近7天登录次数
    private int recentBrowseCount;

    // 最近3天浏览会员界面次数
    private int browseMemberViewCount;

    // 最近3天使用自选监测次数
    private int useOptionalMonitoringCount;

    // 规则引擎计算后，推送到 运营系统内容
    private String pushContent;

    // 距离上次开会员的 时间天数
    private int recentOpenMemberDayCount;

    // 是否已经使用了暑期优惠
    private boolean summerDiscount = false;

    // 可以使用的代金券总额
    private int cashCouponAmount;

    public ActionRule() {
    }

    public ActionRule(String userName, int recentBrowseCount, int browseMemberViewCount, int useOptionalMonitoringCount, String pushContent, int recentOpenMemberDayCount, boolean summerDiscount, int cashCouponAmount) {
        this.userName = userName;
        this.recentBrowseCount = recentBrowseCount;
        this.browseMemberViewCount = browseMemberViewCount;
        this.useOptionalMonitoringCount = useOptionalMonitoringCount;
        this.pushContent = pushContent;
        this.recentOpenMemberDayCount = recentOpenMemberDayCount;
        this.summerDiscount = summerDiscount;
        this.cashCouponAmount = cashCouponAmount;
    }

    public int getCashCouponAmount() {
        return cashCouponAmount;
    }

    public void setCashCouponAmount(int cashCouponAmount) {
        this.cashCouponAmount = cashCouponAmount;
    }

    public boolean isSummerDiscount() {
        return summerDiscount;
    }

    public void setSummerDiscount(boolean summerDiscount) {
        this.summerDiscount = summerDiscount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRecentBrowseCount() {
        return recentBrowseCount;
    }

    public void setRecentBrowseCount(int recentBrowseCount) {
        this.recentBrowseCount = recentBrowseCount;
    }

    public int getBrowseMemberViewCount() {
        return browseMemberViewCount;
    }

    public void setBrowseMemberViewCount(int browseMemberViewCount) {
        this.browseMemberViewCount = browseMemberViewCount;
    }

    public int getUseOptionalMonitoringCount() {
        return useOptionalMonitoringCount;
    }

    public void setUseOptionalMonitoringCount(int useOptionalMonitoringCount) {
        this.useOptionalMonitoringCount = useOptionalMonitoringCount;
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent;
    }

    public int getRecentOpenMemberDayCount() {
        return recentOpenMemberDayCount;
    }

    public void setRecentOpenMemberDayCount(int recentOpenMemberDayCount) {
        this.recentOpenMemberDayCount = recentOpenMemberDayCount;
    }
}
