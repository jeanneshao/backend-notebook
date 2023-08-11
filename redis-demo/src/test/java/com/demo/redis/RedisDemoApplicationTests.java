package com.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootTest
@Slf4j
class RedisDemoApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    ValueOperations valueOperations;


    @Test
    void contextLoads() {
        log.info("contextLoads");
    }

    @Test
    void testOpsForValue() {
        valueOperations = stringRedisTemplate.opsForValue();
//        // set study:1 study-1
//        valueOperations.set("study:1", "study-1");
//        log.info((String) valueOperations.get("study:1")); //study-1
//        // SETRANGE study:1 study-1
//        valueOperations.set("study:1", "study-1", 2l);
//        log.info((String) valueOperations.get("study:1")); // ststudy-1

//         // SETEX mykey 2 "Hello" // SET key value EX 2
//        valueOperations.set("study:1", "study-1", 2l, TimeUnit.SECONDS);
//        log.info((String) valueOperations.get("study:1")); //study-1

//        // set study:1 study-1 nx
//        // setnx total-crashes 99
//        valueOperations.setIfAbsent("study:1", "study-2");
//        log.info((String) valueOperations.get("study:1")); //study-1

//        // set study:1 study-1 xx
//        valueOperations.setIfPresent("study:1", "study-3");
//        log.info((String) valueOperations.get("study:1")); //study-3

//        valueOperations.setIfPresent("study:2", "study-3");
//        log.info((String) valueOperations.get("study:2")); //null

//        valueOperations.set("study-incre","0");
//        log.info( (String) valueOperations.get("study-incre")); //0
//        // incr study-incre
//        valueOperations.increment("study-incre");
//        log.info( (String) valueOperations.get("study-incre")); //1
//        //        // incrby study-incre 2
//        valueOperations.increment("study-incre",2l);
//        log.info( (String) valueOperations.get("study-incre")); //3
//        //        incrbyfloat total-crashes 2.3
//        valueOperations.increment("study-incre",2.3);
//        log.info( (String) valueOperations.get("study-incre")); //5.3

//        valueOperations.set("study-decr", "0");
//        // decr total-crashes
//        valueOperations.decrement("study-decr");
//        log.info((String) valueOperations.get("study-decr")); //4.3
//        // decrby total-crashes 2
//        valueOperations.decrement("study-decr", 2);
//        log.info((String) valueOperations.get("study-decr")); //2.3

//        // mget study-decr study-incre study:1
//        List multiGet = valueOperations.multiGet(Arrays.asList("study-decr", "study-incre", "study:1"));
//       log.info(String.valueOf(multiGet)); //[-3, 5.3, study-3]

//       // mset study-decr 99 study-incre 88 study:1 hello
//        Map<String, ? extends Serializable> multiset = Map.of("study-decr", "99", "study-incre", "88", "study:1", "multiset");
//        valueOperations.multiSet(multiset);
//        List multiGet = valueOperations.multiGet(Arrays.asList("study-decr", "study-incre", "study:1"));
//        log.info(String.valueOf(multiGet)); //[99, 88, multiset]
//       // APPEND key value
//        valueOperations.append("bike:2","from java");
//        log.info((String) valueOperations.get("bike:2")); //2.3

//        valueOperations.append("bike:2","from java");
//        log.info((String) valueOperations.get("bike:2")); //2.3

//       // SETBIT key offset value
//        valueOperations.setBit("bit-demo",0, true);
//        log.info(String.valueOf(valueOperations.getBit("bit-demo",0))); //2.3
//        log.info(String.valueOf(valueOperations.getBit("bit-demo",1))); //2.3

        BitFieldSubCommands.BitFieldGet command = BitFieldSubCommands.BitFieldGet.create(
                BitFieldSubCommands.BitFieldType.unsigned(8), BitFieldSubCommands.Offset.offset(0)
        );
        BitFieldSubCommands bitFieldSubCommands = BitFieldSubCommands.create(command);
        valueOperations.bitField("bit-demo", bitFieldSubCommands);

    }

    @Test
    void testOpsForSet() {
        SetOperations setOperations = stringRedisTemplate.opsForSet();

//        setOperations.add("redis-set","set1","set2","3");
//        Long setSize = setOperations.size("redis-set");
//        log.info("size ===> {}",setSize);
//        Object popped = setOperations.pop("redis-set");
//        setSize = setOperations.size("redis-set");
//        log.info("size ===> {},popped===>{}",setSize,popped);
//        Set members = setOperations.members("redis-set");
//        log.info("members ===> {}",members);
//        setOperations.add("redis-set", "set3", "set4");
//        members = setOperations.members("redis-set");
//        log.info("members ===> {}", members);
//        Long removeCount = setOperations.remove("redis-set", "set1", "set2");
//        members = setOperations.members("redis-set");
//        log.info("removeCount====>{}, members ===> {}", removeCount, members);

//        setOperations.add("redis-set2","set1","set2","3");
//        Set differences = setOperations.difference("redis-set", "redis-set2");
//        Set differences2 = setOperations.difference("redis-set2", "redis-set");
//        log.info("differences====>{}", differences);
//        log.info("differences2====>{}", differences2);
//
//        setOperations.add("redis-set3","set1","set2","set3","set4","set7");

        //Returns the members of the set resulting from the difference between the first set and all the successive sets.
//        Set differences3 =  setOperations.difference(Arrays.asList("redis-set","redis-set2","redis-set3"));
//        log.info("differences3====>{}", differences3);
//        Set differences4 =  setOperations.difference(Arrays.asList("redis-set3","redis-set2","redis-set"));
//        log.info("differences4====>{}", differences4);

//        Set difference5 = setOperations.difference("redis-set", Arrays.asList("redis-set2", "redis-set3"));
//        Set difference6 = setOperations.difference("redis-set3", Arrays.asList("redis-set2", "redis-set"));

//        Long stored = setOperations.differenceAndStore(Arrays.asList("redis-set3", "redis-set2", "redis-set"), "dif-store");
//        log.info("stored====>{}", stored);

//        Long stored2 = setOperations.differenceAndStore("redis-set", Arrays.asList("redis-set2", "redis-set3"), "dif-stored2");
//        log.info("stored====>{}", stored2);

//        Set randomMembers = setOperations.distinctRandomMembers("redis-set", 3);
//        log.info("randomMembers====>{}", randomMembers);
//        randomMembers = setOperations.distinctRandomMembers("redis-set", 3);
//        log.info("randomMembers====>{}", randomMembers);

//        Set intersected = setOperations.intersect("redis-set", Arrays.asList("redis-set2", "redis-set3"));
//        log.info("intersected====>{}", intersected);

//        Long stored = setOperations.intersectAndStore(Arrays.asList("redis-set", "redis-set2", "redis-set3"), "interseted-store");
//        log.info("stored====>{}", stored);

//        Boolean isMember888 = setOperations.isMember("redis-set", "888");
//        Boolean isMember777 = setOperations.isMember("redis-set", "777");
//        log.info("isMember888====>{}, isMember777====>{}", isMember888,isMember777);

        Set union = setOperations.union(Arrays.asList("redis-set", "redis-set2", "redis-set3"));
        Long storedUnion = setOperations.unionAndStore(Arrays.asList("redis-set", "redis-set2", "redis-set3"), "union-store");
        log.info("storedUnion====>{}, union====>{}", storedUnion, union);

    }

    @Test
    void testListOperations() {
        ListOperations operations = stringRedisTemplate.opsForList();
//        Long lPushedCount = operations.leftPushAll("list-demo", Arrays.asList("list1", "list2", "list3"));
//        Long rPushedCount = operations.rightPushAll("list-demo", Arrays.asList("list4", "list5", "list6"));
//        operations.leftPush("list-demo","single1");
//        operations.rightPush("list-demo","single2");
//        operations.leftPush("list-demo","single2","before-single2");
//        operations.rightPush("list-demo","single1","after-single1");
        // redis 6才有的功能，我的版本是5，不支持
//        Long single2Index = operations.indexOf("list-demo", "single2");
//        Long lastIndexSingle2 = operations.lastIndexOf("list-demo", "single2");

//        Object itemAt3 = operations.index("list-demo", 3);
//        log.info("itemAt3===>{}<======>",itemAt3);
//        Object leftPop = operations.leftPop("list-demo");
//        log.info("leftPop===>{}<======>",leftPop);
//        Object rightPop = operations.rightPop("list-demo");
//        log.info("rightPop===>{}<======>",rightPop);
//        Object leftPop1 = operations.leftPop("list-demo-block", Duration.ofSeconds(3));
//        log.info("leftPop1===>{}<======>",leftPop1);

//        operations.leftPushIfPresent("list-demo-block","2");

//        List range2To5 = operations.range("list-demo", 2, 5); //前闭后闭
//        log.info("lastIndexSingle2===>{}<======>",range2To5);//
//        operations.leftPushAll("list-demo", Arrays.asList("toRemove", "toRemove", "toRemove"));
//        operations.rightPushAll("list-demo", Arrays.asList("toRemove", "toRemove", "toRemove"));
//        List allrecords = operations.range("list-demo", 0, -1); //所有
//        log.info("lastIndexSingle2===>{}<======>",allrecords);
//
//        operations.remove("list-demo",2,"toRemove" );//count正数 从左往右删
//        allrecords = operations.range("list-demo", 0, -1); //所有
//        log.info("lastIndexSingle2===>{}<======>",allrecords);
//        operations.remove("list-demo",-2,"toRemove" );//count负数 从右往左删
//        allrecords = operations.range("list-demo", 0, -1); //所有
//        log.info("lastIndexSingle2===>{}<======>",allrecords);
//        List allrecords = operations.range("list-demo", 0, -1); //所有
//        List allrecords2 = operations.range("list-demo-copy", 0, -1); //所有
//        log.info("list-demo===>{}<======>",allrecords);
//        log.info("list-demo-copy===>{}<======>",allrecords2);
//        operations.rightPopAndLeftPush("list-demo","list-demo-copy");
//         allrecords = operations.range("list-demo", 0, -1); //所有
//         allrecords2 = operations.range("list-demo-copy", 0, -1); //所有
//        log.info("list-demo===>{}<======>",allrecords);
//        log.info("list-demo-copy===>{}<======>",allrecords2);

        operations.trim("list-demo-copy", 0, -1);
    }

    @Test
    void testZSetOperations() {
        ZSetOperations operations = stringRedisTemplate.opsForZSet();
//        operations.add("zset-demo","zset-1",3.2);
//        operations.add("zset-demo","zset-2",5.2);
//        operations.add("zset-demo","zset-3",4.2);
//        Set zsetDemos = operations.range("zset-demo", 0, -1);
//        log.info("zsetDemos====>{}",zsetDemos);

//        operations.addIfAbsent("zset-demo","zset-2",2.2);
//        operations.addIfAbsent("zset-demo","zset-4",5.5);
//        Set<DefaultTypedTuple> tupleSet = Set.of(
//                new DefaultTypedTuple("zset-5", 1.1),
//                new DefaultTypedTuple("zset-6", 1.2)
//        );
//        operations.addIfAbsent("zset-demo",tupleSet);
//        operations.incrementScore("zset-demo","zset-5", 1.1);

//        Long count = operations.count("zset-demo", 1.2, 3.2);
//        Long count = operations.count("zset-demo", Double.MIN_VALUE, Double.MAX_VALUE);
//        log.info("count====>{}", count);

//        Set<DefaultTypedTuple> tupleSet2 = Set.of(
//                new DefaultTypedTuple("zset-5", 1.1),
//                new DefaultTypedTuple("zset-6", 1.2),
//                new DefaultTypedTuple("zset-7", 1.3)
//        );
//        operations.addIfAbsent("zset-demo2", tupleSet2);
//        operations.intersectAndStore("zset-demo","zset-demo2","zset-intersect");

//        Set rangeByScore = operations.rangeByScore("zset-demo", 1.2, 3.2);
//        log.info("rangeByScore====>{}", rangeByScore);

//        Set rangeByScoreWithScores = operations.rangeByScoreWithScores("zset-demo", 1.2, 3.2);
//        log.info("rangeByScoreWithScores====>{}", rangeByScoreWithScores);
//
//        Long rank = operations.rank("zset-demo", "zset-5");
//        log.info("rank====>{}", rank);

//        Long removedCount = operations.remove("zset-demo", "zset-5");
//        operations.removeRange("zset-demo",3,5);

//        operations.removeRangeByScore("zset-demo",3.9,100.0);

        Set setReversed = operations.reverseRange("zset-demo2", 0, 3);
        log.info("setReversed====>{}", setReversed);
        Double score = operations.score("zset-demo2", "zset-7");
        log.info("score====>{}", score);
        operations.unionAndStore("zset-demo", "zset-demo2", "zset-demo-union");
        Long size = operations.zCard("zset-demo-union");
        log.info("size====>{}", size);


    }

    @Test
    void testHashOperations() {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
//        opsForHash.put("hash-demo","hash1","It is a hash value1");
//        opsForHash.putAll("hash-demo", Map.of("hash2","It is a hash value2","hash3","It is a hash value3","hash4","It is a hash value4","hash5","It is a hash value5"));
//        Object hash1 = opsForHash.get("hash-demo", "hash1");
//        log.info("hash1===>{}<======>", hash1);
//        Long deleteCount = opsForHash.delete("hash-demo", "hash1");
//        log.info("deleteCount===>{}<======>", deleteCount);
//        deleteCount = opsForHash.delete("hash-demo", "hash111");
//        log.info("deleteCount===>{}<======>", deleteCount);
//
//        Map<Object, Object> entries = opsForHash.entries("hash-demo");
//        log.info("entries===>{}<======>", entries);
//        opsForHash.put("hash-demo", "hash1", "7");
//        Long newValue = opsForHash.increment("hash-demo", "hash1", 5);
//        log.info("newValue===>{}<======>", newValue);

        Long hash2ValueLength = opsForHash.lengthOfValue("hash-demo", "hash2");
        log.info("hash2ValueLength===>{}<======>", hash2ValueLength);

        List<Object> objects = opsForHash.multiGet("hash-demo", Arrays.asList("has1", "hash2", "hash999"));
        log.info("objects===>{}<======>", objects);

    }

}
