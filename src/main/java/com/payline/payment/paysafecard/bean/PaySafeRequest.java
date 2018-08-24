package com.payline.payment.paysafecard.bean;

import com.google.gson.annotations.Expose;
import com.payline.payment.paysafecard.utils.InvalidRequestException;
import com.payline.payment.paysafecard.utils.PaySafeCardConstants;
import com.payline.pmapi.bean.payment.ContractConfiguration;

public abstract class PaySafeRequest {
    @Expose(serialize = false, deserialize = false)
    private String authenticationHeader;

    PaySafeRequest(ContractConfiguration configuration) throws InvalidRequestException {
        if (configuration == null || configuration.getProperty(PaySafeCardConstants.AUTHORISATIONKEY_KEY) == null){
            throw new InvalidRequestException("PaySafeRequest must have an authorisation key when created");
        } else {
            this.authenticationHeader = "Basic " + configuration.getProperty(PaySafeCardConstants.AUTHORISATIONKEY_KEY).getValue();
        }
    }

    public String getAuthenticationHeader() {
        return authenticationHeader;
    }
}
