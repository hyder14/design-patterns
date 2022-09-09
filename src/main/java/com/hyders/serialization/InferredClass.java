package com.hyders.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InferredClass {

    @JsonProperty("Status")
        private String status;

    @JsonProperty("BIC")
        private String bicCode;

    @JsonProperty("RAASTPartnerBanks")
        private String bankName;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "InferredClass{" +
                "status='" + status + '\'' +
                ", bicCode='" + bicCode + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
