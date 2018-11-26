package leetcode;

import leetcode.unionfind.Bricks;

public class Main {

    public static void main(String[] args) {
        Bricks b = new Bricks();
        b.hitBricks(new int[][]{{1,0,0,0},{1,1,1,0}},new int[][]{{1,0}});
    }
}
