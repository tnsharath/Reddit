
package com.vintile.sharathkumartn_reddit.model.postmodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllAwarding {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("is_enabled")
    @Expose
    private Boolean isEnabled;
    @SerializedName("subreddit_id")
    @Expose
    private Object subredditId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("end_date")
    @Expose
    private Integer endDate;
    @SerializedName("award_sub_type")
    @Expose
    private String awardSubType;
    @SerializedName("coin_reward")
    @Expose
    private Integer coinReward;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("days_of_premium")
    @Expose
    private Integer daysOfPremium;
    @SerializedName("is_new")
    @Expose
    private Boolean isNew;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("icon_height")
    @Expose
    private Integer iconHeight;
    @SerializedName("resized_icons")
    @Expose
    private List<ResizedIcon> resizedIcons = null;
    @SerializedName("days_of_drip_extension")
    @Expose
    private Integer daysOfDripExtension;
    @SerializedName("award_type")
    @Expose
    private String awardType;
    @SerializedName("start_date")
    @Expose
    private Integer startDate;
    @SerializedName("coin_price")
    @Expose
    private Integer coinPrice;
    @SerializedName("icon_width")
    @Expose
    private Integer iconWidth;
    @SerializedName("subreddit_coin_reward")
    @Expose
    private Integer subredditCoinReward;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Object getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(Object subredditId) {
        this.subredditId = subredditId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String getAwardSubType() {
        return awardSubType;
    }

    public void setAwardSubType(String awardSubType) {
        this.awardSubType = awardSubType;
    }

    public Integer getCoinReward() {
        return coinReward;
    }

    public void setCoinReward(Integer coinReward) {
        this.coinReward = coinReward;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Integer getDaysOfPremium() {
        return daysOfPremium;
    }

    public void setDaysOfPremium(Integer daysOfPremium) {
        this.daysOfPremium = daysOfPremium;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(Integer iconHeight) {
        this.iconHeight = iconHeight;
    }

    public List<ResizedIcon> getResizedIcons() {
        return resizedIcons;
    }

    public void setResizedIcons(List<ResizedIcon> resizedIcons) {
        this.resizedIcons = resizedIcons;
    }

    public Integer getDaysOfDripExtension() {
        return daysOfDripExtension;
    }

    public void setDaysOfDripExtension(Integer daysOfDripExtension) {
        this.daysOfDripExtension = daysOfDripExtension;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(Integer coinPrice) {
        this.coinPrice = coinPrice;
    }

    public Integer getIconWidth() {
        return iconWidth;
    }

    public void setIconWidth(Integer iconWidth) {
        this.iconWidth = iconWidth;
    }

    public Integer getSubredditCoinReward() {
        return subredditCoinReward;
    }

    public void setSubredditCoinReward(Integer subredditCoinReward) {
        this.subredditCoinReward = subredditCoinReward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
