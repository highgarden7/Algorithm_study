import java.util.StringTokenizer;

public class 공원산책 {
    static int[] coordinates = {0, 0};
    static int width = 0;
    static int height = 0;

    public static void main(String[] args) throws Exception {
//        int[] s1 = solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"});
        int[] s2 = solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"});
//        int[] s3 = solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"});

        return;
    }

    public static int[] solution(String[] park, String[] routes) {
        String[][] matrix = getMatrix(park);

        for(String cmd : routes) {
            runCMD(matrix, cmd);
        }

        return coordinates;
    }

    public static String[][] getMatrix(String[] park) {
        width = park[0].length();
        height = park.length;

        String[][] matrix = new String[height][width];

        for(int i = 0; i < height ; i++) {
            String[] parkElement = park[i].split("");

            int temp = 0;

            for (String elem : parkElement) {
                matrix[i][temp] = elem;

                if("S".equals(matrix[i][temp])) {
                    coordinates[0] = i;
                    coordinates[1] = temp;
                }

                temp++;
            }
        }

        return matrix;
    }

    public static void runCMD(String[][] park, String cmd) {
        StringTokenizer st = new StringTokenizer(cmd, " ");

        String op = st.nextToken();
        int repeat = Integer.parseInt(st.nextToken());

        switch (op) {
            case "N" :
                moveNorth(park, repeat);
                break;
            case "E" :
                moveEast(park, repeat);
                break;
            case "W" :
                moveWest(park, repeat);
                break;
            case "S" :
                moveSouth(park, repeat);
                break;
        }
    }

    public static void moveNorth(String[][] park, int repeat) {
        if(coordinates[0] - repeat < 0)
            return;

        for (int i = 1; i < repeat + 1; i++) {
            if("X".equals(park[coordinates[0] - i][coordinates[1]])) {
                return;
            }
        }
        coordinates[0] -= repeat;
    }

    public static void moveEast(String[][] park, int repeat) {
        if (coordinates[1] + repeat >= width) {
            return;
        }

        for (int i = 1; i < repeat + 1; i++) {
            if("X".equals(park[coordinates[0]][coordinates[1] + i])) {
                return;
            }
        }

        coordinates[1] += repeat;
    }

    public static void moveWest(String[][] park, int repeat) {
        if (coordinates[1] - repeat < 0) {
            return;
        }

        for (int i = 1; i < repeat + 1; i++) {
            if("X".equals(park[coordinates[0]][coordinates[1] - i])) {
                return;
            }
        }

        coordinates[1] -= repeat;
    }

    public static void moveSouth(String[][] park, int repeat) {
        if(coordinates[0] + repeat >= height)
            return;

        for (int i = 1; i < repeat + 1; i++) {
            if("X".equals(park[coordinates[0] + i][coordinates[1]])) {
                return;
            }
        }
        coordinates[0] += repeat;
    }
}

