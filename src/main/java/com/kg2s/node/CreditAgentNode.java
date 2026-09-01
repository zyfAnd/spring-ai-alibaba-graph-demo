package com.kg2s.node;


import com.alibaba.cloud.ai.graph.OverAllState;
import com.alibaba.cloud.ai.graph.action.NodeAction;
import com.kg2s.mode.StateKeys;
import com.kg2s.tool.CreditTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 信用审核
 */
@Component("creditAgentNode")
public class CreditAgentNode implements NodeAction {

    private final ChatClient chatClient;
    private final CreditTools creditTools;

    public CreditAgentNode(ChatClient chatClient, CreditTools creditTools) {
        this.chatClient = chatClient;
        this.creditTools = creditTools;
    }


    @Override
    public Map<String, Object> apply(OverAllState state) throws Exception {
        String applicationId =  (String) state.value(StateKeys.APPLICATION_ID).orElse("UNKNOWN");


        String prompt = ("String prompt = (\"你是一名风控审核 Agent。请评估申请人 %s 的信用状况...\").formatted(applicationId);\n")
                .formatted(applicationId);


        String response = chatClient.prompt().user(prompt).tools(creditTools).call().content();
        boolean creditPassed = response.contains("passed");
        Map<String, Object> updatedState = new HashMap<>();
        updatedState.put(StateKeys.CREDIT_PASSeD, creditPassed);
        return updatedState;
    }
}
