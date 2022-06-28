public class Print2Array {
    public static void main(String[] args) {

    }

    public void print(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int dept = 0; dept < arr.length; dept++) {
            for (int index = 0; index < arr[dept].length; index++) {
                sb.append(arr[dept][index]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
