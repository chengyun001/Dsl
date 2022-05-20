package com.yun.dsl;

import com.yun.dsl.condition.Conditions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Where {

  private Conditions conditions;
}
