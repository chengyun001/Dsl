package com.yun.dsl.column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Column {

    private String tableName;
    private String columnName;
    private boolean isMain; //在join on时候 主表字段设置为true，注意级联时候级联的主表也要设置为true
    private Object value;

    public Column(Object value) {
        this.value = value;
    }
}
