package leetcode.creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Franco
 * undo
 */
public class RandomCreator {

    private int num;
    private int min;
    private int max;

    public RandomCreator() {

    }

    public RandomCreator(int num, int max) {
        this.num = num;
        this.max = max;
        min = 0;
    }
    public RandomCreator(int num, int min, int max) {
        this.num = num;
        this.min = min;
        this.max = max;
    }

    public void out() {
        String classpath = this.getClass().getClassLoader().getResource("./").getPath();
        classpath = classpath.substring(1, classpath.length() - 1);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(classpath + File.pathSeparator +"1.txt"));
            writer.write("[");
            Random r = new Random();
            for(int i = 1; i <= num; i++) {
                if(i == num) writer.write(r.nextInt(max));
                else writer.write(r.nextInt(max) + ",");
            }
            writer.write("]");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
