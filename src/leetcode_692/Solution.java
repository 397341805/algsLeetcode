package leetcode_692;

import java.util.*;

/**
 * @Classname 692. 前K个高频单词
 * @Description 给一非空的单词列表，返回前 k 个出现次数最多的单词。返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * @Date 2021/5/20 20:05
 * @Created by Fabric
 */
class Solution {
     public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordMap = new HashMap<>();
        for(String word : words){
             wordMap.put(word,wordMap.getOrDefault(word,0)+1);
        }
        List<String> wordList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : wordMap.entrySet()){
            wordList.add(entry.getKey());
        }
        //Comparetor 简写
        wordList.sort((o1, o2) -> wordMap.get(o1).equals(wordMap.get(o2)) ? o2.compareTo(o1) : wordMap.get(o2) - wordMap.get(o1));
        return wordList.subList(0,k);
     }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String [] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(sol.topKFrequent(words,k));
    }
}