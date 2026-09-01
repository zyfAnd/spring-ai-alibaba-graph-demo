package com.kg2s.node;

import com.alibaba.cloud.ai.graph.OverAllState;
import com.alibaba.cloud.ai.graph.action.NodeAction;
import com.kg2s.mode.StateKeys;
import com.kg2s.tool.FinancialTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("financialAgentNode")
public class FinancialAgentNode implements NodeAction {

    private final ChatClient chatClient;
    private final FinancialTools financialTools;

    public FinancialAgentNode(ChatClient chatClient, FinancialTools financialTools) {
        this.chatClient = chatClient;
        this.financialTools = financialTools;
    }


    /**
     * 
     * @param state
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> apply(OverAllState state) throws Exception {
        String applicationId = (String) state.value(StateKeys.APPLICATION_ID).orElse("UNKNOWN");
        Object amount  = state.value(StateKeys.APPLY_AMOUNT).orElse("0");
        String prompt = "你是一名财务核查 Agent 。申请人 %s 申请贷款金额为 %s 元。" +
                "请结合银行流水或公积金工具 ， " +
                "评估其收入的真实性与还贷能力 评估完成后， 请在最后结论中包含“能力充足” 或者" +"能力不足" + "".formatted(applicationId, amount);
        String response = chatClient.prompt().user(prompt).tools(financialTools).call().content();
        boolean incomePassed = response.contains("充足");
        Map<String, Object> updateState = new HashMap<>();
        updateState.put(StateKeys.INCOME_PASSED, incomePassed);
        return updateState;
    }
}
