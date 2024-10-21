package programmers;
import java.util.*;

class _3차_파일명_정렬_Java_241021 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String file1, String file2) {
                String[] parts1 = splitFileName(file1);
                String[] parts2 = splitFileName(file2);

                int headCompare = parts1[0].toLowerCase().compareTo(parts2[0].toLowerCase());
                if (headCompare != 0) {
                    return headCompare;
                }

                int num1 = Integer.parseInt(parts1[1]);
                int num2 = Integer.parseInt(parts2[1]);
                if (num1 != num2) {
                    return num1 - num2;
                }

                return 0;
            }

            private String[] splitFileName(String file) {
                String head = "";
                String number = "";
                String tail = "";

                int i = 0;

                while (i < file.length() && !Character.isDigit(file.charAt(i))) {
                    head += file.charAt(i);
                    i++;
                }

                while (i < file.length() && Character.isDigit(file.charAt(i))) {
                    number += file.charAt(i);
                    i++;
                    if (number.length() == 5) break; 
                }

                tail = file.substring(i);

                return new String[] { head, number, tail };
            }
        });

        return files;
    }
}
