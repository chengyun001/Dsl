package com.yun.dsl;

import com.yun.dsl.condition.ConditionElement;
import com.yun.dsl.condition.JoinFlag;
import com.yun.dsl.table.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinBuilder {
    private JoinFlag joinFlag;
    private Table table;
    private ConditionElement conditionElement;


}
