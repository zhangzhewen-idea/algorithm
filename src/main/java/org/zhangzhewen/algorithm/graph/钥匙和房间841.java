package org.zhangzhewen.algorithm.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 钥匙和房间841 {
    public static void main(String[] args) {
        /*new 钥匙和房间841().canVisitAllRooms(new ArrayList() {{
            add(new ArrayList() {{
                add(1);
            }});
            add(new ArrayList() {{
                add(2);
            }});
            add(new ArrayList() {{
                add(3);
            }});
            add(new ArrayList() {{
            }});
        }});*/

        /*boolean res = new 钥匙和房间841().canVisitAllRooms(new ArrayList() {{
            add(new ArrayList() {{
                add(1);
                add(3);
            }});
            add(new ArrayList() {{
                add(3);
                add(0);
                add(1);
            }});
            add(new ArrayList() {{
                add(2);
            }});
            add(new ArrayList() {{
                add(0);
            }});
        }});*/

        /*boolean res = new 钥匙和房间841().canVisitAllRooms(new ArrayList() {{
            add(new ArrayList() {{
                add(2);
                add(3);
            }});
            add(new ArrayList() {{
            }});
            add(new ArrayList() {{
                add(2);
            }});
            add(new ArrayList() {{
                add(1);
                add(3);
                add(1);
            }});
        }});*/

        boolean res = new 钥匙和房间841().canVisitAllRooms(new ArrayList() {{
            add(new ArrayList() {{
                add(1);
            }});
            add(new ArrayList() {{
            }});
            add(new ArrayList() {{
                add(0);
                add(3);
            }});
            add(new ArrayList() {{
                add(1);
            }});
        }});

        System.out.println(res);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        for (int i = 0; i < rooms.size(); i++) {
            boolean[] visited = new boolean[rooms.size()];
            dfs(rooms, i, visited);
            boolean res = true;
            for (int j = 0; j < visited.length; j++) {
                if (!visited[j]) {
                    res = false;
                    break;
                }
            }
            if (res) {
                return true;
            }
        }

        return false;
    }

    void dfs(List<List<Integer>> rooms, int enterRoom, boolean[] visited) {
        if (visited[enterRoom]) {
            return;
        }
        visited[enterRoom] = true;
        Iterator<Integer> ite = rooms.get(enterRoom).iterator();
        while (ite.hasNext()) {
            int key = ite.next();
//            ite.remove();
            dfs(rooms, key, visited);
        }
    }
}
