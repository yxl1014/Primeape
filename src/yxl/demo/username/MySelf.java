package yxl.demo.username;

import java.io.*;
import java.util.*;

public class MySelf {
    static final int MOD = (int) (1e9) + 7;

    static class Region implements Comparable<Region> {
        int rid;
        int nextRid;
        int bossLevel;

        public Region(int rid) {
            this.rid = rid;
        }

        public Region(int rid, int nextRid) {
            this.rid = rid;
            this.nextRid = nextRid;
        }

        @Override
        public String toString() {
            return "Region{" +
                    "rid=" + rid +
                    ", nextRid=" + nextRid +
                    ", bossLevel=" + bossLevel +
                    '}';
        }

        @Override
        public int compareTo(Region o) {
            return Integer.compare(this.rid, o.rid);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Region> regionMap = new TreeMap<>();

        String[] t = reader.readLine().split(" ");
        int regionNum = Integer.parseInt(t[0]);
        int uplevel = Integer.parseInt(t[1]);

        for (int i = 0; i < regionNum - 1; i++) {
            t = reader.readLine().split(" ");
            int rid = Integer.parseInt(t[0]);
            int nextRid = Integer.parseInt(t[1]);
            if (regionMap.containsKey(rid)) {
                regionMap.get(rid).nextRid = nextRid;
            } else {
                regionMap.put(rid, new Region(rid, nextRid));
            }
            if (!regionMap.containsKey(nextRid))
                regionMap.put(nextRid, new Region(nextRid));
        }
        t = reader.readLine().split(" ");
        for (int i = 1; i <= regionNum; i++)
            regionMap.get(i).bossLevel = Integer.parseInt(t[i - 1]);

        System.out.println(regionMap);
        List<Region> list = new ArrayList<>(regionMap.values());
        Collections.sort(list);
        int num = 0;
        for (Region r : list) {
            Region tmp = r;
            int level = r.bossLevel;
            do {
                num++;
            } while ((tmp = regionMap.get(tmp.nextRid)) != null && Math.abs(level - tmp.bossLevel) <= uplevel);
        }

        writer.write((num % MOD) + "\n");
        writer.flush();
        reader.close();
        writer.close();
    }
}
