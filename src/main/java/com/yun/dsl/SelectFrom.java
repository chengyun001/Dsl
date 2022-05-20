package com.yun.dsl;

import com.yun.dsl.column.Column;
import com.yun.dsl.table.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelectFrom {

  private List<Column> columns;
  private Table table;
  private List<JoinBuilder> joins;

}
