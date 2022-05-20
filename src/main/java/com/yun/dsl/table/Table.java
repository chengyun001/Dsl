package com.yun.dsl.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private String alias;

    private String tableName;

    public Table(String tableName) {
        this.tableName = tableName;
    }

}
