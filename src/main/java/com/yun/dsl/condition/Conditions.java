package com.yun.dsl.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conditions implements Serializable {

  private List<ConditionElement> conditionElements;

}
