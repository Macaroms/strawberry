package com.console.stu.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-15 11:05
 **/

public class Group {
    public static void main(String[] args) {
        List<SortModel> list = new ArrayList<>();
        list.add(new SortModel("f", 1, 5));// 1
        list.add(new SortModel("a", 1, 6));// 5
        list.add(new SortModel("d", 3, 2));// -1
        list.add(new SortModel("c", 3, 1));// -2
        list.add(new SortModel("e", 3, 3));// 0
        list.add(new SortModel("b", 2, 4));// 2
        Map<Integer, List<SortModel>> collect = list.stream().collect(Collectors.groupingBy(SortModel::getValue));

    }
}

@Data
@AllArgsConstructor
class GroupModel {
    private String name;
    private Integer value;
    private Integer type;
}
