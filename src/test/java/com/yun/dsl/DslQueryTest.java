package com.yun.dsl;

import com.yun.dsl.column.Column;
import com.yun.dsl.condition.*;
import com.yun.dsl.table.Table;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DslQueryTest {
    @Test
    public void t1(){
        Optional.ofNullable(generateDslQuery())
                .ifPresent(System.out::println);


    }
    public static DslQuery generateDslQuery() {
        List<Column> columns = new ArrayList<>(Arrays.asList(
                Column.builder().tableName("user").columnName("name").isMain(true).build(),
                Column.builder().tableName("user").columnName("age").isMain(true).build(),
                Column.builder().tableName("user").columnName("companyId").isMain(true).build(),
                Column.builder().tableName("user").columnName("jobId").isMain(true).build()
        ));
        //on user.cid =  company_info.cid
        // select * from A left join B on
        ConditionElement conditionElement1 = new ConditionElement(Column.builder().tableName("user").columnName("companyId").build(),
                ConditionMethod.eq, Column.builder().tableName("company_info").columnName("companyId").build());

        ConditionElement conditionElement = new ConditionElement(Column.builder().tableName("user").columnName("jobId").build(),
                ConditionMethod.eq, Column.builder().tableName("job_info").columnName("jobId").build());

        ConditionElement conditionElement2 = new ConditionElement(Column.builder().tableName("company_info").columnName("status").isMain(true).build(),
                ConditionMethod.eq, Column.builder().tableName("status_info").columnName("status").build());

        List<JoinBuilder> jbs = new ArrayList<>(Arrays.asList(new JoinBuilder(JoinFlag.left,new Table("company_info"), conditionElement1)
                ,new JoinBuilder(JoinFlag.left, new Table("job_info"), conditionElement)
                , new JoinBuilder(JoinFlag.left, new Table("status_info"), conditionElement2)
        ));
        SelectFrom selectFrom = SelectFrom.builder()
                .columns(columns)
                .table(new Table("user"))
                .joins(jbs)
                .build();

        List<Order> orders = new ArrayList<>(Arrays.asList(
                new Order(Column.builder().tableName("user").columnName("name").build(), true),
                new Order(Column.builder().tableName("user").columnName("age").build(), false)
        ));

        List<ConditionElement> conditionElements = new ArrayList<>(Arrays.asList(
                new ConditionElement(Column.builder().tableName("user").columnName("age").isMain(true).build(), ConditionMethod.lt, new Column(19))
                ,new ConditionElement(JunctionEnum.and),
                new ConditionElement(Column.builder().tableName("company_info").columnName("status").isMain(false).build(), ConditionMethod.eq, new Column("1001"))
             /*   ,new ConditionElement(JunctionEnum.and),
                new ConditionElement(Column.builder().tableName("job_info").columnName("isDel").isMain(false).build(), ConditionMethod.eq, new Column(1))*/
        ));
        // user.id = ? or (user.name = ? and user.age = ?)

      /*  List<ConditionElement> conditionElements =  new ArrayList<>(Arrays.asList(
                new ConditionElement(Column.builder().tableName("user").columnName("id").build(),
                        ConditionMethod.le, new Column(15)),
                new ConditionElement(JunctionEnum.and),
                new ConditionElement(new ArrayList<>(Arrays.asList(
                        new ConditionElement(Column.builder().tableName("company_info").columnName("status").build(),
                                ConditionMethod.eq, new Column("1001")),
                        new ConditionElement(JunctionEnum.and),
                        new ConditionElement(Column.builder().tableName("user").columnName("age").build(),
                                ConditionMethod.eq, new Column(32))
                )))
        ));*/
        Conditions conditions = new Conditions(conditionElements);

        DslQuery.DslQueryBuilder builder = DslQuery.builder()
                .selectFrom(selectFrom)
                .where(new Where(conditions))
                .orderBy(new OrderBy(orders))
                .limit(new Limit(0, 2));

        DslQuery dslQuery = builder.build();
        return dslQuery;
    }
}
