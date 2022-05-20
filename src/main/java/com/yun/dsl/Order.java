package com.yun.dsl;

import com.yun.dsl.column.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  private Column column;
  private boolean isAsc;
}
