package com.console.stu.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : jiangwei97@aliyun.com
 * @since : 2023-06-15 11:05
 **/

public class Sorted {
    public static void main(String[] args) {
        List<SortModel> list = new ArrayList<>();
        list.add(new SortModel("f", 4, 5));// 1
        list.add(new SortModel("a", 1, 6));// 5
        list.add(new SortModel("d", 3, 2));// -1
        list.add(new SortModel("c", 3, 1));// -2
        list.add(new SortModel("e", 3, 3));// 0
        list.add(new SortModel("b", 2, 4));// 2
        // 按照value的升序
        List<SortModel> valueAsc = list.stream()
                .sorted(Comparator.comparing(SortModel::getValue))
                .collect(Collectors.toList());
        System.out.println(valueAsc);
        // 按照value的降序
        List<SortModel> valueDesc = list.stream()
                .sorted(Comparator.comparing(SortModel::getValue).reversed())
                .collect(Collectors.toList());
        System.out.println(valueDesc);
        // 先按照value的升序排序，再按照type升序排序
        List<SortModel> valueTypeAsc = list.stream()
                .sorted(Comparator.comparing(SortModel::getValue).thenComparing(SortModel::getType))
                .collect(Collectors.toList());
        System.out.println(valueTypeAsc);
        // 先按照value的升序排序，再按照type降序排序
        List<SortModel> valueTypeDesc = list.stream()
                .sorted(Comparator.comparing(SortModel::getValue).thenComparing((o1, o2) -> o2.getType() - o1.getType()))
                .collect(Collectors.toList());
        System.out.println(valueTypeDesc);
        // 按照 type-value 排序
        List<SortModel> typeMinusValueAsc = list.stream()
                .sorted(Comparator.comparing((o) -> o.getType() - o.getValue()))
                .collect(Collectors.toList());
        System.out.println(typeMinusValueAsc);
    }
}

@Data
@AllArgsConstructor
class SortModel {
    private String name;
    private Integer value;
    private Integer type;
}
