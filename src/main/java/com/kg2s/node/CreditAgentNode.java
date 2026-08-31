package com.kg2s.node;


import com.alibaba.cloud.ai.graph.OverAllState;
import com.alibaba.cloud.ai.graph.action.NodeAction;
import com.alibaba.cloud.ai.graph.internal.node.Node;
import com.kg2s.mode.LoanContext;
import com.kg2s.tool.CreditTools;
import org.springframework.ai.chat.client.ChatClient;

import java.util.Map;

public class CreditAgentNode implements NodeAction<OverAllState> {

    private final ChatClient chatClient;
    private final CreditTools creditTools;

    public CreditAgentNode(ChatClient chatClient, CreditTools creditTools) {
        this.chatClient = chatClient;
        this.creditTools = creditTools;
    }


    @Override
    public Map<String, Object> apply(OverAllState state) throws Exception {
        String applicationId = "";
        String prompt = "你是一名风控审核 Agent 。 请评估申请人 的信用状况。 你可以自主选着调用工具查询其黑名单或征信评分" +
                "结论中申请明确给出是否通过， 若未在黑名单内且评分大于600 判为 风控通过" +
                "".formatted();
        return Map.of();
    }
}
