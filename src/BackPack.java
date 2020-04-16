public class BackPack {
    public static void main(String[] args) {
        //�������Ϊ10
        int m = 10;
        int n = 3;
        /*
        ������������������ֱ�Ϊ3�� 4�� 5����ֵ�ֱ�Ϊ4�� 5�� 6
         */
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = BackPack_Solution(m, n, w, p);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }
        //printPack(c, w, m, n);

    }

    /**
     * @param m ��ʾ�������������
     * @param n ��ʾ��Ʒ����
     * @param w ��ʾ��Ʒ��������
     * @param p ��ʾ��Ʒ��ֵ����
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]��ʾǰi����Ʒǡ����һ������Ϊm�ı������Ի�õ�����ֵ
        //����ʽ��c[i][m]=max{c[i-1][m-w[i]]+pi , c[i-1][m]}
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //����ƷΪi������Ϊjʱ�������i��������(w[i-1])С������jʱ��c[i][j]Ϊ�����������֮һ��
                //(1)��Ʒi�����뱳���У�����c[i][j]Ϊc[i-1][j]��ֵ
                //(2)��Ʒi���뱳���У��򱳰�ʣ������Ϊj-w[i-1],����c[i][j]Ϊc[i-1][j-w[i-1]]��ֵ���ϵ�ǰ��Ʒi�ļ�ֵ
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])) {
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c;
    }
}