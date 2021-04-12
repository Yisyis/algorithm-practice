package com.yis.labuladong.binaryTree02;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * 递归法： 相当于扫描出二叉树叶子节点
 * <p>
 * 该解法问题：不符合迭代器原则
 * 一次性算出了所有叶子节点的值，全部装到result列表，也就是内存中，
 * next和hasNext方法只是在对result列表做迭代。
 * 如果输入的规模非常大，构造函数中的计算就会很慢，而且很占用内存。
 *
 * @author YeShuai
 * @date 2021/4/12
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    private LinkedList<Integer> result;

    public NestedIterator(List<NestedInteger> nestedList) {
        result = new LinkedList<>();
        traverse(nestedList);
        it = result.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    public void traverse(List<NestedInteger> nestedIntegers) {
        for (NestedInteger nestedInteger : nestedIntegers) {
            if (nestedInteger.isInteger()) {
                result.add(nestedInteger.getInteger());
            } else {
                traverse(nestedInteger.getList());
            }
        }
    }

}

/**
 * 341. 扁平化嵌套列表迭代器
 * 递归法： 相当于扫描出二叉树叶子节点
 * <p>
 * 该解法：
 * 迭代器求值应该是「惰性的」，也就是说，如果你要一个结果，我就算一个（或是一小部分）结果出来，而不是一次把所有结果都算出来。
 *
 * @author YeShuai
 * @date 2021/4/12
 */
class NestedIterator1 implements Iterator<Integer> {

    private LinkedList<NestedInteger> result;

    public NestedIterator1(List<NestedInteger> nestedList) {
        // 不直接用 nestedList 的引用，是因为不能确定它的底层实现
        // 必须保证是 LinkedList，否则下面的 addFirst 会很低效
        result = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        // hasNext 方法保证了第一个元素一定是整数类型
        return result.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        // 循环拆分列表元素，直到列表第一个元素是整数类型
        while (!result.isEmpty() && !result.get(0).isInteger()) {
            // 当列表开头第一个元素是列表类型时，进入循环
            List<NestedInteger> list = result.remove(0).getList();
            // 将第一个列表打平并按顺序添加到开头
            for (int i = list.size() - 1; i >= 0 ; i--) {
                result.addFirst(list.get(i));
            }
        }
        return !result.isEmpty();
    }

}
