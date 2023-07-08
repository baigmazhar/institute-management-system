package com.ims.institutemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstituteManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstituteManagementSystemApplication.class, args);

		class Main {
			public static void main(String[] args) {
				System.out.println("Hello Java");
				String str = "Hi Team How are you doing";
				int maxLength = findMaxLengthWord(str);
				System.out.println("Length of the biggest word: " + maxLength);
			}

			public static int findMaxLengthWord(String str) {
				int maxLength = 0;
				int currentLength = 0;

				for (int i = 0; i < str.length(); i++) {
					char ch = str.charAt(i);

					// Check if the current character is a valid letter
					if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
						currentLength++;
					} else {
						// Update maxLength if the current word is longer
						if (currentLength > maxLength) {
							maxLength = currentLength;
						}
						currentLength = 0; // Reset currentLength for the next word
					}
				}

				// Check if the last word is the longest
				if (currentLength > maxLength) {
					maxLength = currentLength;
				}

				return maxLength;
			}
		}

	}

}
