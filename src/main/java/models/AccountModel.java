package models;

public class AccountModel {
    private final String name;
    private final String phone;
    private final String description;
    private final boolean isCampaign;
    private final String industry;

    public AccountModel(String name, String phone, String description, boolean isCampaign, String industry) {
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.isCampaign = isCampaign;
        this.industry = industry;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getDescription() { return description; }
    public boolean isCampaign() { return isCampaign; }
    public String getIndustry() { return industry; }
}