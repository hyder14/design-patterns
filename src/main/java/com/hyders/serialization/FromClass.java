package com.hyders.serialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



public class FromClass {

    @JsonProperty("status")
    private String Status;


    @JsonProperty("bicCode")
    private String BIC;

    @JsonProperty("bankName")
    private String RAASTPartnerBanks;


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getRAASTPartnerBanks() {
        return RAASTPartnerBanks;
    }

    public void setRAASTPartnerBanks(String RAASTPartnerBanks) {
        this.RAASTPartnerBanks = RAASTPartnerBanks;
    }
}
