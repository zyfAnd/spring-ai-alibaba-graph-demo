package com.kg2s.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

/**
 * thats for creait query tool
 * like Bureau call, blacklist checking.
 */

@Component
public class CreditTools {

    @Tool(description = "query the applicant if in blacklist")
    public String checkBlacklist(String applicationId){

        return "Applicant " + applicationId + " not in the blacklisted";
    }

    @Tool(description = "query the applicant credit -> Bureau")
    public String queryCreditReport(String applicationId){
        return "Applicant " + applicationId + " has been successfully reported";
    }

}
