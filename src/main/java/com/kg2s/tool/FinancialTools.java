package com.kg2s.tool;

import org.springframework.ai.tool.annotation.Tool;

/**
 * thats for financial informartion for the applicant
 */
public class FinancialTools {

    @Tool(description = "query the recent few months e statement for the applicant")
    public String queryBankStatement(String applicationId, int months){
        return "the applicant" + applicationId + " recent "+months + " bank statement";
    }

    @Tool(description = "query the applicant recent CPF information")
    public String querySocialSecurity(String applicationId){

    return "the applicant" + " " + applicationId + " social security";
    }
}
