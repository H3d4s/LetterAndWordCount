package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetterAndWordCount 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        String chuoi = scanner.nextLine();

        Map<String, Integer> ketQuaTu = wordCount(chuoi);
        Map<Character, Integer> ketQuaKyTu = letterCount(chuoi);

        // In số lần xuất hiện của từng từ
        for (Map.Entry<String, Integer> entry : ketQuaTu.entrySet()) 
        {
            String tu = entry.getKey();
            int soLanXuatHien = entry.getValue();
            System.out.println("Word " + tu + "': " + soLanXuatHien + " times");
        }

        // In số lần xuất hiện của từng ký tự
        for (Map.Entry<Character, Integer> entry : ketQuaKyTu.entrySet()) 
        {
            char kyTu = entry.getKey();
            int soLanXuatHien = entry.getValue();
            System.out.println("Letter " + kyTu + "': " + soLanXuatHien + " time");
        }

        scanner.close();
    }

    public static Map<String, Integer> wordCount(String chuoi) 
    {
        Map<String, Integer> wordCount = new HashMap<>();

        // Tách chuỗi thành các từ bằng khoảng trắng
        String[] wordArr = chuoi.split("\\s+");

        // Duyệt qua từng từ và cập nhật bản đếm
        for (String word : wordArr) 
        {
            // Loại bỏ các ký tự đặc biệt và số
            word = word.replaceAll("[^a-zA-Z]", "");

            // Chuyển tất cả thành chữ thường để phân biệt từ in hoa và in thường
            word = word.toLowerCase();

            // Tăng số lần xuất hiện của từ
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

    public static Map<Character, Integer> letterCount(String chuoi) 
    {
        Map<Character, Integer> letterCount = new HashMap<>();

        // Duyệt qua từng ký tự trong chuỗi và cập nhật bản đếm
        for (char letter : chuoi.toCharArray()) 
        {
            if (Character.isLetter(letter)) 
            {
                // Chỉ đếm ký tự chữ cái và phân biệt chữ thường và chữ hoa
                letter = Character.toLowerCase(letter);
                letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
            }
        }

        return letterCount;
    }
}
