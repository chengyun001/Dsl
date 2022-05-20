package com.yun.dsl.condition;

import com.yun.dsl.column.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionElement implements Serializable {

    // 简单condition逻辑
    private Column left;//表连接时候主表条件放在left
    private ConditionMethod method;
    private Column right;

    // 嵌套逻辑
    private List<ConditionElement> conditionElements;

    // 连接逻辑and/or
    private JunctionEnum junctionType;

    public ConditionElement(Column left, ConditionMethod method, Column right) {
        this.left = left;
        this.method = method;
        this.right = right;
    }

    public ConditionElement(List<ConditionElement> conditionElements) {
        this.conditionElements = conditionElements;
    }

    public ConditionElement(JunctionEnum junctionType) {
        this.junctionType = junctionType;
    }
}
