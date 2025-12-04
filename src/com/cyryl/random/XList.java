package com.cyryl.random;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T>{
    private List<T> list;

    public static <T> XList<T> of(Collection<T> collection) {
        return new XList<>(collection);
    }

    public static <T> XList<T> of(T... ts) {
        return new XList<>(Arrays.stream(ts).toList());
    }

    public static XList<Character> ofChars(String word) {
        return new XList<>(word.chars().mapToObj(c -> (char) c).toList());
    }

    public static XList<String> ofTokens(String word, String delimiter) {
        List<String> tokens = Arrays.stream(word.split(delimiter)).toList();
        return new XList<>(tokens);
    }

    public static XList<Character> ofTokens2(String word, char delimiter) {
        String separatedWord = word
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining(String.valueOf(delimiter)));
        return ofChars(separatedWord);
    }

    public static XList<String> ofTokens(String word) {
        return ofTokens(word, " ");
    }

    private XList(Collection<T> elements) {
        list = new ArrayList<>(elements);
    }

    public XList() {
        super();
    }


    public XList<T> union(Collection<T> other) {
        List<T> unionList = new ArrayList<>();
        unionList.addAll(list);
        unionList.addAll(other);
        return new XList<>(unionList);
    }

    public XList<T> diff(Collection<T> other) {
        Set<T> set = new HashSet<>(other);
        List<T> diffList = list.stream().filter(element -> !set.contains(element)).toList();
        return new XList<>(diffList);
    }

    public XList<T> unique() {
        return new XList<>(list.stream().distinct().toList());
    }

    public <X> XList<T> combine() {
        return null;
    }

    private <X> XList<XList<X>> combine(XList<XList<X>> xLists) {
        XList<XList<X>> result = new XList<>();
        Deque<X> currElements = new ArrayDeque<>();
        combineLists(xLists, result, currElements, 0, xLists.size());
        return result;
    }

    private <X> void combineLists(XList<XList<X>> xLists, XList<XList<X>> result, Deque<X> currElements, int listIdx, int nrOfLists) {
        if (listIdx >= nrOfLists) {
            result.add(new XList<>(currElements));
            return;
        }
        XList<X> currList = xLists.get(listIdx);
        for (X x : currList) {
            currElements.push(x);
            combineLists(xLists, result, currElements, listIdx + 1, nrOfLists);
            currElements.pop();
        }
    }

    public <R> XList<R> collect(Function<T, R> func) {
        return new XList<>(list.stream().map(func).toList());
    }

    public String join(String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    public String join() {
        return join(" ");
    }

    public void forEachWithIndex(BiConsumer<T, Integer> biConsumer) {
        for (int i = 0; i < list.size(); i++) {
            biConsumer.accept(list.get(i), i);
        }
    }
}
