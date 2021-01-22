package Algorithms.graph;


import java.util.*;

/*
Сколько у человека потенциальных друзей?
*/

public class FriendsList {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        FriendsList friendsList = new FriendsList();
        friendsList.humanRelationships = generateRelationships();

        //      F3 - F7
        //    /
        //   /  F1 - F2
        // F4 / |     |
        //    \ F0 - F5 - F6 - F8

        //    F0 F1 F2 F3 F4 F5 F6 F7 F8
        // F0 1
        // F1 1  1
        // F2    1  1
        // F3          1
        // F4 1  1     1  1
        // F5 1     1        1
        // F6                1  1
        // F7          1           1
        // F8                   1

        Set<Integer> allFriendsAndPotentialFriends = friendsList.getAllFriendsAndPotentialFriends(4, 4);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 6, 7, 8]
        Set<Integer> potentialFriends = friendsList.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 6, 7, 8]
    }


    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(index);

        while (deep > 0) { // - глубина проверки друзей у поддрузей
            int count = q.size();
            for (int j = 0; j < count; ++j) { // регулируем количество проверок,
                // проверяем только тех друзей, которых мы нашли у друзей при прошлой проверке
                @SuppressWarnings("ConstantConditions")
                int tmp = q.poll();
                for (int i = 0; i < humanRelationships.length; i++) {
                    if (checkIfFriendPresent(tmp, i)) {
                        set.add(i);
                        if(!q.contains(i))
                            q.add(i);
                    }
                }
            }
            deep--;
        }
        set.remove(index);
        return set;
    }

    private boolean checkIfFriendPresent(int ind, int i) {
        if ((i < ind) && (ind < humanRelationships.length) && humanRelationships[ind][i]) {
            return true;
        } else return (i > ind) && humanRelationships[i][ind];
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true},                 //7
                {false, false, false, false, false, false, true, false, true}           //8
        };
    }
}
