package string;

/**
 * Created by Huanzhou on 2016/1/21.
 */
public class No157_ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    public int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {

            char[] buffer = new char[4];
            boolean endOfFile = false;
            int readBytes = 0;

            while (readBytes < n && !endOfFile) {
                int currReadBytes = read4(buffer);
                if (currReadBytes !=4) {
                    endOfFile = true;
                }
                int length = Math.min(n - readBytes, currReadBytes);
                for (int i=0; i<length; i++) {
                    buf[readBytes + i] = buffer[i];
                }
                readBytes += length;
            }
            return readBytes;

    }




    public static void main(String[] args) {

    }
}
